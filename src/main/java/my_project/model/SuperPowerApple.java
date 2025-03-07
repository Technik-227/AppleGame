package my_project.model;

import KAGO_framework.view.DrawTool;

public class SuperPowerApple extends Apple{
    public SuperPowerApple(double x, double y){
        super(x, y);
        this.speed=170;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x, y, radius);
        drawTool.setCurrentColor(0,255,255,255);
        drawTool.drawCircle(x, y, radius - 6);
        drawTool.drawCircle(x, y, radius - 2);
    }
}
