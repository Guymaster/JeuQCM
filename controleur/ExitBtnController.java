package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import modele.GameState;

public class ExitBtnController implements ActionListener{
GameState gameModel;
	
	public ExitBtnController(GameState _gameModel){
		gameModel = _gameModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
