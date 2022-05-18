package qmp.guardarropas;

import qmp.prenda.Categoria;
import qmp.prenda.Prenda;

import java.util.List;
import java.util.stream.Collectors;


public class Guardarropas {
  private List<Prenda> misPrendas;

  public Prenda buscarPrendaValidaDe(Categoria unaCategoria) {
    /* De la lista de prendas, filtra son de cierta categoría y se pueden sugerir.
    Si encuentra alguna la devuelve, y si no, devuelve null.
    */

    List<Prenda> prendasDisponibles = this.misPrendas.stream().filter(prenda -> prenda.sePuedeSugerir())
        .filter(prenda -> prenda.getTipo().getCategoria() == unaCategoria).collect(Collectors.toList());
    if (prendasDisponibles.size() > 0) {
      for (Prenda p : prendasDisponibles) {
        return p;
      }
    }
    return null;
  }

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
}
