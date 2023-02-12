public class Menu {

    public static void main(String[] args) {

        int [][] plateau = new int [8][8];
        //On l'initialise à 2 car on effectue un changement en début de chaque tour
        int joueur = 2;

        Methodes.creation (plateau);
        Methodes.affichage(plateau);

        do {

            if (joueur == 1)
                joueur = 2;
            else
                joueur = 1;

            System.out.println("C'est au tour du joueur " + joueur);
            Tour.tour(plateau, joueur);
            Methodes.affichage(plateau);

        } while ( !Methodes.victoire (plateau, joueur));

        System.out.println("Félicitations joueur " + joueur + " a gagné !");

    }
}
