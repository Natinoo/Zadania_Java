public class Orzel extends Zwierze
{
    @Override
    void jedz() {
        System.out.println("Orzeł się żywi");
    }

    @Override
    void wydalaj() {
        System.out.println("Orzeł wydala resztki jedzenia");
    }

    @Override
    public void lec() {
        System.out.println("Orzeł lata w przestworzach");
    }

    @Override
    public void wyladuj() {
        System.out.println("Orzeł ląduje");
    }

    @Override
    void spij() {
        System.out.println("Orzeł spi");
    }
}
