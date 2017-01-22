package pacman;

import java.util.ArrayList;
import java.util.List;

public class Fantome extends Personnage {
	public String CurrentDirection = "up";
	private int CasePreviousState;

	private int CurrentX;
	private int CurrentY;
	
	private int FantomeId;

	public Fantome(int X, int Y,int Type) {
		super(X, Y);
		CurrentX = Map.getPosX(Type);
		CurrentY = Map.getPosY(Type);
		FantomeId = Type;
		}


	private void setCurrentDirection() {
		int[][] m = Map.getGrille();
		int NewX;
		int NewY;
		ArrayList AvailableDirections = new ArrayList();

			if (m[CurrentY - 1][CurrentX] == 0 || m[CurrentY - 1][CurrentX] == 2 || m[CurrentY - 1][CurrentX] == 3) {
				// Il peut aller en haut
				AvailableDirections.add("up");
			}
			if (m[CurrentY + 1][CurrentX] == 0 || m[CurrentY + 1][CurrentX] == 2 || m[CurrentY + 1][CurrentX] == 3) {
				// Il peut aller en bas
				AvailableDirections.add("down");
			}
			if (m[CurrentY][CurrentX - 1] == 0 || m[CurrentY][CurrentX - 1] == 2 || m[CurrentY][CurrentX - 1] == 3) {
				// Il peut aller � gauche
				AvailableDirections.add("left");
			}
			if (m[CurrentY][CurrentX + 1] == 0 || m[CurrentY][CurrentX + 1] == 2 || m[CurrentY][CurrentX + 1] == 3) {
				// Il peut aller � droite
				AvailableDirections.add("right");
			}
		// Identification des directions possibles
		

		// On regarde si le fantome peut faire un pas de plus dans sa direction
		// actuelle, si non : on d�termine une nouvelle direction parmi les
		// possibles
		if (!AvailableDirections.contains(CurrentDirection)) {
			// On choisit une direction au hasard parmi celles disponibles
			int rand = (int) Math.round(Math.random() * (AvailableDirections.size() - 1)); // On
																							// tire
																							// un
																							// nombre
																							// al�atoire
																							// entre
																							// 0
																							// et
																							// le
																							// nombre
																							// d'entr�es
																							// dans
																							// le
																							// tableau,
																							// et
																							// on
																							// le
																							// r�cup�re
																							// en
																							// int
			CurrentDirection = AvailableDirections.get(rand).toString();
		}
	}

	public boolean move() {
		setCurrentDirection();

		int[][] m = Map.getGrille();

		int NewX;
		int NewY;

		NewX = CurrentX;
		NewY = CurrentY;

		switch (CurrentDirection) {
		// On red�finit la coordonn�es correspondant au d�placement
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

		// On identifie une �ventuelle collision avec le joueur
		boolean Collision = false;
		if (m[NewY][NewX] == 3) {
			Collision = true;
		}

		m[CurrentY][CurrentX] = CasePreviousState;

		// On sauvegarde l'�tat de la case o� on va aller pour pouvoir le
		// r�initialiser apr�s que le fantome l'aie quitt�e
		CasePreviousState = (m[NewY][NewX] == 0 || m[NewY][NewX] == 3 ? 0 : 2); // op�rateur
																				// ternaire
																				// powaa

		m[NewY][NewX] = FantomeId;
		CurrentX = NewX;
		CurrentY = NewY;

		Map.map = m;

		return Collision;
	}
}