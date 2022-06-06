package test.second.convert;

public class Fahrenheit implements Convert{
public static double convert(double digit) {
final double nine = 9;
        final double five = 5;
        final double thirtyTwo = 32;
        return digit * nine / five + thirtyTwo;
        }
}

