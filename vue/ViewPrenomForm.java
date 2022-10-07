package vue;

import java.util.Observable;

import controleur.PrenomJoueurController;
import modele.ChangeType;
import modele.GameState;

public class ViewPrenomForm extends View{
	/*
	 * DECLARATION DES ATTRIBUTS
	 */
	private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    PrenomJoueurController controller;
    GameState gameState;
    /*
     * CONSTRUCTEUR
     */
    ViewPrenomForm(){
    	super();
    }
    /*
     * DECLARATION DES METHODES
     */
    public static void main(String args[]) {
    	new ViewPrenomForm().init();
    }
    GameState getGameState(){return gameState;}
    void init(){ //Initialiser la fenetre
    	super.init();
    	jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        gameState = new GameState();
        gameState.addObservateur(this);
        controller = new PrenomJoueurController(gameState, jTextField1);
        jButton1.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prénom du Joueur");

        jTextField1.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setToolTipText("Votre Prénom");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setText("Votre Prénom");

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jButton1.setText("Valider");
        jButton1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        this.setSize(367, 185);

    	this.setLocationRelativeTo(null);
    }
    @Override
	public void update(Observable arg0, Object change) {
		if(change == ChangeType.prenom){
			ViewQuestion viewQuestion = new ViewQuestion(gameState);
			viewQuestion.init();
			this.setVisible(false);
		}
		else if(change == ChangeType.jeuReplay){
			this.setVisible(true);
		}
	}
}
