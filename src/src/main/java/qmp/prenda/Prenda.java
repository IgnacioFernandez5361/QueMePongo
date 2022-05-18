package qmp.prenda;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private Color colorPrimario;
  private Color colorSecundario;
  private Material material;
  private TipoPrenda tipoPrenda;
  private Trama trama;
  private int cantVecesUsado = 0;
  private Estado estado = Estado.LIMPIA;

  public Prenda(Color colorPrimario, Material material, TipoPrenda tipoPrenda, Trama trama) {
    this.colorPrimario = requireNonNull(colorPrimario, "Dato color primario es obligatorio");
    this.material = requireNonNull(material, "Dato material es obligatorio");
    this.tipoPrenda = tipoPrenda;
    this.trama = trama;
  }
/*atributo TipoPrenda nunca sera null, dado que BorradorPrenda la inicializa siempre*/
  public Prenda(Color colorPrimario, Color colorSecundario, Material material, TipoPrenda tipoPrenda, Trama trama) {
    this.colorPrimario = requireNonNull(colorPrimario, "Dato color primario es obligatorio");
    this.colorSecundario = colorSecundario;
    this.material = requireNonNull(material, "Dato material es obligatorio");
    this.tipoPrenda = tipoPrenda;
    this.trama = trama;
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

}
