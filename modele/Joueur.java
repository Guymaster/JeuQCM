package modele;

public class Joueur {
	public String nom;
	public int score = 0;
	void scorePlus(int nb){
		score = score + nb;
	}
	public Joueur(String _nom){
		nom = _nom;
	}
}
