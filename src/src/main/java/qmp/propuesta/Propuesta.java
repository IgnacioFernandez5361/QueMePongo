package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public abstract class Propuesta {
  public Prenda prenda;
  public EstadoPropuesta estado;

  public void aceptarEn(Guardarropas guardarropas) {
    this.estado = EstadoPropuesta.ACEPTADA;
  }

  public abstract void deshacerEn(Guardarropas guardarropas);

  public void rechazar() {
    this.estado = EstadoPropuesta.RECHAZADA;
  }
}
