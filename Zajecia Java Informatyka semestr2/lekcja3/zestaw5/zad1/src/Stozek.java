public class Stozek
{
    private static double r,h;
    private static double l=Math.pow(Math.pow(r,2)+Math.pow(h,2),0.5);
    private static String name="Stożek";

    public static double pole(double r,double l)
    {
        return Math.PI*Math.pow(r,2)+Math.PI*r*l;
    }
    public static double objetosc(double r, double h)
    {
        return (1.0/3)*Math.PI*Math.pow(r,2)*h;
    }
    public static double getR()
    {
        return r;
    }
    public static void setR(double r)
    {
        Stozek.r = r;
    }
    public static double getH()
    {
        return h;
    }
    public static void setH(double h)
    {
        Stozek.h = h;
    }
    public double getL()
    {
        return l;
    }
    public void setL(double l)
    {
        this.l = l;
    }

    public static String getName()
    {
        return name;
    }
    public static void setName(String name)
    {
        Stozek.name = name;
    }

    public static void view()
    {
        System.out.print("Figura:"+name+", jej promien: "+r+", jej wysokosc: "+h+"\nPole Kuli: "+pole(r,l)+"\nObjętosc Kuli: "+objetosc(r,h));
    }
}
