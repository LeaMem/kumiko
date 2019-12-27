package com.lea.kumiko.juc.basic;

public class ThreadHappensBefore {

//    public static volatile boolean flag = false;
//
//
//    public static void setFlag() {
//        flag = true;
//    }

    public static Boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        ThreadHappensBefore before = new ThreadHappensBefore();



         new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!flag){
//                    System.out.println("flag 地址是 " + System.identityHashCode(flag));
                    System.out.println(System.currentTimeMillis() + "fail");
                    i++;
                }
                System.out.println("flag 地址是 " + System.identityHashCode(flag));
                System.out.println("结束");
                System.out.println("count = " + i);
            }
        }).start();

        Thread.sleep(1000L);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis() + "准备写");
//                setFlag();
                flag = true;
                System.out.println(System.currentTimeMillis() + "写好了");
            }
        }).start();





       Thread.sleep(5000L);


    }

}
