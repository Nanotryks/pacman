package pacman;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {

	public static void main(String[] args) {
		int score = 0;
		int X, Y;
		Map M = new Map();
		Joueur J = new Joueur(M.getX(), M.getY(), score);
		Fantome F = new Fantome(M.getX(), M.getY()); // TODO : générer X
														// fantomes
		Jeu G = new Jeu();
		StdDraw.setCanvasSize(600, 725);
		StdDraw.setXscale(0, 40);
		StdDraw.setYscale(0, 50);
		StdDraw.enableDoubleBuffering();
		Map.AfficherLabyrinthe();

		while (true) {
			// Détection des entrées (clavier)
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();

				switch (key) {
				case 'z': // up
					J.setDirection("up");
					break;
				case 's': // down
					J.setDirection("down");
					break;
				case 'q': // left
					J.setDirection("left");
					break;
				case 'd': // right
					J.setDirection("right");
					break;

				}
			}

			// Mise à jour des positionnements des personnages
			J.move();

			// Déplacement des fantomes
			F.Deplacement();

			// On regarde si le joueur s'est fait toucher par une fantome

			// On regarde si toutes les pièces ont été mangées

			// Actualisation de l'affichage
			Map.AfficherLabyrinthe();
			Map.AfficherUI();
			StdDraw.show();


			// Délai d'actualisation de l'affichage
			try {
				Thread.sleep(60);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}

	}

	/*
	 * public static void restart() { while (PennDraw.hasNextKeyTyped() == true)
	 * { Map.AfficherLabyrinthe(); }
	 */
}
