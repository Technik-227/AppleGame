package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;


//TODO 04c: Passe die Klasse Pear entsprechend der Vererbung an.
public class Pear extends Fruit {

    //Attribute
    public double radiusX;
    public double radiusY;
    public double speed1;
    protected boolean richtung;


    //Referenzen

    /**
     * Konstruktor
     * @param x x-Koordinate des Mittelpunkts der Birne
     * @param y y-Koordinate des Mittelpunkts der Birne
     */
    public Pear(double x, double y){
        super(x,y);
        this.speed=50*((int)(Math.random()*10 + 1));
        this.radiusX = 10;
        this.radiusY = 15;
        points=-1;
    }

    /**
     * Methode wird automatisch aufgerufen.
     * Zeichnet die Birne als Ellipse
     * @param drawTool Referenz auf das Zeichenwerkzeug
     */
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(130,200,30,255);
        drawTool.drawFilledEllipse(x, y, radiusX, radiusY);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawEllipse(x, y, radiusX, radiusY);
    }

    /**
     * Methode wird automatisch aufgerufen.
     * Sorgt für die Bewegung der Birne. Falls die Birne den unteren Fensterrand erreicht, wird er zurückgesetzt.
     * @param(dt)Gibt die vergangene Zeit in Sekunden seit dem letzten Aufruf an.
     */
    private void setRichtung() {
        if (x > Config.WINDOW_WIDTH) {
            richtung = false;
        }
        if (x < 0) {
            richtung = true;
        }
    }

    public void update(double dt){
        //TODO 05a: Ergänze die Pear-Objekte um das Verhalten, dass sich Pear-Objekte parallel zur Bewegung nach unten auch nach links bewegen.
        //TODO 05b: Die Pear-Objekte sollen das Fenster nicht (vollständig) verlassen. Wenn eines der Fensterränder erreicht wird, so soll die seitliche Bewegung umgekehrt werden.
        super.update(dt);
        setRichtung();
        if (!richtung){
            x = x - speed * dt;//when false




        }else if (richtung){

            x = x + speed * dt;//when true


        }

    }
}