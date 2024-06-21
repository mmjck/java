public class SMSService implements MessageService{

    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("Send message");
    }
    
}
