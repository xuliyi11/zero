package test.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class  OOMObj{

    }
    public static void main(String[] args) {
        List<OOMObj> objectList = new ArrayList<>();
        while (true) {
            objectList.add(new OOMObj());
        }
    }
}
