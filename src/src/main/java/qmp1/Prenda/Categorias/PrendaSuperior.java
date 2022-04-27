package qmp1.Prenda.Categorias;

import java.util.HashSet;
import java.util.Set;

public class PrendaSuperior extends CategoriaPrenda{
    public PrendaSuperior(){
        Set<String> tiposR = new HashSet<>();
        tiposR.add("Remera de mangas cortas");
        tiposR.add("Remera de mangas largas");
        tiposR.add("Musculosa");
        this.tiposReconocidos = tiposR;
    }

    public String getCategoria() {
        return "PARTE_SUPERIOR";
    }
}
