import java.util.Random;
import java.util.Scanner;

//Napisz metodę, która jako argument przyjmie trzy liczby. Metoda powinna zwrócić true jeśli
//z odcinków o długości przekazanych w argumentach można zbudować trójkąt prostokątny.
//Argumenty przekazywane do metody są liczbami losowymi z przedziału <a,b> a i b wczytywane są
//przez użytkownika z klawiatury
public class zad7
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int x,y,j,k,l;
        System.out.print("Podaj przedzial liczb:\n");
        System.out.print("1 wartosc: ");
        x = in.nextInt();
        System.out.print("2 wartosc: ");
        y = in.nextInt();

        j= (int) (Math.random()*(Math.abs(x-y)+1)+Math.min(x,y));
        k= (int) (Math.random()*(Math.abs(x-y)+1)+Math.min(x,y));
        l= (int) (Math.random()*(Math.abs(x-y)+1)+Math.min(x,y));
        if(trojkat(j,k,l))
        {
            System.out.print("Z bokow "+j+", "+k+", "+l+" da sie zrobic trojkat ");
        }
        else {
            System.out.print("Z bokow "+j+", "+k+", "+l+" nie da sie zrobic trojkat ");
        }
    }
    public static boolean trojkat(int a,int b,int c)
    {
        int A, B, C;
        A=Math.min(a,Math.min(b,c));
        C=Math.max(a,Math.max(b,c));
        B=a+b+c-A-C;
        return A+B>C;
    }
}