package qmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import qmp.accion.Accion;
import qmp.excepciones.GuardarropasInvalidoException;
import qmp.guardarropas.Guardarropas;
import qmp.guardarropas.Sugerencia;
import qmp.meteorologia.ServicioMeteorologico;
import qmp.prenda.Prenda;

public class Usuario {
  private List<Guardarropas> misGuardarropas;
  private Sugerencia sugerenciaDiaria;

  private List<Accion> acciones;

  public Usuario(){
    this.misGuardarropas = new ArrayList<>();
  }

  public void deshacerPropuestasAceptadasEn(Guardarropas guardarropas) {
    if (!misGuardarropas.contains(guardarropas)) {
      throw new GuardarropasInvalidoException("No tiene acceso a este guardarropas.");
    }
    guardarropas.deshacerPropuestasAceptadas();
  }

  public void calcularSugerenciaDiaria(ServicioMeteorologico servicioMeteorologico) {
    Sugerencia sugerencia = null;
    for(int i = 0; sugerencia == null; i++){
      sugerencia = misGuardarropas.get(i).generarSugerencia(servicioMeteorologico);
      if(sugerencia != null){
        sugerenciaDiaria = sugerencia;
      }
    }
  }

  public void habilitarAccion(Accion accion){
    acciones.add(accion);
  }

  public void deshabilitarAccion(Accion accion){
    acciones.remove(accion);
  }

  void agregarGuardarropas(Guardarropas nuevoGuardarropa){
    misGuardarropas.add(nuevoGuardarropa);
  }
  
  void quitarGaurdarropas(Guardarropas nuevoGuardarropa) {
    misGuardarropas.remove(nuevoGuardarropa);
  }

  public void recibirAlertas(List<String> alertas) {
    acciones.forEach(accion -> accion.recibirAlertas(alertas));
  }
}
