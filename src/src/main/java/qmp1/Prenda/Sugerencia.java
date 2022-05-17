package qmp1.Prenda;

import java.util.Set;

public class Sugerencia {
	
	
	
	Prenda sugerenciaTorso;
	Prenda sugernciaPiernas;
	Prenda sugerenciaPies;
	Prenda sugerenciaAccesorio;
	
	//sugerencia deberia tener de forma obligatoria torso, piernas y pies, y de forma opccional accesorios

	//Constructor sin accesorio
	Sugerencia(Prenda torso, Prenda piernas, Prenda pies){
		sugerenciaTorso = torso;
		sugernciaPiernas = piernas;
		sugerenciaPies = pies;
	}
	//Constructo con accesorio
	Sugerencia(Prenda torso, Prenda piernas, Prenda pies ,Prenda accesorio){
		sugerenciaTorso = torso;
		sugernciaPiernas = piernas;
		sugerenciaPies = pies;
		sugerenciaAccesorio = accesorio;
	}
	
   /*Como usuarie de QuéMePongo, quiero recibir varias 
    * sugerencias que combinen las prendas de mi guardarropas */
	
	void sugerenciaDeGuardarropas() {
		
	}

	
	/*Como usuario QueMePongo, quiero que al aparecer en una sugerencia,
	 *  la aplicación asuma que una prenda ha sido usada.*/
	
	public boolean prendaUsada(Prenda prenda) {
    	return sugerenciaTorso == prenda || sugernciaPiernas == prenda || sugerenciaPies == prenda || sugerenciaAccesorio == prenda ;
    }
	
	
}
