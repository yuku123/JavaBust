package com.zifang.ex.bust.charpter12.test001;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentratTest {
    private static final Lock lock_test001 = new ReentrantLock();

    @Test
    public void test001() throws InterruptedException {
        new Thread(()-> test001_innerFunction(),"线程1").start();
        new Thread(()->test001_innerFunction(),"线程2").start();
        Thread.sleep(100000L);
    }

    public static void test001_innerFunction(){
        try {
            lock_test001.lock();
            System.out.println(Thread.currentThread().getName()+"获得到锁");
            Thread.sleep(1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock_test001.unlock();
        }
    }

    private static final Lock lock_test002 = new ReentrantLock(true);

    @Test
    public void test002() throws InterruptedException {
        new Thread(()-> test002_innerFunction(),"线程1").start();
        new Thread(()->test002_innerFunction(),"线程2").start();
        Thread.sleep(100000L);
    }

    public static void test002_innerFunction(){
        while (true){
            lock_test002.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock_test002.unlock();
            }
        }
    }

    private static final Lock lock_test003 = new ReentrantLock(false);

    @Test
    public void test003() throws InterruptedException {
        new Thread(()-> test003_innerFunction(),"线程1").start();
        new Thread(()->test003_innerFunction(),"线程2").start();
        Thread.sleep(100000L);
    }

    public static void test003_innerFunction(){
        while (true){
            lock_test003.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock_test003.unlock();
            }
        }
    }
}
