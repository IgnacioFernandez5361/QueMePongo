package qmp1.Prenda;


public class Prenda {
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public TipoPrenda tipoPrenda;
    public Trama trama;
    public Categoria categoria;

    public Categoria getCategoria(){
        return this.categoria;
    }

    public Prenda(Color colorPrimario, Material material, TipoPrenda tipoPrenda, Categoria categoria){
        if(tipoPrenda.coincideCategoria(categoria)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }
        else throw new RuntimeException("La categoria no se condice con su tipo");
    }

    public Prenda(Color colorPrimario, Color colorSecundario, Material material, TipoPrenda tipoPrenda, Categoria categoria){
        if(tipoPrenda.coincideCategoria(categoria)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.colorSecundario = colorSecundario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }

        else throw new RuntimeException("La categoria no se condice con su tipo");
    }

    /*Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.*/

    public Prenda(TipoPrenda tipoPrenda){
        this.tipoPrenda = tipoPrenda;
    }

    /*Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados
    a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.

     */






    public void agregarTrama(Trama trama) {
        if(tipoPrenda.tramaHabilitada(trama)){
            this.trama = trama;
        }
        /*Caso contrario, a parte de no hacer nada lanza una excepccion*/
    }

    public void agregarMaterial(Material material) {
        if(tipoPrenda.materialHabilitado(material)){
            this.material = material;
        }

        /*Caso contrario, a parte de no hacer nada lanza una excepccion*/
    }

    public void agregarColorPrimario(Color colorPrimario) {
        if(tipoPrenda.colorHabilitado(colorPrimario)){
            this.colorPrimario = colorPrimario;
        }

        /*Caso contrario, a parte de no hacer nada lanza una excepccion*/
    }


    public void agregarColorSecundario(Color colorSecundario){
        if(tipoPrenda.colorHabilitado(colorSecundario)){
            this.colorSecundario = colorSecundario;
        }

        /*Caso contrario, a parte de no hacer nada lanza una excepccion*/
    }


    /*Dudas:

        * Tambien la categoria vendria a ser parte de los materiales? (En caso que si, podria usar
        el metodo coincideCategoria en esta parte) Recordar que aun no estaria definida.
        *
        * */


}
