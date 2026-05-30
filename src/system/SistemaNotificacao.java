package system;

import services.EmailInterno;

/**
 * Cliente do sistema de notificações.
 * ESTÁ ACOPLADO DIRETAMENTE à classe EmailInterno.
 * Para trocar o serviço, precisaríamos alterar este código.
 */
public class SistemaNotificacao {

    private EmailInterno email;

    public SistemaNotificacao() {
        this.email = new EmailInterno(); // dependência concreta
    }

    public void notificar(String usuario, String mensagem) {
        // Chama o método específico do serviço de e-mail
        email.enviarEmail(usuario, "Notificação do sistema", mensagem);
    }
}