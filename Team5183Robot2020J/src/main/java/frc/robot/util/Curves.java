package frc.robot.util;

import java.lang.Math;

public class Curves {
    
    /**Calculates the Y value for an X value on an exponential curve
     * Equation: base^x
     * @param x the X value
     * @param base the constant number of the equation.
     * @return the Y value as a double from 0 to the max X value
     */
    public static double Exponential(double x, double base) {  //TODO test this curve to ensure its working :>
        return ((Math.pow(1+base, x)-1)/base);
    }

    //TODO make the JavaDoc comment for this function
    public static double Sinusoidal(double x, double a, double c, double d) {  //TODO test if this curve works
        return (a(Math.sin(x-c))+d);  //TODO make sure this is the right equation
    }
}