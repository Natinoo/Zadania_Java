import java.util.Scanner;

public class zad4
{
    public static void main(String[] args)
    {
        System.out.print("Podaj liczbe: ");
        if(podzielna3i5(new Scanner(System.in).nextFloat()))
            System.out.print("Liczba jest podzielna przez 3 i 5");
        else
            System.out.print("Liczba nie jest podzielna przez 3 i 5");
    }
    public static boolean podzielna3i5(float a)
    {
        if((int) a != a || a%15 != 0)
            return false;
        else
            return true;
    }
}