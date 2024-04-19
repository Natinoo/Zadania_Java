public abstract class Ryba implements Plywanie
{
    void jedz()
    {
        System.out.println("Ryba je");
    }
    void wydalaj()
    {
        System.out.println("Ryba wydala");
    }

    @Override
    public void plyn() {
        System.out.println("Ryba płynie");
    }

    @Override
    public void wynurz() {
        System.out.println("Ryba sie wynurza");
    }
    @Override
    public void zanurz() {
        System.out.println("Ryba sie zanurza");
    }
}
