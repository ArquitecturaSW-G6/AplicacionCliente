require 'stomp'

class TurnoService
  def self.enviar_turno(nombre, servicio, hora)
    begin
      client = Stomp::Client.new('admin', 'admin', 'activemq', 61613)
      mensaje = { nombre: nombre, servicio: servicio, hora: hora }.to_json

      client.publish('/queue/turnos', mensaje)
      client.close

      puts "Turno enviado correctamente a ActiveMQ: #{mensaje}"
      { status: 'ok', message: 'Turno enviado correctamente' }
    rescue => e
      puts "Error al enviar turno: #{e.message}"
      { status: 'error', message: e.message }
    end
  end
end