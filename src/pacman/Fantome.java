package pacman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fantome extends Personnage {
	public Fantome(int X, int Y) {
		super(X, Y);
		// TODO Auto-generated constructor stub
	}

	public static int AleatoireX(){
		int[] tableau = {-1,0,1} ;
		Random rand = new Random() ;
		int posAleatoireX = tableau[rand.nextInt(tableau.length)] ;
		
		return posAleatoireX;
	}
	
	public static int AleatoireY(){
		int[] tableau = {-1,0,1} ;
		Random rand = new Random() ;
		int posAleatoireY = tableau[rand.nextInt(tableau.length)] ;
		
		return posAleatoireY;
	}
	
	public static int[] DeplacementOK(int[] tab,int f){
		int[][] m = Map.getGrille();
		int x = tab[0];
		int y = tab[1];
		if(m[y][x]==1){
			tab = DeplacementOK(DeplacementFantome(m,f),f);
		}
		return tab;
	}
	public static int[] DeplacementFantome(int[][] m, int f){
		int PosX = Map.getPosX(f);
		int PosY = Map.getPosY(f);
		int dx = AleatoireX();
		int dy = AleatoireY();
		PosY=PosY+dy;
		PosX=PosX+dx;
		int[] tab = {PosX,PosY};
		return tab;
				
	}
	public boolean[] piece = {false,false,false,false};

	public boolean[] Piece(int f, int x, int y){
		int[][] m = Map.getGrille();
		
		if(m[y][x]==2){
			piece[f-4]=true;
		}
		else{
			piece[f-4]=false;
		}
		return piece;
	} 
	
	public boolean[] EtatPiece(){
		return piece;
	}
	
	public void Deplacement(){
		int[][] m = Map.getGrille();
		for(int f = 4;f<5;f++){ // A changer lors de l'ajout des 3 autres fantômes !!!!!!!! 
			int [] tab = DeplacementOK(DeplacementFantome(m,f),f);
			System.out.println(EtatPiece()[f-4]);
			if(EtatPiece()[f-4]==true){ //La case où est le fantôme était une pièce
				m[Map.getPosY(f)][Map.getPosX(f)]=2; 
			}
			else{
				m[Map.getPosY(f)][Map.getPosX(f)]=0; 
			}
			Piece(f,tab[0],tab[1]);
			m[tab[1]][tab[0]] = f;
			
		}
		Map.map = m;
	}
	
	}