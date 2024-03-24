import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Wybierz numer zadania [1-6]: ");
        float odp = in.nextFloat();

        if(odp == 1)
        {
            double a, b, c;
            System.out.print("\nPodaj liczbe a: ");
            a = in.nextDouble();
            System.out.print("\nPodaj liczbe b: ");
            b = in.nextDouble();
            System.out.print("\nPodaj liczbe c: ");
            c = in.nextDouble();
            funkcjaMinecraft(a,b,c);
        }
        else if(odp == 2)
        {
            System.out.print("\nPodaj liczbe x: ");
            double x = in.nextDouble();
            trzyFunkcje(x);
        }
        else if(odp == 3)
        {
            double a, b, c;
            System.out.print("\nPodaj liczbe a: ");
            a = in.nextDouble();
            System.out.print("\nPodaj liczbe b: ");
            b = in.nextDouble();
            System.out.print("\nPodaj liczbe c: ");
            c = in.nextDouble();
            double[] liczby = sortuj(a,b,c,true);
            System.out.print("\nLiczby posortowane od najmniejszej do największej: "+liczby[0]+", "+liczby[1]+", "+liczby[2]);
        }
        else if(odp == 4)
        {
            nwmZad4();
        }
        else if(odp == 5)
        {
            nwmZad5();
        }
        else if(odp == 6)
        {
            double a, b;
            System.out.print("\nPodaj liczbe a: ");
            a = in.nextDouble();
            System.out.print("\nPodaj liczbe b: ");
            b = in.nextDouble();
            System.out.print("\nPodaj operacje matematyczną: ");
            System.out.print("\nWynik obliczenia to: "+dzialanie(a,b,wybierzOperacje()));
        }
        else
            System.out.print("\nNie rozpoznano numeru zadania");
    }

    public static double[] funkcjaMinecraft(double a, double b, double c)
    {
        double delta = b*b - 4*a*c;
        if(delta < 0)
        {
            System.out.print("\nFunkcja nie ma rozwiązań dla podanych parametrów.");
            return null;
        }
        else if(delta == 0)
        {
            delta = (-b/(2*a));
            System.out.print("\nFunkcja posiada jedno rozwiązanie dla podanych parametrów:\n  x0 = "+ delta);
            return (new double[]{delta});
        }
        else
        {
            delta = Math.pow(delta,0.5);
            double x1 = ((-b+delta)/(2*a));
            double x2 = ((-b-delta)/(2*a));
            System.out.print("\nFunkcja posiada dwa rozwiązania dla podanych parametrów:\n  x1 = "+ x1 + "\n  x2 = "+x2);
            return (new double[]{x1,x2});
        }
    }
    public static void trzyFunkcje(double a)
    {
        System.out.print("\nWartość funkcji a("+a+") = ");
        if(a>0)
            System.out.print(2*a);
        else if(a==0)
            System.out.print(0);
        else
            System.out.print(-3*a);

        System.out.print("\nWartość funkcji b("+a+") = ");
        if(a>=1)
            System.out.print(a*a);
        else
            System.out.print(a);

        System.out.print("\nWartość funkcji c("+a+") = ");
        if(a>2)
            System.out.print((a+2));
        else if(a==2)
            System.out.print(8);
        else
            System.out.print(a-4);
    }
    public static double[] sortuj(double a, double b, double c, boolean t)
    {
//        double[] liczby = new double[]{a,b,c};
//        Arrays.sort(liczby);
//        //można tak jak na górze
        double[] liczby = new double[3];

        //jeśli t = true to sortujemy najmniejsza-największa, jeśli false to największa-najmniejsza
        if(t)
        {
            liczby[0] = Math.min(a,Math.min(b,c));
            liczby[2] = Math.max(a,Math.max(b,c));
        }
        else
        {
            liczby[0] = Math.max(a,Math.max(b,c));
            liczby[2] = Math.min(a,Math.min(b,c));
        }

        liczby[1] = a+b+c-liczby[0]-liczby[2];
        return liczby;
    }
    public static void nwmZad4()
    {
        Scanner in = new Scanner(System.in);
        boolean a = false, b = false;
        System.out.print("\nCzy pada deszcz: ");
        String odp = in.nextLine().trim().toLowerCase();

        if(odp.equals("pada") || odp.equals("t") || odp.equals("tak") || odp.equals("true") || odp.equals("y") || odp.equals("yes"))
            a = true;
        System.out.print("\nCzy na przystanku jest autobus: ");
        odp = in.nextLine().trim().toLowerCase();
        if(odp.equals("jest") || odp.equals("t") || odp.equals("tak") || odp.equals("true") || odp.equals("y") || odp.equals("yes"))
            b = true;

        if(a && b)
            System.out.print("\nWeź parasol.\nDostaniesz się na uczelnie.");
        else if(a && !b)
            System.out.print("\nNie dostaniesz się na uczelnie.");
        else if(!a && b)
            System.out.print("\nDostaniesz się na uczelnie.\nMiłego dnia i pięknej pogody.");
        else
            System.out.print("\nNie dostaniesz się na uczelnie, ale\n miłego dnia i pięknej pogody.");
    }
    public static void nwmZad5()
    {
        Scanner in = new Scanner(System.in);
        boolean a = false, b = false;

        System.out.print("\nCzy jest zniżka na samochód: ");
        String odp = in.nextLine().trim().toLowerCase();
        if(odp.equals("jest") || odp.equals("t") || odp.equals("tak") || odp.equals("true") || odp.equals("y") || odp.equals("yes"))
            a = true;

        System.out.print("\nCzy otrzymałeś premię: ");
        odp = in.nextLine().trim().toLowerCase();
        if(odp.equals("otrzymałem") || odp.equals("otrzymalem") || odp.equals("t") || odp.equals("tak") || odp.equals("true") || odp.equals("y") || odp.equals("yes"))
            b = true;

        if(!a || b)
            System.out.print("\nMożesz kupić samochód!\nZniżki na samochód nie ma");
        else if(!a || !b)//to się nigdy nie wykona, bo jeśli mamy premię, a nie ma zniżki to warunek wyżej sie wykona i nawet założy, iż zniżki nie ma, chodźby była!
            System.out.print("\nZakup samochodu trzeba odłożyć na później\nZniżki na samochód nie ma");
        else if(a || b)//też sie nie wykona, bo aby pierwszy sie nie wykonał to musi być a=true i b = false, a wtedy sie wykona drugi warunek
            System.out.print("\nMożesz kupić samochód!");
    }
    public static int wybierzOperacje()
    {
        String str = new Scanner(System.in).nextLine().trim().toLowerCase();
        if(str.equals("+") || str.equals("dodaj") || str.equals("dodawanie") || str.equals("suma"))
        {
            System.out.print("\nWybrano dodawania");
            return 0;
        }
        if(str.equals("-") || str.equals("minus") || str.equals("odejmij") || str.equals("odejmowanie") || str.equals("roznica") || str.equals("różnica"))
        {
            System.out.print("\nWybrano odejmowanie");
            return 1;
        }
        if(str.equals("x") || str.equals("*") || str.equals("iloczyn") || str.equals("razy") || str.equals("pomnoz") || str.equals("pomnoż") || str.equals("pomnóż") || str.equals("pomnóz") || str.equals("mnożenie") || str.equals("mnozenie"))
        {
            System.out.print("\nWybrano mnożenie");
            return 2;
        }
        if(str.equals("/") || str.equals("dziel") || str.equals("dzielenie") || str.equals("podziel") || str.equals("iloraz"))
        {
            System.out.print("\nWybrano dzielenie");
            return 3;
        }
        if(str.equals("%") || str.equals("mod") || str.equals("modulo") || str.equals("reszta") || str.equals("reszta z dzielenia"))
        {
            System.out.print("\nWybrano reszte z dzielenia");
            return 4;
        }
        else return -1;
    }
    public static double dzialanie(double a, double b, int o)
    {
        if(o == 0) return a+b;
        if(o == 1) return a-b;
        if(o == 2) return a*b;
        if(o == 3)
        {
            if(b == 0)
            {
                if(a == 0) return Double.NaN;
                else if(a > 0) return Double.POSITIVE_INFINITY;
                else return Double.NEGATIVE_INFINITY;
            }
            else
                return a/b;
        }
        if(o == 4) return a%b;
        else return Double.NaN;
    }
}
