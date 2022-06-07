package exception;

public class NotFoundEx extends Exception{
    private  String massege;
    public NotFoundEx(String massege){
        this.massege = massege;
    }
    public void prinEror(){
        System.out.println(massege);
    }
}
