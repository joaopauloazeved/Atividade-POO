package system;

public class Main {

	public static void main(String[] args) {
		SistemaNotificacao sistema = new SistemaNotificacao();
		sistema.notificar("joao@email.com", "Seu cadastro foi confirmado.");
		sistema.notificar("admin@empresa.com", "Falha de autenticação detectada.");
	}
}