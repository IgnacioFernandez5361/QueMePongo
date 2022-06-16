package qmp.prenda;

import qmp.excepciones.ColorIncompatibleConTipoException;
import qmp.excepciones.MaterialIncompatibleConTipo;
import qmp.excepciones.TramaIncompatibleConTipoException;

public class BorradorPrenda {

    public final TipoPrenda tipoPrenda;
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public Trama trama = Trama.LISA;

    public BorradorPrenda(TipoPrenda tipoPrenda){
        this.tipoPrenda = tipoPrenda;
    }

    public void agregarTrama(Trama trama) {
        this.validarTramaConTipo(trama);
        this.trama = trama;
    }

    public void agregarMaterial(Material material) {
        this.validarMaterialConTipo(material);
        this.material = material;
    }

    public void agregarColorPrimario(Color colorPrimario) {
        this.validarColorConTipo(colorPrimario);
        this.colorPrimario = colorPrimario;
    }

    public void agregarColorSecundario(Color colorSecundario){
        this.validarColorConTipo(colorSecundario);
        this.colorSecundario = colorSecundario;
    }

//VALIDACIONES
    private void validarTramaConTipo(Trama trama) {
        if(!tipoPrenda.tramaHabilitada(trama)){
            throw new TramaIncompatibleConTipoException("Trama inconsistente con su tipo de prenda");
        }
    }

    private void validarMaterialConTipo(Material material) {
        if(!tipoPrenda.materialHabilitado(material)){
            throw new MaterialIncompatibleConTipo("Material inconsistente con su tipo de prenda");
        }
    }

    private void validarColorConTipo(Color colorPrimario) {
        if(!tipoPrenda.colorHabilitado(colorPrimario)){
            throw new ColorIncompatibleConTipoException("Color inconsistente con su tipo de prenda");
        }
    }

public Prenda generarPrenda(){
    /*la validacion de datos ya lo haria el Constructor Prenda en clase Prenda */

    if(colorSecundario != null)
        return new Prenda(colorPrimario,colorSecundario,material,tipoPrenda,trama);
    else
        return new Prenda(colorPrimario,material,tipoPrenda,trama);
    }
}
