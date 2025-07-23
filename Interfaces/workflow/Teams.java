public class Teams implements CanalNotificacao {
    public void notificar(Mensagem mensagem) {
        System.out.println("[TEAMS] {" + mensagem.getTipoMensagem() + "} - " + mensagem.getTexto());
    }
}
