require "rails"
require "action_controller/railtie"
require "action_view/railtie"
require "sprockets/railtie" if defined?(Sprockets)
require "active_model/railtie"
# ❌ Elimina o comenta esta línea:
# require "action_mailer/railtie"

module ServicioCliente
  class Application < Rails::Application
    config.load_defaults 6.1

    # Desactivar ActiveRecord completamente
    config.generators do |g|
      g.orm :null
    end

    config.api_only = true
  end
end
