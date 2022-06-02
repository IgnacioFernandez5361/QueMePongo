package qmp.prenda;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qmp.AccuWeatherAPI;

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
    return !this.estaLavandose() && !this.estaPercudida() && this.coincideClima();
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
  
  public boolean coincideClima() {
	  return this.temperaturaActual() < tipoPrenda.getTempMax();
  }

  //La temperatura actual tiene que ser menor a la temperatura permitida por la prenda


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
AccuWeatherAPI apiClima = new AccuWeatherAPI();

List< Map<String, Object> > condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina"); 

Map<String, Object> climaActual = condicionesClimaticas.stream().filter( ) // tiene que devolver los datos de la temperatura de hoy con un filter tal vez


// hay que filtar por fecha

	double temperaturaActual() {
      AccuWeatherAPI api;


      List< Map<String, Object> > condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
      //HashMap<String, Object> datos = (HashMap<String, Object>) condicionesClimaticas.get(57).get("Value"); //Mejorar por favor
      return (double) condicionesClimaticas.get(??).get("Temperature"); //nose bien
	}
    //DUDAS
    //¿Que parametro tipo HashMap<String, Object> debo pasar para que me devuelva temperatura???
    // Lo que retorna que tipo es? Es un tipo int, double o un objeto?


//PARA TESTS
  public int getCantVecesUsado() {
    return cantVecesUsado;
  }
}
