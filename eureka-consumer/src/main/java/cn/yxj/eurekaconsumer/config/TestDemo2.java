package cn.yxj.eurekaconsumer.config;

import java.util.concurrent.*;

public class TestDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(new Caculator());
        Future<Integer> future2 = executorService.submit(new Caculator());
        System.out.println("结果1为："+future.get());
        System.out.println("结果2为："+future2.get());
        executorService.shutdown();

    }
}
class Caculator implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        int sum =0 ;
        if(name.endsWith("1")){
            Thread.sleep(3000);
        }
        for (int i = 0; i <= 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
