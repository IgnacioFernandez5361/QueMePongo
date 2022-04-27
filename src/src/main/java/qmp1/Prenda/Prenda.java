package qmp1.Prenda;

import qmp1.Prenda.Categorias.CategoriaPrenda;


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


}
