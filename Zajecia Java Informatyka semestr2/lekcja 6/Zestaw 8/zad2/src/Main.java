import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        try {
            int liczba = 5;
            long Silnia = Factorial.countFactorial(liczba);
            System.out.println("Silnia z " + liczba + " wynosi: " + Silnia);
        } catch (BlednaWartoscDlaSilniException e) {
            System.err.println(e.getMessage());
        }
    }
}

