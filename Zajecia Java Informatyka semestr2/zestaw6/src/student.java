public class student extends osoba
{
    private String nrAlbumu;
    private String kierunek;

    public student(String firstName, String lastName, int age, String nrAlbumu, String kierunek) {
        super(firstName, lastName, age);
        this.nrAlbumu = nrAlbumu;
        this.kierunek = kierunek;
    }
    public void view()
    {
//        System.out.println("--Student--\nImię: "+firstName+", Nazwisko: "+lastName+", wiek: "+age);
        super.view();
        System.out.println("nr Albumy: "+nrAlbumu+"\nKierunek: "+kierunek);
    }
}
