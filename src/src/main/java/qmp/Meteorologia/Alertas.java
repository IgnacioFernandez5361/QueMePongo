package qmp.Alertas;

import qmp.Meteorologia.AccuWeatherAPI;

public class Alertas{
  private AccuWeatherAPI api = new AccuWeatherAPI();
  private String ciudad;
  private Map<String, Object> ultimasAlertas;
  
  public Map<String, Object> getAlertas{
    ultimasAlertas = this.api.getsAlerts(ciudad);
    return ultimasAlertas
    }
  public string getNotificaciones{
    /* if ultimasAlertas.contiene ("Storm") --> return "Llevar Paraguas"
    else if ultimasAlertas.contiene("Hail") ----> return "Evita salir en auto"*/
    return "falta terminar";
  }

}
