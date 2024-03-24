import java.time.LocalDate;

//Stwórz klasę przechowującą informacje o Budynku (nazwa, rok budowy, liczba pięter). Przygotuj
//metodę wyświetlającą wszystkie informacje o budynku, oraz metodę obliczającą ile lat ma budynek
//        (rok obecny możesz ustawić na sztywno). Stwórz kilka obiektów (budynków), ustaw im wartości i
//wywołaj dla nich metody. Do obliczenia daty należy użyć klasy LocalData.
public class Budynek
{
    public String Nazwa="";
    public LocalDate Rok_Budowy= LocalDate.parse("2001-09-11");
    public double liczba_pieter=0;

    Budynek(String N, LocalDate Rok, double pietro)
    {
        Nazwa = N;
        Rok_Budowy = Rok;
        liczba_pieter = pietro;
    }

    Budynek()
    {

    }

    void info()
    {
        System.out.print("\n Nazwa Budynku: "+Nazwa+"\nRok Budowy: "+Rok_Budowy+", budynek stoi już: "+maidInHeaven()+"\nLiczba pięter: "+liczba_pieter);
    }
    LocalDate maidInHeaven()
    {
        return LocalDate.now().minusYears(Rok_Budowy.getYear()).minusMonths(Rok_Budowy.getMonthValue()).minusDays(Rok_Budowy.getDayOfYear());
    }

}
