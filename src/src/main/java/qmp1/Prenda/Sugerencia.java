package qmp1.Prenda;

import java.util.Set;

public class Sugerencia {
	
	
	
	Prenda sugerenciaTorso;
	Prenda sugernciaPiernas;
	Prenda sugerenciaPies;
	Prenda sugerenciaAccesorio;
	
	//accesorio no sabria como hacerlo opcional
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
