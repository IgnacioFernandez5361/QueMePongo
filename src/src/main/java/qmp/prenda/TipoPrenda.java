package qmp.prenda;

import java.util.List;

public class TipoPrenda {
    private Categoria categoria;
    private List<Color> coloresPermitidos;
    private List<Material> materialesPermitidos;
    private List<Trama> tramasPermitidas;

    public TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
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
