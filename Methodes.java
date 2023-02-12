import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Methodes {

    //Remplissage du tableau
    public static void creation(int[][] plateau) {

        //initialisation du plateau
        for (int l = 0; l < plateau.length; l++) {
            for (int col = 0; col < plateau[l].length; col++) {

                //Cas lignes pions noirs
                if (l < 3) {
                    if (l % 2 == 0) {
                        if (col % 2 != 0) // lignes paires et col impair = pions noir
                            plateau[l][col] = 2;
                        else
                            plateau[l][col] = 0;

                    } else {
                        if (col % 2 == 0)
                            plateau[l][col] = 2;
                        else
                            plateau[l][col] = 0;
                    }

                }
                //Cas des lignes sans pions
                else if (l == 3 || l == 4) {
                    plateau[l][col] = 0;
                }
                //Cas lignes pions blancs
                else {
                    if (l % 2 != 0) {
                        if (col % 2 == 0)
                            plateau[l][col] = 1;
                        else
                            plateau[l][col] = 0;
                    } else {
                        if (col % 2 != 0)
                            plateau[l][col] = 1;
                        else
                            plateau[l][col] = 0;
                    }

                }

            }

        }


    }

    //Affiche le tableau
    //ATTENTION ICI AFFICHAGE PREVU POUR WINDOWS
    public static void affichage(int[][] plateau) {
        //Variables pour convertir int en ascii
        int codeAscii;
        char ascii;

        //Affiche les lettres de ligne en haut
        System.out.println("      A " + "  B " + "  C " + "  D " + "  E " + "  F " + "  G " + "  H ");
        //Affiche les numéros de ligne en début de chaque ligne
        for (int l = 0; l < plateau.length; l++) {
            if (l < 9) {
                System.out.print(" " + (l + 1) + "   ");
            } else {
                System.out.print((l + 1) + "   ");
            }
            //Parcours le tableau
            for (int col = 0; col < plateau[l].length; col++) {

                if (plateau[l][col] == 1) {
                    codeAscii = 9898;
                    ascii = (char) codeAscii;

                } else if (plateau[l][col] == 2) {

                    codeAscii = 9899;
                    ascii = (char) codeAscii;


                } else {

                    codeAscii = 46;
                    ascii = (char) codeAscii;
                    System.out.print(" ");


                }

                System.out.print(ascii + "  ");


            }
            System.out.println();
        }
    }

    //Convertit un int ascii en int indice
    public static int convertirAscii(int ascii) {

        if (ascii == 65)
            return 0;
        else if (ascii == 66)
            return 1;
        else if (ascii == 67)
            return 2;
        else if (ascii == 68)
            return 3;
        else if (ascii == 69)
            return 4;
        else if (ascii == 70)
            return 5;
        else if (ascii == 71)
            return 6;
        else if (ascii == 72)
            return 7;
        else if (ascii == 73)
            return 8;
        else
            return 9;

    }

    //Convertit un indice en char ascii
    public static char convertirInt(int indice) {

        if (indice == 0)
            return 'A';
        else if (indice == 1)
            return 'B';
        else if (indice == 2)
            return 'C';
        else if (indice == 3)
            return 'D';
        else if (indice == 4)
            return 'E';
        else if (indice == 5)
            return 'F';
        else if (indice == 6)
            return 'G';
        else
            return 'H';

    }

    //Vérifie que le pion ou la dame peut prendre
    public static boolean prise(int[][] plateau, int joueur, int x, int y) {

        int pionEnnemi;
        int dameEnnemi;
        int pionJoueur;
        int dameJoueur;
        if(joueur == 1){
            pionJoueur=1;
            dameJoueur=3;
            pionEnnemi=2;
            dameEnnemi=4;
        }
        else{
            pionJoueur=2;
            dameJoueur=4;
            pionEnnemi=1;
            dameEnnemi=3;
        }

        //Prise en avant et en arrière pour les pions
        if (plateau[x][y] == pionJoueur) {

            //Vérifier si la case existe puis si elle contient une pièce adverse
            // Puis vérifier que la case derrière existe puis qu'elle ne contient rien
            //[1][1] i.e bas droite
            if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                if (plateau[x + 1][y + 1] == pionEnnemi || plateau[x + 1][y + 1] == dameEnnemi) {
                    if (x + 2 >= 0 && x + 2 <= plateau.length - 1 && y + 2 >= 0 && y + 2 <= plateau[x].length - 1) {
                        if (plateau[x + 2][y + 2] == 0)
                            return true;
                    }
                }
            }

            // [-1][-1] i.e haut gauche
            if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                if (plateau[x - 1][y - 1] == pionEnnemi || plateau[x - 1][y - 1] == dameEnnemi) {
                    if (x - 2 >= 0 && x - 2 <= plateau.length - 1 && y - 2 >= 0 && y - 2 <= plateau[x].length - 1) {
                        if (plateau[x - 2][y - 2] == 0)
                            return true;
                    }
                }
            }

            //[1][-1] i.e bas gauche
            if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                if (plateau[x + 1][y - 1] == pionEnnemi || plateau[x + 1][y - 1] == dameEnnemi) {
                    if (x + 2 >= 0 && x + 2 <= plateau.length - 1 && y - 2 >= 0 && y - 2 <= plateau[x].length - 1) {
                        if (plateau[x + 2][y - 2] == 0)
                            return true;
                    }
                }
            }

            //[-1][1] i.e haut droite
            if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                if (plateau[x - 1][y + 1] == pionEnnemi || plateau[x - 1][y + 1] == dameEnnemi) {
                    if (x - 2 >= 0 && x - 2 <= plateau.length - 1 && y + 2 >= 0 && y + 2 <= plateau[x].length - 1) {
                        if (plateau[x - 2][y + 2] == 0)
                            return true;
                    }
                }
            }

        }
        else if (plateau[x][y] == dameJoueur) {

            int nbCase = 1; //Qu'on va incrémenter dans un if pour vérifier puis remettre à 1

            //Vérifier si la case existe puis si elle contient une pièce adverse
            //Si elle ne contient rien vérifie la case derrière jusqu'à limite du tableau
            //Si pièce ennemie regarde si la case derrière est vide

            //Vérifie diagonale [1][1] i.e bas droite
            while (x + nbCase >= 0 && x + nbCase <= plateau.length - 1 && y + nbCase >= 0 && y + nbCase <= plateau[x].length - 1) {
                if (plateau[x + nbCase][y + nbCase] == pionEnnemi || plateau[x + nbCase][y + nbCase] == dameEnnemi) {
                    if (x + nbCase + 1 >= 0 && x + nbCase + 1 <= plateau.length - 1 && y + nbCase + 1 >= 0 && y + nbCase + 1 <= plateau[x].length - 1)
                        if (plateau[x + nbCase + 1][y + nbCase + 1] == 0)
                            return true;
                }
                nbCase++;
            }
            nbCase = 0;

            //Vérifie diagonale [-1][-1] i.e haut gauche
            while (x - nbCase >= 0 && x - nbCase <= plateau.length - 1 && y - nbCase >= 0 && y - nbCase <= plateau[x].length - 1) {
                if (plateau[x - nbCase][y - nbCase] == pionEnnemi || plateau[x - nbCase][y - nbCase] == dameEnnemi) {
                    if (x - nbCase - 1 >= 0 && x - nbCase - 1 <= plateau.length - 1 && y - nbCase - 1 >= 0 && y - nbCase - 1 <= plateau[x].length - 1)
                        if (plateau[x - nbCase - 1][y - nbCase - 1] == 0)
                            return true;
                }
                nbCase++;
            }
            nbCase = 0;

            //Vérifie diagonale [1][-1] i.e bas gauche
            while (x + nbCase >= 0 && x + nbCase <= plateau.length - 1 && y - nbCase >= 0 && y - nbCase <= plateau[x].length - 1) {
                if (plateau[x + nbCase][y - nbCase] == pionEnnemi || plateau[x + nbCase][y - nbCase] == dameEnnemi) {
                    if (x + nbCase + 1 >= 0 && x + nbCase + 1 <= plateau.length - 1 && y - nbCase - 1 >= 0 && y - nbCase - 1 <= plateau[x].length - 1)
                        if (plateau[x + nbCase + 1][y - nbCase - 1] == 0)
                            return true;
                }
                nbCase++;
            }
            nbCase = 0;

            //Vérifie diagonale [-1][1] i.e haut droite
            while (x - nbCase >= 0 && x - nbCase <= plateau.length - 1 && y + nbCase >= 0 && y + nbCase <= plateau[x].length - 1) {
                if (plateau[x - nbCase][y + nbCase] == pionEnnemi || plateau[x - nbCase][y + nbCase] == dameEnnemi) {
                    if (x - nbCase - 1 >= 0 && x - nbCase - 1 <= plateau.length - 1 && y + nbCase + 1 >= 0 && y + nbCase + 1 <= plateau[x].length - 1)
                        if (plateau[x - nbCase - 1][y + nbCase + 1] == 0)
                            return true;
                }
                nbCase++;
            }
            nbCase = 0;

        }

        return false;

    }

    //Parcours le tableau et vérifie s’il y a une prise obligatoire (dame et pion à vérifier)
    //Retourne vrai s'il y a au moins une prise obligatoire
    public static boolean verifPriseObligatoireDébut(int[][] plateau, int joueur) {

        //Dans ce programme plateau[x][y] i.e l'indice x tableau d'adresses et y tableau contenant les int
        for (int x = 0; x < plateau.length; x++) {

            for (int y = 0; y < plateau[x].length; y++) {

                if (prise(plateau, joueur, x, y))
                    return true;
            }
        }
        return false;
    }

    //Demande la saisie de l’utilisateur puis appel la fonction convertirAscii et modifie les paramètres
    public static int saisieLigneUtilisateur() {

        int ligne;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(" Saisissez la ligne : ");
            ligne = scanner.nextInt();
        } while (ligne < 1 || ligne > 8);

        ligne -= 1;

        return ligne;

    }

    public static int saisieColUtilisateur() {

        int col;

        Scanner scanner = new Scanner(System.in);

        char colonneChar; //colonne de l'utilisateur
        int Icolonne; // colonne ascii

        do {
            System.out.println(" Saisissez la colonne : ");
            colonneChar = scanner.next().charAt(0);
            Icolonne = (int) colonneChar;
        } while (Icolonne < 65 || Icolonne > 74);

        col = Methodes.convertirAscii(Icolonne);
        return col;

    }

    //Affiche les indices des pions ou dames pouvant être bougés puis les compare avec le pion demandé à l’utilisateur
    // Appel la fonction saisieUtilisateur
    //Tant que la saisieUtilisateur ne correspond pas -> la rappelle
    //Une fois qu’elle correspond modifie les variables de la pièce sélectionnée
    public static int[][] afficherPriseObligatoire(int[][] plateau, int joueur) {

        ArrayList<Integer> l = new ArrayList<>();
        int [][]retour = new int [1][2];
        int iActuel = 0;

        //Stocker les indices des pions ou dames pouvant effectuer au moins une prise dans un tableau
        for (int i1Plat = 0; i1Plat < plateau.length; i1Plat++) {

            for (int i2Plat = 0; i2Plat < plateau[i1Plat].length; i2Plat++) {

                if (prise(plateau, joueur, i1Plat, i2Plat)) {
                    System.out.println("Prise à faire depuis " + (i1Plat+1) + " " + convertirInt(i2Plat));
                    l.add(i1Plat);
                    iActuel++;
                    l.add(i2Plat);
                    iActuel++;

                }
            }
        }

        //Demander la sélection
        int ligneSelectionnée;
        int colSelectionnée;
        boolean valeurTrouvée = false;

       do {

           System.out.println("Sélectionnez la ligne puis la colonne du pion à déplacer : ");
           ligneSelectionnée = saisieLigneUtilisateur();
           colSelectionnée = saisieColUtilisateur();

           //Parcourir la liste et vérifier que la valeur s'y trouve
           for(int indListe = 0 ; indListe < l.size(); indListe+=2){

               if( l.get(indListe) == ligneSelectionnée ){

                   if( l.get(indListe+1) == colSelectionnée) {
                       valeurTrouvée = true;
                   }
               }
           }

       } while(valeurTrouvée == false);

        retour[0][0] = ligneSelectionnée;
        retour[0][1] = colSelectionnée;

        return retour;
    }

    //Affiche les indices des endroits où la pièce sélectionnée peut se déplacer, les stocke dans une liste
    // puis Appel saisieUtilisateur
    // puis les compare et effectue le déplacement
    // On modifie le plateau de jeu
    public static void effectuerPrise(int [][] plateau, int [][] pion, int joueur) {

        int x = pion[0][0];
        int y = pion[0][1];

        ArrayList<Integer> l = new ArrayList<>();

        int pionEnnemi;
        int dameEnnemi;
        int pionJoueur;
        int dameJoueur;

        if(joueur == 1){
            pionJoueur=1;
            dameJoueur=3;
            pionEnnemi=2;
            dameEnnemi=4;
        }
        else{
            pionJoueur=2;
            dameJoueur=4;
            pionEnnemi=1;
            dameEnnemi=3;
        }

        //Stocker l'indice de la case où arriver et celle du pion qui devra disparaître
        //On les stocke de 4 en 4 i.e les 2 premiers indices = endroit où bouger, les 2 autres = pièce dévorée
        if (plateau[x][y] == pionJoueur) {

                //[1][1] i.e bas droite
                if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                    if (plateau[x + 1][y + 1] == pionEnnemi || plateau[x + 1][y + 1] == dameEnnemi) {
                        if (x + 2 >= 0 && x + 2 <= plateau.length - 1 && y + 2 >= 0 && y + 2 <= plateau[x].length - 1) {
                            if (plateau[x + 2][y + 2] == 0) {
                                l.add(x + 2);
                                l.add(y + 2);
                                l.add(x + 1);
                                l.add(y + 1);
                            }
                        }
                    }
                }

                // [-1][-1] i.e haut gauche
                if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                    if (plateau[x - 1][y - 1] == pionEnnemi || plateau[x - 1][y - 1] == dameEnnemi) {
                        if (x - 2 >= 0 && x - 2 <= plateau.length - 1 && y - 2 >= 0 && y - 2 <= plateau[x].length - 1) {
                            if (plateau[x - 2][y - 2] == 0) {
                                l.add(x - 2);
                                l.add(y - 2);
                                l.add(x - 1);
                                l.add(y - 1);
                            }
                        }
                    }
                }

                //[1][-1] i.e bas gauche
                if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                    if (plateau[x + 1][y - 1] == pionEnnemi || plateau[x + 1][y - 1] == dameEnnemi ) {
                        if (x + 2 >= 0 && x + 2 <= plateau.length - 1 && y - 2 >= 0 && y - 2 <= plateau[x].length - 1) {
                            if (plateau[x + 2][y - 2] == 0) {
                                l.add(x + 2);
                                l.add(y - 2);
                                l.add(x + 1);
                                l.add(y - 1);
                            }

                        }
                    }
                }

                //[-1][1] i.e haut droite
                if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                    if (plateau[x - 1][y + 1] == pionEnnemi || plateau[x - 1][y + 1] == dameEnnemi) {
                        if (x - 2 >= 0 && x - 2 <= plateau.length - 1 && y + 2 >= 0 && y + 2 <= plateau[x].length - 1) {
                            if (plateau[x - 2][y + 2] == 0) {
                                l.add(x - 2);
                                l.add(y + 2);
                                l.add(x - 1);
                                l.add(y + 1);
                            }

                        }
                    }
                }

            }
        else if (plateau[x][y] == dameJoueur ) {

                int nbCase = 1; //Qu'on va incrémenter dans un if pour vérifier puis remettre à 1

                //Stocker l'indice de la case où arriver et celle du pion qui devra disparaître

                //Vérifie diagonale [1][1] i.e bas droite
                while (x + nbCase >= 0 && x + nbCase <= plateau.length - 1 && y + nbCase >= 0 && y + nbCase <= plateau[x].length - 1) {
                    if (plateau[x + nbCase][y + nbCase] == pionEnnemi || plateau[x + nbCase][y + nbCase] == dameEnnemi) {
                        if (x + nbCase + 1 >= 0 && x + nbCase + 1 <= plateau.length - 1 && y + nbCase + 1 >= 0 && y + nbCase + 1 <= plateau[x].length - 1)
                            if (plateau[x + nbCase + 1][y + nbCase + 1] == 0) {

                                l.add(x + nbCase + 1);
                                l.add(y + nbCase + 1);
                                l.add(x + nbCase);
                                l.add(y + nbCase);

                                //On recherche s'il y a d'autres cases vides après la prise où la dame peut s'arrêter
                                int after = nbCase+2;
                                while (x + after >= 0 && x + after <= plateau.length - 1 && y + after >= 0 && y + after <= plateau[x].length - 1){
                                    if (plateau[x + after][y + after] == 0){

                                        l.add(x + after);
                                        l.add(y + after);
                                        l.add(x + nbCase);
                                        l.add(y + nbCase);

                                    }

                                    after++;

                                }

                            }
                    }
                    nbCase++;
                }
                nbCase = 0;

                //Vérifie diagonale [-1][-1] i.e haut gauche
                while (x - nbCase >= 0 && x - nbCase <= plateau.length - 1 && y - nbCase >= 0 && y - nbCase <= plateau[x].length - 1) {
                    if (plateau[x - nbCase][y - nbCase] == pionEnnemi || plateau[x - nbCase][y - nbCase] == dameEnnemi) {
                        if (x - nbCase - 1 >= 0 && x - nbCase - 1 <= plateau.length - 1 && y - nbCase - 1 >= 0 && y - nbCase - 1 <= plateau[x].length - 1) {
                            if (plateau[x - nbCase - 1][y - nbCase - 1] == 0) {

                                l.add(x - nbCase - 1);
                                l.add(y - nbCase - 1);
                                l.add(x - nbCase);
                                l.add(y - nbCase);

                                //On recherche s'il y a d'autres cases vides après la prise où la dame peut s'arrêter
                                int after = nbCase + 2;
                                while (x - after >= 0 && x - after <= plateau.length - 1 && y - after >= 0 && y - after <= plateau[x].length - 1) {
                                    if (plateau[x - after][y - after] == 0) {

                                        l.add(x - after);
                                        l.add(y - after);
                                        l.add(x - nbCase);
                                        l.add(y - nbCase);

                                    }

                                    after++;
                                }
                            }
                        }
                    }
                    nbCase++;
                }
                nbCase=0;

                //Vérifie diagonale [1][-1] i.e bas gauche
                while (x + nbCase >= 0 && x + nbCase <= plateau.length - 1 && y - nbCase >= 0 && y - nbCase <= plateau[x].length - 1) {
                    if (plateau[x + nbCase][y - nbCase] == pionEnnemi || plateau[x + nbCase][y - nbCase] == dameEnnemi) {
                        if (x + nbCase + 1 >= 0 && x + nbCase + 1 <= plateau.length - 1 && y - nbCase - 1 >= 0 && y - nbCase - 1 <= plateau[x].length - 1){
                            if (plateau[x + nbCase + 1][y - nbCase - 1] == 0){
                                l.add(x + nbCase + 1);
                                l.add(y - nbCase - 1);
                                l.add(x + nbCase);
                                l.add(y - nbCase);

                                //On recherche s'il y a d'autres cases vides après la prise où la dame peut s'arrêter
                                int after = nbCase+2;
                                while (x + after >= 0 && x + after <= plateau.length - 1 && y - after >= 0 && y - after <= plateau[x].length - 1) {
                                    if (plateau[x + after][y + after] == 0) {

                                        l.add(x + after);
                                        l.add(y - after);
                                        l.add(x + nbCase);
                                        l.add(y - nbCase);

                                    }
                                    after++;
                                }
                            }
                        }
                    }
                    nbCase++;
                }
                nbCase=0;

                //Vérifie diagonale [-1][1] i.e haut droite
                while (x - nbCase >= 0 && x - nbCase <= plateau.length - 1 && y + nbCase >= 0 && y + nbCase <= plateau[x].length - 1) {
                    if (plateau[x - nbCase][y + nbCase] == pionEnnemi || plateau[x - nbCase][y + nbCase] == dameEnnemi) {
                        if (x - nbCase - 1 >= 0 && x - nbCase - 1 <= plateau.length - 1 && y + nbCase + 1 >= 0 && y + nbCase + 1 <= plateau[x].length - 1){
                            if (plateau[x - nbCase - 1][y + nbCase + 1] == 0){

                                l.add(x - nbCase - 1);
                                l.add(y + nbCase + 1);
                                l.add(x - nbCase);
                                l.add(y + nbCase);

                                //On recherche s'il y a d'autres cases vides après la prise où la dame peut s'arrêter
                                int after = nbCase+2;
                                while (x - after >= 0 && x - after <= plateau.length - 1 && y + after >= 0 && y + after <= plateau[x].length - 1) {
                                    if (plateau[x - after][y + after] == 0) {

                                        l.add(x - after);
                                        l.add(y + after);
                                        l.add(x - nbCase);
                                        l.add(y + nbCase);

                                    }
                                    after++;
                                }
                            }
                        }
                    }
                    nbCase++;
                }
            }

        //Affichage
        for(int i = 0 ; i < l.size(); i+=4){

            System.out.println("Déplacement possible en " + ( l.get(i)+1 ) + convertirInt(l.get(i+1)));

        }

        //Appel saisieUtilisateur et comparaison
        int a = 0;
        int b= 0;

        //Demander la sélection
        int ligneSelectionnée;
        int colSelectionnée;
        boolean valeurTrouvée = false;

        do {

            System.out.println("Sélectionnez la ligne puis la colonne de l'emplacement où bouger votre pièce : ");
            ligneSelectionnée = saisieLigneUtilisateur();
            colSelectionnée = saisieColUtilisateur();

            //Parcourir la liste et vérifier que la valeur s'y trouve
            for (int indListe = 0 ; indListe < l.size(); indListe+=4){

                if( l.get(indListe) == ligneSelectionnée ){

                    if( l.get(indListe+1) == colSelectionnée) {
                        valeurTrouvée = true;
                        a=l.get(indListe+2);
                        b=l.get(indListe+3);
                    }
                }
            }

        } while(!valeurTrouvée);

        //ATTENTION NE PAS BOUGER L ORDRE : Effectuer le déplacement
        //Vérifier s'il s'agit d'un pion ou d'une dame
        //Mettre à zéro la case qui doit disparaître
        plateau[a][b]=0;

        //Mettre à zéro l'ancien emplacement et avec la pièce le nouvel emplacement
        if ( plateau[x][y] == pionJoueur ){
            plateau[x][y]=0;
            plateau[ligneSelectionnée][colSelectionnée]=pionJoueur;
        }
        else {
            plateau[x][y]=0;
            plateau[ligneSelectionnée][colSelectionnée]=dameJoueur;
        }

        //Remettre les bonnes valeurs dans pion pour pouvoir le faire interagir avec les autres fonctions dans Tour
        pion[0][0]=ligneSelectionnée;
        pion[0][1]=colSelectionnée;

    }

    //Demande déplacement puis Déplacement de la Dame
    public static void DeplacementDame (int [][] plateau, int ligne, int col, int joueur){

        Scanner scanner = new Scanner(System.in);
        //variables qui s'incrementent = permet de faire les diagonales
        // on doit donc les répéter 4 fois (pour les diagonales)
        int x = 0; //ligne
        int y = 0; //colonne
        boolean fin_boucle= false;
        char colC;

        int nbsout =1; // permet comptage nb sout = nb de variables a faire : A ENLEVER SI IDEE NON RETENUE

        ArrayList<Integer> coordC = new ArrayList<>();
        ArrayList<Integer> coordL = new ArrayList<>();
        //ici, le programme parcours toute la diagonale sud-est.
        do{
            x++;
            y++;

            //Regarde si case dans tableau, puis continue son parcours j'usqu'à tonber sur une case diff de 0
            if ((ligne+x) >=0 && (ligne+x) <plateau.length-1 && (col+y) >=0 && (col+y) <=plateau[ligne].length-1 ) {
                if (plateau[ligne + x][col + y] == 0) {
                    colC = (char) convertirInt(col+y);
                    System.out.println(nbsout +" - DSE : la ligne " + ((ligne+x)+1) + " et la colonne " + colC + " est libre");
                    nbsout++;
                    coordL.add((ligne+x)+1);
                    coordC.add((col+y)+1);
                }
                else{
                    fin_boucle= true;
                }
            }
            else {
                fin_boucle= true;
            }

        }while (!fin_boucle);

        //les boucles etant des do, il est necessaire de re-initiallisé
        fin_boucle=false;
        x = 0; //ligne
        y = 0; //colonne
        colC= (char) convertirInt(col);

        //ici, le programme parcours toute la diagonale sud-ouest.
        do{
            x++;
            y--;

            //Regarde si case dans tableau, puis continue son parcours j'usqu'à tonber sur une case diff de 0
            if ((ligne+x) >=0 && (ligne+x) <plateau.length-1 && (col+y) >=0 && (col+y) <=plateau[ligne].length-1 ) {
                if (plateau[ligne + x][col + y] == 0) {
                    colC = (char) convertirInt(col+y); // ATENTION AU + ICI
                    System.out.println(nbsout +" - DSO : la ligne " + ((ligne+x)+1) + " et la colonne " + colC + " est libre");
                    nbsout++;
                    coordL.add((ligne+x)+1);
                    coordC.add((col+y)+1);
                }
                else {
                    fin_boucle= true;
                }
            }
            else {
                fin_boucle= true;
            }

        }while (!fin_boucle);

        //les boucles etant des do, il est necessaire de re-initiallisé
        fin_boucle=false;
        x = 0; //ligne
        y = 0; //colonne
        colC= (char) convertirInt(col);

        //ici, le programme parcours toute la diagonale Nord-ouest.
        do{
            x--;
            y--;

            //Regarde si case dans tableau, puis continue son parcours j'usqu'à tonber sur une case diff de 0
            if ((ligne+x) >=0 && (ligne+x) <plateau.length-1 && (col+y) >=0 && (col+y) <=plateau[ligne].length-1 ) {
                if (plateau[ligne + x][col + y] == 0) {
                    colC = (char) convertirInt(col+y); // ATENTION AU + ICI
                    System.out.println(nbsout +" - DNO : la ligne " + ((ligne+x)+1) + " et la colonne " + colC + " est libre");
                    nbsout++;
                    coordL.add((ligne+x)+1);
                    coordC.add((col+y)+1);
                }
                else {
                    fin_boucle= true;
                }
            }
            else {
                fin_boucle= true;
            }

        }while (!fin_boucle);

        //les boucles etant des do, il est necessaire de re-initiallisé
        fin_boucle=false;
        x = 0; //ligne
        y = 0; //colonne
        colC= (char) convertirInt(col);

        //ici, le programme parcours toute la diagonale Nord-Est.
        do{
            x--;
            y++;

            //Regarde si case dans tableau, puis continue son parcours j'usqu'à tonber sur une case diff de 0
            if ((ligne+x) >=0 && (ligne+x) <plateau.length-1 && (col+y) >=0 && (col+y) <=plateau[ligne].length-1 ) {
                if (plateau[ligne + x][col + y] == 0) {
                    colC = (char) convertirInt(col+y); // ATENTION AU + ICI
                    System.out.println(nbsout +" - DNE : la ligne " + ((ligne+x)+1) + " et la colonne " + colC + " est libre");
                    nbsout++;
                    coordL.add((ligne+x)+1);
                    coordC.add((col+y)+1);
                }
                else {
                    fin_boucle= true;
                }
            }
            else {
                fin_boucle= true;
            }

        }while (!fin_boucle);

        // A FAIRE :
        // il faut desormais que l'on demande a l'utilisateur la case sur laquelle allez, et donc stocker
        // chacune des valeurs des cases posssibles, pour verifier que son déplacement est correct

        // IDEE : faire un tableau qui stocke les valeurs des coordonnées des cases, ainsi qu'une variable qui note
        // le nb de fois que les tours sont fait
        // ainsi on a le nb de tour qui c'est fait (=le nombre de case de notre tableau qui sera rempli) et les
        // valeurs des coordonnées dans les cases
        // compte le nombre de fois que les sout ce sont mis

        int ligneS;
        int colS;
        int colcharS;
        int num = -1;
        boolean verif= false;

        //verif que la selecion de l'utilisateur est correcte
        do {
            System.out.println(coordL);
            System.out.println(coordC);
            System.out.println("indiquez la ligne, puis la colonne de votre choix : ");
            ligneS=scanner.nextInt();
            colcharS=scanner.next().charAt(0); // on récupère le cara de l'utilisateur
            colS= (int) colcharS; // on converti ce cara en nombre
            colS= convertirAscii(colS); // on transforme ce nombre en nombre cohérent pour nous
            System.out.println(colS);

            ArrayList<Integer> stockresult = new ArrayList<>(); // stock les résutats de la 1ere boucle for
            // dans les cas ou la meme ligne apparait deux fois dans la liste, une liste qui ttocke les indices pou cette
            // même ligne apparait permet de verifier que la colonne saisie est bien celle associée à la ligne
            // et pas une clonne d'une autre ligne
            // la solution avec un stockage par variable est fausse, car elle ne prend pas en comptz le fait qu'une
            // ligne puissent être répétée + d'une fois dans la liste de stockage des lignes
            for (int i =0; i<coordL.size(); i++){
                if (coordL.get(i) == ligneS){
                    stockresult.add(i);
                    System.out.println("1ere B passée");
                }
            }

            for (int j=0; j<coordC.size(); j++){ // regarde si la ligne saisie est bien associé à la colonne saisie
                for (int z=0; z<stockresult.size(); z++) {
                    if (coordC.get(j) == (colS + 1) && j == stockresult.get(z)) {
                        verif = true;
                        System.out.println("2eme B passée");
                    }
                }
            }

            //mettre un for pour parcourir liste, ce qui permet verif valeurs tapée et celles proposée ?
            // IDEE : la boucle for va parcourir le tableau de case j'usqu'à trouver la valeur
            // PB : il se peut que la valeur ne soit pas associé a une col ou ligne mais passe quand meme
            // 2EME IDEE : DEUX liste, 1 pour les col et l'autre pour les lignes, comme ca la case 1 de la liste col
            // associée a la case 1 de la liste ligne !

            // valeur case + 0 = ligne
            // valeur case + 1 = col



        }while (verif == false);

        //ici partie qui change les valeurs en fonction des cases choisies = déplacement pur
        if (plateau [ligne][col] == 1){
            plateau[ligneS-1][colS]=1;
        }
        else{
            plateau[ligneS-1][colS]=2;
        }
        plateau [ligne][col] = 0;




        System.out.println("deplacement dame c'est bien executé : bravo !");

    }

    //Demande déplacement puis Déplacement du pion
    public static void DeplacementPion(int [][] plateau, int ligne, int col, int joueur){
        Scanner scanner = new Scanner(System.in);
        int ligneDiagoDB;
        char colDiagoDB;
        int ligneDiagoGB;
        char colDiagoGB;
        int ligneDiagoDN;
        char colDiagoDN;
        int ligneDiagoGN;
        char colDiagoGN;
        int colDiagG = col-1;
        int colDiagD = col+1;
        ligneDiagoDN = (ligne + 1)+1;
        colDiagoDN = (char) convertirInt((col+1));
        ligneDiagoGN = (ligne + 1)+1;
        colDiagoGN = (char) convertirInt((col-1));
        ligneDiagoGB = (ligne - 1)+1;
        colDiagoGB = (char) convertirInt((col-1));
        ligneDiagoDB = (ligne - 1)+1;
        colDiagoDB = (char) convertirInt((col+1));
        int BouN =0;
        //les diff possibilités de choix
        // blanc
        if (plateau[ligne][col] == 1) {
            // x+1 >= 0 && x+1 <= t.length-1 && y+1 >= 0 && y+1 <= t[x].length-1
            if (ligne-1 >=0 && ligne-1 <plateau.length-1 && col+1 >=0 && col+1 <=plateau[ligne].length-1 ) {
                if (plateau[ligne - 1][col + 1] == 0) {
                    System.out.println("Vous pouvez choisir la ligne : " + ligneDiagoDB + " avec la colonne : " + colDiagoDB);
                }
                else {
                    ligneDiagoDB = 999;
                    colDiagoDB = 'Z';
                }
            }
            if (ligne-1 >=0 && ligne-1 <plateau.length-1 && col-1 >=0 && col-1 <=plateau[ligne].length-1 ) {
                if (plateau[ligne - 1][col - 1] == 0) {
                    System.out.println("Vous pouvez choisir la ligne : " + ligneDiagoGB + " avec la colonne : " + colDiagoGB);
                }
                else {
                    ligneDiagoGB = 999;
                    colDiagoGB = 'Z';
                }
            }
            BouN =1;
        }
        // noir
        if (plateau[ligne][col] == 2) {
            if (ligne+1 >=0 && ligne+1 <plateau.length-1 && col+1 >=0 && col+1 <=plateau[ligne].length-1 ) {
                if (plateau[ligne + 1][col + 1] == 0) {
                    System.out.println("Vous pouvez choisir la ligne : " + ligneDiagoDN + " avec la colonne : " + colDiagoDN);
                }
                else {
                    ligneDiagoDN = 999;
                    colDiagoDN = 'Z';
                }
            }
            if (ligne+1 >=0 && ligne+1 <plateau.length-1 && col-1 >=0 && col-1 <=plateau[ligne].length-1 ) {
                if (plateau[ligne + 1][col - 1] == 0) {
                    System.out.println("Vous pouvez choisir la ligne : " + ligneDiagoGN + " avec la colonne : " + colDiagoGN);
                }
                else {
                    ligneDiagoGN = 999;
                    colDiagoGN = 'Z';
                }
            }
            BouN =2;
        }

        int ligneS;
        int colS;
        int colcharS;

        //verif que la selecion de l'utilisateur est correcte
        do {
            System.out.println("indiquez la ligne, puis la colonne de votre choix : ");
            ligneS=scanner.nextInt();
            colcharS=scanner.next().charAt(0);
            colS= (int) colcharS;
            colS= convertirAscii(colS);

        }while ((ligneS != ligneDiagoGN  && ligneS!= ligneDiagoGB && ligneS!= ligneDiagoDB && ligneS!= ligneDiagoDN) || (colS != colDiagD && colS != colDiagG));



        //ici partie qui change les valeurs en fonction des cases choisies
        plateau [ligne][col] = 0;
        if (BouN ==1){
            plateau[ligneS-1][colS]=1;
        }
        else{
            plateau[ligneS-1][colS]=2;
        }

    }

    //Vérifie que la pièce sélectionnée appartienne bien au joueur
    public static boolean verifPion ( int [][]plateau, int joueur, int ligne, int col){

        if (joueur == 1){
            if (plateau[ligne][col] == 1 || plateau[ligne][col] == 3 )
                return true;
        }
        else {
            if (plateau[ligne][col] == 2 || plateau[ligne][col] == 4 )
                return true;
        }
        return false;
    }

    //Vérifie que la pièce sélectionnée puisse bouger d'une case
    //Si la dame peut bouger d'une case elle peut bouger de plus juste vérifier les 4 cases autour
    //ATTENTION cette fonction ne teste que le déplacement pas la prise !
    public static boolean bloque (int [][] plateau, int joueur, int ligne, int col){

        int x = ligne;
        int y = col;

        //ATTENTION GERER LES PIONS : les pions ne peuvent se déplacer que en avant
        if (plateau[x][y] == 1 || plateau[x][y] == 2){
            if (joueur == 1){

                //[-1][1]
                if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                    if (plateau[x - 1][y + 1] == 0) {
                        return false;
                    }
                }
                //[-1][-1]
                if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                    if (plateau[x - 1][y - 1] == 0) {
                        return false;
                    }
                }

            }

            else {

                //[1][1]
                if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                    if (plateau[x + 1][y + 1] == 0) {
                        return false;
                    }
                }
                //[1][-1]
                if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                    if (plateau[x + 1][y - 1] == 0) {
                        return false;
                    }
                }
            }
        }

        //DAMES pareil dans les 2 cas : peut se déplacer dans tous les sens
        else {

            //Vérifier que la case existe puis qu'elle contient bien un 0
            //[1][1]
            if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                if (plateau[x + 1][y + 1] == 0) {
                    return false;
                }
            }
            //[1][-1]
            if (x + 1 >= 0 && x + 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                if (plateau[x + 1][y - 1] == 0) {
                    return false;
                }
            }
            //[-1][1]
            if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y + 1 >= 0 && y + 1 <= plateau[x].length - 1) {
                if (plateau[x - 1][y + 1] == 0) {
                    return false;
                }
            }
            //[-1][-1]
            if (x - 1 >= 0 && x - 1 <= plateau.length - 1 && y - 1 >= 0 && y - 1 <= plateau[x].length - 1) {
                if (plateau[x - 1][y - 1] == 0) {
                    return false;
                }
            }
        }

        return true;

        }

    //Vérifie qu'il reste un pion du joueur et que celui-ci n'est pas bloqué
    public static boolean victoire (int [][] plateau, int joueur){

        int pionEnnemi;
        int dameEnnemi;
        int joueurEnnemi;

        //étant donné qu'on veut appeler la fonction prise pour vérifier les pions adverses -> joueurEnnemi
        if (joueur == 1){
            pionEnnemi = 2;
            dameEnnemi = 4;
            joueurEnnemi = 2;
        }
        else {
            pionEnnemi = 1;
            dameEnnemi = 3;
            joueurEnnemi = 1;
        }

        //Vérifie s'il reste au moins un pion du joueur adverse
        // Et que celui-ci peut effectuer un déplacement ou une prise
        for (int ind1 = 0; ind1 < plateau.length; ind1++){
            for (int ind2 = 0; ind2 < plateau[ind1].length; ind2 ++){

                if(plateau[ind1][ind2] == pionEnnemi || plateau[ind1][ind2] == dameEnnemi ){
                    if ( !bloque(plateau,joueurEnnemi,ind1,ind2) || prise(plateau,joueurEnnemi,ind1,ind2) ){
                        return false;
                    }
                }
            }
        }

        return true;

    }

    //Transformer un pion en dame
    public static void transformation (int [][] plateau, int joueur, int ligne, int col){

        if( plateau[ligne][col] == 1 || plateau[ligne][col] == 2 ){

            if(joueur == 1){

                if(ligne == 0){
                    plateau[ligne][col] = 3;
                }

            }
            else{
                if (ligne == plateau.length-1){
                    plateau[ligne][col] = 4;
                }

            }

        }
    }

}
