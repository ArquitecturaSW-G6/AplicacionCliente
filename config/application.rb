require_relative "boot"

require "rails"
require "active_model/railtie"
require "active_job/railtie"
require "action_controller/railtie"
require "action_mailer/railtie"
require "action_view/railtie"
require "action_cable/engine"
# No cargamos ActiveRecord ni ActiveStorage
# require "active_record/railtie"
# require "active_storage/engine"

Bundler.require(*Rails.groups)

module ServicioCliente
  class Application < Rails::Application
    config.load_defaults 7.0
    config.api_only = true

    # 🔧 Desactiva completamente ActiveRecord antes de inicializar el middleware
    initializer :disable_active_record, before: :load_config_initializers do
      config.active_record = ActiveSupport::OrderedOptions.new
      config.active_record.database_selector = nil
      config.active_record.database_resolver = nil
      config.active_record.database_resolver_context = nil
    end

    # 🔒 Elimina cualquier referencia al middleware de ActiveRecord
    initializer :remove_active_record_middlewares, after: :initialize_logger do |app|
      app.config.middleware.delete ActiveRecord::Migration::CheckPending rescue nil
      app.config.middleware.delete ActiveRecord::Middleware::DatabaseSelector rescue nil
      app.config.middleware.delete ActiveRecord::Middleware::DatabaseConnection rescue nil
    end

    # 🚫 Generadores sin ORM
    config.generators.orm :null
  end
end