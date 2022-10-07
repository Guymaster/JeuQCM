package vue;

import java.util.Observable;
import java.util.Observer;

public class View extends javax.swing.JFrame implements Observer {
	/*
	 * CONSTRUCTEUR
	 */
	View(){
		super();
	}
	/*
	 * METHODE
	 */
	void init(){
        this.setResizable(false);
    	this.setVisible(true);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("VUE UPDATED");
		
	}
}