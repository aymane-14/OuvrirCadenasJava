import java.util.Scanner;

public class ouvrirCadenas {

    public static void main(String[] args) {
        Cadenas cadenas = new Cadenas("324671", "000000", 5);
        Scanner scanner = new Scanner(System.in);

        // Tant que le cadenas est fermé ou bloqué
        while (cadenas.etat.equals("fermé") || cadenas.etat.equals("bloqué")) {
            // --- Saisie du code secret ---
            String code = saisirCode(scanner, "Entrer le code Secret : ");
            cadenas.verifier(code);

            // --- Si le cadenas est bloqué ---
            if (cadenas.etat.equals("bloqué")) {
                String codeTechnicien = saisirCode(scanner, "Cadenas bloqué ! Entrer le code Technicien pour débloquer : ");
                cadenas.debloquer(codeTechnicien);
                System.out.println();
            }
        }

        System.out.print("Cadenas ouvert !");
        scanner.close(); // Bonne pratique : fermer le scanner
    }

    // Méthode utilitaire pour saisir et valider un code à 6 chiffres
    private static String saisirCode(Scanner scanner, String message) {
        System.out.print(message);
        String code = scanner.next();


        while (code.length() != 6 || !code.matches("\\d+")) {
            System.out.print("Le code doit contenir exactement 6 chiffres et juste des chiffres : ");
            code = scanner.next();
        }

        return code;
    }
}
