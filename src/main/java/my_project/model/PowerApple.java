package my_project.model;

import KAGO_framework.view.DrawTool;

public class PowerApple extends Apple{
    /**
     * Konstruktor
     *
     * @param x x-Koordinate des Mittelpunkts des Apfels
     * @param y y-Koordinate des Mittelpunkts des Apfels
     */
    public PowerApple(double x, double y) {
        super(x, y);
        this.speed=270;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x, y, radius);
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawCircle(x, y, radius - 6);
    }
    /*public void speedBuff(){
        double random = Math.random() * 149 + 110;
    }*/
}
