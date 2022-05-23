package exception;

public class ExistenceName extends Exception{
    private  String massege;
    public ExistenceName(String massege){
        this.massege=massege;
    }
    public void prinEror(){
        System.out.println(massege);
    }

}
