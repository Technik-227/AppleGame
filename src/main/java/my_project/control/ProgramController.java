package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player player;
    private Apple[] apples = new Apple[8];
    private Apple[] crazyapples = new Apple[500];
    private Pear[] crazypears = new Pear[50];
    private Pear pear;
    private PowerApple pa1;
    private SlowPear sp1;
    private SuperPowerApple spa1;
    private PointsApple poa1;
    private CrazyApple ca1;
    private CrazyPear cp1;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        //Erzeugen eines Player-Objektes
        player= new Player(50, Config.WINDOW_HEIGHT-100, viewController);
        //Player-Objekt wird gezeichnet
        viewController.draw(player);

        //Erzeugen eines Apple-Objektes
        for (int i = 0; i < 8; i++) {
            apples[i] = new Apple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
            //Apple-Objekt wird gezeichnet
            viewController.draw(apples[i]);
        }

        for (int i = 0; i < 500; i++) {
            crazyapples[i] = new Apple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
            //Apple-Objekt wird gezeichnet
        }

        for (int i = 0; i < 50; i++) {
            crazypears[i] = new Pear(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
            //Apple-Objekt wird gezeichnet
        }

        pear = new Pear(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        //Apple-Objekt wird gezeichnet
        viewController.draw(pear);
        pa1 = new PowerApple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        viewController.draw(pa1);
        sp1 = new SlowPear(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        //Apple-Objekt wird gezeichnet
        viewController.draw(sp1);
        spa1 = new SuperPowerApple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        viewController.draw(spa1);

        poa1 = new PointsApple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        viewController.draw(poa1);

        ca1 = new CrazyApple(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        viewController.draw(ca1);

        cp1 = new CrazyPear(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        viewController.draw(cp1);
        /*
        //Erzeugen eines Apple-Objektes
        apple1 = new Apple1(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        //Apple-Objekt wird gezeichnet
        viewController.draw(apple1);

        //Erzeugen eines Apple-Objektes
        apple2 = new Apple1(Math.random()*(Config.WINDOW_HEIGHT-40)+40, Math.random()*100-20);
        //Apple-Objekt wird gezeichnet
        viewController.draw(apple2);*/
    }

    /**
     * Sorgt dafür, dass zunächst gewartet wird, damit der SoundController die
     * Initialisierung abschließen kann. Die Wartezeit ist fest und damit nicht ganz sauber
     * implementiert, aber dafür funktioniert das Programm auch bei falscher Java-Version
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        //Kollision von Spieler und Apple wird geprüft. Bei einer Kollision werden dem Player-Objekt die Punkte gutgeschrieben.
        for (int i = 0; i < 8; i++) {
            if(player.collidesWith(apples[i])){
                player.addPoints(apples[i].getPoints());
                apples[i].jumpBack();
            }
        }

        for (int i = 0; i < 500; i++) {
            if(player.collidesWith(crazyapples[i])){
                player.addPoints(crazyapples[i].getPoints());
                crazyapples[i].jumpBack();
            }
        }

        for (int i = 0; i < 50; i++) {
            if(player.collidesWith(crazypears[i])){
                player.addPoints(crazypears[i].getPoints());
                crazypears[i].jumpBack();
            }
        }

        if(player.collidesWith(pear)){
            player.addPoints(pear.getPoints());
            pear.jumpBack();
        }
        if(player.collidesWith(pa1)){
            pa1.jumpBack();
            player.speedBuff();
        }
        if(player.collidesWith(sp1)){
            sp1.jumpBack();
            player.speedSlowBuff();
        }
        if(player.collidesWith(spa1)){
            spa1.jumpBack();
            player.extremeSpeedBuff();
        }
        if(player.collidesWith(poa1)){
            player.addPoints(poa1.getPoints());
            poa1.jumpBack();
        }
        if(player.collidesWith(ca1)){
            ca1.jumpBack();
            for (int i = 0; i < 500; i++) {
                viewController.draw(crazyapples[i]);
            }
            if(ca1.getPoints() == 100){
                for (int i = 0; i < 500; i++) {
                    crazyapples[i] = null;
                    viewController.removeDrawable(crazyapples[i]);
                   //viewController.reset();
                }
            }
        }

        if(player.collidesWith(cp1)){
            cp1.jumpBack();
            for (int i = 0; i < 50; i++) {
                //viewController.draw(crazypears[i]);
            }
        }


    }

    /**
     * Verarbeitet einen Mausklick.
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){

    }
}
