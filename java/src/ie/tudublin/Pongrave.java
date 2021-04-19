package ie.tudublin;

import processing.core.PApplet;


public class Pongrave extends PApplet{
    Puck p;
    Paddle padright;
    Paddle padleft;
    float halfW = width / 2;
    float halfH = height / 2;

    public void settings()
    {
        size(1080, 720, P3D);
        // fullScreen(P3D);
    }
 
    public void setup()
    {
        p = new Puck(this, width/2, height/2, random(5, 8), random(5, 8));
        padright = new Paddle(this, 10, 100, 20, height / 2, width - 25, 10, false);

        padleft = new Paddle(this, 10, 100, 20, height / 2, 25, 10, true);
    }

    public void draw()
    {
        background(0);

        p.render();
        p.update();
        p.edgedetect();
        p.paddledetect(padleft);
        p.paddledetect(padright);
        
        padright.render();
        padright.update();
        padleft.render();
        padleft.update();

    }

    public void keyReleased()
    {
        padright.control(0);
        padleft.control(0);
    }


    public void keyPressed()
    {
        if(keyCode == UP)
        {
            padright.control(10);
        }
        if(keyCode == DOWN)
        {
            padright.control(-10);
        }
        if(keyCode == 'W')
        {
            padleft.control(10);
        }
        if(keyCode == 'S')
        {
            padleft.control(-10);
        }
    }

}
