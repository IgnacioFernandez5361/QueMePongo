package qmp.guardarropas;

import qmp.propuesta.EstadoPropuesta;
import qmp.propuesta.Propuesta;
import qmp.meteorologia.ServicioMeteorologico;
import qmp.prenda.Categoria;
import qmp.prenda.Prenda;
import sun.security.ec.SunEC;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Guardarropas {
  private List<Prenda> misPrendas;
  private List<Propuesta> propuestas;

  public Guardarropas(List<Prenda> prendas, List<Propuesta> propuestas) {
    this.misPrendas = prendas;
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

  public Sugerencia generarSugerencia(ServicioMeteorologico servicioMeteorologico){
    Prenda parteSuperior = buscarPrendaValidaDe(Categoria.PARTE_SUPERIOR, servicioMeteorologico);
    Prenda parteInferior = buscarPrendaValidaDe(Categoria.PARTE_INFERIOR, servicioMeteorologico);
    Prenda calzado = buscarPrendaValidaDe(Categoria.CALZADO, servicioMeteorologico);

    if(parteSuperior != null && parteInferior != null && calzado != null) {
      return new Sugerencia(parteSuperior,parteInferior,calzado);
    }
    else{
      return null;
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
}
