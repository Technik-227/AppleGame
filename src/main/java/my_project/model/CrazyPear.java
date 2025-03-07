package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class CrazyPear extends Pear{


    public CrazyPear(double x, double y){
        super(x,y);
        this.speed = 250;
        this.radiusX = 10;
        this.radiusY = 15;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(180,200,230,255);
        drawTool.drawFilledEllipse(x, y, radiusX, radiusY);
        drawTool.setCurrentColor(67,150,25,255);
        drawTool.drawEllipse(x, y, radiusX, radiusY);
    }
}
