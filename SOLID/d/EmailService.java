public class EmailService implements MessageService{

    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("Send email");
    }
     
}
