Rails.application.configure do
  # Recarga el código en cada solicitud (útil en desarrollo)
  config.cache_classes = false

  # No hace eager load (carga diferida de clases)
  config.eager_load = false

  # Muestra errores detallados
  config.consider_all_requests_local = true

  # Activa medición de tiempos del servidor
  config.server_timing = true

 
end