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
		StdDraw.clear(StdDraw.BLACK);
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
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledSquare(CurrentCoordX, CurrentCoordY, 0.4);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(CurrentCoordX, CurrentCoordY, 0.3);					
					break;
				case 2: //Pièce
					StdDraw.picture(CurrentCoordX, CurrentCoordY,"coin.png", 0.5, 0.5);				
					break;
				case 3: //Joueur
					StdDraw.picture(CurrentCoordX, CurrentCoordY, Joueur.CurrentImage, 1, 1);
					break;
				case 4: //Fantome
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledCircle(CurrentCoordX, CurrentCoordY, 0.5);					
					break;					
				case 5: //Fantome
					StdDraw.setPenColor(StdDraw.PINK);
					StdDraw.filledCircle(CurrentCoordX, CurrentCoordY, 0.5);						
					break;
				case 6: //Fantome
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.filledCircle(CurrentCoordX, CurrentCoordY, 0.5);						
					break;
				case 7: //Fantome
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledCircle(CurrentCoordX, CurrentCoordY, 0.5);						
					break;
				}
				
				
			}

		}

	}

	public static void AfficherUI() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(19.5, 11, 14, 3);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(19.5, 11, "Score : "+Joueur.getScore());
		StdDraw.show();
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
