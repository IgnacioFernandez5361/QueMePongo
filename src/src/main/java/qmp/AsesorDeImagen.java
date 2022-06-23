package qmp;

import qmp.meteorologia.ServicioMeteorologico;
import qmp.guardarropas.BorradorSugerencia;
import qmp.guardarropas.Guardarropas;
import qmp.guardarropas.Sugerencia;

public class AsesorDeImagen {
    private ServicioMeteorologico servicioMeteorologico;
    private Guardarropas guardarropas;

    public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico, Guardarropas guardarropas){
        this.servicioMeteorologico = servicioMeteorologico;
        this.guardarropas = guardarropas;
    }

    public Sugerencia sugerirAtuendo(String direccion){
        BorradorSugerencia borradorSugerencia = new BorradorSugerencia(guardarropas);
        return borradorSugerencia.crearSugerencia(servicioMeteorologico);
    }

}
