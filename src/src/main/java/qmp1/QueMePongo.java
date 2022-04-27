package qmp1;

import qmp1.Prenda.*;

import java.util.HashSet;
import java.util.Set;

/*Comentario de prueba*/
public class QueMePongo {
    private Set<Atuendo> misAtuendos;
    Prenda borradorUltimaPrenda;

    /*Como usuarie de QuéMePongo, quiero guardar un borrador de la la última prenda que empecé a cargar para continuar después.
     */
    void crearPrenda(TipoPrenda tipoPrenda){
        borradorUltimaPrenda = new Prenda(tipoPrenda);
    }

    void especificarColorPrimario(Color colorPrimario){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarColorPrimario(colorPrimario);

        }
        /*Si no existe borradorUltimaPrenda, lanza una excepccion de primero crear prenda*/

    }

    void especificarMaterial(Material material){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarMaterial( material);

        }
        /*Si no existe borradorUltimaPrenda, lanza una excepccion*/
    }

    void especificarTrama(Trama trama){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarTrama(trama);

        }
        /*Si no existe borradorUltimaPrenda, lanza una excepccion*/
    }

    void especificarColorSecundario(Color colorSecundario){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarColorSecundario(colorSecundario);

        }
        /*Si no existe borradorUltimaPrenda, lanza una excepccion*/
    }


    /*¿debe tener algo como "especificarCategoria"?*/

/*Agrega un atuendo ya existente*/
    public void agregarAtuendo(Atuendo unAtuendo){
        if(unAtuendo.validarAtuendo()){
            misAtuendos.add(unAtuendo);
        }
    }

}
