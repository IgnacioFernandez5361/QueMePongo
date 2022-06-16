package qmp;

import java.util.ArrayList;
import java.util.List;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class Usuario {
  private List<Guardarropas> misGuardarropas;

  public Usuario(){
    this.misGuardarropas = new ArrayList<>();
  }

  
  void agregarGuardarropas(Guardarropas nuevoGuardarropa){
    misGuardarropas.add(nuevoGuardarropa);
  }
  
  void quitarGaurdarropas(Guardarropas nuevoGuardarropa) {
    misGuardarropas.remove(nuevoGuardarropa);
  }
}
