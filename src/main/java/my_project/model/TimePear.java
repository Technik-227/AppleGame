package my_project.model;

import KAGO_framework.view.DrawTool;

public class TimePear extends Pear{
    public TimePear(double x, double y){
        super(x,y);
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
