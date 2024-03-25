
class Prostokat extends Figura
{
	double wys=0, szer=0;
	
	Prostokat(double wys,double szer){
		this.wys = wys;
		this.szer = szer;
			
	}
	Point[] points= new Point[]
			{
					new Point(1,5),
					new Point(1,10),
					new Point(6,5),
					new Point(6,10)
			};
	public Prostokat(float wys,float szer,String kolor)
	{
		this.wys =wys;
		this.szer=szer;
		this.kolor=kolor;
	}
    double getPowierzchnia() {
        return (szer * wys);
    }

	void przesun(float x,float y)
	{

	}
    
}