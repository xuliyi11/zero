package test.Thread;

import java.util.concurrent.Callable;

public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        return "123";
    }
}
