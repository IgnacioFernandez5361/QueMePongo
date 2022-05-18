package qmp.uniforme;

import qmp.prenda.*;

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

class SanJuan extends FabricanteUniformes{


    /*chomba verde de piqué*/
    Prenda fabricarParteSuperior(){
        BorradorPrenda borrador =  new BorradorPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR));
        borrador.agregarColorPrimario(Color.VERDE); /*Arreglar TipoPrenda, sino va a tener problema para habilitar colores y materiales*/
        borrador.agregarMaterial(Material.PIQUE);
        return  borrador.generarPrenda();

    }
    /*pantalón de acetato gris*/
    Prenda fabricarParteInferior(){
        BorradorPrenda borrador = new BorradorPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR));
        borrador.agregarColorPrimario(Color.GRIS);
        borrador.agregarMaterial(Material.ACETATO);
        return  borrador.generarPrenda();
    }
    /*zapatillas blancas*/
    Prenda fabricarCalzado(){
        BorradorPrenda borrador = new BorradorPrenda(new TipoPrenda(Categoria.CALZADO));
        borrador.agregarColorPrimario(Color.BLANCO);
        return  borrador.generarPrenda();
    }
}


class InstitutoJonson extends FabricanteUniformes{

    /*camisa blanca*/
    Prenda fabricarParteSuperior(){
        BorradorPrenda borrador =  new BorradorPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR));
        borrador.agregarColorPrimario(Color.BLANCO);
        return borrador.generarPrenda();
    }
    /* pantalón de vestir negro */
    Prenda fabricarParteInferior(){
        BorradorPrenda borrador = new BorradorPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR));
        borrador.agregarColorPrimario(Color.NEGRO);
        borrador.agregarMaterial(Material.DE_VESTIR);
        return borrador.generarPrenda();
    }
    /* zapatos negros*/
    Prenda fabricarCalzado(){
        BorradorPrenda borrador = new BorradorPrenda(new TipoPrenda(Categoria.CALZADO));
        borrador.agregarColorPrimario(Color.NEGRO);
        return  borrador.generarPrenda();
    }


}
/*Dudas:

1)en la 1º iteracion uno de los requerimientos para validar prenda es que el color, trama y material sean consistentes para el TipoPrenda.

Es decir: TipoPrenda deberia tener atributos "coloresConsistentes", "tramasConsistentes" y "materialesConsistentes", pero me di cuenta que a la hora de crear nuevos TipoPrenda (para Uniformes por ejemplo) Se nos complica crear esas lista, y nos surgio la duda si realmente van esos atributos.
Se me habia ocurrido cambiar los atributos de esta forma:
coloresConsistentes => coloresInconsistentes
Asi cuando construyo TipoPrenda puedo enviar null como parametro, pero se me hace raro enviar tantos null

Esta bien ese cambio o esos atributos directamente no van en TipoPrenda?

2)
Para Uniforme esta siguiendo el ejemplo de la clase y creando el SanJuan e InstitutoJonson como subclases que heredan de FabricanteUniforme los mensajes:

abstract Prenda fabricarParteSuperior();
    abstract Prenda fabricarParteInferior();
    abstract Prenda fabricarCalzado();

El problema es que las caracteristicas de los uniforme a veces no coinciden con los requeremientos para las validaciones:

Ejemplo, SanJuan tenia de calzado zapatillas blancas, no menciona el material, por lo que si construyo asi la prenda no la validara por el requerimiento de que material no podia ser null.

Hay varios ejemplos parecidos.Instituto Jonson tiene camisa blanca, pantalón de vestir negro y zapatos negros.

En este caso que deberia hacer?
- Deberia crear una constante POR_DEFECTO en Material, para asi enviar un borrador.agregarMaterial(Material.POR_DEFECTO);
- Construyo esa prenda sin el parametro (no lo validara)
- Le invento algun material , por ejemplo, SINTETICO en Material

3) Como puedo hacer para crear una constante:

 constant CHOMBA = new TipoPrenda(Categoria.PARTE_SUPERIOR)

 para asi utilizarla y no crear un nueva


 */

