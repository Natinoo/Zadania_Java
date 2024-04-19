public class Kula
{
    private static double r;
    private static String name="Kula";
    public static double pole(double r)
    {
        return 4*Math.PI*Math.pow(r,2);
    }

    public static double getR()
    {
        return r;
    }

    public static void setR(double r)
    {
        Kula.r = r;
    }

    public static String getName()
    {
        return name;
    }

    public static void setName(String name)
    {
        Kula.name = name;
    }

    public static double objetosc(double r)
    {
        return (4.0/3)*Math.pow(r,3);
    }
    public static void view()
    {
        System.out.print("Figura:"+name+", jej promien: "+r+"\nPole Kuli: "+pole(r)+"\nObjętosc Kuli: "+objetosc(r));
    }
}
