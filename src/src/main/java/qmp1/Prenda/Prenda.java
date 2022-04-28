package qmp1.Prenda;


import qmp1.Atuendo;

public class Prenda {
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public TipoPrenda tipoPrenda;
    public Trama trama = Trama.LISA;
    public Categoria categoria;

    public Categoria getCategoria(){
        return this.categoria;
    }

    public Prenda(Color colorPrimario, Material material, TipoPrenda tipoPrenda, Categoria categoria, Trama trama){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
            this.trama = trama;
    }

    public Prenda(Color colorPrimario, Color colorSecundario, Material material, TipoPrenda tipoPrenda,
                  Categoria categoria, Trama trama){
        this.categoria = categoria;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.tipoPrenda = tipoPrenda;
        this.trama = trama;
    }

    /*Nuevos requerimientos*/

    /*Asi para que se instancio, si o si tenemos que pasarle unicamente el tipo de prenda primero, ni mas ni menos*/
}
