package qmp.Meteorologia;

import qmp.Meteorologia.AccuWeatherAPI;

import java.util.*;
import java.time.*;

public class ServicioMeteorologico {
  private Map<String, Object> ultimaRespuesta;
  private LocalDateTime proximaExpiracion;
  private AccuWeatherAPI api = new AccuWeatherAPI();
  private String direccion;
  private Duration periodoDeValidez;
  private Map<String, List<String>> alertas;

  public ServicioMeteorologico(Duration periodoDeValidez, String direccion) {
    this.proximaExpiracion = LocalDateTime.now();
    this.proximaExpiracion = proximaExpiracion.plus(periodoDeValidez);
    this.direccion = direccion;
    this.periodoDeValidez = periodoDeValidez;
  }

  public Double obtenerTemperatura() {
    Object pronosticoTemperatura = obtenerCondicionesClimaticas().get("Temperature");
    Object valorTemperatura = ((Map) pronosticoTemperatura).get("Value");
    Double temperatura = pasarACelsius(Double.parseDouble(valorTemperatura.toString()));

    return temperatura;
  }

  public Map<String, Object> obtenerCondicionesClimaticas() {
    if (this.ultimaRespuesta == null || this.expiro()) {
      this.ultimaRespuesta = consultarApi();
      this.proximaExpiracion = LocalDateTime.now().plus(this.periodoDeValidez);
    }
    return this.ultimaRespuesta;
  }

  public void actualizarAlertas(){
    Map<String, List<String>> nuevasAlertas = api.getAlerts(direccion);
    if(!alertas.get("CurrentAlerts").equals(nuevasAlertas.get("CurrentAlerts"))){
      alertas = nuevasAlertas;
    }
  }

  public List<String> consultarAlertasActuales(){
    return alertas.get("CurrentAlerts");
  }

  private Map<String, Object> consultarApi() {
    return this.api.getWeather(direccion).get(0);
  }

  private double pasarACelsius(double temperatura){
    return (temperatura - 32) * 5 / 9;
  }

  private boolean expiro() {
    return proximaExpiracion.isAfter(LocalDateTime.now());
  }
}