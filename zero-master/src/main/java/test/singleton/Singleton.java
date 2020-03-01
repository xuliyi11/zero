package test.singleton;

public class Singleton {
  /*  private Singleton(){

    }
    private static Singleton singleton;

    private static void getSingleton(){
        singleton = new Singleton();
    }*/

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.hashCode();
    }
}
