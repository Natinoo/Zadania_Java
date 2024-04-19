public class Prostopadloscian
{
    private static double a,b,c;
    private static String name="Prostopadłościan";
    public static double pole(double a,double b,double c)
    {
        return 2*(a*b+a*c+b*c);
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        Prostopadloscian.a = a;
    }

    public static double getB() {
        return b;
    }

    public static void setB(double b) {
        Prostopadloscian.b = b;
    }

    public static double getC() {
        return c;
    }

    public static void setC(double c) {
        Prostopadloscian.c = c;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Prostopadloscian.name = name;
    }

    public static double obwod(double a, double b, double c)
    {
        return a*b*c;
    }
    public static void view()
    {
        System.out.print("Figura:"+name+", Długość boków:\n bok A: "+a+"\n bok B:"+b+",\n wysokość(bok C):"+c+"\nPole Prostopadłościanu: "+pole(a,b,c)+"\nObwód Prostopadłościanu: "+obwod(a,b,c));
    }
}
