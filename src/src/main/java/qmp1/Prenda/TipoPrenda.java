package qmp1.Prenda;

import java.util.LinkedList;

public class TipoPrenda {
    Categoria categoria;
    LinkedList<Color> coloresPermitidos;
    LinkedList<Material> materialesPermitidos;
    LinkedList<Trama> tramasPermitidas;

    TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    boolean coincideCategoria(Categoria unaCategoria){
        return this.categoria == unaCategoria;
    }

    public boolean colorHabilitado(Color colorPrimario) {
        return coloresPermitidos.contains(colorPrimario);
    }

    public boolean materialHabilitado(Material material) {
        return materialesPermitidos.contains((material));
    }

    public boolean tramaHabilitada(Trama trama) {
        return tramasPermitidas.contains(trama);
    }
}
