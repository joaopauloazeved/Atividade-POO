package system;

import notificador.Notificador;

public class SistemaNotificacao {

	private final Notificador notificador;

	public SistemaNotificacao(Notificador notificador) {
		this.notificador = notificador;
	}

	public void notificar(String usuario, String mensagem) {
		notificador.enviar(usuario, mensagem);
	}
}