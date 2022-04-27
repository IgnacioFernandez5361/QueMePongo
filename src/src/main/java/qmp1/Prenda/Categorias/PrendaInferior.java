package qmp1.Prenda.Categorias;

import java.util.HashSet;
import java.util.Set;

public class PrendaInferior extends CategoriaPrenda{
    public PrendaInferior(){
        Set<String> tiposR = new HashSet<>();
        tiposR.add("Jeans");
        tiposR.add("Pollera");
        tiposR.add("Pantalon");
        this.tiposReconocidos = tiposR;
    }

    public String getCategoria() {
        return "PARTE_INFERIOR";
    }
}
