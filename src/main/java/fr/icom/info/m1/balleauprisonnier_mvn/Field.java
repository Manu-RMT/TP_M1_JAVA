package fr.icom.info.m1.balleauprisonnier_mvn;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * Classe gerant le terrain de jeu.
 * 
 */
public class Field extends Canvas {
	
	/** Joueurs */
	Human [] equipe1 = new Human[3];
	IA[] equipeRobot = new IA[3];
	/** Couleurs possibles */
	String[] colorMap = new String[] {"blue", "green", "orange", "purple", "yellow"};
	/** Tableau traçant les evenements */
    ArrayList<String> input = new ArrayList<String>();
	Projectile balle;

    final GraphicsContext gc;
    final int width;
    final int height;
    
    /**
     * Canvas dans lequel on va dessiner le jeu.
     * 
     * @param scene Scene principale du jeu a laquelle on va ajouter notre Canvas
     * @param w largeur du canvas
     * @param h hauteur du canvas
     */
	public Field(Scene scene, int w, int h) 
	{
		super(w, h); 
		width = w;
		height = h;

		/** permet de capturer le focus et donc les evenements clavier et souris */
		this.setFocusTraversable(true);
		
        gc = this.getGraphicsContext2D();
        
        /** On initialise le terrain de jeu */

        for(int i = 0 ; i < 3; i ++) {
			int pos = 3* width/4;
			if (i == 0) {
				pos = width / 2;
			} else if (i == 1) {
				pos = width /4 ;
			}
			equipe1[i] = new Human(gc, colorMap[0], pos, h-50, "bottom", "assets/PlayerBlue.png");
        	equipe1[i].display();
			equipeRobot[i] = new IA(gc, colorMap[1], pos, 2, "top", "assets/PlayerRed.png");
			equipeRobot[i].display();
        }

		balle = new Projectile(gc,0,width/2,height/2);

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est pressee on la rajoute a la liste d'input
	     *   
	     */
	    this.setOnKeyPressed(
	    		new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            // only add once... prevent duplicates
	    	            if ( !input.contains(code) )
	    	                input.add( code );
	    	        }
	    	    });

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est relachee on l'enleve de la liste d'input
	     *   
	     */
	    this.setOnKeyReleased(
	    	    new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            input.remove( code );
	    	        }
	    	    });
	    
	    /** 
	     * 
	     * Boucle principale du jeu
	     * 
	     * handle() est appelee a chaque rafraichissement de frame
	     * soit environ 60 fois par seconde.
	     * 
	     */
	    new AnimationTimer() 
	    {
	        public void handle(long currentNanoTime)
	        {	 
	            // On nettoie le canvas a chaque frame
	            gc.setFill( Color.LIGHTGRAY);
	            gc.fillRect(0, 0, width, height);
	        	
	            // Deplacement et affichage des equipe1
	        	for (int i = 0; i < equipe1.length; i++)
	    	    {
	        		if (i==0 && input.contains("LEFT"))
	        		{
	        			equipe1[i].moveLeft();
	        		}
	        		if (i==0 && input.contains("RIGHT"))
	        		{
	        			equipe1[i].moveRight();
	        		}
	        		if (i==0 && input.contains("UP"))
	        		{
	        			equipe1[i].turnLeft();
	        		}
	        		if (i==0 && input.contains("DOWN"))
	        		{
	        			equipe1[i].turnRight();
	        		}
	        		if (i==1 && input.contains("Q"))
	        		{
	        			equipe1[i].moveLeft();
	        		}
	        		if (i==1 && input.contains("D"))
	        		{
	        			equipe1[i].moveRight();
	        		}
	        		if (i==1 && input.contains("Z"))
	        		{
	        			equipe1[i].turnLeft();
	        		}
	        		if (i==1 && input.contains("S"))
	        		{
	        			equipe1[i].turnRight();
	        		}
	        		if (input.contains("SPACE")){
	        			equipe1[i].shoot();
					}

	        		if (input.contains("ENTER")){
	        			equipeRobot[i].shoot();
					}

	        		equipe1[i].display();
					equipeRobot[i].display();
					equipeRobot[i].MouvementRandom();
					equipeRobot[i].Turning_IA();

	    	    }

				balle.display();

	    	}
	     }.start(); // On lance la boucle de rafraichissement 
	     
	}

	public Human[] getEquipe1() {
		return equipe1;
	}
	public IA[] getequipeRobot() {
		return equipeRobot;
	}
	public Projectile getProjectile() {
		return balle;
	}
}
