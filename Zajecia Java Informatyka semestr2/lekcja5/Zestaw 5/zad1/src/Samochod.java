public class Samochod implements Jedz
{

    @Override
    public void przyspieszaj()
    {
        System.out.println("Samochod zwieksza prędkość!");
    }

    @Override
    public void zwalniaj()
    {
        System.out.println("Samochod spowalnia!");
    }
}
