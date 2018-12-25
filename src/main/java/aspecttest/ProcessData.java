package aspecttest;

public class ProcessData {

    public static void main(String args[]) {

        ProcessData processData = new ProcessData();

        processData.saveDB();

    }

    public void saveDB() {

        System.out.println("保存数据至 DB");

    }
}