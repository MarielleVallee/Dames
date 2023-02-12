import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodesTest {

    //Puisque cette fonction appelle la fonction prise,
    // il teste les 2 en même temps
    @Test
    public final void testVerifPriseObligatoireDébut(){

        //prend en paramètres : int[][] plateau, int joueur
        //Retourne vrai si au moins un pion du joueur peut prendre
        int [][] t1j1= {{0,0,0},{0,2,0},{1,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(t1j1, 1));
        int [][] t2j1={{0,0,0},{0,1,0},{1,0,1}};
        assertFalse(Methodes.verifPriseObligatoireDébut(t2j1, 1));

        int[][] t1j2={{2,0,0},{0,3,0},{0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(t1j2, 2));
        int[][] t2j2 = {{2,0,0},{0,4,0},{1,0,0}};
        assertFalse(Methodes.verifPriseObligatoireDébut(t2j2, 2));
        assertTrue(Methodes.verifPriseObligatoireDébut(t2j2, 1));
        int[][] t3j2 = {{2,0,2},{0,1,0},{0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(t3j2, 2));

        //Retourne vrai si au moins une dame peut prendre

        int [][] t1j3= {{3,0,0},{0,2,0},{0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(t1j3, 1));

        int [][] t2j3= {{3,0,0},{0,0,0},{0,0,2}};
        assertFalse(Methodes.verifPriseObligatoireDébut(t2j3, 1));

        int [][] t3j3= {{3,0,0,0},{0,0,0,0},{0,0,2,0},{0,0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(t3j3, 1));

        int [][] t4j3= {{3,0,0},{0,0,0},{0,0,0}};
        assertFalse(Methodes.verifPriseObligatoireDébut(t4j3, 1));

        //Test ultime dame
        int [][] ultimeDame = {{3,0,0,0,3},{0,0,0,2,0},{0,0,0,0,0},{0,0,0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(ultimeDame,1));

        int[][] verifDame = {{0,0,0,0,0},{0,0,0,0,0},{0,0,3,0,0},{0,2,0,0,0},{0,0,0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(verifDame,1));

        int[][] veri4 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,4,0,0},{0,1,0,0,0},{0,0,0,0,0}};
        assertTrue(Methodes.verifPriseObligatoireDébut(veri4,2));

    }

    //Test verifPion
    @Test
    public final void testVerifPion(){

        //int [][]plateau, int joueur, int ligne, int col

        int [][] t1= {{0,1},{0,0}};
        assertTrue(Methodes.verifPion(t1, 1,0,1));

        int [][] t2= {{0,2},{3,0}};
        assertTrue(Methodes.verifPion(t2, 1,1,0));
        assertFalse(Methodes.verifPion(t2,1,0,1));
        assertTrue(Methodes.verifPion(t2,2,0,1));

        int[][] t3 = {{0,4},{0,3}};
        assertTrue(Methodes.verifPion(t3, 1,1,1));
        assertFalse(Methodes.verifPion(t3,1,0,0));
        assertTrue(Methodes.verifPion(t3,2,0,1));

    }

    //Test bloque ATTENTION cette fonction ne teste que le déplacement pas la prise !
    @Test
    public final void testBloque(){

        //int [][] plateau, int ligne, int col
        int [][] t1= {{0,1},{0,0}};
        assertTrue(Methodes.bloque(t1, 1,0,1));

        int [][] t2= {{0,1},{2,0}};
        assertTrue(Methodes.bloque(t2, 1,0,1));
        assertTrue(Methodes.bloque(t2, 2,1,0));

        int [][] t3= {{0,0},{2,0}};
        assertTrue(Methodes.bloque(t3, 2,1,0));

        int [][] t4= {{0,0},{3,0}};
        assertFalse(Methodes.bloque(t4, 1,1,0));

        int [][] t5= {{2,0},{0,0}};
        assertFalse(Methodes.bloque(t5, 2,0,0));

        int [][] t6 = {{2,0,0,1},{1,0,0,0},{0,0,4,0},{0,3,0,0},{0,1,0,2}};
        assertFalse(Methodes.bloque(t6,2,0,0));
        assertFalse(Methodes.bloque(t6,1,1,0));
        assertFalse(Methodes.bloque(t6,2,2,2));
        assertFalse(Methodes.bloque(t6,1,3,1));
        assertFalse(Methodes.bloque(t6,1,4,1));
        assertTrue(Methodes.bloque(t6,1,0,3));
        assertTrue(Methodes.bloque(t6,2,4,3));

    }

    //Test Victoire
    @Test
    public final void testVictoire(){

        //int [][] plateau, int joueur
        //Joueur 1
        int[][] t1j1 = {{0,0,0},{0,0,1}};
        assertTrue(Methodes.victoire(t1j1,1));
        int[][] t2j1 = {{0,0,0},{2,0,1}};
        assertTrue(Methodes.victoire(t2j1,1));
        //Déplacement possible
        int[][] t3j1 = {{0,0,0},{4,0,1}};
        assertFalse(Methodes.victoire(t3j1,1));
        int[][] t5j1 = {{0,2,0},{0,0,0},{1,0,1}};
        assertFalse(Methodes.victoire(t5j1,1));
        //Prise possible
        int[][]t4j1 = {{0,0,0},{0,1,0},{2,0,1}};
        assertFalse(Methodes.victoire(t4j1,1));

        //Joueur 2
        int[][] t1j2 = {{2,0,2},{0,0,0}};
        assertTrue(Methodes.victoire(t1j2,2));
        int[][] t2j2 = {{1,0,0},{2,0,2}};
        assertTrue(Methodes.victoire(t2j2,2));
        //Déplacement possible
        int[][] t3j2 = {{0,0,0},{1,0,0},{0,0,2}};
        assertFalse(Methodes.victoire(t3j2,2));
        int[][] t4j2 = {{3,0,0},{0,0,2}};
        assertFalse(Methodes.victoire(t4j2,2));
        //Prise possible
        int [][] t5j2 = {{3,0,0},{0,2,0},{2,0,0}};
        assertFalse(Methodes.victoire(t5j2,2));

    }

    //Test Transformation
    @Test
    public final void testTransformation(){

        //Transformations
        int [][] t1 = {{0,0,1},{0,0,0}};
        int [][] t1bis = {{0,0,3},{0,0,0}};
        Methodes.transformation(t1,1,0,2);
        assertArrayEquals(t1,t1bis);

        int [][] t2 = {{0,0,0},{0,0,2}};
        int [][] t2bis = {{0,0,0},{0,0,4}};
        Methodes.transformation(t2,2,1,2);
        assertArrayEquals(t2,t2bis);

    }

}

