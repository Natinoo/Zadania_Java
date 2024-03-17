import java.util.Scanner;

//Napisz program, który odpowie na pytanie, czy podane przez użytkownika słowo jest
//palindromem. Palindrom to słowo, które jest takie samo czytane od początku i od końca, np.
//kajak
public class zad5
{
    public static void main(String[] args)
    {
        String palnijdrom;
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj slowo, sprawdzimy czy jest palindromem:--> ");
        palnijdrom = in.nextLine();

        palnijdrom=palnijdrom.trim().toLowerCase();
        for(int i=0;i<(palnijdrom.length()+1)/2;i++)
        {
            if(palnijdrom.charAt(i)!=palnijdrom.charAt(palnijdrom.length()-i-1))
            {
                System.out.print(palnijdrom+" nie jest palindromem #brown-1");
                return;
            }

        }
        System.out.print(palnijdrom.substring(0,1).toUpperCase()+palnijdrom.substring(1).toLowerCase()+" jest palindromem!");
    }
}
