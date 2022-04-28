package qmp1.Prenda;

import qmp1.Atuendo;

public class BorradorPrenda {
    private  TipoPrenda tipoPrenda;
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public Trama trama;
    public Categoria categoria;


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

    public void removerTrama(){
        this.trama = Trama.LISA;
    } //era null

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

    public void agregarCategoria(Categoria categoria) {
        if(tipoPrenda.coincideCategoria(categoria)){
            this.categoria = categoria;
        }
        else {
            throw new RuntimeException("La categoria no coincide con su tipo");
        }
    }

    public Prenda generarPrenda(){
        if(esValido()){
            if(colorSecundario != null) return new Prenda(colorPrimario,colorSecundario,material,
                    tipoPrenda,categoria,trama);
            else return new Prenda(colorPrimario,material,tipoPrenda,categoria,trama);
        }
        else throw new RuntimeException("Hay valores necesarios para generar una prenda no inicializados");
    }

    private boolean esValido() {
        return this.colorPrimario != null && this.material != null &&
                this.tipoPrenda != null && this.categoria != null;
    }

    /*private void completarDatosPorDefecto() {
        if(this.trama == null){
            this.trama = Trama.LISA;
        }
    }*/
}
