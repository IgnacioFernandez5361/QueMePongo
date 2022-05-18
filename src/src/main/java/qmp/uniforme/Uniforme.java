package qmp.uniforme;

import qmp.prenda.Prenda;

public class Uniforme {

  Prenda parteSuperior;
  Prenda parteInferior;
  Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteInferior = parteInferior;
    this.parteSuperior = parteSuperior;
    this.calzado = calzado;
  }

}