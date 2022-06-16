package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaQuitado implements Propuesta {
  Prenda prendaAQuitar;
  EstadoPropuesta estado;

  public PropuestaQuitado(Prenda prendaAQuitar) {
    this.prendaAQuitar = prendaAQuitar;
    this.estado = EstadoPropuesta.PENDIENTE;
  }

  public void aceptarEn(Guardarropas guardarropas) {
    guardarropas.quitarPrenda(prendaAQuitar);
    this.estado = EstadoPropuesta.RECHAZADA;
  }
}
