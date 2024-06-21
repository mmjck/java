public class Notification {
    private MessageService service;


    public Notification(MessageService service){
        this.service = service;
    }


    public void notifyUser(String message, String receiver){
        service.sendMessage(message, receiver);
    }
}
