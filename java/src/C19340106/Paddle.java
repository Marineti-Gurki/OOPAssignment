package C19340106;
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
        //grabs band values from the song and uses them to draw a paddle. The colour of the paddle changes slightly based on the song
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
            Pongrave.fill(0 + PApplet.map(b, 0, Pongrave.getBands().length*20, 0, 255), 200, 255); //changes the fill of the paddle to be according to song.
            Pongrave.box(x, y, h);
            Pongrave.popMatrix();
        }
    }

    void leftInput()
    {
        //controls for Left player
        if(playing == false)
        {
            if(Pongrave.checkKey('W'))
            {
                control(10);        //the 10 is then sent to control, and puts it into ymovement.
            }
            if(Pongrave.checkKey('S'))
            {
                control(-10);
            }
        }
    }
    void rightInput()
    {
        //controls for Right player
        if(playing == false)
        {
            if(Pongrave.checkKey(PApplet.UP))
            {
                control(10);        //the 10 is then sent to control, and puts it into ymovement.
            }
            if(Pongrave.checkKey(PApplet.DOWN))
            {
                control(-10);
            }
        }
    }

    void control(float padspeed)
    {
        ymovement = padspeed; //this is what controls the padspeed, changes ymovement to be the padspeed.
    }


    void update()
    {
        posy = posy - ymovement;    //moves the y position of the pads by ymovement.
        posy = constrain(posy, y/2, Pongrave.height - y/2); //stops the paddle from going off screen.
    }
    void PlayPause()
    {
        //this is for when the game is paused, otherwise you can move the paddles while paused, which is probably not preferable lol.
        if(playing == false)
        {
            temppadspeed = padspeed;    //if not playing then paddle is not free to move
            padspeed = 0;
        }
        if(playing == true)
        {
            padspeed = temppadspeed;    //if playing then paddle is free to move
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
