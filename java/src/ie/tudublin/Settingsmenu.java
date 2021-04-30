package ie.tudublin;

import processing.core.PVector;
import processing.core.PApplet;

public class Settingsmenu extends Pongrave
{

    Pongrave Pongrave;
    PVector tickbox;
    PVector buttonsize;
    PVector buttonloc;
    String settingname;
    boolean box;
    boolean puckspeed;
    boolean vol;
    boolean mute;
    boolean speedgain;
    int gap;


    public Settingsmenu(Pongrave pongrave, int gap, String settingname, boolean box, boolean puckspeed, boolean vol, boolean mute, boolean speedgain) {
        Pongrave = pongrave;
        tickbox = new PVector(25, 25);
        buttonsize = new PVector(Pongrave.width/4 - 50, Pongrave.height/10);
        buttonloc = new PVector(Pongrave.width/2, Pongrave.height/2 - gap);
        this.settingname = settingname;
        this.gap = gap;
        this.box = box;
        this.puckspeed = puckspeed;
        this.vol = vol;
        this.mute = mute;
        this.speedgain = speedgain;

    }

    void render()
    {
        if(box)
        {
            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
            Pongrave.colorMode(RGB);
            Pongrave.fill(0);
            Pongrave.stroke(255);
            Pongrave.strokeWeight(5);
            Pongrave.rect(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f, Pongrave.height/2 - gap, tickbox.x, tickbox.y);
            Pongrave.popMatrix();
        }

        if(box == false)
        {
            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
            Pongrave.colorMode(RGB);
            Pongrave.fill(0);
            Pongrave.stroke(255);
            Pongrave.strokeWeight(5);

            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - (tickbox.x/2) - 35,
            Pongrave.height/2 - gap - (tickbox.x/2),
            Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f + (tickbox.x/2) - 35,
            Pongrave.height/2 - gap - (tickbox.x/2));

            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f, Pongrave.height/2 - gap, Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f, Pongrave.height/2 - gap - tickbox.x);
            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - (tickbox.x/2), Pongrave.height/2 - gap - (tickbox.x/2), Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f + (25/2), Pongrave.height/2 - gap - (tickbox.x/2));
            Pongrave.popMatrix();
        }

        if(puckspeed)
        {
            // println(Pongrave.mouseX);
            if(mousePressed == true 
            && Pongrave.mouseX >= Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - (tickbox.x/2) - 35 
            && Pongrave.mouseX <= Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f + (tickbox.x/2) - 35 
            /*&& Pongrave.mouseY <= Pongrave.height/2 - gap - (tickbox.x/2) 
            && Pongrave.mouseY >= Pongrave.height/2 - gap - (tickbox.x/2)*/)
            {
                println("test-");
            }
        }


        Pongrave.pushMatrix();
        Pongrave.textAlign(RIGHT);
        float textsize = Pongrave.textWidth(settingname);
        float fixedsize = PApplet.map(textsize, 0, Pongrave.width, Pongrave.mn.buttonloc.x - Pongrave.mn.buttonsize.x/2, Pongrave.mn.buttonloc.x + Pongrave.mn.buttonsize.x/2);
        Pongrave.textSize(fixedsize/20);
        Pongrave.fill(255);
        Pongrave.text(settingname, Pongrave.width/2+(fixedsize/20), Pongrave.height/2 - gap);
        Pongrave.popMatrix();
    }
}

