package JUC_pv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskComputer implements Callable<Boolean>{

    private static Integer count;
    public FutureTaskComputer(Integer count){
        this.count = count;
    }

    private Integer computer(){
        int result = 1;
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            result += i;
        }
        return result;
    }

    @Override
    public Boolean call() throws Exception {
        final Integer computer = computer();
        if(computer % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}
