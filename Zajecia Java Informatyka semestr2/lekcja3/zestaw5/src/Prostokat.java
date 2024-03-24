public class Prostokat
{
    private static double a,b;
    private static String name="Prostokąt";
    public static double pole(double a,double b)
    {
        return a*b;
    }
    public static double obwod(double a,double b)
    {
        return (2*a)+(2*b);
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        Prostokat.a = a;
    }

    public static double getB() {
        return b;
    }

    public static void setB(double b) {
        Prostokat.b = b;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Prostokat.name = name;
    }

    public static void view()
    {
        System.out.print("Figura:"+name+", Długość boków:\n bok A: "+a+"\n bok B:"+b+"\nPole Prostokąta: "+pole(a,b)+"\nObwód Prostokąta: "+obwod(a,b));
    }
}
