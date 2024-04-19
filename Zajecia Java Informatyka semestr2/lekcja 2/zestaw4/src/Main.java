import java.util.Scanner;

public class Main
{
    double liczba =0.0;
    Scanner in = new Scanner(System.in);

    public void main(String[] args)
    {
        System.out.println("---Zad1---");zad1();
        System.out.println("\n---Zad2---");zad2();
        System.out.println("\n---Zad3---");zad3();
        System.out.println("\n---Zad4---");zad4();
        System.out.println("\n---Zad5---");zad5();
        System.out.println("\n---Zad6---");zad6();
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
    public void zad3()
    {
        String[] tablica = {"Dzis","jest","bardzo","brzydka","pogoda","i","pada","bardzo","mocno."};
        for(String S:tablica)
        {
            System.out.print(S.toUpperCase()+" ");
        }
    }
    public void zad4()
    {
        Scanner skanuj = new Scanner(System.in);
        System.out.println("Podaj 5 slow do tablicy: ");
        String[] tablica = new String[5];
        for(int i=0;i<5;i++)
        {
            tablica[i] = skanuj.nextLine().trim();
        }
        for(int i=4;i>=0;i--)
        {
            for(int j=tablica[i].length()-1;j>=0;j--)
            {
                System.out.print(tablica[i].charAt(j));
            }
            System.out.print(" ");
        }
    }
    public void zad5()
    {
        double min=21374209111.0;
//        double tablica[] = new double[8];
        double tablica[] = {10,-2,1,100,20,-15,0,10};
        double tab2[]= new double[8];
        System.out.println("Podaj 8 liczb to tablicy");
//        for(int i=0;i<8;i++)
//        {
//            tablica[i] = in.nextDouble();
//        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(tablica[i]>tablica[j])
                {
                    tab2[i]=tablica[j];
                }
            }
            tablica[i]=min;
        }
        tablica=tab2;
        for(double X:tablica ){System.out.print(X+" ");}
    }
    public void zad6()
    {
        double tab[]= new double[5];
        for(int i=0;i<5;i++)
        {
            tab[i] = in.nextDouble();
        }
        for(double x:tab){System.out.println("silnia liczby "+x+" = "+silnia(x));}
    }
    public double silnia(double x)
    {
        if(x==2){return x;}
        else if(x>2){return x* silnia(x-1);}
        else return 1;

    }
}
