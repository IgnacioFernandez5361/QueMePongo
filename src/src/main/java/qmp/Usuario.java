package qmp;

import java.util.ArrayList;
import java.util.List;

import qmp.excepciones.GuardarropasInvalidoException;
import qmp.guardarropas.Guardarropas;
import qmp.guardarropas.Sugerencia;
import qmp.prenda.Prenda;

public class Usuario {
  private List<Guardarropas> misGuardarropas;
  private Sugerencia sugerenciaDiaria;

  public Usuario(){
    this.misGuardarropas = new ArrayList<>();
  }

  public void deshacerPropuestasAceptadasEn(Guardarropas guardarropas) {
    if (!misGuardarropas.contains(guardarropas)) {
      throw new GuardarropasInvalidoException("No tiene acceso a este guardarropas.");
    }
    guardarropas.deshacerPropuestasAceptadas();
  }

  public void setSugerenciaDiaria(Sugerencia sugerenciaDiaria) {
    this.sugerenciaDiaria = sugerenciaDiaria;
  }

  void agregarGuardarropas(Guardarropas nuevoGuardarropa){
    misGuardarropas.add(nuevoGuardarropa);
  }
  
  void quitarGaurdarropas(Guardarropas nuevoGuardarropa) {
    misGuardarropas.remove(nuevoGuardarropa);
  }
}
