package qmp.prenda;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qmp.AccuWeatherAPI;
import qmp.ServicioMeteorologico;

public class Prenda {
  private final Color colorPrimario;
  private Color colorSecundario;
  private final Material material;
  private final TipoPrenda tipoPrenda;
  private final Trama trama;
  private int cantVecesUsado = 0;
  private Estado estado = Estado.LIMPIA;
  //private Clima aptaClima;

  public Prenda(Color colorPrimario, Material material, TipoPrenda tipoPrenda, Trama trama) {
    this.colorPrimario = requireNonNull(colorPrimario, "Dato color primario es obligatorio");
    this.material = requireNonNull(material, "Dato material es obligatorio");
    this.tipoPrenda = tipoPrenda;
    this.trama = trama;
    //this.aptaClima = aptoPara; La dejo en comentario por las dudas
  }

  /*atributo TipoPrenda nunca sera null, dado que BorradorPrenda la inicializa siempre*/
  public Prenda(Color colorPrimario, Color colorSecundario, Material material, TipoPrenda tipoPrenda, Trama trama) {
    this.colorPrimario = requireNonNull(colorPrimario, "Dato color primario es obligatorio");
    this.colorSecundario = colorSecundario;
    this.material = requireNonNull(material, "Dato material es obligatorio");
    this.tipoPrenda = tipoPrenda;
    this.trama = trama;
    //this.aptaClima = aptoPara;
  }

  public TipoPrenda getTipo() {
    return this.tipoPrenda;
  }

/////

  public boolean sePuedeSugerir() {
    return !this.estaLavandose() && !this.estaPercudida();
  }

  private boolean estaPercudida() {
    return estado == Estado.PERCUDIDA;
  }

  private boolean estaLavandose() {
    return estado == Estado.LAVANDOSE;
  }


  //Se suma 1, de corresponder, actualiza el estado de prenda
  public void seUsa() {
    cantVecesUsado++;
    this.actualizarEstadoPrenda();
  }

  public void actualizarEstadoPrenda() {
    if (cantVecesUsado == 1) {
      estado = Estado.USADA;
    } else if (cantVecesUsado == 2) {
      estado = Estado.SUCIA;
    } else if (cantVecesUsado == 5) {
      estado = Estado.PERCUDIDA;
    }
  }

  public void empezarLavado() {
    if (estado == Estado.SUCIA) {
      estado = Estado.LAVANDOSE;
    }
  }

  public void terminarLavado() {
    if (estado == Estado.LAVANDOSE) {
      estado = Estado.LIMPIA;
      cantVecesUsado = 0;
    }
  }




  /*
  public Clima climaHoy() {
	  if(temperaturaActual() > 20) {
		  return Clima.CALOR;
	  }if(temperaturaActual() < 10 ) {
		  return Clima.FRIO;
	  }else {
		  return Clima.NORMAL;
	  }
  }*/

  /*Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas 
  de Buenos Aires en un momento dado para obtener sugerencias acordes.
*/

  /* Dejo estas líneas de abajo comentadas, según creo el ServicioMeteorologico ya las soluciona:
  AccuWeatherAPI apiClima = new AccuWeatherAPI();
  List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
  Map<String, Object> climaActual = condicionesClimaticas.stream().filter() // tiene que devolver los datos de la temperatura de hoy con un filter tal vez
   */

  //PARA TESTS
  public int getCantVecesUsado() {
    return cantVecesUsado;
  }


  public boolean perteneceCategoria(Categoria unaCategoria) {
    return (this.getTipo().getCategoria() == unaCategoria);
  }

  public boolean compatibleConClima(String direccion, ServicioMeteorologico servicioMeteorologico) {
    return this.temperaturaActual(direccion, servicioMeteorologico) < tipoPrenda.getTempMax();
  }//La temperatura actual tiene que ser menor a la temperatura permitida por la prenda

  public Double temperaturaActual(String direccion, ServicioMeteorologico servicioMeteorologico) {
    return servicioMeteorologico.obtenerTemperatura(direccion);
  }

}
