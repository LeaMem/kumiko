package com.lea.leet.design.abstractFactory;

public class SumFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new SumPhone();
    }

    @Override
    public Computer createComputer() {
        return new SumComputer();
    }


    public static void main(String[] args) {

        Factory appleFac = new AppleFactory();
        Phone applePhone = appleFac.createPhone();
        Computer appleComputer = appleFac.createComputer();
        applePhone.activate();
        System.out.println(appleComputer.getOsName());


        Factory sumFac = new SumFactory();
        Phone sumPhone = sumFac.createPhone();
        Computer sumComputer = sumFac.createComputer();
        sumPhone.activate();
        System.out.println(sumComputer.getOsName());

    }

}
