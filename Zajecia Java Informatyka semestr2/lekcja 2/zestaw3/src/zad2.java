import java.util.Scanner;

//Napisz program, który pozwoli na wczytanie 10 liczb i wyznaczeniu ilości oraz sumy liczb
//ujemnych i dodatnich podanych przez użytkownika
public class zad2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int sumad = 0, sumau = 0, iloscd = 0, iloscu = 0;
        for (int i = 0; i < 10; i++)
        {
            int liczb;
            System.out.print("\nPodaj liczbe: ");
            liczb = in.nextInt();
            if (liczb > 0) {
                sumad += liczb;
                iloscd++;
            }
            else if(liczb < 0)
            {
                sumau += liczb;
                iloscu++;
            }
        }
        System.out.print("Suma lb dodatnich: "+sumad+", i ich ilosc: "+iloscd);
        System.out.print("\nSuma lb ujmenych: "+sumau+", i ich ilosc: "+iloscu);
    }
}
