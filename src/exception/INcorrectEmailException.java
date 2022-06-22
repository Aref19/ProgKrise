package exception;

public class INcorrectEmailException  extends  Exception{
     private  String message;
    public INcorrectEmailException() {
        super("Leider Email incorrect");
    }

}
