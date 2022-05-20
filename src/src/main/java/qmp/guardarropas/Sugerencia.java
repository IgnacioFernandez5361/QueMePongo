package qmp.guardarropas;

import qmp.prenda.Prenda;

public class Sugerencia {
	Prenda sugerenciaTorso;
	Prenda sugerenciaPiernas;
	Prenda sugerenciaPies;
	Prenda sugerenciaAccesorio;

	public Sugerencia(Prenda torso, Prenda piernas, Prenda pies){
		sugerenciaTorso = torso;
		sugerenciaPiernas = piernas;
		sugerenciaPies = pies;
		usarPrendas(); //Cuando crea la sugerencia envia mensaje a Prenda que fue usada

	}
	//Constructo con accesorio
	public Sugerencia(Prenda torso, Prenda piernas, Prenda pies ,Prenda accesorio){
		sugerenciaTorso = torso;
		sugerenciaPiernas = piernas;
		sugerenciaPies = pies;
		sugerenciaAccesorio = accesorio;
		usarPrendas();
	}

	private void usarPrendas() {
		sugerenciaTorso.seUsa();
		sugerenciaPiernas.seUsa();
		sugerenciaPies.seUsa();
		if(this.sugerenciaAccesorio !=null){
			sugerenciaAccesorio.seUsa();;
		}
	}

	public boolean prendaUsada(Prenda prenda) {
    	return sugerenciaTorso == prenda || sugerenciaPiernas == prenda ||
					sugerenciaPies == prenda || sugerenciaAccesorio == prenda ;
    }
}
