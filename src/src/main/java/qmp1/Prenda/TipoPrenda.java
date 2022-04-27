package qmp1.Prenda;

public class TipoPrenda {
    Categoria categoria;

    TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    boolean coincideCategoria(Categoria unaCategoria){
        return this.categoria == unaCategoria;
    }

}
