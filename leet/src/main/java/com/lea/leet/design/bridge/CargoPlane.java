package com.lea.leet.design.bridge;

public class CargoPlane extends Airplane {

    public CargoPlane(AirplaneMaker maker) {
        super(maker);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("CargoPlane fly.");
    }

    public static void main(String[] args) {

        //飞机制造商为 Airbus
        AirplaneMaker maker = new Airbus();

        //飞机类型为 PassengerPlane
        Airplane plane = new PassengerPlane(maker);

        plane.fly();

        //飞机制造商为 MD
        AirplaneMaker airplaneMaker = new MD();

        Airplane airplane = new CargoPlane(airplaneMaker);

        airplane.fly();

    }
}
