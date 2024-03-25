public class Okrag
{
    private Point srodek;
    public Okrag()
    {
        this.srodek = new Point();
        this.promien=0.0;
    }
    public Okrag(Point srodek, double promien) {
        this.srodek = srodek;
        this.promien = promien;
    }
    private double promien;
    public double getPowierzchnia(double promien)
    {
        return Math.PI* Math.pow(promien,2);
    }
    public double getSrednica(double promien)
    {
        return 2*promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }
    public double getPromien() {
        return promien;
    }
        public boolean wSrodku(Point point)
        {
            double dystans = Math.pow(point.getX()-srodek.getX(),2)+Math.pow(point.getY()-srodek.getY(),2);
            return dystans <= promien;
        }
}

