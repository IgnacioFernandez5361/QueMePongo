package qmp;

import java.util.Set;

import qmp.prenda.Prenda;


public class Atuendo {
/*Tal vez tendremos que cambiar diseño, a otro en donde usaremos una clase Atuendo*/
  public Atuendo(Set<Prenda> atuendo) {
    this.prendas = atuendo;
  }

  public void agregarPrenda(Prenda unaPrenda) {
    prendas.add(unaPrenda);
  }
}


