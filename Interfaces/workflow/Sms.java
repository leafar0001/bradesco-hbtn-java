public class Sms implements CanalNotificacao {
    public void notificar(Mensagem mensagem) {
        System.out.println("[SMS] {" + mensagem.getTipoMensagem() + "} - " + mensagem.getTexto());
    }
}
