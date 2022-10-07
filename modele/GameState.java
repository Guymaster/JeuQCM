package modele;

import java.util.ArrayList;
import java.util.Observable;

import vue.Audio;
import vue.View;

public class GameState extends Observable{
	/*
	 * ATTRIBUTS
	 */
	public Joueur player = null;
	public int numQuestion = 1; //Le numero de la question en cours
	ArrayList<Question> questionsPossibles = new ArrayList<Question>();
	public int tempsRestant = 15; //Nombre de secondes laissées à l'utilisateur pour répondre
	ArrayList<View> observateurs = new ArrayList();
	public Question questionEnCours;
	public Lettre lastCorrect = null;
	/*
	 * CONSTRUCTEUR
	 */
	public GameState(){
		for(Question question: Question.toutesLesQuestions){
			questionsPossibles.add(question);
		}
		questionEnCours = getRandomQuestion();
	}
	/*
	 * METHODES
	 */
	int getTempsRestant(){
    	return tempsRestant;
    }
    public void setTempsRestant(int temps){
    	tempsRestant = temps;
    	notifyObservers(ChangeType.tempsChange);
    }
	public void setPlayer(Joueur _player){
		player = _player;
		notifyObservers(ChangeType.prenom);
	}
	public void addObservateur(View _vue){
		observateurs.add(_vue);
	}
	
	public void notifyObservers(ChangeType _change){
		for(View _vue: observateurs){
			_vue.update(this, _change);
		}
		System.out.println("ON A NOTIFIE");
	}
	void addPointToPlayer(int points){
		player.scorePlus(points);
		notifyObservers(ChangeType.score);
	}
	Question getRandomQuestion(){
		int index = (int)(Math.random()*questionsPossibles.size()); //Index au hasard
		return questionsPossibles.get(index);
	}
	Question getNextQuestion(){
		return questionsPossibles.get(numQuestion-1);
	}
	void removeQuestion(Question _question){ //Enlever une question des questions possibles
		int i = 0;
		for(Question q: questionsPossibles){
			if(q.enonce.equals(_question.enonce)) questionsPossibles.remove(i);
			i++;
		}
	}
	public void essayerReponse(Lettre _lettre){
		System.out.println(_lettre);
		lastCorrect = questionEnCours.trueLetter;
		questionSuivante(questionEnCours.verifierLettre(_lettre));
	}
	public Boolean essayerReponseQuestionPassee(Lettre _lettre){
		System.out.println("On colorie " + _lettre + " en " + (questionsPossibles.get(numQuestion-2).verifierLettre(_lettre)));
		return questionsPossibles.get(numQuestion-2).verifierLettre(_lettre);
	}
	void questionSuivante(Boolean trouve){
		if(numQuestion == Question.NBRE_QUESTIONS-1){
			if(trouve){
				player.scorePlus(2);
				//new Audio("sons/applaudissement.wav").play();
			}
			else{
				new Audio("/sons/Huer.wav").play();
			}
			System.out.println(trouve);
			notifyObservers(ChangeType.jeuTermine);
		}
		else{
			if(trouve){
				player.scorePlus(2);
				new Audio("/sons/applaudissement.wav").play();
			}
			else{
				new Audio("/sons/Huer.wav").play();
			}
			//removeQuestion(questionEnCours);
			questionEnCours = getNextQuestion();
			numQuestion++;
			notifyObservers(trouve? ChangeType.questionTrouve:ChangeType.questionNonTrouve);}
	}
	public void rejouer(){
		numQuestion = 1;
		player = null;
		questionEnCours = null;
		lastCorrect = null;
		notifyObservers(ChangeType.jeuReplay);
	}
	public void terminer(){
		player = null;
		questionEnCours = null;
		lastCorrect = null;
		notifyObservers(ChangeType.jeuTermine);
	}
}
