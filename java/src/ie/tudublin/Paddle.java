package ie.tudublin;
import processing.core.PApplet;

public class Paddle extends Pongrave
{
    Pongrave Pongrave;
    float x;
    float y;
    float h;
    float posy;
    float posx;
    float padspeed;
    float ymovement = 0;

    public Paddle(Pongrave pongrave, float x, float y, float h, float posy, float posx, float padspeed, boolean padleft) {
        Pongrave = pongrave;
        this.x = x;
        this.y = y;
        this.h = h;
        this.posy = posy;
        this.posx = posx;
        this.padspeed = padspeed;
        if(padleft)
        {
            posx = posx / 2 + 10;
            if(keyCode == 'W')
            {
                control(10);
            }
            if(keyCode == 'S')
            {
                control(-10);
            }
        }
        else
        {
            posx = Pongrave.width - 50;
            if(keyCode == UP)
            {
                padright.control(10);
            }
            if(keyCode == DOWN)
            {
                padright.control(-10);
            }
        }
    }

    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.colorMode(RGB);
        Pongrave.translate(posx, posy);
        Pongrave.noStroke();
        Pongrave.fill(255, 0, 0);
        Pongrave.box(x, y, h);
        Pongrave.popMatrix();

        Pongrave.pushMatrix();
        Pongrave.translate(posx, posy);
        Pongrave.noStroke();
        Pongrave.fill(255, 0, 0);
        Pongrave.box(x, y, h);
        Pongrave.popMatrix();
    }

    void leftInput()
    {
            if(Pongrave.checkKey('W'))
            {
                control(10);
            }
            if(Pongrave.checkKey('S'))
            {
                control(-10);
            }
    }
    void rightInput()
    {
            if(Pongrave.checkKey(PApplet.UP))
            {
                control(10);
            }
            if(Pongrave.checkKey(PApplet.DOWN))
            {
                control(-10);
            }
    }

    void control(float padspeed)
    {
        ymovement = padspeed;
    }


    void update()
    {
        posy = posy - ymovement;
        posy = constrain(posy, y/2, Pongrave.height - y/2);
    }



    // void reset()
    // {

    // }


    public Pongrave getPongrave() {
        return Pongrave;
    }
    public float getPosy() {
        return posy;
    }

    public void setPosy(float posy) {
        this.posy = posy;
    }

    public float getPosx() {
        return posx;
    }

    public void setPosx(float posx) {
        this.posx = posx;
    }

    public float getPadspeed() {
        return padspeed;
    }

    public void setPadspeed(float padspeed) {
        this.padspeed = padspeed;
    }

    public void setPongrave(Pongrave pongrave) {
        Pongrave = pongrave;
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
    public float getH() {
        return h;
    }
    public void setH(float h) {
        this.h = h;
    }
    public float getposy() {
        return posy;
    }
    public void setposy(float posy) {
        this.posy = posy;
    }
    public float getposx() {
        return posx;
    }
    public void setposx(float posx) {
        this.posx = posx;
    }


    




}
