package qmp.guardarropas;

import java.util.Set;

import qmp.prenda.Prenda;

public class Atuendo {
  private final Prenda prendaInferior;
  private final Prenda prendaCalzado;
  private final Prenda prendaSuperior;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado){
    this.prendaInferior = prendaInferior;
    this.prendaCalzado = prendaCalzado;
    this.prendaSuperior = prendaSuperior;
  }

}


