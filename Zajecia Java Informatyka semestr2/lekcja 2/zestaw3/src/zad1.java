import java.util.Scanner;

//Grupa laboratoryjna składa się z n studentów (wartość n podaje użytkownik). Wprowadzamy
//liczbę punktów dla każdego studenta. Napisz program, który obliczy średnią liczbę punktów w
//grupie z wykorzystaniem pętli while
public class zad1
{
    public static void main(String[] args)
    {
        int student;
        float suma=0;
        int i=0;
        System.out.print("Podaj ilu mamy studentow: \n");
        Scanner in = new Scanner(System.in);
        student = in.nextInt();
        while(i<student)
        {
           System.out.print("Podaj pkt studenta "+(i+1)+": ");
           suma+= in.nextInt();
           i++;
        }
        suma = suma/student;
        System.out.print("Średnia pkt grupy to: "+suma);
    }
}