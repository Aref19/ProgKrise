package exception;

public class EmailExisted extends  Exception{

    public EmailExisted() {
        super("Email ist shon vorhanden");
    }
}
