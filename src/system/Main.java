package system;

public class Main {

	public static void main(String[] args) {
		 System.out.println("=== Sistema sem Adapter (passo 1) ===\n");
		SistemaNotificacao sistema = new SistemaNotificacao();
		sistema.notificar("joao@email.com", "Seu cadastro foi confirmado.");
		sistema.notificar("admin@empresa.com", "Falha de autenticação detectada.");
	}
}