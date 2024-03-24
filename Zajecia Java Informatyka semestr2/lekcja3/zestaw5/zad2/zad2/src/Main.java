import com.sun.source.tree.TryTree;

import java.time.LocalDate;
import java.util.Scanner;

//Stwórz klasę przechowującą informacje o Budynku (nazwa, rok budowy, liczba pięter). Przygotuj
//metodę wyświetlającą wszystkie informacje o budynku, oraz metodę obliczającą ile lat ma budynek
//        (rok obecny możesz ustawić na sztywno). Stwórz kilka obiektów (budynków), ustaw im wartości i
//wywołaj dla nich metody. Do obliczenia daty należy użyć klasy LocalData.
public class Main
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        String N;
        LocalDate R;
        double P;
        Budynek A = new Budynek();
        Budynek B = new Budynek("Biblioteka",LocalDate.parse("2016-05-16"),9.0);
        Budynek C = new Budynek("Szkoła Podstawowa nr 9 w Warszawie",LocalDate.parse("2007-02-17"),3.0);

        System.out.print("--Podaj informacje dotyczące twojego budynku--\nNazwa Budynku--> ");
        A.Nazwa = in.nextLine();
        System.out.print("--Rok wybudowania Budynku(RRRR-MM-DD)--> ");
        try
        {
            A.Rok_Budowy = LocalDate.parse(in.nextLine());
        }
        catch(Exception e)
        {
            System.out.println("Źle podano datę");
            A.Rok_Budowy=LocalDate.parse("2001-11-09");
        }
        System.out.print("--Liczba pięter w budynku--> ");
        A.liczba_pieter = Double.parseDouble(in.nextLine());

        A.info();
        B.info();
        C.info();
    }

}