package fr.icom.info.m1.balleauprisonnier_mvn;
import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

public class IA extends Player {
    /**
     * Constructeur du Joueur
     *
     * @param gc     ContextGraphic dans lequel on va afficher le joueur
     * @param color  couleur du joueur
     * @param xInit
     * @param yInit  position verticale
     * @param side
     * @param equipe
     */
    String directionIA = "droite";

    IA(GraphicsContext gc, String color, int xInit, int yInit, String side, String equipe) {
        super(gc, color, xInit, yInit, side, equipe);
    }


    /**
     * Deplacement aleatoire de l'IA
     */
    void MouvementRandom(){

            if (this.x > 520)
            {
                directionIA = "gauche";
            }
            if (this.x < 10)
            {
                directionIA = "droite";
                System.out.print(directionIA);
            }

            if(Objects.equals(directionIA, "droite")){
                spriteAnimate();
                x+=this.step/3;
            }else{
                spriteAnimate();
                x-=this.step/3;
            }
    }
}
