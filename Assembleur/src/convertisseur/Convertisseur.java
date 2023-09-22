package convertisseur;

import java.util.Scanner;

public class Convertisseur {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        String stop = "";
        GestionFonction gestionFonction = new GestionFonction();

        while (!stop.equals("s")) {
            System.out.print("Veuillez choisir une commande assembleur : ");

            if (scanner.hasNextLine()) {
                stop = scanner.nextLine();
                if (!stop.equals("s")) {
                    String[] arguments = deleteChar(stop).split(" ");
                    int choiceClass = gestionFonction.choiceClass(arguments);
                    String binary = gestionFonction.redirectionClass(arguments, choiceClass);

                    System.out.println(binary + " -> " + ConvertToBits.convertBitsToHexa(binary));
                }
            }
        }
    }

    private static String deleteChar(String line){
        StringBuilder newChaine = new StringBuilder();
        for ( int i = 0; i < line.length(); i++) {
            char caractere = line.charAt(i);
            if (caractere != ',' && caractere != '[' && caractere != ']') {
                newChaine.append(caractere);
            }
        }
        return newChaine.toString();
    }

}
