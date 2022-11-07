package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.lang.Math;


public class Projectile {

	double vitesse;
    double direction;
    Image projectile;
    double xpos;
    double ypos;
    Sprite sprite;
    GraphicsContext graphicsContext;

    Projectile(GraphicsContext gc,double angle, double xproj, double yproj){
        graphicsContext = gc;
        projectile = new Image("assets/ball.png");
        direction = angle;
        vitesse = 8;
        xpos = xproj;
        ypos = xproj;


        sprite = new Sprite(projectile, 0,0, Duration.seconds(.2),"top");
        sprite.setX(xpos);
        sprite.setY(ypos);

        Deplacement(angle);
    }
    
    void Deplacement(double direction){
    	xpos = xpos * Math.cos(direction);
    	ypos = ypos * Math.sin(direction);
    }

    void display()
    {
//        graphicsContext.save(); // saves the current state on stack, including the current transform
//        rotate(graphicsContext, angle, x + directionArrow.getWidth() / 2, y + directionArrow.getHeight() / 2);
//        graphicsContext.drawImage(directionArrow, x, y);
//        graphicsContext.restore(); // back to original state (before rotation)
    }

}
