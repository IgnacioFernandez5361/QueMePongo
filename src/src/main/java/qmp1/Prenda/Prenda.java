package qmp1.Prenda;


import qmp1.Atuendo;

public class Prenda {
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public TipoPrenda tipoPrenda;
    public Trama trama; /*Lo de que sea LISA por defecto ya lo hace completarDatosPorDefecto()*/
    public Categoria categoria;

    public Categoria getCategoria(){
        return this.categoria;
    }

    /*Nuevos requerimientos*/

    /*Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.*/

    /*Asi para que se instancio, si o si tenemos que pasarle unicamente el tipo de prenda primero, ni mas ni menos*/

    public Prenda(TipoPrenda tipoPrenda){
        this.tipoPrenda = tipoPrenda;
    }

    /*Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados
    a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.

     */

    /*Metodos para especificar caracteristicas de prenda*/


    public void agregarTrama(Trama trama) {
        if(tipoPrenda.tramaHabilitada(trama)){
            this.trama = trama;
        }

        else{
            throw new RuntimeException("Trama inconsistente con su tipo de prenda");
        }
    }

    public void removerTrama(){
        this.trama = null;
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

    public void agregarCategoria(Categoria categoria) {
        if(tipoPrenda.coincideCategoria(categoria)){
            this.categoria = categoria;
        }
        else{
            throw new RuntimeException("La categoria no coincide con su tipo");
        }


    }


    /*Para guardar una prenda en un atuendo*/

    public void guardarEnAtuendo(Atuendo atuendo) {
          if(this.esValido()){
              this.completarDatosPorDefecto();
              atuendo.agregarPrenda(this);
          }
          else{
              throw new RuntimeException("La prenda es INVALIDA, no se puede guardar");
          }
    }

    public boolean esValido() {
        return this.colorPrimario != null && this.material != null && this.tipoPrenda != null && this.categoria != null;

    }

    private void completarDatosPorDefecto() {
          if(this.trama == null){
              this.trama = Trama.LISA;
          }
    }
}
