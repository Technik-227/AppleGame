package my_project.model;

import KAGO_framework.view.DrawTool;

//public int points;

public class CrazyApple extends Apple{
        public CrazyApple(double x, double y){
            super(x, y);
            this.speed=90;
        }

        public void draw(DrawTool drawTool) {
            drawTool.setCurrentColor(255,0,0,255);
            drawTool.drawFilledCircle(x, y, radius);
            drawTool.setCurrentColor(0,255,0,255);
            drawTool.drawFilledCircle(x, y, radius);
            drawTool.setCurrentColor(0,0,255,255);
            drawTool.drawFilledCircle(x, y, radius);
            drawTool.setCurrentColor(0,0,0,255);
            drawTool.drawCircle(x, y, radius);
            drawTool.setCurrentColor(0,255,255,255);
            drawTool.drawCircle(x, y, radius - 6);
            drawTool.drawCircle(x, y, radius - 2);
        }
    /*public int getPoints(){
        return points;
    }*/

}
