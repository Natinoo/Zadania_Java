import java.util.Scanner;

public class zad5
{
    public static void main(String[] args)
    {
        System.out.print("Podaj liczbe: ");
        float a = new Scanner(System.in).nextFloat();
        System.out.print("Liczba "+a+"^3 = "+pot3(a));
    }
    public static float pot3(float a)
    {
        return a*a*a; //można też (float) Math.pow(a,3)
    }
}