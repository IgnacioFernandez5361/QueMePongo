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
		torso.seUsa(); //Cuando crea la sugerencia envia mensaje a Prenda que fue usada
		piernas.seUsa();
		pies.seUsa();
	}
	//Constructo con accesorio
	public Sugerencia(Prenda torso, Prenda piernas, Prenda pies ,Prenda accesorio){
		sugerenciaTorso = torso;
		sugernciaPiernas = piernas;
		sugerenciaPies = pies;
		sugerenciaAccesorio = accesorio;
		torso.seUsa();
		piernas.seUsa();
		pies.seUsa();
		accesorio.seUsa();
	}

	public boolean prendaUsada(Prenda prenda) {
    	return sugerenciaTorso == prenda || sugernciaPiernas == prenda ||
					sugerenciaPies == prenda || sugerenciaAccesorio == prenda ;
    }
}
