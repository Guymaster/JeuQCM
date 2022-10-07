package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import modele.GameState;
import modele.Joueur;

public class PrenomJoueurController implements ActionListener{
	GameState gameModel;
	JTextField field;
	
	public PrenomJoueurController(GameState _gameModel, JTextField _field){
		gameModel = _gameModel;
		field = _field;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(field.getText().isEmpty()==false) gameModel.setPlayer(new Joueur(field.getText()));
	}
}
