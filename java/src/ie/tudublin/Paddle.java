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
    boolean playing;
    float temppadspeed;

    public Paddle(Pongrave pongrave, float x, float y, float h, float posy, float posx, float padspeed, boolean padleft, boolean playing) {
        Pongrave = pongrave;
        this.x = x;
        this.y = y;
        this.h = h;
        this.posy = posy;
        this.posx = posx;
        this.padspeed = padspeed;
    }

    void render()
    {
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float b = bands[i];
            float bigb = (b/10) - 2;
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            Pongrave.translate(posx, posy);
            Pongrave.strokeWeight(bigb);
            Pongrave.stroke(255, 255, 255, 50);
            Pongrave.fill(PApplet.map(b, 0, Pongrave.getBands().length*20, 0, 255), 255, 255);
            Pongrave.box(x, y, h);
            Pongrave.popMatrix();

        }
    }

    void leftInput()
    {
        if(playing == false)
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
    }
    void rightInput()
    {
        if(playing == false)
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
    void PlayPause()
    {
        if(playing == false)
        {
            temppadspeed = padspeed;
            padspeed = 0;
        }
        if(playing == true)
        {
            padspeed = temppadspeed;
        }
        
    }

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
