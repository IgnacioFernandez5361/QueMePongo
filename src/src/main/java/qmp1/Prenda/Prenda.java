package qmp1.Prenda;

import qmp1.Prenda.Categorias.CategoriaPrenda;

public class Prenda {
    private String colorPrimario;
    private String colorSecundario;
    private String material;
    private String tipoPrenda;
    private Trama trama;
    private CategoriaPrenda categoria;

    public String getCategoria(){
        return categoria.getCategoria();
    }

    public Prenda(String colorPrimario, String material, String tipoPrenda, CategoriaPrenda categoria){
        if(categoria.reconoceTipo(tipoPrenda)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }
        else throw new RuntimeException("La categoria no se condice con su tipo");
    }

    public Prenda(String colorPrimario, String colorSecundario, String material, String tipoPrenda, CategoriaPrenda categoria){
        if(categoria.reconoceTipo(tipoPrenda)){
            this.categoria = categoria;
            this.colorPrimario = colorPrimario;
            this.colorSecundario = colorSecundario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
        }
        else throw new RuntimeException("La categoria no se condice con su tipo");
    }
}
