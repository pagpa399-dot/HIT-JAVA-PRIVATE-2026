public class SmsSender implements MessageSender{
    @Override
    public String send(String message){
        return "Đã gửi bằng tin nhắn" + message;
    }
}
