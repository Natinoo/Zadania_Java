
class main
{
	public static void main(String[] arg)
	{
		Prostokat maly_punkt = new Prostokat(3, 6, "czerwony");
		Trojkat rownoboczny = new Trojkat(7, 4, "bia³y");
		//maly_punkt.zwieksz(3,4);

		Figura sruct = new Figura();
		Kwadrat square = new Kwadrat(10,"Niebieski");
		Prostokat rectangle = new Prostokat(4,6,"Zielony");
		Punkt pkt = new Punkt(3,6);
		Trojkat triangle = new Trojkat(8,11,"¯ó³ty");

		System.out.println(sruct.getKolor());
		System.out.println(rectangle.opis());
		System.out.println(triangle.opis());
	}
}