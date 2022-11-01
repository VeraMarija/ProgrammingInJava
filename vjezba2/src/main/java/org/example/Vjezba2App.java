package org.example;

public class Vjezba2App {

    public static void main(String[] args) {

        Sensor sensor1 = new Sensor("temperatura vode", -3266.8, 3266.8, "Celzijev stupanj");
        Sensor sensor2 = new Sensor("tlak vode", 0.0, 65.336, "Bar");
        Sensor sensor3 = new Sensor("potrosnja u zadnjih 1 tjedan",0.0,6533.6, "m3");

        MyDevice d = new MyDevice("tcp://localhost:1883","Vera","M J E R A C   V O D E ----->  " );

        d.makesensorList(sensor1,sensor2,sensor3);
        d.ClientAndConnect();
        d.PublishMessage();
        d.disconnect();


        d.ClientAndConnect();
        d.deserialize();
        d.disconnect();

    }
}