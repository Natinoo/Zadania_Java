import java.util.Scanner;

//Dany jest ciąg n liczb (n>0), napisz program pozwalający na obliczenie sumy wszystkich liczb
//parzystych w danym ciągu.
public class zad3
{
    public static void main(String[] args)
    {
        int sumaP=0;
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Please, how big you want your ciag to be?\n \\--> ");
        n = in.nextInt();
        if(n<=0)
        {
            System.out.print("\nyou think you smart,no");
            return;
        }
        for(int i = 0; i < n; i++)
        {
            float liczba;
            System.out.print("\nPodaj "+(i+1)+" liczbe twojego ciagu: ");
            liczba = in.nextInt();
            if(liczba%2==0)
            {
                sumaP+=liczba;
            }
        }
        System.out.print("\nSuma liczb parzystych z twojego numerical sequence is: "+sumaP);
    }
}

