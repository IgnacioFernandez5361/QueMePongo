package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public abstract class Propuesta {
  public Prenda prenda;
  public EstadoPropuesta estado;

  public abstract void aceptarEn(Guardarropas guardarropas);

  public abstract void deshacerEn(Guardarropas guardarropas);

  public void rechazar() {
    this.estado = EstadoPropuesta.RECHAZADA;
  }
}
