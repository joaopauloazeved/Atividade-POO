package system;

import services.EmailInterno;

public class SistemaNotificacao {

	private EmailInterno email;

	public SistemaNotificacao() {
		this.email = new EmailInterno();
	}

	public void notificar(String usuario, String mensagem) {
		email.enviarEmail(usuario, "Notificação do sistema", mensagem);
	}
}