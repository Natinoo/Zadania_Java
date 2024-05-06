import java.io.*;
import java.util.Scanner;

public class lekcja
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        FileWriter output = null;
        String line;
        System.out.println("Podaj scieżkę pliku: ");
        try{
            output= new FileWriter(scan.nextLine());
            System.out.println("Podaj zawartosc pliku: ");
            while(true){
                line= scan.nextLine();
                if(line.equals("-")) break;
                output.write(line);
                output.write(System.lineSeparator());
            }
        }finally {
            if(output !=null)
                output.close();
        }
    }
}
//C:\Users\Student\Desktop\lekcja 8\zad1.txt