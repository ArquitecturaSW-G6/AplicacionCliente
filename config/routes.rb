Rails.application.routes.draw do
  post '/turno', to: 'turnos#create'
end
