class TurnosController < ApplicationController
  def create
    nombre   = params[:nombre]
    servicio = params[:servicio]
    hora     = params[:hora]

    resultado = TurnoService.enviar_turno(nombre, servicio, hora)
    render json: resultado
  end
end
