package exception;

public class ExceptionsName extends Exception{
    private  String massege;
    public ExceptionsName(String massege){
        this.massege = massege;
    }
    public void prinEror(){
        System.out.println(massege);
    }

}
