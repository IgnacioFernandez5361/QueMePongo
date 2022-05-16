package qmp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import qmp1.Prenda.Categoria;
import qmp1.Prenda.Prenda;

public class Atuendo {
    protected Set<Prenda> prendas;
/*
    Prenda parteSuperior;
    Prenda parteInferior;
    Prenda accesorios;
    Prenda calzado;
*/


    /*
    * */

    public Atuendo(HashSet<Prenda> atuendo){
        this.prendas = atuendo;
    }

    public void agregarPrenda(Prenda unaPrenda){
    	if( unaPrenda.prendaValida()) {
        prendas.add(unaPrenda);
    	}
    }
   

/*
    public void agregarPrenda(Prenda unaPrenda){
        if(unaPrenda.categoria == Categoria.PARTE_SUPERIOR){
            this.parteSuperior = unaPrenda;
        }
        if(unaPrenda.categoria == Categoria.PARTE_INFERIOR{
            this.parteInferior = unaPrenda;
        }
        if(unaPrenda.categoria == Categoria.CALZADO){
            this.calzado = unaPrenda;
        }
        if(unaPrenda.categoria == Categoria.ACCESORIOS){
            this.accesorios = unaPrenda;
        }
        else{
            throw new RuntimeException("Categoria inexistente");
        }
    }*/
    
    /*Como usuarie de QuéMePongo, quiero poder guardar una prenda solamente si esta es válida. 
 
    public void agregarPrenda(Prenda unaPrenda){
        if(unaPrenda.esValida()) {
        	prendas.add(unaPrenda);
        }else {
        	 else throw new RuntimeException("La prenda es no es valida");
        }
        
    }
 */

    public boolean validarAtuendo(){
        List<String> catPrendas = prendas.stream().map(unAtuendo -> unAtuendo.getCategoria().toString())
                .collect(Collectors.toList());

        return catPrendas.contains("CALZADO") && catPrendas.contains("PARTE_SUPERIOR")
                && catPrendas.contains("PARTE_INFERIOR");
    }
}


