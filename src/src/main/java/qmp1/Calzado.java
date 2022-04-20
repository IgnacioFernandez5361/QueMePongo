package qmp1;

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

    public String getCategoria() {
        return "CALZADO";
    }
}
