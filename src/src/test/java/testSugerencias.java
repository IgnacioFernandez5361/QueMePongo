import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qmp.PropuestaAgregar;
import qmp.ServicioMeteorologico;
import qmp.Usuario;
import qmp.guardarropas.BorradorSugerencia;
import qmp.guardarropas.Guardarropas;
import qmp.guardarropas.Sugerencia;
import qmp.prenda.*;

import java.time.Duration;
import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class testSugerencias {


    TipoPrenda remera = new TipoPrenda(Categoria.PARTE_SUPERIOR, 20);
    Prenda remeraVerde = new Prenda(Color.VERDE, Material.POLIESTER, remera, Trama.LISA);
    Prenda remeraNegroConCalavera = new Prenda(Color.NEGRO, Color.BLANCO, Material.POLIESTER, remera, Trama.LISA);
    Prenda remeraGris = new Prenda(Color.GRIS, Material.POLIESTER, remera, Trama.LISA);

    TipoPrenda shin = new TipoPrenda(Categoria.PARTE_INFERIOR, 20);
    Prenda shinAzulSintetico = new Prenda(Color.AZUL, null, Material.SINTETICO, shin, Trama.LISA);
    Prenda shinRojizo = new Prenda(Color.ROJO, null, Material.SINTETICO, shin, Trama.LISA);

    TipoPrenda zapatos = new TipoPrenda(Categoria.CALZADO, 20);
    Prenda zapatosNegros = new Prenda(Color.NEGRO, null, Material.CUERO, zapatos, Trama.LISA);
    Prenda zapatosGris = new Prenda(Color.GRIS, null, Material.CUERO, zapatos, Trama.LISA);

    Prenda gorro = new Prenda(Color.AZUL, Material.ALGODON, new TipoPrenda(Categoria.ACCESORIOS, 20), Trama.LISA);

    List<Prenda> misPrendas= new ArrayList<>();
    //Guardarropas guardaropas  = new Guardarropas(new ArrayList<Prenda>(), "uno", new List<Usuario>(), new PropuestaAgregar());
    BorradorSugerencia borrador = new BorradorSugerencia(new Guardarropas(new ArrayList<Prenda>(), "uno", new ArrayList<Usuario>(), new PropuestaAgregar()));



    @BeforeEach
    public void init() { //Despues simplificar y delegar



        misPrendas.add(remeraVerde);
        misPrendas.add(remeraNegroConCalavera);
        misPrendas.add(remeraGris);
        misPrendas.add(shinAzulSintetico);
        misPrendas.add(shinRojizo);
        misPrendas.add(zapatosNegros);
        misPrendas.add(zapatosGris);
        misPrendas.add(gorro);

        Guardarropas guardaropas  = new Guardarropas(misPrendas,"uno",new ArrayList<>(), new PropuestaAgregar());
        BorradorSugerencia borrador = new BorradorSugerencia(guardaropas);
    }

    @Test
    public void prendaApareceEnSugerenciaFueUsada(){
        ServicioMeteorologico servicioMeteorologico = new ServicioMeteorologico(Duration.ofMinutes(30),
            "Buenos Aires, Argentina");
        borrador.vestirTorso(servicioMeteorologico);
        borrador.vestirPiernas(servicioMeteorologico);
        borrador.vestirPies(servicioMeteorologico);
        Sugerencia sugerencia = borrador.crearSugerencia(servicioMeteorologico);
        assertEquals(sugerencia.getSugerenciaPies().getCantVecesUsado(), 1);
        assertEquals(sugerencia.getSugerenciaTorso().getCantVecesUsado(), 1);
        assertEquals(sugerencia.getSugerenciaPies().getCantVecesUsado(), 1);
    }

    @Test
    public void prendaSinSugrerirNoFueUsada(){
        assertEquals(remeraVerde.getCantVecesUsado(), 0);
        assertEquals(gorro.getCantVecesUsado(), 0);
        assertEquals(remeraGris.getCantVecesUsado(), 0);
    }
}
