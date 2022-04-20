package qmp1;

import java.util.HashSet;
import java.util.Set;

/*Comentario de prueba*/
public class QueMePongo {
    private Set<Atuendo> misAtuendos;

/*Agrega un atuendo ya existente*/
    public void agregarAtuendo(Atuendo unAtuendo){
        if(unAtuendo.validarAtuendo()){
            misAtuendos.add(unAtuendo);
        }
    }
}
