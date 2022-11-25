package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
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
        ypos = yproj;

       // Deplacement(angle);
        sprite = new Sprite(projectile, 0,0, Duration.seconds(.2),"top");
        sprite.setX(xpos);
        sprite.setY(ypos);

    }
    
    void Deplacement(double direction){
    	xpos = xpos * Math.cos(direction);
    	ypos = ypos * Math.sin(direction);
    }

    void display()
    {
        graphicsContext.save(); // saves the current state on stack, including the current transform
        rotate(graphicsContext, direction, xpos + projectile.getWidth() / 2, ypos + projectile.getHeight() / 2);
        graphicsContext.drawImage(projectile, xpos, ypos);
        graphicsContext.restore(); // back to original state (before rotation)
    }
    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
}
