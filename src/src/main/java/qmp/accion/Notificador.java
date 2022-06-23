package qmp.accion;

import java.util.List;

public class Notificador implements Accion{
  private NotificationService notificationService;

  public Notificador(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @Override
  public void recibirAlertas(List<String> alertas){
    if(alertas.contains("STORM")){
      notificationService.notify("Lleve paraguas");
    }
    if(alertas.contains("HAIL")){
      notificationService.notify("Evite salir en auto");
    }
  }
}
