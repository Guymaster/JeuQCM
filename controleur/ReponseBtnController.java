package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.GameState;
import modele.Lettre;

public class ReponseBtnController implements ActionListener{
	/*
	 * ATTRIBUTS
	 */
	Lettre valeur;
	GameState gameModel;
	/*
	 * CONSTRUCTEUR
	 */
	public ReponseBtnController(GameState _gameModel, Lettre _lettre){
		gameModel = _gameModel;
		valeur = _lettre;
	}

	/*
	 * METHODES
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameModel.essayerReponse(valeur);
	}
	
}
