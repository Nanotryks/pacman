package pacman;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	public static int map[][];
	public int X, Y;
	private static int MapHeight, MapWidth;

	public Map() {
		map = Generer.generer();
		MapHeight = map.length;
		MapWidth = map[0].length;

	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public static void AfficherLabyrinthe() {
		StdDraw.picture(19.5, 25, "ground.jpg",50,50);
		int CurrentCaseType;
		int CurrentCoordX;
		int CurrentCoordY;
		
		for (int i = 0; i < MapHeight; i++) {
			for (int j = 0; j < MapWidth; j++) {
				CurrentCoordX = ((40-MapWidth)/2)+j; //Définition de la coordX sur un canevas de 40 de large
				CurrentCoordY = (50-6)-i; //Définition de la coordY sur un canevas de 50 de haut, en comptant 6 espace de marge avant la grille
				
				CurrentCaseType = map[i][j];
				
				switch(CurrentCaseType){
				case 1: //Mur
					StdDraw.picture(CurrentCoordX, CurrentCoordY,"square.png", 1, 1);				
					break;
				case 2: //Pièce
					StdDraw.picture(CurrentCoordX, CurrentCoordY,"coin.png", 0.5, 0.5);				
					break;
				case 3: //Joueur
					StdDraw.picture(CurrentCoordX, CurrentCoordY, Joueur.CurrentImage, 1.3, 1.3);
					break;
				case 4: //Fantome
					StdDraw.picture(CurrentCoordX, CurrentCoordY, "ghost1.png", 1.3, 1.3);				
					break;					
				case 5: //Fantome
					StdDraw.picture(CurrentCoordX, CurrentCoordY, "ghost2.png", 1.3, 1.3);							
					break;
				case 6: //Fantome
					StdDraw.picture(CurrentCoordX, CurrentCoordY, "ghost3.png", 1.3, 1.3);								
					break;
				case 7: //Fantome
					StdDraw.picture(CurrentCoordX, CurrentCoordY, "ghost4.png", 1.3, 1.3);						
					break;
				}
				
				
			}

		}

	}

	public static void AfficherUI() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(19.5, 11, 14, 3);
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledRectangle(19.5, 11, 13.8, 2.8);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(19.5, 11, "Score : "+Joueur.getScore()+"   "+"Vies : "+Joueur.getLifeCount());
		StdDraw.show();
		if (Joueur.getLifeCount()<1){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(19.5, 30, 14, 3);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(19.5, 30, 13.8, 2.8);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.text(19.5, 30, "Game Over - appuyez sur R pour rejouer");
			StdDraw.show();
		}
		if (Joueur.getScore()==239){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(19.5, 30, 14, 3);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(19.5, 30, 13.8, 2.8);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.text(19.5, 30, "Félicitation vous avez gagné !");
			StdDraw.text(19.5, 25, "Appuyez sur R pour rejouer !");
			StdDraw.show();
		}
	}

	public static int[][] getGrille() {
		return map;
	}

	public static int getPosY(int x) {
		getGrille();
		int hauteurInverse = MapHeight-1;
		int a = 0;
		for (int i = 0; i < MapHeight; i++) {
			for (int j = 0; j < MapWidth; j++) {
				if (map[hauteurInverse - i][j] == x) {
					a = hauteurInverse - i;
					break;
				}
			}
		}
		return a;
	}

	public static int getPosX(int x) {
		getGrille();
		int hauteurInverse = MapHeight-1;
		int b = 0;
		for (int i = 0; i < MapHeight; i++) {
			for (int j = 0; j < MapWidth; j++) {
				if (map[hauteurInverse - i][j] == x) {
					b = j;
					break;
				}

			}
		}
		return b;
	}
}
