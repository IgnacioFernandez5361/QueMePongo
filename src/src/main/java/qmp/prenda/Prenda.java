package qmp.prenda;

import static java.util.Objects.requireNonNull;

import qmp.meteorologia.ServicioMeteorologico;

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

  //PARA TESTS
  public int getCantVecesUsado() {
    return cantVecesUsado;
  }


  public boolean perteneceCategoria(Categoria unaCategoria) {
    return (this.getTipo().getCategoria() == unaCategoria);
  }

  public boolean compatibleConClima(ServicioMeteorologico servicioMeteorologico) {
    return servicioMeteorologico.obtenerTemperatura() < tipoPrenda.getTempMax();
  }//La temperatura actual tiene que ser menor a la temperatura permitida por la prenda
}
