public class EmailSender extends BaseMessageSender {

    public EmailSender(String senderName) {
        super(senderName);
    }

//    @Override
//    String send(String message) {
//        return getSenderName() + " gửi email: " + message;
//    }

    @Override
    public String send() {
        return getSenderName() + " gửi email: ";
    }
}