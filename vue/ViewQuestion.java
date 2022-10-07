package vue;
import java.awt.Color;
import java.util.Observable;

import javax.swing.GroupLayout;

import modele.ChangeType;
import modele.GameState;
import modele.Lettre;
import controleur.ReponseBtnController;

public class ViewQuestion extends View{
	/*
	 * ATTRIBUTS
	 */
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton btnSuivant;
    
    
    GameState gameState;
    ReponseBtnController reponseControllerA;
    ReponseBtnController reponseControllerB;
    ReponseBtnController reponseControllerC;
    ReponseBtnController reponseControllerD;
    /*
     * CONSTRUCTEUR
     */
    ViewQuestion(GameState _gameState){
    	super();
    	gameState = _gameState;
    }
    /*
     * METHODES
     */
    void setTempsRestant(int temps){jLabel1.setText(Integer.toString(temps));}
    void init(){
    	super.init();
    	jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSuivant = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reponseControllerA = new ReponseBtnController(gameState, Lettre.A);
        reponseControllerB = new ReponseBtnController(gameState, Lettre.B);
        reponseControllerC = new ReponseBtnController(gameState, Lettre.C);
        reponseControllerD = new ReponseBtnController(gameState, Lettre.D);
        gameState.addObservateur(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jeu QCM");
        this.setSize(1000, 600);

    	this.setLocationRelativeTo(null);

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton1.setText("A: " + gameState.questionEnCours.reponses[0]);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setName("btnA"); // NOI18N
        jButton1.addActionListener(reponseControllerA);

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton2.setText("B: " + gameState.questionEnCours.reponses[1]);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("btnD"); // NOI18N
        jButton2.addActionListener(reponseControllerB);

        jButton3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton3.setText("C: " + gameState.questionEnCours.reponses[2]);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setName("btnB"); // NOI18N
        jButton3.addActionListener(reponseControllerC);

        jButton4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton4.setText("D: " + gameState.questionEnCours.reponses[3]);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setName("btnD"); // NOI18N
        jButton4.addActionListener(reponseControllerD);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(String.valueOf(gameState.numQuestion));
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setInheritsPopupMenu(false);

        btnSuivant.setText("Suivant");
        btnSuivant.setEnabled(false);
        btnSuivant.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(gameState.questionEnCours.enonce);
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setInheritsPopupMenu(false);


        javax.swing.GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        
        btnSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuestion();
            }
        });

        jButton1.getAccessibleContext().setAccessibleName("btnA");
        jButton2.getAccessibleContext().setAccessibleName("btnB");
    }
    @Override
    public void update(Observable arg0, Object change) {
		if(change == ChangeType.tempsChange){
			System.out.println(gameState.tempsRestant);
			setTempsRestant(gameState.tempsRestant);
		}
		else if(change == ChangeType.questionTrouve || change == ChangeType.questionNonTrouve){
			if((gameState.lastCorrect == Lettre.A)){
				System.out.println("ici");
				jButton1.setBackground(Color.GREEN);
			}
			else{
				System.out.println("là");
				jButton1.setBackground(Color.RED);
			}
			jButton2.setBackground((gameState.lastCorrect == Lettre.B)?Color.GREEN:Color.RED);
			jButton3.setBackground((gameState.lastCorrect == Lettre.C)?Color.GREEN:Color.RED);
			jButton4.setBackground((gameState.lastCorrect == Lettre.D)?Color.GREEN:Color.RED);
			jButton1.setEnabled(false);
			jButton2.setEnabled(false);
			jButton3.setEnabled(false);
			jButton4.setEnabled(false);
			btnSuivant.setEnabled(true);
		}
		else if(change == ChangeType.jeuTermine){
			System.out.println("JEU TERMINE");
			ResultView viewResult = new ResultView(gameState);
			viewResult.init();
			this.setVisible(false);
		}
		else if(change == ChangeType.jeuReplay){
			this.setVisible(false);
			dispose();
		}
	}
    public void updateQuestion(){
    	jButton1.setEnabled(true);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		jButton4.setEnabled(true);
    	btnSuivant.setEnabled(false);
    	jButton1.setBackground(null);
		jButton2.setBackground(null);
		jButton3.setBackground(null);
		jButton4.setBackground(null);
		jLabel2.setText(gameState.questionEnCours.enonce);
        jLabel1.setText(String.valueOf(gameState.numQuestion));
    	jButton1.setText("A: " + gameState.questionEnCours.reponses[0]);
		jButton2.setText("B: " + gameState.questionEnCours.reponses[1]);
		jButton3.setText("C: " + gameState.questionEnCours.reponses[2]);
		jButton4.setText("D: " + gameState.questionEnCours.reponses[3]);
    }
}
