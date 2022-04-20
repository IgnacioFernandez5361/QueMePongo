package qmp1;

import java.util.HashSet;
import java.util.Set;

public class QueMePongo {
    private Set<Atuendo> misAtuendos;

    public void agregarAtuendo(Atuendo unAtuendo){
        if(unAtuendo.validarAtuendo()){
            misAtuendos.add(unAtuendo);
        }
    }
}
