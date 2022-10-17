package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.image.Image;
import java.lang.Math;

public class Projectile {

	double vitesse;
    double direction;
    Image projectile;
    double xpos;
    double ypos;

    Projectile(double angle){
        projectile = new Image("assets/ball.png");
        direction = angle;
        vitesse = 8;
    }
    
    void Deplacement(double direction){
    	xpos = xpos * Math.cos(direction);
    	ypos = ypos * Math.sin(direction);
    }

}
