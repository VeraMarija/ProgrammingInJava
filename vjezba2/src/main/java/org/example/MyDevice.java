package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Data
public class MyDevice {

    private final String broker;
    private final String clientID;
    private final String topic;
    private final List<Sensor> sensorList = new ArrayList<>();
    private  MqttClient client;

    public void makesensorList(Sensor @NotNull ... s){
        sensorList.addAll(Arrays.asList(s));
    }

    public void ClientAndConnect() {
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            client = new MqttClient(broker, clientID, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            System.out.println("Topic is : " + topic);
            client.connect(connOpts);
            System.out.println("Connected");
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    public void PublishMessage() {
        int qos = 2;
        for (final var s : sensorList) {
            try {
                String content = s.getName() + " je " + Math.round(s.randomGenerator() * 100.0) / 100.0 + " " + s.getUnit();
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                client.publish(topic, message);
                System.out.println("Message published");
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void disconnect(){
        try{
            client.disconnect();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize() {
        System.out.println("odaberite koje mjerenje zelite od ponudenih,unesite broj pokraj mjerenja");
        int i = 0;
        for (final var s : sensorList) {
            //System.in is a standard input stream
            System.out.println(i + " " + s.getName());
            ++i;
        }
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int qos = 2;
        try {
            String content = sensorList.get(a).getName() + " je " +
                    Math.round(sensorList.get(a).randomGenerator() * 100.0) / 100.0 + " " + sensorList.get(a).getUnit();
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            client.publish(topic, message);
            System.out.println("Message published");
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }


}

