import java.util.Scanner;

public class Main
{
    double liczba =0.0;
    Scanner in = new Scanner(System.in);

    public void main(String[] args)
    {
        System.out.println("---Zad1---");zad1();
        System.out.println("\n---Zad2---");zad2();

    }
    public void zad1()
    {
        System.out.println("Podaj wielkosc tablicy, bedzie to tablica kwadratowa: ");
        liczba = in.nextDouble();
        double suma = 0,srednia,licznik=0;
        double[][] tablica = new double[(int)liczba][(int)liczba];
        for (double[] wiersz : tablica) {
            for (double komorka : wiersz) {
                komorka = losuj(2, 36);
                suma+=komorka;
                licznik++;
            }
        }
        srednia=suma/licznik;
        System.out.print("Suma: "+suma+"\nSrednia: "+srednia);
    }
    public void zad2()
    {
        System.out.println("Podaj wielkosc tablicy: ");
        liczba = in.nextDouble();
        if(liczba<2){liczba=2.0;}
        else if((int)liczba%2==1){liczba++;}
        double[] tablica= new double[(int)liczba];
        double[] tablica2= new double[(int)liczba-1];
        for(int i=0;i<liczba-1;i++){
            tablica[i]=losuj(1,10);
            tablica2[i]=losuj(1,10);
        }
        tablica[(int)liczba-1]=losuj(1,10);
        System.out.print("Parzyste elementy tab1: ");
        for(int i=1;i<liczba;i+=2){System.out.print(tablica[i]+", ");}
        System.out.print("\nNieparzyste elementy tab2: ");
        for(int i=0;i<liczba-1;i+=2){System.out.print(tablica2[i]+", ");}
    }
    public double losuj(double min,double max)
    {
        return (int)((Math.random() *(max-min) + min)*100)/100.0;
    }
}