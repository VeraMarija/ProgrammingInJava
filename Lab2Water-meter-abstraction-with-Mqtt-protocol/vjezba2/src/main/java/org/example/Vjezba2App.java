package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Vjezba2App {

    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------Vjezba2-----------------------------");
        Sensor sensor1 = new Sensor("temperatura vode", 0.0, 80.0, "Celzijev stupanj");
        Sensor sensor2 = new Sensor("tlak vode", 0.0, 65.336, "Bar");
        Sensor sensor3 = new Sensor("potrosnja u zadnjih 1 tjedan",0.0,6533.6, "m3");

        MyDevice d = new MyDevice("tcp://localhost:1883","Vera","M J E R A C   V O D E ----->  " );
        d.makesensorList(sensor1,sensor2,sensor3);
        d.ClientAndConnect();
        d.PublishMessage();
        d.disconnect();


        System.out.println("-----------------------------Vjezba3-----------------------------");
        ObjectMapper objectmapper = new ObjectMapper();
        List <Sensor> sensors = objectmapper.readValue(new File("src/main/java/org/example/SensorList.json"), new TypeReference<List<Sensor>>(){});
        d.setSensorList(sensors);
        d.ClientAndConnect();
        d.PublishMessage();
        d.disconnect();
        System.out.println("-----------------------------------------------------------------");


    }
}
