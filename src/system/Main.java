package system;

import anotacoes.TipoNotificador;
import notificador.Notificador;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static final Map<String, Class<? extends Notificador>> ADAPTER_MAP = new HashMap<>();

	static {
		carregarAdapters();
	}

	@SuppressWarnings("unchecked")
	private static void carregarAdapters() {

		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();

			URL url = loader.getResource("adapters");

			if (url == null) {
				throw new RuntimeException("Pacote adapters não encontrado.");
			}

			File pasta = new File(url.toURI());

			for (File arquivo : pasta.listFiles()) {

				String nome = arquivo.getName();

				if (!nome.endsWith(".class")) {
					continue;
				}

				String classeNome = "adapters." + nome.replace(".class", "");

				Class<?> classe = Class.forName(classeNome);

				if (!Notificador.class.isAssignableFrom(classe)) {
					continue;
				}

				if (!classe.isAnnotationPresent(TipoNotificador.class)) {
					continue;
				}

				TipoNotificador anotacao = classe.getAnnotation(TipoNotificador.class);

				ADAPTER_MAP.put(anotacao.tipo(), (Class<? extends Notificador>) classe);

				System.out.println("[REGISTRADO] " + classe.getSimpleName() + " -> " + anotacao.tipo());
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar adapters", e);
		}
	}

	public static void main(String[] args) {

		System.out.println("\n=== Padrão Adapter + Reflexão e Anotação (passo 3) ===\n");

		String tipo = System.getProperty("notificador.tipo", "email");

		try {

			Class<? extends Notificador> adapterClass = ADAPTER_MAP.get(tipo);

			if (adapterClass == null) {
				throw new RuntimeException("Nenhum adapter encontrado para: " + tipo);
			}

			Constructor<?> constructor = adapterClass.getDeclaredConstructors()[0];

			Class<?> servicoClass = constructor.getParameterTypes()[0];

			Object servico = servicoClass.getDeclaredConstructor().newInstance();

			Notificador notificador = (Notificador) constructor.newInstance(servico);

			TipoNotificador anot = adapterClass.getAnnotation(TipoNotificador.class);

			System.out.println("Anotação encontrada: " + anot.tipo());

			SistemaNotificacao sistema = new SistemaNotificacao(notificador);

			sistema.notificar("joao@email.com", "Seu cadastro foi confirmado.");

			sistema.notificar("admin@empresa.com", "Falha de autenticação.");

		} catch (Exception e) {

			System.err.println("Erro: " + e.getMessage());

			e.printStackTrace();
		}
	}
}