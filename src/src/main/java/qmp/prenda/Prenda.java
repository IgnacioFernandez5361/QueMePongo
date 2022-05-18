package qmp.prenda;

public class Prenda {
    private Color colorPrimario;
    private Color colorSecundario;
    private Material material;
    private TipoPrenda tipoPrenda;
    private Trama trama = Trama.LISA;
    private int cantVecesUsado = 0;
    private Estado estado = Estado.LIMPIA;

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

    public TipoPrenda getTipo(){
      return this.tipoPrenda;
    }

    public boolean sePuedeSugerir() {
    	if(estado == Estado.LAVANDOSE || estado == Estado.PERCUDIDA){
        return false;
      }
      return true;
    }

    public void actualizarEstadoPrenda() {
    	if(cantVecesUsado == 0){
    		estado = Estado.USADA;
    	} else if(cantVecesUsado == 1) {
    		estado = Estado.SUCIA;
    	} else if(cantVecesUsado == 4) {
    		estado = Estado.PERCUDIDA;
    	}
      cantVecesUsado++;
    }

    public void prendaLavandose() {
      if(estado == Estado.SUCIA){
        estado = Estado.LAVANDOSE;
      }
    }

    public void terminarLavado(){
      if(estado == Estado.LAVANDOSE){
        estado = Estado.LIMPIA;
        cantVecesUsado = 0;
      }
    }
}
