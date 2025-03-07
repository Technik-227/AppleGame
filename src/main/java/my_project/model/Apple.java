package my_project.model;

import KAGO_framework.view.DrawTool;


//TODO 04b: Passe die Klasse Apple entsprechend der Vererbung an.
public class Apple extends Fruit {

    //Attribute

    //Referenzen

    /**
     * Konstruktor
     * @param x x-Koordinate des Mittelpunkts des Apfels
     * @param y y-Koordinate des Mittelpunkts des Apfels
     */
    public Apple(double x, double y){
        super(x, y);
        this.speed=100 + (int)(Math.random()*200+1);
        this.radius = 15;
        this.points = 1;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x, y, radius);
    }

    /**
     * Methode wird automatisch aufgerufen.
     * Zeichnet den Apfel als Kreis
     * @param drawTool Referenz auf das Zeichenwerkzeug
     */

    /**
     * Methode wird automatisch aufgerufen.
     * Sorgt für die Bewegung des Apfels. Falls der Apfel den unteren Fensterrand erreicht, wird er zurückgesetzt.
     * @param dt Gibt die vergangene Zeit in Sekunden seit dem letzten Aufruf an.
     */
}