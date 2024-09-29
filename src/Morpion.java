
import java.util.Scanner;

public class Morpion {

    // Méthode pour créer la matrice 5x5
    public static String[][] Creer() {
        // Créer et rempli la matrice avec un point
        String[][] matrice = new String[3][3]; // Création d'une matrice 5x5
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrice[i][j] = " . ";
            }
        }
        return matrice;
    }

    public static void Afficher_matrice(String [][] matrice){
        // affiche la matrice
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(" " + matrice[i][j]);
            }
        }
        System.out.println();

    }


    public static String[][] Remplacer(String[][] matrice, boolean JoueurX, boolean JoueurO, int i, int j) {
        // Rempli la case choisi par le joueur soit X ou O
        if (matrice[i][j].equals(" . ")) {
            if (JoueurX) {
                matrice[i][j] = " X ";
            } else if (JoueurO) {
                matrice[i][j] = " O ";
            }
        } else {
            System.out.println("Cette case est déjà prise");
        }
        return matrice;
    }

    public static boolean[] Echange(boolean JoueurX, boolean JoueurO) {
        // Echange le tour des deux joueurs
        boolean temp = JoueurX;
        JoueurX = JoueurO;
        JoueurO = temp;
        System.out.println("Joueur X : " + JoueurX + " Joueur O : " + JoueurO);
        return new boolean[]{JoueurX, JoueurO};
    }

    public static boolean Verifier_victoire(String[][] matrice, String symbole) {
        // Vérification des lignes
        for (int i = 0; i < 3; i++) {
            if (matrice[i][0].equals(symbole) && matrice[i][1].equals(symbole) && matrice[i][2].equals(symbole)) {
                return true;
            }
        }

        // Vérification des colonnes
        for (int j = 0; j < 3; j++) {
            if (matrice[0][j].equals(symbole) && matrice[1][j].equals(symbole) && matrice[2][j].equals(symbole)) {
                return true;
            }
        }

        // Vérification des diagonales
        if (matrice[0][0].equals(symbole) && matrice[1][1].equals(symbole) && matrice[2][2].equals(symbole)) {
            return true;
        }
        if (matrice[0][2].equals(symbole) && matrice[1][1].equals(symbole) && matrice[2][0].equals(symbole)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        boolean JoueurO = false;
        boolean JoueurX = true;
        boolean continuer = true;
        int i = 0, j= 0;

        String[][] matrice_jeu = Creer();
        Afficher_matrice(matrice_jeu);

        Scanner clavier = new Scanner(System.in);  // Scanner déclaré une fois

        // Boucle de jeu :
        while (continuer) {
            System.out.println("Choisir un ligne et une colonne : ");
            i = clavier.nextInt();
            j = clavier.nextInt();
            while (i >3 || i < 0){
                System.out.println("Erreur sur la ligne");
                i = clavier.nextInt();
            }
            while (j >3 || j < 0){
                System.out.println("Erreur sur la ligne");
                j = clavier.nextInt();
            }
            matrice_jeu = Remplacer(matrice_jeu, JoueurX, JoueurO, i, j);
            Afficher_matrice(matrice_jeu);

            // Vérifier si le joueur X a gagné
            if (Verifier_victoire(matrice_jeu, " X ")) {
                System.out.println("Le joueur X a gagné !");
                continuer = false;
                break;
            }
            // Vérifier si le joueur O a gagné
            if (Verifier_victoire(matrice_jeu, " O ")) {
                System.out.println("Le joueur O a gagné !");
                continuer = false;
                break;
            }

            // Mise à jour des joueurs
            boolean[] nouveauxJoueurs = Echange(JoueurX, JoueurO);
            JoueurX = nouveauxJoueurs[0];
            JoueurO = nouveauxJoueurs[1];


        }

    }
}



