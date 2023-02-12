import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test {

    public static void main(String[] args) {

        //Test Fonction SaisieLigneUtilisateur
        /*int ligne = -1;
        ligne = Methodes.saisieLigneUtilisateur();
        System.out.println("L'indice de la ligne saisie est : " + ligne);

        //Test Fonction SaisieColUtilisateur
        int colonne = -1;
        colonne = Methodes.saisieColUtilisateur();
        System.out.println("L'indice de la colonne saisie est : " + colonne);*/

        //Test afficherPriseObligatoire ( int [][] plateau, int joueur)
        /*int[][] plateau = {{1,0,1},{0,2,0},{0,0,0}};
        int joueur = 1;
        int[][] reception = Methodes.afficherPriseObligatoire(plateau,joueur);
        System.out.print(reception[0][0]);
        System.out.println(reception[0][1]);*/

        //Test effectuerPrise (int [][] plateau, int [][] piece, int joueur)
        //Test Stockage
        /*int [][] plateau = {{0,0,1,0,1,0},{0,3,0,1,0,0},{2,0,0,0,0,1},{0,0,0,2,0,0},{2,0,0,0,0,2},{0,2,0,2,0,0}};
        int [][] piece = {{1,1}};
        int joueur = 1;

        Methodes.effectuerPrise(plateau,piece,joueur);*/

        /*int [][] plateau = {{2,0,0,2},{0,1,0,0},{2,0,0,0},{0,1,0,0}};
        int [][] piece = {{0,0}};
        int joueur = 2;

        Methodes.effectuerPrise(plateau,piece,joueur);*/

        //Test Final EffectuerPrise
        //Problème par rapport à la saisie pour faire un jeu de test JUnit !!!

        /*int [][] t1j1 = {{0,0,0},{0,2,0},{0,0,1}};
        int [][] pionB = {{2,2}};
        int joueur = 1;
        Methodes.effectuerPrise(t1j1,pionB,joueur);

        int [][] t1j1bis = {{1,0,0},{0,0,0},{0,0,0}};

        for( int i = 0; i < t1j1.length ; i++){
            for(int b = 0 ; b < t1j1[i].length ; b++){
                System.out.print(t1j1[i][b]);
            }
            System.out.println();

        }*/

        /*int [][] t2j2 = {{0,0,0,0},{0,0,0,0},{0,1,0,0},{4,0,0,0}};
        int [][] dameN = {{3,0}};
        int joueur = 2;
        Methodes.effectuerPrise(t2j2,dameN,joueur);

        int [][] t2j2bis = {{0,0,0,4},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        for( int i = 0; i < t2j2.length ; i++){
            for(int b = 0 ; b < t2j2[i].length ; b++){
                System.out.print(t2j2[i][b]);
            }
            System.out.println();

        }*/




    }
}
