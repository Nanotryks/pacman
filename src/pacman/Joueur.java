package pacman;

public class Joueur extends Personnage {
	private static int Score = 0;
	private String nom;
	public String CurrentDirection;
	public static String CurrentImage = "pacmanright.png";

	public Joueur(int X, int Y, int Score) {
		super(X, Y);

		// Détection de l'appui d'une touche pour adapter la direction
	}

	public static int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
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

	public void move() {
		if (CurrentDirection != null) {
			int[][] m = Map.getGrille();
			int CurrentX;
			int CurrentY;
			int NewX;
			int NewY;

			CurrentX = Map.getPosX(3);
			CurrentY = Map.getPosY(3);
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
			}

			Map.map = m;
		}
	}

}
