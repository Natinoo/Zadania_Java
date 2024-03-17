//Wykorzystując algorytm z zadania 7, napisz program który pozwoli użytkownikowi na
//wylosowanie n liczb z przedziału (-10,45) i obliczy sumę wszystkich liczb parzystych w danym
//ciągu.

import java.util.Scanner;

public class zad4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n,suma=0;
        System.out.print("Podaj ilosc liczb: \n");
        n = in.nextInt();
        for(int i=0;i<n;i++)
        {
            int m;
            m= (int) (Math.random()*(45+10+1)-10);
            System.out.print("\nLiczba "+(i+1)+": "+m);
            if(m%2==0)
            {
                suma+=m;
            }
        }
        System.out.print("\nSuma parzystych liczb: "+suma);
    }
}
