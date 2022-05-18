package qmp.guardarropas;

import qmp.prenda.Categoria;
import qmp.prenda.Prenda;

public class BorradorSugerencia {
    Prenda sugerenciaTorso;
    Prenda sugerenciaPiernas;
    Prenda sugerenciaPies;
    Prenda sugerenciaAccesorio;

    Guardarropas guardarropa;
//Se debe inicializar si o si con un atributo guardarropa
    BorradorSugerencia(Guardarropas guardarropa){
        this.guardarropa = guardarropa;
    }

    //guardarropa busca la prenda y en el proceso valida que esta no este lavada ni permutida
    void vestirTorso(){
        this.sugerenciaTorso = guardarropa.buscarPrendaValidaDe(Categoria.PARTE_SUPERIOR) ;
    }

    void vestirPiernas(){
        this.sugerenciaPiernas = guardarropa.buscarPrendaValidaDe(Categoria.PARTE_INFERIOR) ;
    }

    void vestirPies(){
        this.sugerenciaPies = guardarropa.buscarPrendaValidaDe(Categoria.CALZADO);
    }
    void vestirAccesorios(){
        this.sugerenciaAccesorio = guardarropa.buscarPrendaValidaDe(Categoria.CALZADO);
    }

    Sugerencia crearSugerencia(){
        this.validarQueVisteCompletamente(); //1ºValida que tenga torso, piernas y pies
        Sugerencia sugerencia;
        if(sugerenciaAccesorio != null){
            sugerencia = new Sugerencia(sugerenciaTorso, sugerenciaPiernas, sugerenciaPies, sugerenciaAccesorio);
        }
        else{
            sugerencia = new Sugerencia(sugerenciaTorso, sugerenciaPiernas, sugerenciaPies);
        }
        return sugerencia; //retorna la sugerencia

    }
//Si no viste completamente devolvera excepccion, caso contrario no hace nada
    private void validarQueVisteCompletamente() {
        if(sugerenciaTorso == null ||sugerenciaPiernas == null || sugerenciaPies == null){
            throw new RuntimeException("Faltan prendas de alguna categoría en el guardarropas");
        }
    }

}
