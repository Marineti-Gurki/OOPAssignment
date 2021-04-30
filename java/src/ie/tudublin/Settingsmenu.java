package ie.tudublin;

import processing.core.PVector;

public class Settingsmenu extends Pongrave
{

    Pongrave Pongrave;
    PVector tickbox;
    PVector buttonsize;
    PVector buttonloc;
    String settingname;
    int gap;


    public Settingsmenu(Pongrave pongrave, int gap, String settingname) {
        Pongrave = pongrave;
        tickbox = new PVector(25, 25);
        buttonsize = new PVector(Pongrave.width/4 - 50, Pongrave.height/10);
        buttonloc = new PVector(Pongrave.width/2, gap);
        this.settingname = settingname;
        this.gap = gap;

    }

    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.rectMode(CENTER);
        Pongrave.colorMode(RGB);
        Pongrave.fill(0);
        Pongrave.stroke(255);
        Pongrave.strokeWeight(5);
        Pongrave.rect(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f, Pongrave.height/2 - gap, tickbox.x, tickbox.y);
        Pongrave.popMatrix();

        Pongrave.pushMatrix();
        Pongrave.textAlign(CENTER);
        Pongrave.fill(0);
        Pongrave.text(settingname, Pongrave.width/2, Pongrave.height/2 - gap);
        Pongrave.popMatrix();
    }
}

