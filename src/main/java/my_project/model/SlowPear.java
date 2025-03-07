package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class SlowPear extends Pear {
    /**
     * Konstruktor
     *
     * @param x x-Koordinate des Mittelpunkts der Birne
     * @param y y-Koordinate des Mittelpunkts der Birne
     */
    public SlowPear(double x, double y) {
        super(x, y);
        this.speed = 150;
        this.radiusX = 10;
        this.radiusY = 15;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(130, 200, 30, 255);
        drawTool.drawFilledEllipse(x, y, radiusX, radiusY);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawEllipse(x, y, radiusX, radiusY);
        drawTool.setCurrentColor(255, 200, 130, 255);
        drawTool.drawFilledEllipse(x, y, radiusX - 5, radiusY - 2);
    }
}
