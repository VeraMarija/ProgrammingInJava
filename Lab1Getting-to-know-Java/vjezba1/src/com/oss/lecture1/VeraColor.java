package com.oss.lecture1;

import javax.swing.*;
import java.beans.ConstructorProperties;

public class VeraColor {
    int value;

    private static void testColorValueRange(int r, int g, int b, int a) {
        boolean rangeError = false;
        String badComponentString = "";

        if (a < 0 || a > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if (r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if (g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if (b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if (rangeError == true) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }

    public VeraColor(int r, int g, int b) {
        this(r, g, b, 255);
    }

    @ConstructorProperties({"red", "green", "blue", "alpha"})
    public VeraColor(int r, int g, int b, int a) {
        value = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
        testColorValueRange(r,g,b,a);
    }
    public int getRGB() {
        return value;
    }


    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    public int getGreen() {  return (getRGB() >> 8) & 0xFF;}

    public int getBlue() {
        return (getRGB() >> 0) & 0xFF;
    }

    public static VeraColor decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new VeraColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }


    public static float[] RGBtoCMYK(int r, int g, int b, float[] cmykvalue) {
        float cyan,magenda,yellow,K;
        if (cmykvalue == null) {
            cmykvalue = new float[4];
        }

        cyan = 1-(r/255.0f);
        magenda = 1-(g/255.0f);
        yellow = 1-(b/255.0f);

        float var_k=1;
        if ( cyan < var_k )   var_k = cyan;
        if ( magenda < var_k )   var_k = magenda;
        if ( yellow < var_k )   var_k = yellow;

        if ( var_k == 1 ) {
            cyan = 0;
            magenda = 0;
            yellow = 0;
        }
        else {
            cyan = (cyan - var_k) / (1 - var_k);
            magenda = (magenda - var_k) / (1 - var_k);
            yellow = (yellow - var_k) / (1 - var_k);
        }

        K = var_k;
        cmykvalue[0] = cyan*100;
        cmykvalue[1] = magenda*100;
        cmykvalue[2] = yellow*100;
        cmykvalue[3] = K*100;
        return cmykvalue;
    }

    public static float[] RGBtoHSL(int r, int g, int b, float[] hslvalue){
        float hue, saturation, lightness;
        if (hslvalue == null) {
            hslvalue = new float[3];
        }

        float max = ((float) Math.max(Math.max(r,g),b) ) / 255.0f;
        float min = ((float) Math.min(Math.min(r,g),b) ) / 255.0f;

        lightness = ( max + min ) / 2;

        if (min == max) {
            saturation=0 ;
            hue=0;
        }
        else {
            if (lightness <= 0.5)
                saturation = (max - min) / (max + min);
            else
                saturation = (max - min) / (2.0f - max - min);

            if ( (int) max == r )
                hue = (g/255.0f-b/255.0f)/(max-min) ;
            else if ( (int) max == g)
                hue = 2.0f + (b/255.0f-r/255.0f)/(max-min);
            else
                hue = 4.0f + (r/255.0f-g/255.0f)/(max-min);
        }

        hslvalue[0] = hue;
        hslvalue[1] = saturation;
        hslvalue[2] = lightness;
        return hslvalue;
    }

    public static float[] RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

}


