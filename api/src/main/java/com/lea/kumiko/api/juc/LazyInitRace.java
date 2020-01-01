package com.lea.kumiko.api.juc;

import com.lea.kumiko.api.dto.Person;

import java.util.concurrent.TimeUnit;

public class LazyInitRace {

    private Person person = null;

    public Person getInstance()  {
        if(person == null){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person = new Person();
            person.setAge(12);
            person.setName("ding");
            System.out.println("init" + " " + System.identityHashCode(person));
        }
        return person;
    }

    public static void main(String[] args) {

        LazyInitRace lazyInitRace = new LazyInitRace();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Person instance = lazyInitRace.getInstance();
                System.out.println(instance.getName());
                System.out.println("first " + System.identityHashCode(instance));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Person instance = lazyInitRace.getInstance();
                System.out.println(instance.getName());
                System.out.println("second " + System.identityHashCode(instance));
            }
        }).start();

    }

}
