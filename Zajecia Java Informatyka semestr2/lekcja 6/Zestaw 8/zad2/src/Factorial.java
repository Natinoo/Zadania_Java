public class Factorial {

    public static long countFactorial(int a) throws BlednaWartoscDlaSilniException{
        if(a<0){
            throw new BlednaWartoscDlaSilniException("liczba nie moze byc ujemna");
        }
        if(a==0){
            return 1;
        }
        long wynik =1;
        for (int i = 1; i <= a; i++) {
            wynik*=i;
        }
        return wynik;
    }
}