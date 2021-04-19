package ie.tudublin;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
import processing.core.*;
import processing.core.PApplet;


public class Puck extends Pongrave
{
    Pongrave Pongrave;
    float x, y;
    float speedx;
    float speedy;
    boolean playing;

    public Puck(Pongrave pongrave, float x, float y, float speedx, float speedy) {
        Pongrave = pongrave;
        this.x = x;
        this.y = y;
        this.speedx = speedx;
        this.speedy = speedy;
    }

    void paddledetect(Paddle p)
    {
        //WIP
    //     Pongrave.noFill();
    //     Pongrave.stroke(255, 0, 0);
    //     Pongrave.rect(p.posx, p.posy, p.x, p.y);
    //     if(x - 12.5f < p.posx - p.y/2 && speedx < 0 && x > 25)
    //     {
    //         speedx *= -1;
    //     }
    //     if(y < p.posy + p.y && y > p.posy - p.y)
    //     {
    //         speedx *= -1;
    //         println(p.posx);
    //     }
    //     else if(x < p.posx - p.h/2)
    //     {
    //         speedx *= -1;
    //     }
    // }
//WIP

    void render() 
    {
        Pongrave.pushMatrix();
        Pongrave.ellipse(x, y, 25, 25);
        Pongrave.translate(x, y);
        Pongrave.lights();
        Pongrave.stroke(255);
        Pongrave.fill(255);
        Pongrave.popMatrix();
    }
    void update()
    {
        x = x + speedx;
        y = y + speedy;
    }
    void reset()
    {
        speedx = random(5, 8);
        speedy = random(5, 8);
        x = Pongrave.width / 2;
        y = Pongrave.height / 2;
    }

    void edgedetect()
    {
        if(y - 12.5 < 0 || y + 12.5 > Pongrave.height)
        {
            speedy *= -1;
        }
        if(x < 0 || x > Pongrave.width)
        {
            reset();
        }
    }




    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Pongrave getPongrave() {
        return Pongrave;
    }

    public void setPongrave(Pongrave pongrave) {
        Pongrave = pongrave;
    }


    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public float getSpeedx() {
        return speedx;
    }

    public void setSpeedx(float speedx) {
        this.speedx = speedx;
    }

    public float getSpeedy() {
        return speedy;
    }

    public void setSpeedy(float speedy) {
        this.speedy = speedy;
    }
    
}
