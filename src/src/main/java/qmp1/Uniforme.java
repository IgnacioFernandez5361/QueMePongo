package qmp1;

import qmp1.Prenda.Prenda;

import java.util.HashSet;

public class Uniforme extends Atuendo {
  public String nombreInstitucion;

  public Uniforme(HashSet<Prenda> atuendo) {
    super(atuendo);
  }

  public Uniforme(HashSet<Prenda> uniforme, String nombreInstitucion) {
    super(uniforme);
    this.nombreInstitucion = nombreInstitucion;
  }

  public boolean validarUniforme() {
    return super.validarAtuendo() && prendas.size() == 3; // Valido que haya SÓLO UNA de cada tipo
  }
}