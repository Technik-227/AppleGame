package my_project.model;

import KAGO_framework.view.DrawTool;

public class PointsApple extends Apple{
    public PointsApple(double x, double y){
        super(x, y);
        this.speed=100;
        this.points = 100;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,255,0,255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x, y, radius);
        drawTool.setCurrentColor(255,255,0,255);
        drawTool.drawCircle(x, y, radius - 6);
    }
}
