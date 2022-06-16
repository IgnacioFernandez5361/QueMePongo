package qmp.propuesta;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaAgregar {
    Prenda prenda;




    public void aceptarEn(Guardarropas guardarropas){
        guardarropas.agregarPrenda(this.prenda);

    }

}
