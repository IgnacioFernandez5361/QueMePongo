package qmp.guardarropas;

import qmp.propuesta.EstadoPropuesta;
import qmp.propuesta.Propuesta;
import qmp.propuesta.PropuestaAgregar;
import qmp.propuesta.PropuestaQuitado;
import qmp.ServicioMeteorologico;
import qmp.Usuario;
import qmp.prenda.Categoria;
import qmp.prenda.Prenda;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Guardarropas {
  private List<Prenda> misPrendas;
  private String nombre;
  private List<Propuesta> propuestas;

  /*Pensaba cambiar atributo:
   * MisPrendas => prendaSuperior, prendaInferior, prendaCalzado, etc*/

  private List<Prenda> prendasSuperiores;
  private Set<Prenda> prendasInferiores;
  private Set<Prenda> prendasCalzado;


  public Guardarropas(List<Prenda> prendas, String nombre, List<Propuesta> propuestas) {
    this.misPrendas = prendas;
    this.nombre = nombre;
    this.propuestas = propuestas;
  }

  public Prenda buscarPrendaValidaDe(Categoria unaCategoria, ServicioMeteorologico servicioMeteorologico) {
    Stream<Prenda> prendasDeCategoria = misPrendas.stream().filter(prenda -> prenda.perteneceCategoria(unaCategoria));
    Stream<Prenda> prendasSugeribles = prendasDeCategoria.filter(Prenda::sePuedeSugerir);
    Stream<Prenda> prendas = prendasSugeribles.filter(prenda -> prenda.compatibleConClima(servicioMeteorologico));
    if (prendas.count() == 0) {
      return null;
    } else {
      return prendas.findFirst().get();
    }
  }

  void setMisPrendas(List<Prenda> prendas) {
    this.misPrendas = prendas;
  }

  public void quitarPrenda(Prenda prenda) {
    misPrendas.remove(prenda);
  }

  public void agregarPrenda(Prenda prenda) {
    misPrendas.add(prenda);
  }

  public List<Propuesta> getPropuestasSegun(EstadoPropuesta estado) {
    return this.propuestas
        .stream()
        .filter(propuesta -> propuesta.estado == estado)
        .collect(Collectors.toList());
  }

  public List<Propuesta> propuestasPendientes() {
    return getPropuestasSegun(EstadoPropuesta.PENDIENTE);
  }

  public void agregarPropuesta(Propuesta propuesta) {
    propuestas.add(propuesta);
  }

  public void deshacerPropuestasAceptadas() {
    List<Propuesta> propuestasAceptadas = getPropuestasSegun(EstadoPropuesta.ACEPTADA);
    propuestasAceptadas.forEach(propuesta -> propuesta.deshacerEn(this));
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.aceptarEn(this);
  }
/*
  //Iteracion 3
  public Atuendo generarSugerencia(){
    return new Atuendo(prendasSuperiores.stream().findFirst(), prendasInferiores.stream().findFirst(), prendasCalzado.stream().findFirst());
  }*/
}
