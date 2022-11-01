
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
    public void testClientAndConnect() throws Exception {
        MyDevice d =new MyDevice("tcp://localhost:1883","Vera","M J E R A C   V O D E ----->  " );
        d.ClientAndConnect();
    }


}


