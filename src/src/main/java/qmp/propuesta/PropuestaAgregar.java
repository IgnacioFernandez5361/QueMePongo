package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaAgregar implements Propuesta {
    Prenda prendaAAgregar;
    EstadoPropuesta estado;

    public PropuestaAgregar(Prenda prenda) {
        this.prendaAAgregar = prenda;
        this.estado = EstadoPropuesta.PENDIENTE;
    }

    public void aceptarEn(Guardarropas guardarropas){
        guardarropas.agregarPrenda(this.prendaAAgregar);
        this.estado = EstadoPropuesta.ACEPTADA;
    }
}
