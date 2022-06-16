package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaAgregar extends Propuesta {

  public PropuestaAgregar(Prenda prenda) {
    this.prenda = prenda;
    this.estado = EstadoPropuesta.PENDIENTE;
  }

  public void aceptarEn(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(this.prenda);
    this.estado = EstadoPropuesta.ACEPTADA;
  }

  public void deshacerEn(Guardarropas guardarropas) {
    guardarropas.quitarPrenda(prenda);
  }
}
