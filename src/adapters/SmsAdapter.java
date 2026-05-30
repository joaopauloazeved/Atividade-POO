package adapters;

import anotacoes.TipoNotificador;
import notificador.Notificador;
import services.SmsServico;

@TipoNotificador(tipo = "sms")
public class SmsAdapter implements Notificador {
	private SmsServico sms;

	public SmsAdapter(SmsServico sms) {
		this.sms = sms;
	}

	@Override
	public void enviar(String destinatario, String mensagem) {
		sms.enviarSms(destinatario, mensagem);
	}
}