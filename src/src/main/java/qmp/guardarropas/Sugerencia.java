package qmp.guardarropas;

import qmp.prenda.Prenda;

public class Sugerencia {
	Prenda sugerenciaTorso;
	Prenda sugernciaPiernas;
	Prenda sugerenciaPies;
	Prenda sugerenciaAccesorio;

	public Sugerencia(Prenda torso, Prenda piernas, Prenda pies){
		sugerenciaTorso = torso;
		sugernciaPiernas = piernas;
		sugerenciaPies = pies;
	}
	//Constructo con accesorio
	public Sugerencia(Prenda torso, Prenda piernas, Prenda pies ,Prenda accesorio){
		sugerenciaTorso = torso;
		sugernciaPiernas = piernas;
		sugerenciaPies = pies;
		sugerenciaAccesorio = accesorio;
	}

	public boolean prendaUsada(Prenda prenda) {
    	return sugerenciaTorso == prenda || sugernciaPiernas == prenda ||
					sugerenciaPies == prenda || sugerenciaAccesorio == prenda ;
    }
}
