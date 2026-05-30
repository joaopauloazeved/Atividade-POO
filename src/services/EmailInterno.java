package services;

public class EmailInterno {

	public void enviarEmail(String destino, String titulo, String texto) {
		System.out.println("[EmailInterno] Enviando e-mail...");
		System.out.println("  Para:   " + destino);
		System.out.println("  Título: " + titulo);
		System.out.println("  Texto:  " + texto);
		System.out.println();
	}
}