package qmp.prenda;

import java.util.*;

public class TipoPrenda {
    private final Categoria categoria;
    private final HashSet<Color> coloresInconsistentes;
    private final HashSet<Material> materialesInconsistentes;
    private final HashSet<Trama> tramasInconsistentes;
    private final double tempMax; //Creo que va en TipoPrenda

    //DUDAS
    //tempMax tiene mas sentido que vaya en Prenda, pero entonces habria que retocar un monton de mensajes en BorradorPrenda
    //en TipoPrenda nos ahorramos todos los cambios, pero puede que sea innesesario ¿?




    public TipoPrenda(Categoria categoria, double tempMax){

        this.categoria = categoria;
        this.coloresInconsistentes = new HashSet<>();
        this.materialesInconsistentes = new HashSet<>();
        this.tramasInconsistentes = new HashSet<>();
        this.tempMax = tempMax;

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean colorHabilitado(Color colorPrimario) {
        if(colorPrimario != null){
            return !(coloresInconsistentes.contains(colorPrimario));
        }
        else return false;
    }

    public boolean materialHabilitado(Material material) {
        if(material != null){
            return !materialesInconsistentes.contains((material));
        }
        else return false;
    }

    public boolean tramaHabilitada(Trama trama) {
        if(trama != null){
            return !tramasInconsistentes.contains(trama);
        }
        else return false;
    }
    //Para avergiguar temperatura maxima
    public double getTempMax(){
        return this.tempMax;
    }


}
/*Cambie atributos para que facilitar la construccion de TipoPrensa en clase FabricanteUniforme
*
* Igualmente debo consultar si:
      coloresInconsistentes;
    ,materialesInconsistentes;
    ,tramasInconsistentes;
    ¿Se utilizaran? Consultar bien por el requerimiento:
    validar prenda es que el color, trama y material sean consistentes para el TipoPrenda
* */
