package qmp1.Uniforme;

import qmp1.Prenda.Prenda;

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