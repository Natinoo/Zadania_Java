//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Samochod car = new Samochod();
        car.przyspieszaj();
        car.zwalniaj();

        Statek ship = new Statek();
        ship.plyn();

        Samolot plane= new Samolot();
        plane.lec();
    }
}