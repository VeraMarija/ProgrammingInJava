
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;


public class TestLogic{
    @Test
    public void testMakeSensorList() throws Exception{
        Sensor s1= new Sensor("temperatura vode", -3266.8, 3266.8, "Celzijev stupanj");
        Sensor s2 = new Sensor("tlak vode", 0.0, 65.336, "Bar");
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(s1);
        sensors.add(s2);
        MyDevice d = new MyDevice("tcp://localhost:1883","Vera","M J E R A C   V O D E ----->  " );
        d.makesensorList(s1,s2);
        List<Sensor> sensors2 = d.getSensorList();
        Assert.assertEquals(sensors,sensors2);
        }

   @Test
    public void testClientAndConnect() {
        try {
            MqttClient mqttClient = new MqttClient("tcp://localhost:1880","Vera455");
            mqttClient.connect();
        } catch (MqttException exception){
            var reason = exception.getReasonCode();
            String msg = exception.getMessage();
            String loc = exception.getLocalizedMessage();
            String cause = String.valueOf(exception.getCause());
            Assert.assertEquals(32103, reason);
            Assert.assertEquals("Unable to connect to server", msg);
            Assert.assertEquals("Unable to connect to server", loc);
            Assert.assertEquals("java.net.ConnectException: Connection refused: no further information", cause);

            System.out.println(reason);
            System.out.println(msg);
            System.out.println(loc);
            System.out.println(cause);

        }
    }
}

