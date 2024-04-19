//klasa kolo
//r - promien
//metoda pole  i objetosc
public class kolo
{
    private static double r;

    private static String name="Trójkąt";

    public static double pole(double r)
    {
        return Math.PI*Math.pow(r,2);
    }
    public static double obwod(double r)
    {
        return 2*Math.PI*r;
    }
    public static void view()
    {
        System.out.print("Figura:"+name+", jego promień: "+r+"\nPole koła: "+pole(r)+"\nObwód kola: "+obwod(r));
    }
    public void view1()
    {
        System.out.format("Figura:%s, promień: %.2f, \npole: "+"%.2f, \nobwod: %.2f",name,r,pole(r),obwod(r));
    }
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
