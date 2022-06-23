package qmp;

import qmp.guardarropas.Sugerencia;
import qmp.meteorologia.ServicioMeteorologico;

import java.util.List;
import java.util.Set;

public class BaseDeUsuarios {
  private Set<Usuario> usuarios;

  public void mandarSugerenciaDiaria(ServicioMeteorologico servicioMeteorologico){
    usuarios.forEach(usuario -> usuario.calcularSugerenciaDiaria(servicioMeteorologico));
  }

  public void actualizarAlertas(List<String> alertas){
    usuarios.forEach(usuario -> usuario.recibirAlertas(alertas));
  }
}
