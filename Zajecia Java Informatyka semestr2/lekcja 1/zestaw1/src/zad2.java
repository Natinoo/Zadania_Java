import java.util.Scanner;

public class zad2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj pierwszą liczbe: ");
        float a = in.nextFloat();
        System.out.print("Podaj drugą liczbe: ");
        float b = in.nextFloat();
        matma(a,b);
    }
    public static void matma(float a, float b)
    {
        System.out.print("\n" + "Suma liczb "+a+" + "+b+": " + (a+b));
        System.out.print("\n" + "Różnica liczb(a-b) "+a+" - "+b+": " + (a-b));
        System.out.print("\n" + "Różnica liczb(b-a) "+b+" - "+a+": " + (b-a));
        System.out.print("\n" + "Iloraz liczb(a/b) "+a+" / "+b+": " + (a/b));
        System.out.print("\n" + "Iloczyn liczb "+a+" x "+b+": " + (a*b));
    }
}