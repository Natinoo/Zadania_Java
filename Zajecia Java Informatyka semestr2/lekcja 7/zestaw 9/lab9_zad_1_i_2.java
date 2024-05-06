import java.util.*;

public class lab9_zad_1_i_2
{
    static List<String> l1 = new ArrayList<>();
    static List<List<String>> l2 = new ArrayList<>();
    public static void main(String[] arg)
    {
        System.out.print("Select the task (number): ");
        String in = new Scanner(System.in).nextLine();
        switch(in.trim().toLowerCase())
        {
            case "1":
                zad1();
            case "2":
                zad2();
        }
    }

    public static void zad1()
    {
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.print("Tell me a name, Mohher: ");
            String name = s.nextLine();
            if(name.trim().equals("-")) break;
            l1.add(name);
        }
        Set<String> unikalne = new HashSet<>(l1);
        System.out.print("Unique names (number): " + unikalne.size());
    }
    public static void zad2()
    {
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.print("Tell me a name, anon: ");
            String name1 = s.nextLine();
            if(name1.trim().equals("-")) break;

            System.out.print("Tell me it's partner's name, anon: ");
            String name2 = s.nextLine();
            if(name2.trim().equals("-")) break;

            List<String> para = new ArrayList<>();
            para.add(name1); para.add(name2);
            l2.add(para);
        }
        System.out.print("Anon, tell me a name and I'll tell you their partner...    ");
        String n = s.nextLine();
        for(List<String> list : l2)
        {
            if(list.get(0).equals(n))
            {
                System.out.print("Their partner is: " + list.get(1));
//                if(list.get(1).equals("Cooler Daniel")) System.out.print(" B)");
            }
            else if(list.get(1).equals(n))
            {
                System.out.print("Their partner is: " + list.get(0));
//                if(list.get(0).equals("Cooler Daniel")) System.out.print(" B)");
            }
        }
    }
}
