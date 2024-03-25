public class Main {

    public static void main(String[] args)
    {
//        Point pkt = new Point();
//        System.out.println("x("+pkt.x+" ,"+pkt.y);
        Point[] points= new Point[]
                {
                        new Point(),
                        new Point(2.5,-3.45),
                        new Point(7.5,2.5)
                };
        //object figura
        Figura figura = new Figura();{
        System.out.println(figura.opis());
        figura.getKolor();
    }
        //object Prostokat
        Prostokat Rect = new Prostokat(5,10);
        {
            System.out.println(Rect.getPowierzchnia());

        }
        //object Trojkat
        Trojkat triangle = new Trojkat(5,10);
        {
            System.out.println("Nic tu nie ma");
        }

            //metoda opis
        for(Point item: points)
        {
            item.opis();
        }
        //metoda ZERUJ
        for(Point item: points)
        {
            item.zeruj();
        }
        //metoda opis
        for(Point item: points)
        {
            item.opis();
        }
    }


}