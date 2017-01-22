package pacman;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {

	public static void main(String[] args) {
		int score = 0;
		int X, Y;
		Map M = new Map();
		Joueur J = new Joueur(M.getX(), M.getY(), score);
		Fantome F = new Fantome(M.getX(), M.getY()); // TODO : g�n�rer X
														// fantomes
		Jeu G = new Jeu();
		StdDraw.setCanvasSize(600, 725);
		StdDraw.setXscale(0, 40);
		StdDraw.setYscale(0, 50);
		StdDraw.enableDoubleBuffering();
		Map.AfficherLabyrinthe();

		while (true) {
			// D�tection des entr�es (clavier)
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

			// Mise � jour des positionnements des personnages
			J.move();

			// D�placement des fantomes
			F.Deplacement();

			// On regarde si le joueur s'est fait toucher par une fantome

			// On regarde si toutes les pi�ces ont �t� mang�es

			// Actualisation de l'affichage
			Map.AfficherLabyrinthe();
			Map.AfficherUI();
			StdDraw.show();


			// D�lai d'actualisation de l'affichage
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
