package qmp;

import java.util.*;
import java.time.*;

public class ServicioMeteorologico {
  private Map<String, Object> ultimaRespuesta;
  private LocalDateTime proximaExpiracion;
  private AccuWeatherAPI api;
  private String direccion;
  private Duration periodoDeValidez;

  public ServicioMeteorologico(AccuWeatherAPI api, Duration periodoDeValidez, String direccion) {
    this.api = api;
    this.proximaExpiracion = proximaExpiracion.plus(periodoDeValidez);
    this.direccion = direccion;
    this.periodoDeValidez = periodoDeValidez;
  }

  public Map<String, Object> obtenerCondicionesClimaticas() {
    if (this.ultimaRespuesta == null || this.expiro()) {
      this.ultimaRespuesta = consultarApi(this.direccion);
      this.proximaExpiracion = LocalDateTime.now().plus(this.periodoDeValidez);
    }
    return this.ultimaRespuesta;
  }

  private Map<String, Object> consultarApi(String direccion) {
    return this.api.getWeather(direccion).get(0);
  }

  private boolean expiro() {
    return proximaExpiracion.isAfter(LocalDateTime.now());
  }
}