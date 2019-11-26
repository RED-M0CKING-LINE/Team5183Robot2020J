package frc.robot.util;

public class Curves {
    
    /**Calculates the Y value for an X value on an exponential curve
     * Equation: base^x
     * @param x the X value
     * @param base the constant number of the equation.
     * @return the Y value as a double from 0 to the max X value
     */
    public static double Exponential(double x, double base) {  //TODO test this curve to ensure its working :>
        return ((java.lang.Math.pow(1+base, x)-1)/base);
    }
    
}