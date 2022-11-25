package fr.icom.info.m1.balleauprisonnier_mvn;
import javafx.scene.canvas.GraphicsContext;

public class Human extends Player {
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
    Human(GraphicsContext gc, String color, int xInit, int yInit, String side, String equipe) {
        super(gc, color, xInit, yInit, side, equipe);
    }

    /**
     *  Deplacement du joueur vers la gauche, on cantonne le joueur sur le plateau de jeu
     */

    void moveLeft()
    {
        if (x > 10 && x < 520)
        {
            spriteAnimate();
            x -= step;
        }
    }

    /**
     *  Deplacement du joueur vers la droite
     */
    void moveRight()
    {
        if (x > 10 && x < 520)
        {
            spriteAnimate();
            x += step;
        }
    }

    /**
     *  Rotation du joueur vers la gauche
     */
    void turnLeft()
    {
        if (angle > 0 && angle < 180)
        {
            angle += 1;
        }
        else {
            angle += 1;
        }

    }

    /**
     *  Rotation du joueur vers la droite
     */
    void turnRight()
    {
        if (angle > 0 && angle < 180)
        {
            angle -=1;
        }
        else {
            angle -= 1;
        }
    }
}
