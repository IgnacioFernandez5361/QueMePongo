package qmp1.Uniforme;

import qmp1.Prenda.Prenda;

abstract class FabricanteUniformes {
/*FALTA*/
    Uniforme fabricarUniforme(){
        return new Uniforme(
                this.fabricarParteSuperior(),
                this.fabricarParteInferior(),
                this.fabricarCalzado()
        );
    }

    abstract Prenda fabricarParteSuperior();
    abstract Prenda fabricarParteInferior();
    abstract Prenda fabricarCalzado();
}

/*
class SanJuan extends FabricanteUniformes{

    Prenda fabricarParteSuperior();
    Prenda fabricarParteInferior();
    Prenda fabricarCalzado();
}


class InstitutoJonson extends FabricanteUniformes{
    Prenda fabricarParteSuperior();
    Prenda fabricarParteInferior();
    Prenda fabricarCalzado();


}
*/