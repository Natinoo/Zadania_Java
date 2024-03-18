import java.util.Scanner;

public class zad6
{
    public static void main(String[] args)
    {
        System.out.print("Podaj liczbe: ");
        float a = new Scanner(System.in).nextFloat();
        System.out.print("Liczba "+a+"^(1/2) = "+kwadratKorzen(a));
    }
    public static float kwadratKorzen(float a)
    {
        return (float) Math.pow(a,(1.0/2)); //można też "(float) Math.sqrt(a)" albo "(float) Math.pow(a,0.5)"
    }
}