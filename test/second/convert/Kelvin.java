package test.second.convert;

public class Kelvin implements Convert {
    public static double convert(double digit) {
        final double kel = 273.15;
        return digit + kel;
    }
}