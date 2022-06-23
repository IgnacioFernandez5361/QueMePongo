package qmp.accion;

import java.util.List;

public class MailInformativo implements Accion{
  private MailSender mailSender;
  private String direccion;

  public MailInformativo(MailSender mailSender, String direccion) {
    this.mailSender = mailSender;
    this.direccion = direccion;
  }

  @Override
  public void recibirAlertas(List<String> alertas) {
    if(!alertas.isEmpty()){
      mailSender.send(direccion,"Nuevas alertas meteorologicas" +
          String.join(", ", alertas));
    }
  }
}
