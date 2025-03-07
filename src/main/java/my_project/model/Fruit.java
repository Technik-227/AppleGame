package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

//TODO 04a: Setze die Klasse Fruit um.
public abstract class Fruit extends GraphicalObject{
    public double radius;
    public double speed;
    public int points;

    public Fruit(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    public abstract void draw(DrawTool drawTool);

    public void update(double dt){
        y=y+speed*dt;
        if(y> Config.WINDOW_HEIGHT){
            jumpBack();
        }
    }

    /**
     * Setzt den Apfel zurück an den oberen Fensterrand
     */
    public void jumpBack(){
        x=Math.random()*(Config.WINDOW_HEIGHT-40);
        y=-50;
    }

    public int getPoints(){
        return points;
    }
    public void setSpeed(double speed1){
        speed1 = speed;
    }
}
