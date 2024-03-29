package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaQuitado extends Propuesta {

  public PropuestaQuitado(Prenda prenda) {
    this.prenda = prenda;
    this.estado = EstadoPropuesta.PENDIENTE;
  }

  public void aceptarEn(Guardarropas guardarropas) {
    super.aceptarEn(guardarropas);
    guardarropas.quitarPrenda(prenda);
  }

  public void deshacerEn(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(prenda);
  }
}
