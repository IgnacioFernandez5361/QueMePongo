package qmp1;

import qmp1.Prenda.*;

import java.util.HashSet;
import java.util.Set;

/*Comentario de prueba*/
public class QueMePongo {
    private Set<Atuendo> misAtuendos;
    private Set<Prenda> misPrendas;
    Prenda borradorUltimaPrenda;



    /*Como usuarie de QuéMePongo, quiero guardar un borrador de la la última prenda que empecé a cargar para continuar después.
     */
    void crearPrenda(TipoPrenda tipoPrenda){
        borradorUltimaPrenda = new Prenda(tipoPrenda);
    }

    void especificarCategoria(Categoria categoria){
        if(borradorUltimaPrenda!= null) {
            borradorUltimaPrenda.agregarCategoria(categoria);
        }
            else{
                throw new RuntimeException("Prenda inexistente, primero crear prenda");
            }


    }

    void especificarColorPrimario(Color colorPrimario){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarColorPrimario(colorPrimario);

        }
        else{
            throw new RuntimeException("Prenda inexistente, primero crear prenda");
        }

    }

    void especificarMaterial(Material material){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarMaterial( material);

        }
        else{
            throw new RuntimeException("Prenda inexistente, primero crear prenda");
        }
    }

    void especificarTrama(Trama trama){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarTrama(trama);

        }
        else{
            throw new RuntimeException("Prenda inexistente, primero crear prenda");
        }
    }

    void especificarColorSecundario(Color colorSecundario){
        if(borradorUltimaPrenda!= null){
            borradorUltimaPrenda.agregarColorSecundario(colorSecundario);

        }
        else{
            throw new RuntimeException("Prenda inexistente, primero crear prenda");
        }
    }

    void guadarUnaPrenda(Atuendo atuendo){
        borradorUltimaPrenda.guardarEnAtuendo(atuendo);
    }






    /*¿debe tener algo como "especificarCategoria"?*/

/*Agrega un atuendo ya existente*/
    public void agregarAtuendo(Atuendo unAtuendo){
        if(unAtuendo.validarAtuendo()){
            misAtuendos.add(unAtuendo);
        }
    }




}
