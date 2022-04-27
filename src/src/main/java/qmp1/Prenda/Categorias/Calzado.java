package qmp1.Prenda.Categorias;

import qmp1.Prenda.Categoria;

import java.util.HashSet;
import java.util.Set;

public class Calzado extends CategoriaPrenda{
    public Calzado(){
        Set<String> tiposR = new HashSet<>();
        tiposR.add("Crocs");
        tiposR.add("Botas");
        tiposR.add("Zapatillas");
        this.tiposReconocidos = tiposR;
    }

    public Categoria getCategoria() {
        return Categoria.CALZADO;
    }
}
