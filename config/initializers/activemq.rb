require 'stomp'
require 'socket'

def esperar_activemq(host, port, max_intentos = 20)
  puts "⏳ Esperando ActiveMQ (#{host}:#{port})..."
  intentos = 0

  until tcp_disponible?(host, port)
    intentos += 1
    if intentos >= max_intentos
      raise "❌ No se pudo conectar a ActiveMQ en #{host}:#{port} después de #{max_intentos} intentos"
    end
    sleep 2
  end

  puts "✅ ActiveMQ disponible en #{host}:#{port}"
end

def tcp_disponible?(host, port)
  Socket.tcp(host, port, connect_timeout: 2) { true } rescue false
end

unless defined?(ActiveMQ_CLIENT)
  esperar_activemq('activemq', 61613)
  ActiveMQ_CLIENT = Stomp::Client.new('admin', 'admin', 'activemq', 61613)
  puts "💬 Conectado exitosamente a ActiveMQ"
end

# Cierra la conexión limpiamente cuando el contenedor se apaga
at_exit do
  if defined?(ActiveMQ_CLIENT) && ActiveMQ_CLIENT.open?
    ActiveMQ_CLIENT.close
    puts "🔌 Conexión con ActiveMQ cerrada correctamente"
  end
end