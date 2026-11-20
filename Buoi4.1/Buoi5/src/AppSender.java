public class AppSender implements MessageSender {
    @Override
    public String send(String message){
        return "Đã gửi bằng app" + message;
    }
}
