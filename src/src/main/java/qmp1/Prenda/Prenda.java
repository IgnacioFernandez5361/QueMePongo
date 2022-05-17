package qmp1.Prenda;


import java.util.Set;

public class Prenda {
    public Color colorPrimario;
    public Color colorSecundario;
    public Material material;
    public TipoPrenda tipoPrenda;
    public Trama trama = Trama.LISA;
    public int cantVecesUsado;
    public Estado estado;


    public Prenda(Color colorPrimario, Material material, TipoPrenda tipoPrenda, Trama trama){
            this.colorPrimario = colorPrimario;
            this.material = material;
            this.tipoPrenda = tipoPrenda;
            this.trama = trama;
    }

    public Prenda(Color colorPrimario, Color colorSecundario, Material material, TipoPrenda tipoPrenda, Trama trama){
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.tipoPrenda = tipoPrenda;
        this.trama = trama;
    }



    
    public boolean prendaValida() {
    	return false;

    }
    

    /*Nuevos requerimientos*/

    /*Asi para que se instancio, si o si tenemos que pasarle unicamente el tipo de prenda primero, ni mas ni menos*/

   protected Set<Sugerencia> sugerencias;
    
    void actualizarEstadoPrenda() {
    	if( sugerencias.stream().anyMatch(sugerencia -> sugerencia.prendaUsada(this) ) && cantVecesUsado < 2){
    		estado = Estado.USADA;
    	}
    	if(cantVecesUsado == 2) {
    		estado = Estado.SUCIA ;
    	}
    	if(cantVecesUsado == 3 && estado == Estado.SUCIA) {
    		estado = Estado.PERCUDIDA;
    		//ya no es valida para sugieran 
    	}
    }
   
    void prendaLavandose() {
    	estado = Estado.LAVANDOSE;
    	
    }
    
    
    	
}
