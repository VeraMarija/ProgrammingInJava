package com.oss;

import com.oss.lecture1.VeraColor;

import java.awt.Color;


public class ColorConverter {
    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";


        VeraColor c = VeraColor.decode(hexColor);
        System.out.println("decode je " + c.getRed());
        float[] hsbCode = new float[3];
        float[] hslCode = new float[3];
        float[] cmykCode = new float[4];

        VeraColor.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));
        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());
        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");

        VeraColor.RGBtoHSL(c.getRed(), c.getGreen(), c.getBlue(), hslCode);
        System.out.println("Boja u HSL formatu: " + hslCode[0] *60 + "°, " +
                hslCode[1] * 100 + "%, " + hslCode[2] * 100 + "%");

        VeraColor.RGBtoCMYK(c.getRed(), c.getGreen(), c.getBlue(), cmykCode);
        System.out.println("Boja u CMYK formatu: " + cmykCode[0]+ "," +
                Math.round(cmykCode[1])+ "," + Math.round(cmykCode[2])+ "," + Math.round(cmykCode[3]) );
    }
}