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
	static int NBRE_QUESTIONS = 20; //Le nombre de questions posées dans une partie
	public String enonce;
	public String[] reponses = new String[4];
	public String imagePath = "images/ship5.png";
	Lettre trueLetter; //Lettre de la réponse correcte
	static Question[] toutesLesQuestions = new Question[]{ //Enregistrement des questions
		new Question("En quelle année la Côte d'Ivoire a-t-elle eu son Indépendance?", new String[]{"1950", "1945", "1960", "1970"}, Lettre.C),
		new Question("Qui a été le premier homme dans l'espace?", new String[]{"Kegba Bodio", "Neil Amstrong", "Mathieu Codabee", "Youri Gargarine"}, Lettre.D),
		new Question("Que signifie MVC?", new String[]{"Modèle-Vie-Controlleur", "Modèle-Vue-Controlleur", "Mon Vieux Coeur", "Aucune de ces Réponses"}, Lettre.B),
		new Question("Que signifie PGCD?", new String[]{"Plus Grand Connu Diviseur", "Plus Gros Connu Diviseur", "Plus Petit Multiple", "Aucune de ces réponses"}, Lettre.D),
		new Question("Lequel de ces animaux n'est pas un insecte?", new String[]{"Le Cafard", "L'Araignée", "La Sauterelle", "Le Papillon"}, Lettre.B),
		new Question("Qu'est-ce qu'une souris en informatique?", new String[]{"Un rongeur", "Un écran", "Un périphérique de sortie", "Un périphérique d'entrée"}, Lettre.D),
		new Question("Lequel de ces métiers, Leonard de Vinci ne faisait pas?", new String[]{"Peintre", "Architecte", "Medecin", "Poète"}, Lettre.B),
		new Question("Que faut-il faire avant de traverser la route?", new String[]{"Regarder de l'autre côté", "Demander aux conducteurs de s'arreter", "Regarder à gauche et à droite", "Rien du tout"}, Lettre.C),
		new Question("Que faut-il faire lorsque l'on trouve un seringue au sol?", new String[]{"Partir", "La mettre dans une poubelle", "Jouer avec", "Aucune de ces Réponses"}, Lettre.A),
		new Question("Comment ouvrir une porte vérrouillée?", new String[]{"Tourner le poignet", "Pousser", "Frapper", "Aucune de ces Réponses"}, Lettre.D),
	};
	
	/*
	 * METHODES
	 */
	public Boolean verifierLettre(Lettre lettre){ //Vérifier si une lettre est la bonne réponse
		System.out.println("La vraie lettre: "+ trueLetter);
		System.out.println("La lettre Entrée: "+ lettre);
		System.out.println("vraie ou faux? : "+ (lettre==trueLetter));
		return (lettre==trueLetter)?true:false;
	}
}