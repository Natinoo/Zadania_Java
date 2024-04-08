//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Wieloryb whale = new Wieloryb();

        whale.plyn();
        whale.wynurz();
        whale.zanurz();
        whale.jedz();
        whale.wydalaj();
        System.out.println("");

        Orzel eagle = new Orzel();
        eagle.jedz();
        eagle.wydalaj();
        eagle.lec();
        eagle.wyladuj();
        eagle.spij();
    }
}