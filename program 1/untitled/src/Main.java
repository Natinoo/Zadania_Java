import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        float liczba;
        char znak = 'g';
        String imie ="Natan";
        String gogo = "5";
        System.out.print("Hello and welcome!\n"+"To moj pierwszy program stworzony przez "+ imie+"a\n");

        System.out.print("Podaj liczbe: ");
        Scanner pobieranie = new Scanner(System.in);
        liczba = pobieranie.nextFloat();

        for (int i = 1; i <= 5; i++)
        {
            System.out.print(znak);
            System.out.println(i);
        }
        while (liczba >= 5)
        {
            int x = (int) liczba;
            System.out.println("Twoja liczba to: " + x);
            liczba--;

        }
        float z = Float.parseFloat(gogo);
        System.out.print(z);
    }
}