package qmp.guardarropas;

import qmp.PropuestaAgregar;
import qmp.ServicioMeteorologico;
import qmp.prenda.Categoria;
import qmp.prenda.Prenda;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Guardarropas {
  private List<Prenda> misPrendas;

  private PropuestaAgregar propuestaAgregar;

/*,String direccion, ServicioMeteorologico servicioMeteorologico*/

  /* De la lista de prendas, filtra son de cierta categoría y se pueden sugerir.
    Si encuentra alguna la devuelve, y si no, devuelve null.
    */

  /*x
  public Prenda buscarPrendaValidaDe(Categoria unaCategoria ) {

    List<Prenda> prendasDisponibles = this.misPrendas.stream().filter(prenda -> prenda.sePuedeSugerir())
        .filter(prenda -> prenda.getTipo().getCategoria() == unaCategoria).collect(Collectors.toList());
    if (prendasDisponibles.size() > 0) {
      for (Prenda p : prendasDisponibles) {
        return p;
      }
    }
    return null;
  }
      */
  public Prenda buscarPrendaValidaDe(Categoria unaCategoria, ServicioMeteorologico servicioMeteorologico ) {

    Stream<Prenda> prendasDeCategoria =  misPrendas.stream().filter(prenda -> prenda.perteneceCategoria(unaCategoria));
    Stream<Prenda> prendasSugeribles = prendasDeCategoria.filter(Prenda::sePuedeSugerir);
    Stream<Prenda> prendas = prendasSugeribles.filter(prenda -> prenda.compatibleConClima(servicioMeteorologico));
    if(prendas.count() == 0){
      return null;
    }
    else{
      return prendas.findFirst().get();
    }
  } //SE PUEDE MEJORAR

  //Puede ser que tengamos que modificar el diseño de SugerenciaBorrador


  public Guardarropas(List<Prenda> prendas, PropuestaAgregar propuestaAgregar){

    this.misPrendas = prendas;
    this.propuestaAgregar = propuestaAgregar;
  }
  //Para tests
  void setMisPrendas(List<Prenda> prendas ){
    this.misPrendas = prendas;
  }


/*
  public void darSugerencia() {

    // Busco una prenda válida de cada tipo para armar la sugerencia
    Prenda torso = buscarPrendaValidaDe(Categoria.PARTE_SUPERIOR);
    Prenda piernas = buscarPrendaValidaDe(Categoria.PARTE_INFERIOR);
    Prenda pies = buscarPrendaValidaDe(Categoria.CALZADO);
    Prenda accesorios = buscarPrendaValidaDe(Categoria.ACCESORIOS);

    // Si encuentra al menos una para torso, piernas y pies: la crea.
    if (torso != null && piernas != null && pies != null) {
      if (accesorios == null) {
        Sugerencia nuevaSugerencia = new Sugerencia(torso, piernas, pies);
      } else {
        Sugerencia nuevaSugerencia = new Sugerencia(torso, piernas, pies, accesorios);
      } //La actualizacion de estado la realiza Sugerencia en el constructor

    } else {
      // Y si no es posible, lanzo excepción.
      throw new RuntimeException("Faltan prendas de alguna categoría en el guardarropas");
    }
  }

 */


  //5°Iteracion

  public void agregarPrenda(Prenda prenda){
    misPrendas.add(prenda);
  }
//hariamos aceptar(new PropuestaAgregar(new Prenda(...)))
  public void aceptar(PropuestaAgregar propuestaAgregar){
    propuestaAgregar.aceptarEn(this);
  }
}
