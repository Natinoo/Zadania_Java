import java.util.Scanner;

public class Run
{
    boolean Zamykacz=true;
    //metoda ktora bedzie odpowiaac za wysiwetlenie logiki
    //tj. pentla while w ktorej bedzie switch
    int wybor;
    public void Menu()
    {
        System.out.print("\nMenu programu\n1-Koło\n2-Kwadrat\n3-Prostokąt\n4-Sześcian\n5-Prostopadłościan");
        System.out.print("\n6-Kula\n7-Stożek\n8-Exit");
        System.out.print("\nWybierz program:\n-->");
    }
    public void Running()
    {

        int choice;
        while(Zamykacz)
        {
            Menu();
            choice= inputInt();
            switch(choice)
            {
                case 1-> viewkolo();
                case 2-> viewKwadrat();
                case 3-> viewProstokat();
                case 4-> viewSzescian();
                case 5-> viewProstopadloscian();
                case 6-> viewKula();
                case 7-> viewStozek();
                case 8-> Koniec();
                //default -> defaultInstruction();
            }
        }
    }


    private void viewkolo()
    {
        kolo kolo1 = new kolo();
        System.out.println("Podaj promien: ");
        double r = inputDouble();
        if (r > 0) {
            kolo1.setR(r);
            kolo1.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. r= " + Math.abs(r));
            kolo1.setR(Math.abs(r));
        }
    }
    private void viewKwadrat()
    {
        Kwadrat square =new Kwadrat();
        System.out.println("Podaj długość boku: ");
        double a = inputDouble();
        if (a > 0) {
            square.setA(a);
            square.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. a= " + Math.abs(a));
            square.setA(Math.abs(a));
        }
    }
    private void viewProstokat()
    {
        Prostokat prostokat = new Prostokat();
        System.out.println("Podaj długośi boków: ");
        double a = inputDouble();
        double b = inputDouble();
        if (a > 0 || b>0)
        {
            prostokat.setA(a);
            prostokat.setB(b);
            prostokat.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. a= " + Math.abs(a)+"b= "+Math.abs(b));
            prostokat.setA(Math.abs(a));
            prostokat.setB(Math.abs(b));
        }
    }
    private void viewSzescian()
    {
        Szescian cube =new Szescian();
        System.out.println("Podaj długość boku: ");
        double a = inputDouble();
        if (a > 0) {
            cube.setA(a);
            cube.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. a= " + Math.abs(a));
            cube.setA(Math.abs(a));
        }
    }
    private void viewProstopadloscian()
    {
        Prostopadloscian fig = new Prostopadloscian();
        System.out.print("\nPodaj długości boków: \nbok A--> ");
        double a = inputDouble();
        System.out.print("\nbok B--> ");
        double b = inputDouble();
        System.out.print("\nbok C--> ");
        double c = inputDouble();
        if (a > 0 || b>0 || c>0)
        {
            fig.setA(a);
            fig.setB(b);;
            fig.setC(c);
            fig.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. a= " + Math.abs(a)+"b= "+Math.abs(b)+"c= "+Math.abs(c));
            fig.setA(Math.abs(a));
            fig.setB(Math.abs(b));
            fig.setC(Math.abs(c));
        }
    }
    private void viewKula()
    {
        Kula Balls = new Kula();
        System.out.println("Podaj promien: ");
        double r = inputDouble();
        if (r > 0) {
            Balls.setR(r);
            Balls.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. r= " + Math.abs(r));
            Balls.setR(Math.abs(r));
        }
    }
    private void viewStozek()
    {
        Stozek spike = new Stozek();
        System.out.print("Podaj promien: ");
        double r = inputDouble();
        System.out.print("Podaj wysokosc kuli: ");
        double h = inputDouble();
        if (r > 0 || h > 0) {
            spike.setR(r);
            spike.setH(h);
            spike.view();
        }
        else {
            System.out.println("Podano liczbe ujemną, zamieniam ja na liczbe dodatnia. r= " + Math.abs(r)+"h="+Math.abs(h));
            spike.setR(Math.abs(r));
            spike.setR(Math.abs(h));
        }
    }
    private void Koniec()
    {
        int choice;
        System.out.println("Czy napewno chcesz zakończyć program?");
        System.out.println("1-Wyjście z programu, 2-Powrót do Menu");
        choice= inputInt();
        if(1 == choice) {
            Zamykacz=false;
        }
        return;
    }

    public int inputInt()
    {
        Scanner in = new Scanner(System.in);
        int liczba = in.nextInt();
        return liczba;
    }
    public double inputDouble()
    {
        Scanner in = new Scanner(System.in);
        double liczba = in.nextInt();
        return liczba;
    }
}
