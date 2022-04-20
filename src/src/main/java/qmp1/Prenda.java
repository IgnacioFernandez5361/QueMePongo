package qmp1;

public class Prenda {
    private String colorPrimario;
    private String colorSecundario;
    private String material;
    private String tipoPrenda;
    private CategoriaPrenda categoria;

    public String getCategoria(){
        return categoria.toString();
    }

    public Prenda(String colorPrimario, String material, String tipoPrenda, CategoriaPrenda categoria){
        this.categoria = categoria;
        this.colorPrimario = colorPrimario;
        this.material = material;
        this.tipoPrenda = tipoPrenda;
    }

    public Prenda(String colorPrimario, String colorSecundario, String material, String tipoPrenda, CategoriaPrenda categoria){
        this.categoria = categoria;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.tipoPrenda = tipoPrenda;
    }
}
