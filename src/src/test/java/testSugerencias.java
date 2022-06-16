import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qmp.propuesta.Propuesta;
import qmp.propuesta.PropuestaAgregar;
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

  TipoPrenda jeans = new TipoPrenda(Categoria.PARTE_INFERIOR, 20);
  Prenda jeansAzulSintetico = new Prenda(Color.AZUL, null, Material.SINTETICO, jeans, Trama.LISA);
  Prenda jeansRojizo = new Prenda(Color.ROJO, null, Material.SINTETICO, jeans, Trama.LISA);

  TipoPrenda zapatos = new TipoPrenda(Categoria.CALZADO, 20);
  Prenda zapatosNegros = new Prenda(Color.NEGRO, null, Material.CUERO, zapatos, Trama.LISA);
  Prenda zapatosGris = new Prenda(Color.GRIS, null, Material.CUERO, zapatos, Trama.LISA);

  Prenda gorro = new Prenda(Color.AZUL, Material.ALGODON, new TipoPrenda(Categoria.ACCESORIOS, 20), Trama.LISA);

  List<Prenda> misPrendas = new ArrayList<>();
  //Guardarropas guardaropas  = new Guardarropas(new ArrayList<Prenda>(), "uno", new List<Usuario>(), new PropuestaAgregar());

  Guardarropas guardaropas = new Guardarropas(misPrendas, "uno",
      new ArrayList<Propuesta>());
  BorradorSugerencia borrador = new BorradorSugerencia(guardaropas);

  @BeforeEach
  public void init() { //Despues simplificar y delegar
    misPrendas.add(remeraVerde);
    misPrendas.add(remeraNegroConCalavera);
    misPrendas.add(remeraGris);
    misPrendas.add(jeansAzulSintetico);
    misPrendas.add(jeansRojizo);
    misPrendas.add(zapatosNegros);
    misPrendas.add(gorro);
  }

  /*
  @Test
  public void prendaApareceEnSugerenciaFueUsada() {
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
   */

  @Test
  public void prendaSinSugerirNoFueUsada() {
    assertEquals(remeraVerde.getCantVecesUsado(), 0);
    assertEquals(gorro.getCantVecesUsado(), 0);
    assertEquals(remeraGris.getCantVecesUsado(), 0);
  }
}
