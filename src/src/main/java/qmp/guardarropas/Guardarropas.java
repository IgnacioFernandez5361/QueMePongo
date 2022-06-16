package qmp.guardarropas;

import qmp.propuesta.Propuesta;
import qmp.propuesta.PropuestaAgregar;
import qmp.propuesta.PropuestaQuitado;
import qmp.ServicioMeteorologico;
import qmp.Usuario;
import qmp.prenda.Categoria;
import qmp.prenda.Prenda;

import java.util.List;
import java.util.stream.Stream;


public class Guardarropas {
  private List<Prenda> misPrendas;
  private String nombre;
  private List<Usuario> usuarios;
  private List<Propuesta> propuestas;

  public Guardarropas(List<Prenda> prendas , String nombre , List<Usuario> usuarios,
                      List<Propuesta> propuestas) {
    this.misPrendas = prendas;
    this.propuestas = propuestas;
    this.nombre = nombre;
    this.usuarios = usuarios;
  }

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
  }

  void setMisPrendas(List<Prenda> prendas){
    this.misPrendas = prendas;
  }

  public void quitarPrenda(Prenda prenda) {
    misPrendas.remove(prenda);
  }

  public void agregarPrenda(Prenda prenda){
    misPrendas.add(prenda);
  }

  public void aceptar(Propuesta propuesta){
    propuesta.aceptarEn(this);
    propuestas.add(propuesta);
  }
}
