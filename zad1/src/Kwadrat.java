public class Kwadrat
{
    private static double a;
    private static String name="Kwadrat";
    public static double pole(double a)
    {
        return Math.pow(a,2);
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        Kwadrat.a = a;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Kwadrat.name = name;
    }

    public static double obwod(double a)
    {
        return 4*a;
    }
    public static void view()
    {
        System.out.print("Figura:"+name+", Długość boku: "+a+"\nPole Kwadratu: "+pole(a)+"\nObwód Kwadratu: "+obwod(a));
    }
}
