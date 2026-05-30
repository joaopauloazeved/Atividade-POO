package services;

public class SmsServico {
	public void enviarSms(String numero, String texto) {
		System.out.println("[SmsServico] Enviando SMS...");
		System.out.println("  Número: " + numero);
		System.out.println("  Texto:  " + texto);
		System.out.println();
	}
}