package pacman;

import edu.princeton.cs.introcs.StdDraw;

public class Joueur extends Personnage {
	private static int Score = 0;
	private String nom;
	public String CurrentDirection;
	public static String CurrentImage = "pacmanright.png";
	private static int LifeCount = 3;
	
	private int CurrentX;
	private int CurrentY;
	private int StartX;
	private int StartY;
	
	public Joueur(int X, int Y, int Score) {
		super(X, Y);
		
		CurrentX = Map.getPosX(3);
		CurrentY = Map.getPosY(3);

		StartX = CurrentX;
		StartY = CurrentY;
	}

	public static int getScore() {
		return Score;
	}

	public static int getLifeCount() {
		return LifeCount;
	}

	public void setDirection(String direction) {
		CurrentDirection = direction;
		switch (CurrentDirection) {
		case "up":
			CurrentImage = "pacmanup.png";
			break;
		case "down":
			CurrentImage = "pacmandown.png";
			break;			
		case "right":
			CurrentImage = "pacmanright.png";
			break;			
		case "left":
			CurrentImage = "pacmanleft.png";
			break;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void collisionFantome(){
		LifeCount--;
			//On renvoie le joueur à sa case de départ
			int[][] m = Map.getGrille();
			m[StartY][StartX] = 3;
			CurrentX = StartX;
			CurrentY = StartY;
			Map.map = m;
		}
	
	public void move() {
		if (CurrentDirection != null) {
			int[][] m = Map.getGrille();
			int NewX;
			int NewY;

			NewX = CurrentX;
			NewY = CurrentY;

			switch (CurrentDirection) {
			// On redéfinit la coordonnées correspondant au déplacement
			case "up":
				NewY = CurrentY - 1;
				break;
			case "down":
				NewY = CurrentY + 1;
				break;
			case "right":
				NewX = CurrentX + 1;
				break;
			case "left":
				NewX = CurrentX - 1;
				break;
			}

			if (m[NewY][NewX] != 1) {
				// Si la case où je me rends est une pièce, je gagne un point
				if (m[NewY][NewX] == 2) {
					Joueur.Score++;
				}

				m[CurrentY][CurrentX] = 0;
				m[NewY][NewX] = 3;
				
				CurrentX = NewX;
				CurrentY = NewY;
			}

			Map.map = m;
		}
	}

}
