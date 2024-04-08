public abstract class Zwierze implements Latanie, Plywanie
{
    void jedz()
    {

    }
    void wydalaj()
    {

    }
    void spij()
    {

    }

    @Override
    public void plyn() {
        System.out.println("płynie");
    }

    @Override
    public void wynurz() {
        System.out.println("wynurza sie");
    }
    @Override
    public void zanurz() {
        System.out.println("zanurza sie");
    }

    @Override
    public void lec() {
        System.out.println("Zwierze leci");
    }

    @Override
    public void wyladuj() {
        System.out.println("Zwierze ląduje");
    }
}
