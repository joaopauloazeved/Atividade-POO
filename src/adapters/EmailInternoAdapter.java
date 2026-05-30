package adapters;

import anotacoes.TipoNotificador;
import notificador.Notificador;
import services.EmailInterno;

@TipoNotificador(tipo = "email")
public class EmailInternoAdapter implements Notificador {

	private final EmailInterno email;

	public EmailInternoAdapter(EmailInterno email) {
		this.email = email;
	}

	@Override
	public void enviar(String destinatario, String mensagem) {
		email.enviarEmail(destinatario, "Notificação do Sistema", mensagem);
	}
}