import java.io.*;
import java.util.Scanner;

public class zad2
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj scieżkę pliku: ");
        String filePath = scan.nextLine();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            String zawartosc;
            int licznik=0;
            while((zawartosc = fileReader.readLine()) != null) {
            System.out.println(zawartosc); licznik++;}
            System.out.println("liczba liń w pliku: "+licznik);

        }finally {
            if( fileReader!=null)
                fileReader.close();
        }
    }
}
//C:\Users\Student\Desktop\lekcja 8\zad1.txt