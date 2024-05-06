import java.io.*;
import java.util.Scanner;

public class zad3{
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Ask the user for the output file name
        System.out.print("Enter the output file name: ");
        String fileName = scan.nextLine();

        // Ask for the day, month, and year of birth
        System.out.print("Enter the day of birth: ");
        int day = scan.nextInt();
        System.out.print("Enter the month of birth: ");
        int month = scan.nextInt();
        System.out.print("Enter the year of birth: ");
        int year = scan.nextInt();

        // Convert each component to binary
        String dayBinary = Integer.toBinaryString(day);
        String monthBinary = Integer.toBinaryString(month);
        String yearBinary = Integer.toBinaryString(year);

        // Save the binary data to the output file
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeUTF(dayBinary);
            outputStream.writeUTF(monthBinary);
            outputStream.writeUTF(yearBinary);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        System.out.println("Data saved successfully!");
    }
}
//C:\Users\Student\Desktop\lekcja 8\data.txt
