public class Szescian
{
    private static double a;
    private static String name="Sześcian";
    public static double pole(double a)
    {
        return 6*Math.pow(a,2);
    }
    public static double obwod(double a)
    {
        return Math.pow(a,3);
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        Szescian.a = a;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Szescian.name = name;
    }

    public static void view()
    {
        System.out.print("Figura:"+name+", Długość boku: "+a+"\nPole Sześcianu: "+pole(a)+"\nObwód Sześcianu: "+obwod(a));
    }
}
