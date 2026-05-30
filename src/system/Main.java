package system;

import adapters.EmailInternoAdapter;
import adapters.SmsAdapter;
import anotacoes.TipoNotificador;
import notificador.Notificador;
import services.EmailInterno;
import services.SmsServico;

import java.lang.reflect.Constructor;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Padrão Adapter + Reflexão e Anotação (passo 3) ===\n");

		String tipo = System.getProperty("notificador.tipo", "email");
		System.out.println("Tipo de notificador solicitado: " + tipo);

		try {
			Class<? extends Notificador> adapterClass = null;
			Object servico = null;

			if (tipo.equals("email")) {
				adapterClass = EmailInternoAdapter.class;
				servico = new EmailInterno();
			} else if (tipo.equals("sms")) {
				adapterClass = SmsAdapter.class;
				servico = new SmsServico();
			} else {
				throw new IllegalArgumentException("Tipo inválido: " + tipo);
			}

			if (adapterClass.isAnnotationPresent(TipoNotificador.class)) {
				TipoNotificador anot = adapterClass.getAnnotation(TipoNotificador.class);
				System.out.println("Anotação encontrada: tipo = " + anot.tipo());
			} else {
				System.out.println("A classe não possui a anotação @TipoNotificador");
			}

			Constructor<? extends Notificador> construtor = adapterClass.getConstructor(servico.getClass());
			Notificador notificador = construtor.newInstance(servico);

			SistemaNotificacao sistema = new SistemaNotificacao(notificador);

			sistema.notificar("joao@email.com", "Seu cadastro foi confirmado.");
			sistema.notificar("admin@empresa.com", "Falha de autenticação.");

		} catch (Exception e) {
			System.err.println("Erro ao configurar o notificador: " + e.getMessage());
			e.printStackTrace();
		}
	}
}