public class zad1
{
    public static void main(String[] args)
    {
        //System.out.print(ja());
        String dane = ja();
        String imie = dane.substring(0,dane.indexOf(' '));
        int wiek = Integer.parseInt(dane.substring(dane.lastIndexOf(' ')+1));
        System.out.print(imie+", lat "+wiek);
    }
    public static String ja()
    {
        return "Natan 19";
    }
}