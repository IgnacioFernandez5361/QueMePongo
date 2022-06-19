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
			usarPrendas();
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
		if(this.sugerenciaAccesorio != null){
			sugerenciaAccesorio.seUsa();
		}
	}

	public boolean prendaUsada(Prenda prenda) {
    	return sugerenciaTorso == prenda || sugerenciaPiernas == prenda ||
					sugerenciaPies == prenda || sugerenciaAccesorio == prenda ;
    }

	//para tests
	public Prenda getSugerenciaTorso(){
		return sugerenciaTorso;
	}

	public Prenda getSugerenciaPies(){
		return sugerenciaPies;
	}

	public Prenda getSugerenciaPiernas(){
		return sugerenciaPiernas;
	}

	public Prenda getSugerenciaAccesorio(){
		return sugerenciaAccesorio;
	}

}
