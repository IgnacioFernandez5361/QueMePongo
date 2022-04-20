package qmp1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Atuendo {
    private Set<Prenda> prendas;

    public Atuendo(HashSet<Prenda> atuendo){
        this.prendas = atuendo;
    }

    public void agregarPrenda(Prenda unaPrenda){
        prendas.add(unaPrenda);
    }

    public boolean validarAtuendo(){
        Set<String> catPrendas = prendas.stream().map(x -> x.getCategoria()).collect(Collectors.toSet());

        return catPrendas.contains('CALZADO') && catPrendas.contains('PARTE_SUPERIOR')
                && catPrendas.contains('PARTE_INFERIOR');
    }
}
