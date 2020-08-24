import java.util.Scanner;

public class Mittelwert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] eingabe = new double[10];

        for(int i = 0; i < 10; i++) {

            System.out.println("Wert" + (i + 1) + ":");

            eingabe[i] = scanner.nextDouble();
        }

        double summe = 0.0;

        for(double element: eingabe) {

            summe += element;
        }

        double mittelwert = summe / eingabe.length;

        System.out.println("Mittelwert: " + mittelwert);
    }
}
