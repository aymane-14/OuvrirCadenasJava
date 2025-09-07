import java.util.Scanner;

//Une classe Cadenas contient deux méthodes verifier et débloquer

public class Cadenas {

    //Les attributs du classe . RMQ ; pas private car on va l'utiliser sur ouvrirCadenas.java

    private Scanner scanner = new Scanner(System.in);
    String etat;
    String codeSecret;
    String codeTechnicien;
    int tentatives;
    int maxTentatives;

    //Le constructeur

    public Cadenas(String codeS, String codeTech, int maxT) {
        this.codeSecret = codeS;
        this.codeTechnicien = codeTech;
        this.maxTentatives = maxT;
        this.etat = "fermé";
        this.tentatives = 0;
    }

    /* Une méthode qui retourne rien c'est pour ça on utilise "void" . Il vérifie si le code
    saisi identique au code secret . Après 5 tentatives le cadenas se bloque.
     */

    public void verifier(String codeSaisie) {
        if (codeSaisie.equals(codeSecret)) {
            etat = "ouvert";
        }
        else {
            tentatives++;
            System.out.println("Mauvaise Code.");
            if (tentatives > maxTentatives) {
                etat = "bloqué";
            }
        }
    }

    /* Une méthode pour débloquer le cadenas par le technicien . Pour debloquer il faut taper un code secret .
    Si c'est faut on répète .
     */

    public void debloquer(String codeSaisieTech) {
        while (true) {
            if (codeSaisieTech.equals(codeTechnicien)) {
                etat = "fermé";
                tentatives = 0;
                System.out.print("Cadenas débloqué par Technicien.");
                break;
            }
            else {
                System.out.println("Code Technicien incorrect.");
                System.out.print("Entrer le code technicien correct : ");
                codeSaisieTech = scanner.next();
            }
        }
    }

}
