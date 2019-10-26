package co.edu.uniremington.transversal.notificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uniremington.transversal.enumeracion.ComponenteEnumeracion;
import co.edu.uniremington.transversal.excepcion.ExcepcionCustomizada;
import co.edu.uniremington.transversal.loggin.Logger;

@Component
public class Notificacion {

	@Value("${api.key.notificador}")
	private String apiKey;

	@Autowired
	private Logger logger;

	public void notificar(String correo, String asunt, String cuerpo) {

		SendGrid sendGridClient = new SendGrid(apiKey);
		Email from = new Email("admin@app.com", "Aplicacion Prueba");
		Email to = new Email(correo);
		Content contenido = new Content("text/plain", cuerpo);
		Mail mail = new Mail(from, asunt, to, contenido);
		Request peticionCorreo = new Request();

		try {
			peticionCorreo.setMethod(Method.POST);
			peticionCorreo.setEndpoint("mail/send");
			peticionCorreo.setBody(mail.build());

			sendGridClient.api(peticionCorreo);

			logger.trazarEvento("correo enviado a " + correo + " Exitosamente");
		} catch (Exception e) {
			String mensajeUsuario = "Hubo un problema notificando por el correo el mensaje";
			String mensajeTecnico = "No s puede enviar correo a " + correo;
			ExcepcionCustomizada excepcionCustomizada = ExcepcionCustomizada.crear(mensajeTecnico, mensajeUsuario, e,
					ComponenteEnumeracion.TRANSVERSAL);
			logger.trazarTraza(excepcionCustomizada.toString());
		}
	}

}
