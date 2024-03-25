public class osoba
{
    protected String firstName;
    protected String lastName;
    protected int age;
    public osoba(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public void view()
    {
        System.out.println("Imię: "+firstName+", Nazwisko: "+lastName+", wiek: "+age);
    }
}
