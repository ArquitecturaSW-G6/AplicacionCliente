# Fuente principal de gemas
source 'https://rubygems.org'
git_source(:github) { |repo| "https://github.com/#{repo}.git" }

# Versión de Ruby
ruby '3.3.9'

# Framework principal
gem 'rails', '~> 7.1.3', '>= 7.1.3.1'

# Servidor de aplicación (maneja las peticiones HTTP)
gem 'puma', '~> 6.0'

# === 🔹 GEMAS CLAVE PARA EL PROYECTO ===
# Base de datos en memoria (Redis)
gem 'redis', '~> 5.0'

# Conexión con ActiveMQ usando STOMP
gem 'stomp', '~> 1.4'

# Pool de conexiones Redis (evita bloqueos por múltiples hilos)
gem 'connection_pool'



# Utilidades generales
gem 'dotenv-rails'          # Variables de entorno (.env)

# === 🔹 AMBIENTES DE DESARROLLO Y TESTEO ===
group :development, :test do
  gem 'byebug', platforms: [:mri, :mingw, :x64_mingw]
end

group :development do
  gem 'listen', '~> 3.3'
end

# === 🔹 COMPATIBILIDAD CON WINDOWS ===
gem 'tzinfo-data', platforms: [:mingw, :mswin, :x64_mingw, :jruby]


gem 'rack-cors', '~> 2.0', require: 'rack/cors'
