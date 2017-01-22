package pacman;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {

	public static void main(String[] args) {
		int score = 0;
		int X, Y;
		Map M = new Map();
		Joueur J = new Joueur(M.getX(), M.getY(), score);
		Fantome F1 = new Fantome(M.getX(), M.getY(),4);
		Fantome F2 = new Fantome(M.getX(),M.getY(),5);
		Fantome F3 = new Fantome(M.getX(),M.getY(),6);
		Fantome F4 = new Fantome(M.getX(),M.getY(),7);
		StdDraw.setCanvasSize(600, 725);
		StdDraw.setXscale(0, 40);
		StdDraw.setYscale(0, 50);
		StdDraw.enableDoubleBuffering();

		while (true) {
			if(J.getLifeCount() < 1){
				//GameOver : on détecte la barre d'espace pour relancer le jeu
				if (StdDraw.hasNextKeyTyped()) {
					char key = StdDraw.nextKeyTyped();
				}
			}
			else{
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
	
				// Déplacement des fantomes avec détection d'une collision avec le joueur
				

				boolean Collision1 = F1.move();
				boolean Collision2 = F2.move();
				boolean Collision3 = F3.move();
				boolean Collision4 = F4.move();
				boolean Collision = (Collision1 || Collision2 || Collision3 || Collision4);
		
				if(Collision){
					J.collisionFantome();
				}

				// On regarde si le joueur s'est fait toucher par une fantome
	
				// On regarde si toutes les pièces ont été mangées
	
				// Actualisation de l'affichage
				Map.AfficherLabyrinthe();
				Map.AfficherUI();
				StdDraw.show();
	
	
				// Délai d'actualisation de l'affichage
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

		}

	}
}

