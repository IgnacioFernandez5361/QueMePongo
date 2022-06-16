package qmp;

import qmp.guardarropas.Guardarropas;
import qmp.prenda.Prenda;

public class PropuestaQuitado {
    Prenda prenda;

    public void aceptarEn(Guardarropas guardarropas) {
        guardarropas.quitarPrenda(prenda);
    }
}
