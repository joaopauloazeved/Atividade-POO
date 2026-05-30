package services;

public class EmailInterno {
	public void enviarEmail(String destino, String titulo, String corpo) {
		System.out.println("[EmailInterno] Enviando e-mail...");
		System.out.println("  Para:   " + destino);
		System.out.println("  Título: " + titulo);
		System.out.println("  Corpo:  " + corpo);
		System.out.println();
	}
}