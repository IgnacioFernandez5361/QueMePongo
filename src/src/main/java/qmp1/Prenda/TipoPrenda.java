package qmp1.Prenda;

import java.util.LinkedList;

public class TipoPrenda {
    Categoria categoria;
    LinkedList<Color> coloresPermitidos;
    LinkedList<Material> materialesPermitidos;
    LinkedList<Trama> tramasPermitidas;

    public TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    public boolean colorHabilitado(Color colorPrimario) {
        if(colorPrimario != null){
            return coloresPermitidos.contains(colorPrimario);
        }
        else return false;
    }

    public boolean materialHabilitado(Material material) {
        if(material != null){
            return materialesPermitidos.contains((material));
        }
        else return false;
    }

    public boolean tramaHabilitada(Trama trama) {
        if(trama != null){
            return tramasPermitidas.contains(trama);
        }
        else return false;
    }


}

