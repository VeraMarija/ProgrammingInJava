package com.oss.testunit;

import static org.junit.Assert.*;
import com.oss.lecture1.VeraColor;
import org.junit.Test;

public class TestLogic {
/*link su dependencies
* skini paket rucno ubaci u projekt
* 2.nacin maven ili gradle
*
*
*  */
    @Test
    public void testColorDecode(){
        assertEquals(31, VeraColor.decode("0x1FF0FF").getRed());
        assertEquals(240, VeraColor.decode("0x1FF0FF").getGreen());
        assertEquals(255, VeraColor.decode("0x1FF0FF").getBlue());
    }

    float[] hsbCode = new float[3] , hslCode= new float[3],cmykCode=new float[4];

    @Test
    public void testRGBtoHSB(){
        hsbCode=VeraColor.RGBtoHSB(31,240,255,hsbCode);
        assertEquals(184.01784/360,hsbCode[0],0.1);
        assertEquals(87.84314/100,hsbCode[1],0.1);
        assertEquals(100.0/100,hsbCode[2],0.1);
    }


    @Test
    public void testRGBtoHSL(){
        hslCode=VeraColor.RGBtoHSL(31,240,255,hslCode);
        assertEquals(184.01784/60,hslCode[0],0.1);
        assertEquals(100.0/100,hslCode[1],0.1);
        assertEquals(56.078434/100,hslCode[2],0.1);
    }


    @Test
    public void testRGBtoCMYK(){
        cmykCode=VeraColor.RGBtoCMYK(31,240,255,cmykCode);
        assertEquals(88,Math.round(cmykCode[0]));
        assertEquals(6,Math.round(cmykCode[1]));
        assertEquals(0,Math.round(cmykCode[2]));
        assertEquals(0,Math.round(cmykCode[3]));
    }
}


