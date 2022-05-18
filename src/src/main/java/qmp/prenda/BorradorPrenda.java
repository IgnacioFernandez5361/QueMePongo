package qmp.prenda;

public class BorradorPrenda {

    public final TipoPrenda tipoPrenda;
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public Trama trama;


    public BorradorPrenda(TipoPrenda tipoPrenda){
        this.tipoPrenda = tipoPrenda;
    }

    public void agregarTrama(Trama trama) {
        if(tipoPrenda.tramaHabilitada(trama)){
            this.trama = trama;
        }

        else{
            throw new RuntimeException("Trama inconsistente con su tipo de prenda");
        }
    }


    public void agregarMaterial(Material material) {
        if(tipoPrenda.materialHabilitado(material)){
            this.material = material;
        }

        else{
            throw new RuntimeException("Material inconsistente con su tipo de prenda");
        }
    }

    public void agregarColorPrimario(Color colorPrimario) {
        if(tipoPrenda.colorHabilitado(colorPrimario)){
            this.colorPrimario = colorPrimario;
        }

        else{
            throw new RuntimeException("Color inconsistente con su tipo de prenda");
        }
    }


    public void agregarColorSecundario(Color colorSecundario){
        if(tipoPrenda.colorHabilitado(colorSecundario)){
            this.colorSecundario = colorSecundario;
        }
        else{
            throw new RuntimeException("Color inconsistente con su tipo de prenda");
        }
    }
/*
    public Prenda generarPrenda(){
        if(esValido()){
            this.completarTramaPorDefecto();
            if(colorSecundario != null) return new Prenda(colorPrimario,colorSecundario,material,
                    tipoPrenda,trama);
            else return new Prenda(colorPrimario,material,tipoPrenda,trama);
        }
        else throw new RuntimeException("Hay valores necesarios para generar una prenda no inicializados");
    }

    private boolean esValido() {
        return this.colorPrimario != null && this.material != null &&
                this.tipoPrenda != null;
    }
*/

public Prenda generarPrenda(){
    /*la validacion de datos ya lo haria el Constructor Prenda en clase Prenda */
    this.completarTramaPorDefecto();

    if(colorSecundario != null)
        return new Prenda(colorPrimario,colorSecundario,material,tipoPrenda,trama);
    else
        return new Prenda(colorPrimario,material,tipoPrenda,trama);


}
    private void completarTramaPorDefecto() {
        if(this.trama == null){
            this.trama = Trama.LISA;
        }
    }
}
