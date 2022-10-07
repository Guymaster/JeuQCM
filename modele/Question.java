package modele;

public class Question {
	/*
	 * CONSTRUCTEUR
	 */
	Question(String _enonce, String[] _reponses, Lettre _trueLetter){
		enonce = _enonce;
		reponses = _reponses;
		trueLetter = _trueLetter;
	}
	Question(String _enonce, String[] _reponses, Lettre _trueLetter, String _imagePath){
		enonce = _enonce;
		reponses = _reponses;
		trueLetter = _trueLetter;
		imagePath = _imagePath;
	}
	/*
	 * ATTRIBUTS
	 */
	static int NBRE_QUESTIONS = 20; //Le nombre de questions pos�es dans une partie
	public String enonce;
	public String[] reponses = new String[4];
	public String imagePath = "images/ship5.png";
	Lettre trueLetter; //Lettre de la r�ponse correcte
	static Question[] toutesLesQuestions = new Question[]{ //Enregistrement des questions
		new Question("En quelle ann�e la C�te d'Ivoire a-t-elle eu son Ind�pendance?", new String[]{"1950", "1945", "1960", "1970"}, Lettre.C),
		new Question("Qui a �t� le premier homme dans l'espace?", new String[]{"Kegba Bodio", "Neil Amstrong", "Mathieu Codabee", "Youri Gargarine"}, Lettre.D),
		new Question("Que signifie MVC?", new String[]{"Mod�le-Vie-Controlleur", "Mod�le-Vue-Controlleur", "Mon Vieux Coeur", "Aucune de ces R�ponses"}, Lettre.B),
		new Question("Que signifie PGCD?", new String[]{"Plus Grand Connu Diviseur", "Plus Gros Connu Diviseur", "Plus Petit Multiple", "Aucune de ces r�ponses"}, Lettre.D),
		new Question("Lequel de ces animaux n'est pas un insecte?", new String[]{"Le Cafard", "L'Araign�e", "La Sauterelle", "Le Papillon"}, Lettre.B),
		new Question("Qu'est-ce qu'une souris en informatique?", new String[]{"Un rongeur", "Un �cran", "Un p�riph�rique de sortie", "Un p�riph�rique d'entr�e"}, Lettre.D),
		new Question("Lequel de ces m�tiers, Leonard de Vinci ne faisait pas?", new String[]{"Peintre", "Architecte", "Medecin", "Po�te"}, Lettre.B),
		new Question("Que faut-il faire avant de traverser la route?", new String[]{"Regarder de l'autre c�t�", "Demander aux conducteurs de s'arreter", "Regarder � gauche et � droite", "Rien du tout"}, Lettre.C),
		new Question("Que faut-il faire lorsque l'on trouve un seringue au sol?", new String[]{"Partir", "La mettre dans une poubelle", "Jouer avec", "Aucune de ces R�ponses"}, Lettre.A),
		new Question("Comment ouvrir une porte v�rrouill�e?", new String[]{"Tourner le poignet", "Pousser", "Frapper", "Aucune de ces R�ponses"}, Lettre.D),
	};
	
	/*
	 * METHODES
	 */
	public Boolean verifierLettre(Lettre lettre){ //V�rifier si une lettre est la bonne r�ponse
		System.out.println("La vraie lettre: "+ trueLetter);
		System.out.println("La lettre Entr�e: "+ lettre);
		System.out.println("vraie ou faux? : "+ (lettre==trueLetter));
		return (lettre==trueLetter)?true:false;
	}
}