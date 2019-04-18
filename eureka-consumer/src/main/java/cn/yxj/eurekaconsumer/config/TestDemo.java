package cn.yxj.eurekaconsumer.config;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=3;i++){
                printer.loopA(i);}
            }
        },"1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=3;i++){
                    printer.loopB(i);}
            }
        },"2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=3;i++){
                    printer.loopC(i);}
            }
        },"3").start();
    }
}

class Printer{
    private int numer = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void loopA(int total){
        try{
            lock.lock();
            if(numer!=1){
                condition1.await();
            }
            for (int i=0;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"---"+"A---"+ total);
            }
            numer=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void loopB(int total){
        try{
            lock.lock();
            if(numer!=2){
                condition2.await();
            }
            for (int i=0;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"---"+"B---"+ total);
            }
            numer=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void loopC(int total){
        try{
            lock.lock();
            if(numer!=3){
                condition3.await();
            }
            for (int i=0;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"---"+"C---"+ total);
            }
            numer=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


