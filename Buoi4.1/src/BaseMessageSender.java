public abstract class BaseMessageSender {
    private String senderName;

    public BaseMessageSender(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    public abstract String send();
}
