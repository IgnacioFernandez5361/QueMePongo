package qmp1.Prenda;

import qmp1.Prenda.Categorias.CategoriaPrenda;



import static qmp1.Prenda.Trama.LISA;


public class Prenda {
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public String tipoPrenda;
    public Trama trama = LISA;
    public CategoriaPrenda categoria;

    public String getCategoria(){
        return categoria.getCategoria();
    }

    public Prenda(Color colorPrimario, Material material, String tipoPrenda, CategoriaPrenda categoria){
        if(categoria.reconoceTipo(tipoPrenda)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }
        else throw new RuntimeException("La categoria no se condice con su tipo");
    }

    public Prenda(Color colorPrimario, Color colorSecundario, Material material, String tipoPrenda, CategoriaPrenda categoria){
        if(categoria.reconoceTipo(tipoPrenda)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.colorSecundario = colorSecundario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }

        else throw new RuntimeException("La categoria no se condice con su tipo");
    }

    /*Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.*/

    public Prenda(String tipoPrenda){
        this.tipoPrenda = tipoPrenda;
    }


}
