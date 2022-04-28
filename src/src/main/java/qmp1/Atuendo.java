package qmp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import qmp1.Prenda.Prenda;

public class Atuendo {
    private Set<Prenda> prendas;
    /*
    * */

    public Atuendo(HashSet<Prenda> atuendo){
        this.prendas = atuendo;
    }

    public void agregarPrenda(Prenda unaPrenda){
        prendas.add(unaPrenda);
    }
    
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
        List<String> catPrendas = prendas.stream().map(unAtuendo -> unAtuendo.getCategoria())
                .collect(Collectors.toList());

        return catPrendas.contains("CALZADO") && catPrendas.contains("PARTE_SUPERIOR")
                && catPrendas.contains("PARTE_INFERIOR");
    }
}


