package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Player extends GraphicalObject {

    private double speed;
    private int points;

    private ViewController viewController;

    /**
     * Konstruktor
     * @param x x-Koordinate des Mittelpunkts des Spielers
     * @param y y-Koordinate des Mittelpunkts des Spielers
     */
    public Player(double x, double y, ViewController viewController){
        this.viewController=viewController;
        this.x=x;
        this.y=y;
        this.width=60;
        this.height=30;
        this.speed=100;
    }

    /**
     * Methode wird automatisch aufgerufen.
     * Zeichnet den Spieler als Kreis und den Punktestand
     * @param drawTool Referenz auf das Zeichenwerkzeug
     */
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(150,150,0, 255);
        drawTool.drawFilledRectangle(x,y,width, height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(30,30,"Punkte: " + points);
    }

    /**
     * Methode wird automatisch aufgerufen.
     * Sorgt für die Bewegung des Spielers und dafür, dass der Spieler das Fenster nicht verlassen kann.
     * @param dt Gibt die vergangene Zeit in Sekunden seit dem letzten Aufruf an.
     */
    public void update(double dt){
        move(dt);
        checkBounds();
    }

    /**
     * Methode wird von update(double dt) aufgerufen
     * Wenn die passende Taste herunter gedrückt wird, bewegt sich der Spieler in die entsprechende Richtung.
     * @param dt Gibt die vergangene Zeit in Sekunden seit dem letzten Aufruf an.
     */
    public void move(double dt){
        if(viewController.isKeyDown(KeyEvent.VK_A)){
            x=x-speed*dt;
        }
        if(viewController.isKeyDown(KeyEvent.VK_D)){
            x=x+speed*dt;
        }
    }

    /**
     * Methode wird von update(double dt) aufgerufen
     * Stellt sicher, dass der Spieler das Fenster nicht verlassen kann.
     */
    public void checkBounds(){
        if(x<=0){
            x=0;
        }
        if(x>=600-width){
            x=600-width;
        }
    }
    public void speedBuff(){
        //speed = Math.random() * 149 + 110;
        if(speed < 100){
            speed = speed + 15;
        }
    }

    public void extremeSpeedBuff(){
            speed = 300;
    }

    public void speedSlowBuff(){
            speed = 15;
    }

    /**
     * Bei Aufruf Punkte des Spielers um einen bestimmten Wert verändert.
     * @param amount Menge an Punkten, die der Spieler gewinnt bzw. verliert, falls amount<0.
     */
    public void addPoints(int amount){
        points = points + amount;
    }
}
//