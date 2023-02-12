public class Tour {
    public static void tour (int [][] plateau, int joueur ){

        int ligneSelect = -1;
        int colSelect = -1;
        int [][] pion = new int[1][2];

        if (Methodes.verifPriseObligatoireDébut(plateau, joueur)){

            pion = Methodes.afficherPriseObligatoire(plateau, joueur);
            Methodes.effectuerPrise(plateau,pion,joueur);

            ligneSelect = pion[0][0];
            colSelect = pion[0][1];

            while (Methodes.prise(plateau, joueur, ligneSelect, colSelect)){
                Methodes.effectuerPrise(plateau,pion,joueur);
                ligneSelect = pion[0][0];
                colSelect = pion[0][1];
            }

        }

        else {

            System.out.println("Sélectionnez la ligne puis la colonne du pion à déplacer : ");
            ligneSelect = Methodes.saisieLigneUtilisateur();
            colSelect = Methodes.saisieColUtilisateur();

            while(!Methodes.verifPion( plateau, joueur, ligneSelect, colSelect)){
                System.out.println("Erreur le pion selectionné n'est pas celui de votre joueur !");
                ligneSelect = Methodes.saisieLigneUtilisateur();
                colSelect = Methodes.saisieColUtilisateur();
            }

            while(Methodes.bloque(plateau,joueur,ligneSelect,colSelect)){
                System.out.println("Erreur, votre pièce ne peut pas effectuer de déplacement");
                ligneSelect = Methodes.saisieLigneUtilisateur();
                colSelect = Methodes.saisieColUtilisateur();
            }

            if(plateau[ligneSelect][colSelect] == 1 || plateau[ligneSelect][colSelect] == 2 ){

               Methodes.DeplacementPion(plateau,ligneSelect,colSelect,joueur);
            }
            else {

                Methodes.DeplacementDame(plateau,ligneSelect,colSelect,joueur);
            }

        }

        //Vérifier si le pion a fini sur la dernière ligne ennemie i.e s'il y a transformation
        Methodes.transformation(plateau,joueur,ligneSelect,colSelect);

    }

}

