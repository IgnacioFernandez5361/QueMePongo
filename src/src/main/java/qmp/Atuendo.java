package qmp;

import java.util.Set;

import qmp.prenda.Prenda;

public class Atuendo {
    protected Set<Prenda> prendas;

    public Atuendo(Set<Prenda> atuendo) {
        this.prendas = atuendo;
    }

    public void agregarPrenda(Prenda unaPrenda) {
        prendas.add(unaPrenda);
    }
}


