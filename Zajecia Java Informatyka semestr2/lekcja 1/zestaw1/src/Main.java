import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*int a,b;
        String imie;
        Scanner input = new Scanner(System.in);
        System.out.printf("podaj warotsc a");
        a=input.nextInt();
        System.out.printf("podaj liczbe b");
        b=input.nextInt();
        System.out.printf("podaj imie");
         imie = input.next();
        */
        /*
        //z1
        System.out.println("imie"+imie("jan"));
        System.out.println("wiek"+wiek(12));
    }
    public static int wiek(int wiek) {
        return wiek;
    }
    public static String imie(String imie){
        return imie;
      */
        /*
        double a =inputDouble();
        double b =inputDouble();

        kalkulator(a,b);
        */
        /*
        int c=inputInt();
        System.out.println(IsEven(c));
        int h=inputInt();
        System.out.println(Isdevide(h));
         */

        int g =inputInt();
        System.out.println(power(g));
    } // koniec main

    //z2
    /*
    public static void kalkulator(double a, double b){
        System.out.printf("suma"+a+"+"+b+"="+(a+b));
        System.out.printf("suma"+a+"-"+b+"="+(a-b));
        System.out.printf("suma"+a+"*"+b+"="+(a*b));

    }
    //metoda do wczytywania liczby z klawiatury
    public static double inputDouble(){
        Scanner input= new Scanner(System.in);
        System.out.printf("Podaj liczbe");
        double liczba = input.nextDouble();
        return liczba;

        }
    */
    public static int inputInt(){
        Scanner input= new Scanner(System.in);
        System.out.printf("Podaj liczbe: ");
        int liczba = input.nextInt();
        return liczba;

    }
    //z3
    public static Boolean IsEven(int a){
        if((a%2)==0){
            return true;
        }
        else return false;

    }
    //4
    public static Boolean Isdevide(int b){
        if(b % 2== 0 && b % 5 == 0){
            return true;
        }
        else return false;

    }
    //5
    public static int power(int c){
        int result= (int) Math.pow(c,3);
        return result;
    }
    public static int sqrt(int d){
        int result= (int) Math.sqrt(d);
        return result;
    }

    //7
    /*
    public static void Losuj(int a, int b){
        Random random = new Random(b-a+1)+a;
        double liczba =random.nextInt(10)+1;

    }
     */
}