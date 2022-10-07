package vue;

import java.awt.Color;
import java.util.Observable;

import controleur.ExitBtnController;
import controleur.RejouerBtnController;
import modele.ChangeType;
import modele.GameState;
import modele.Lettre;

public class ResultView extends View{
	/*
	 * ATTRIBUTS
	 */
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    GameState gameState;
    RejouerBtnController rejouerController;
    ExitBtnController exitController;
	
	
	/*
	 * CONSTRUCTEUR
	 */
    ResultView(GameState _gameState){
    	super();
    	gameState = _gameState;
    }
	
	/*
	 * METHODES
	 */
    void init(){
    	super.init();
    	jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rejouerController = new RejouerBtnController(gameState);
        exitController = new ExitBtnController(gameState);
        gameState.addObservateur(this);

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jButton1.setText("Valider");
        jButton1.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Résultats du QCM");
        setSize(500, 260);

    	this.setLocationRelativeTo(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground((gameState.player.score>=10)?new java.awt.Color(51, 153, 0):Color.RED);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(((gameState.player.score>=10)?"Félicitations ":"Tu peux faire Mieux ") + String.valueOf(gameState.player.nom));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 55)); // NOI18N
        jLabel2.setForeground((gameState.player.score>=10)?new java.awt.Color(51, 153, 0):Color.RED);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(String.valueOf(gameState.player.score)+"/20");

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jButton2.setText("Fermer");
        jButton2.setFocusable(false);
        jButton2.addActionListener(exitController);

        jButton3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jButton3.setText("Rejouer");
        jButton3.setFocusable(false);
        jButton3.addActionListener(rejouerController);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }
    @Override
    public void update(Observable arg0, Object change) {
		if(change == ChangeType.jeuReplay){
			this.setVisible(false);
			dispose();
		}
	}
}
