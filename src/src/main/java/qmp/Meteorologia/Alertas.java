package qmp.Alertas;

import qmp.Meteorologia.AccuWeatherAPI;

public class Alertas{
  private AccuWeatherAPI api = new AccuWeatherAPI();
  private String ciudad;
  
  public Map<String, Object> getAlertas{
    return this.api.getAlerts(ciudad);
    }

}
