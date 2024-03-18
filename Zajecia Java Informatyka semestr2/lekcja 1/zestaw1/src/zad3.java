import java.util.Scanner;

public class zad3
{
    public static void main(String[] args)
    {
        System.out.print("Podaj liczbe: ");
        if(parzysta(new Scanner(System.in).nextFloat()))
            System.out.print("Liczba jest parzysta");
        else
            System.out.print("Liczba nie jest parzysta");
    }
    public static boolean parzysta(float a)
    {
        if(a == 0 || (int) a != a || a%2 != 0)
            return false;
        else
            return true;
    }
}