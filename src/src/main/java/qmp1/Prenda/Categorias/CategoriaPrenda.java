package qmp1.Prenda.Categorias;

import qmp1.Prenda.Categoria;
import qmp1.Prenda.TipoPrenda;

import java.util.Set;

public abstract class CategoriaPrenda {
    protected Set<String> tiposReconocidos;

    public boolean reconoceTipo(String unTipo) {
        return tiposReconocidos.contains(unTipo);
    }

    public abstract Categoria getCategoria();

    public void agregarReconocido(String nuevoTipo){
        tiposReconocidos.add(nuevoTipo);
    }
}
