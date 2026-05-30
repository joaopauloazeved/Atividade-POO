package adapters;

import notificador.Notificador;
import services.EmailInterno;

public class EmailInternoAdapter implements Notificador {
	private EmailInterno email;

	public EmailInternoAdapter(EmailInterno email) {
		this.email = email;
	}

	@Override
	public void enviar(String destinatario, String mensagem) {
		email.enviarEmail(destinatario, "Notificação do sistema", mensagem);
	}
}