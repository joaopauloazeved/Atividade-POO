package system;

import adapters.EmailInternoAdapter;
import adapters.SmsAdapter;
import notificador.Notificador;
import services.EmailInterno;
import services.SmsServico;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Sistema com Adapter (passo 2) ===\n");

		EmailInterno emailServico = new EmailInterno();
		Notificador emailAdapter = new EmailInternoAdapter(emailServico);
		SistemaNotificacao sistemaEmail = new SistemaNotificacao(emailAdapter);
		sistemaEmail.notificar("joao@email.com", "Seu cadastro foi confirmado.");
		sistemaEmail.notificar("admin@empresa.com", "Falha de autenticação.");

		SmsServico smsServico = new SmsServico();
		Notificador smsAdapter = new SmsAdapter(smsServico);
		SistemaNotificacao sistemaSms = new SistemaNotificacao(smsAdapter);
		sistemaSms.notificar("+5511999998888", "Seu código é 123456.");
	}
}