require_relative "application"

# Evitar inicialización de ActiveRecord
module ActiveRecord; end

Rails.application.initialize!
