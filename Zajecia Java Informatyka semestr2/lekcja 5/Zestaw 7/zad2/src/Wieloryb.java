public class Wieloryb extends Ryba
{
    @Override
    void jedz() {
        System.out.println("Wieloryb zywi sie planktonem");
    }

    @Override
    void wydalaj() {
        System.out.println("Wieloryb wydala plankton");
    }

    @Override
    public void plyn() {
        System.out.println("Wieloryb plywa po oceanie");
    }

    @Override
    public void wynurz() {
        System.out.println("Wieloryb wynurza sie by nabrac powietrza");
    }

    @Override
    public void zanurz() {
        System.out.println("Wieloryb zanurza sie by eksplorowac ocen");
    }
}
