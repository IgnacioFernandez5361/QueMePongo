package qmp.accion;

import qmp.Usuario;
import qmp.meteorologia.ServicioMeteorologico;

import java.util.List;

public class RecalculoDeSugerencia implements Accion{
  private Usuario usuario;
  private ServicioMeteorologico servicioMeteorologico;

  public RecalculoDeSugerencia(Usuario usuario, ServicioMeteorologico servicioMeteorologico) {
    this.usuario = usuario;
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public void recibirAlertas(List<String> alertas) {
    if(!alertas.isEmpty()){
      usuario.calcularSugerenciaDiaria(servicioMeteorologico);
    }
  }
}
