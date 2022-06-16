package qmp;

import java.util.ArrayList;
import java.util.List;

import qmp.excepciones.GuardarropasInvalidoException;
import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class Usuario {
  private List<Guardarropas> misGuardarropas;

  public Usuario(){
    this.misGuardarropas = new ArrayList<>();
  }

  public void deshacerPropuestasAceptadasEn(Guardarropas guardarropas) {
    if (!misGuardarropas.contains(guardarropas)) {
      throw new GuardarropasInvalidoException("No tiene acceso a este guardarropas.");
    }
    guardarropas.deshacerPropuestasAceptadas();
  }

  void agregarGuardarropas(Guardarropas nuevoGuardarropa){
    misGuardarropas.add(nuevoGuardarropa);
  }
  
  void quitarGaurdarropas(Guardarropas nuevoGuardarropa) {
    misGuardarropas.remove(nuevoGuardarropa);
  }
}
