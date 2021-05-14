/**
 * @Author: Matiss Priednieks
 * @Date:   2021-05-06T15:12:09+01:00
 * @Email:  C19340106@mytudublin.ie
 * @Filename: BG.java
 * @Last modified by:   Matiss Priednieks
 * @Last modified time: 2021-05-07T16:30:09+01:00
 */



package C19340106;

import processing.core.PImage;
import processing.core.PVector;

public class BG extends Pongrave
{
    Pongrave Pongrave;
    float rot = 0;
    PVector size;
    PImage rightcontrols;
    PImage leftcontrols;

    public BG(Pongrave pongrave) {
        Pongrave = pongrave;
        size = new PVector(Pongrave.width/1.44f, Pongrave.width/1.44f);
        halfH = Pongrave.height/2;
        halfW = Pongrave.width/2;
        rightcontrols = Pongrave.loadImage("updown.png");   //loads updown image for right controls
        leftcontrols = Pongrave.loadImage("WASD.png");      //loads wasd image for left controls
    }

    void render()
    {
        halfH = Pongrave.height/2;
        halfW = Pongrave.width/2;
        // size.x = Pongrave.width/1.44f;
        // size.y = Pongrave.width/1.44f;

        Pongrave.colorMode(HSB);
        rot += Pongrave.getAmplitude() / 5.0f; //rotation of sphere is determined by the amplitude of the song divided by 5, smaller number would make it rotate more aggresively, which for the sake of not distracting the players, is avoided.
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands(); //gets smoothed bands array from visual.java class.

        //for loop drawing most of the background objects, i.e a large sphere rotating in the far background, and a pong table like platform, both for aesthetic reasons and so that the rotating sphere is easier on the eyes.
        for(int i = 0 ; i < bands.length; i ++)
        {
            float h = bands[i];
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            h = (h * 5f) % 255;
            Pongrave.fill(h, 50, 255, 100);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.translate(halfW, halfH);
            Pongrave.rotateY(rot/4);
            float spheresize = Pongrave.width/2 + Pongrave.height/2;
            Pongrave.sphere(spheresize); //draws a sphere according to screen size, rotates and changes colours according to music.
            Pongrave.popMatrix();

            //draws pong table on one side (gaps are intentional)
            Pongrave.pushMatrix();
            Pongrave.hint(DISABLE_OPTIMIZED_STROKE);    //added to fix issues with strokes showing through when they're not meant to. Causes some glitchy-ness on rare occasions.
            Pongrave.rectMode(CENTER);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.rect(Pongrave.width - Pongrave.width/4, halfH, size.x/1.5f, size.y);
            Pongrave.popMatrix();

            //displays image of controls on the right side
            Pongrave.pushMatrix();
            Pongrave.imageMode(CENTER);
            Pongrave.colorMode(HSB);
            Pongrave.tint(255, 50);
            Pongrave.tint(0+h/2, 41, 255, 100);     //wanted a slight tint change based on the music and have the opacity be slightly reduced so that it doesn't completely pop and distract the player.
            Pongrave.image(rightcontrols, Pongrave.width/2 + Pongrave.width/3, Pongrave.height/8);
            Pongrave.popMatrix();

            //draws pong table on the other side (gaps are intentional)
            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.rect(Pongrave.width/4, halfH, size.x/1.5f, size.y);
            Pongrave.popMatrix();

            //displays image of controls on the left side
            Pongrave.pushMatrix();
            Pongrave.imageMode(CENTER);
            Pongrave.colorMode(HSB);
            Pongrave.tint(255, 50);     //wanted a slight tint change based on the music and have the opacity be slightly reduced so that it doesn't completely pop and distract the player.
            Pongrave.tint(0+h/2, 41, 255, 100);
            Pongrave.image(leftcontrols, Pongrave.width/6, Pongrave.height/8);
            Pongrave.popMatrix();
        }
    }
    void renderbars()
    {
        Pongrave.colorMode(HSB);
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            //renders frequency bars along the sides of the game and react to music both by changing colour and size.
            float h = bands[i];
            Pongrave.pushMatrix();
            float gap = Pongrave.width / (float) Pongrave.getBands().length;
            Pongrave.stroke(0, 125, 0);
            Pongrave.fill(h, 125, 255);
            Pongrave.rect(0, i * gap, -Pongrave.getSmoothedBands()[i] * 1f, gap);
            Pongrave.rect(Pongrave.width, i * gap, -Pongrave.getSmoothedBands()[i] * 1f, gap);
            Pongrave.popMatrix();

        }
    }
}
