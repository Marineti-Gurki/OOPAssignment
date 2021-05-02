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
        // used for button detection for minus
        float minusboxX1 = Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - 35;
        float minusboxY1 = Pongrave.height/2 - gap - (tickbox.x/2);

        // used for button detection for plus
        float plusboxX1 = Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f;
        float plusboxY1 = Pongrave.height/2 - gap - (tickbox.x/2);

        // used for button detection boxes
        float lineboxX2 = Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.6f;
        float lineboxY2 = Pongrave.height/2 - gap/1.3f;


        //if the setting is a box, it will display a box, for stuff like mute or similar (toggle-able things)
        if(box)
        {
            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
            Pongrave.colorMode(RGB);
            Pongrave.fill(0);
            Pongrave.stroke(255);
            Pongrave.strokeWeight(5);
            Pongrave.rect(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.6f , Pongrave.height/2 - gap/1.3f, tickbox.x, tickbox.y);
            Pongrave.popMatrix();
        }

        //if the setting isn't a box, it will display a - and + beside the settings name, for settings that have multiple tiers, i.e volume or puckspeed
        if(box == false)
        {
            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
            Pongrave.colorMode(RGB);
            Pongrave.fill(0);
            Pongrave.stroke(255);
            Pongrave.strokeWeight(5);

            //This is the minus
            //formatted like so so it's easier to tell what's what
            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - (tickbox.x/2) - 35, //lines X1
            Pongrave.height/2 - gap - (tickbox.x/2),                                             //lines Y1
            Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f + (tickbox.x/2) - 35,               //lines X2
            Pongrave.height/2 - gap - (tickbox.x/2));                                            //lines Y1


            //This is the plus
            //vertical line
            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f, //vert lines X1
            Pongrave.height/2 - gap,                                        //vert lines Y1
            Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f,               //vert lines X2
            Pongrave.height/2 - gap - tickbox.x);                           //vert lines Y2
            //horizontal line
            Pongrave.line(Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f - (tickbox.x/2), //hor lines X1
            Pongrave.height/2 - gap - (tickbox.x/2),                                        //hor lines Y1
            Pongrave.width/2 + Pongrave.mn.buttonsize.x/2.2f + (25/2),                      //hor lines X2
            Pongrave.height/2 - gap - (tickbox.x/2));                                       //hor lines Y2
            Pongrave.popMatrix();
        }

        //if setting is puckspeed, it will check if mouse is pressing on plus or minus and will adjust puck speed accordingly. **needs implementing of setting itself**
        if(puckspeed)
        {
            Pongrave.pushMatrix();

            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < minusboxX1 + tickbox.x/2
            && Pongrave.mouseX > minusboxX1 - tickbox.x/2
            && Pongrave.mouseY < minusboxY1 + tickbox.x/2
            && Pongrave.mouseY > minusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Minus");
            }
            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < plusboxX1 + tickbox.x/2
            && Pongrave.mouseX > plusboxX1 - tickbox.x/2
            && Pongrave.mouseY < plusboxY1 + tickbox.x/2
            && Pongrave.mouseY > plusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Plus");
            }
            Pongrave.popMatrix();
        }
        if(vol)
        {
            Pongrave.pushMatrix();

            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < minusboxX1 + tickbox.x/2
            && Pongrave.mouseX > minusboxX1 - tickbox.x/2
            && Pongrave.mouseY < minusboxY1 + tickbox.x/2
            && Pongrave.mouseY > minusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Minus");
            }
            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < plusboxX1 + tickbox.x/2
            && Pongrave.mouseX > plusboxX1 - tickbox.x/2
            && Pongrave.mouseY < plusboxY1 + tickbox.x/2
            && Pongrave.mouseY > plusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Plus");
            }
            Pongrave.popMatrix();
        }

        
        //if setting is mute, it will check if mouse is pressing on the specific location defined in the if statement. **needs implementing of setting itself**
        if(mute)
        {
            Pongrave.pushMatrix();
            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < lineboxX2 + tickbox.x/2
            && Pongrave.mouseX > lineboxX2 - tickbox.x/2
            && Pongrave.mouseY < lineboxY2 + tickbox.x/2
            && Pongrave.mouseY > lineboxY2 - tickbox.x/2)
            {
                println("test2");
            }
            Pongrave.popMatrix();
        }
        
        if(speedgain)
        {
            Pongrave.pushMatrix();

            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < minusboxX1 + tickbox.x/2
            && Pongrave.mouseX > minusboxX1 - tickbox.x/2
            && Pongrave.mouseY < minusboxY1 + tickbox.x/2
            && Pongrave.mouseY > minusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Minus");
            }
            if(Pongrave.mousePressed == true 
            && Pongrave.mouseX < plusboxX1 + tickbox.x/2
            && Pongrave.mouseX > plusboxX1 - tickbox.x/2
            && Pongrave.mouseY < plusboxY1 + tickbox.x/2
            && Pongrave.mouseY > plusboxY1 - tickbox.x/2)
            {
                //placeholder code
                println("Plus");
            }
            Pongrave.popMatrix();
        }
        
        // prints each settings text based on what was passed into settingname variable through the constructor, and location is decided by the gap variable.
        Pongrave.pushMatrix();
        Pongrave.textAlign(RIGHT);
        float textsize = Pongrave.textWidth(settingname);                                                                                                                       //checks text overall size
        float fixedsize = PApplet.map(textsize, 0, Pongrave.width, Pongrave.mn.buttonloc.x - Pongrave.mn.buttonsize.x/2, Pongrave.mn.buttonloc.x + Pongrave.mn.buttonsize.x/2); //maps the text size to the size of it's container so that it stays within the settings menu
        Pongrave.textSize(fixedsize/20);                                                                                                                                        //scales the text size down further as it is still too big
        Pongrave.fill(255);
        Pongrave.text(settingname, Pongrave.width/2+(fixedsize/20), Pongrave.height/2 - gap);
        Pongrave.popMatrix();
    }
}

