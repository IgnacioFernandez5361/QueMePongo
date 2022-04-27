package qmp1.Prenda.Categorias;

import qmp1.Prenda.Categoria;

import java.util.HashSet;
import java.util.Set;

public class Accesorio extends CategoriaPrenda{
    public Accesorio(){
        Set<String> tiposR = new HashSet<>();
        tiposR.add("Anillo");
        tiposR.add("Paniuelo");
        tiposR.add("Anteojos");
        this.tiposReconocidos = tiposR;
    }

    public Categoria getCategoria() {
        return Categoria.ACCESORIOS;
    }
}
