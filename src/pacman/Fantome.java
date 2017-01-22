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
				// Il peut aller à gauche
				AvailableDirections.add("left");
			}
			if (m[CurrentY][CurrentX + 1] == 0 || m[CurrentY][CurrentX + 1] == 2 || m[CurrentY][CurrentX + 1] == 3) {
				// Il peut aller à droite
				AvailableDirections.add("right");
			}
		// Identification des directions possibles
		

		// On regarde si le fantome peut faire un pas de plus dans sa direction
		// actuelle, si non : on détermine une nouvelle direction parmi les
		// possibles
		if (!AvailableDirections.contains(CurrentDirection)) {
			// On choisit une direction au hasard parmi celles disponibles
			int rand = (int) Math.round(Math.random() * (AvailableDirections.size() - 1)); // On
																							// tire
																							// un
																							// nombre
																							// aléatoire
																							// entre
																							// 0
																							// et
																							// le
																							// nombre
																							// d'entrées
																							// dans
																							// le
																							// tableau,
																							// et
																							// on
																							// le
																							// récupère
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

		// On identifie une éventuelle collision avec le joueur
		boolean Collision = false;
		if (m[NewY][NewX] == 3) {
			Collision = true;
		}

		m[CurrentY][CurrentX] = CasePreviousState;

		// On sauvegarde l'état de la case où on va aller pour pouvoir le
		// réinitialiser après que le fantome l'aie quittée
		CasePreviousState = (m[NewY][NewX] == 0 || m[NewY][NewX] == 3 ? 0 : 2); // opérateur
																				// ternaire
																				// powaa

		m[NewY][NewX] = FantomeId;
		CurrentX = NewX;
		CurrentY = NewY;

		Map.map = m;

		return Collision;
	}
}