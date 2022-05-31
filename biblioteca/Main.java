package biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linie;
        Biblioteca biblioteca = new Biblioteca();
        do {
            //stergeClient Titel
            linie = scanner.nextLine();
            int pozitieSpace = linie.indexOf(' '); //poz 12

            if (pozitieSpace == -1) continue;

            String comanda = linie.substring(0, pozitieSpace);

            switch (comanda) {
                case "stergeClient":
                    System.out.println("Nu vreau");
                    break;

            }
            System.out.println("Comanda data e " + linie);
        } while (!linie.equals("exit"));
    }
}
