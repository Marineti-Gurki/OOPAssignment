package ie.tudublin;

public class Puck extends Pongrave
{
    Pongrave Pongrave;
    float x, y;
    float speedx, speedy;
    float rot;
    boolean playing;
    float tempxspeed, tempyspeed;

    public Puck(Pongrave pongrave, float x, float y, float speedx, float speedy, boolean playing) {
        Pongrave = pongrave;
        this.x = x;
        this.y = y;
        this.speedx = speedx;
        this.speedy = speedy;
        this.playing = playing;
        rot = random(TWO_PI);
    }

    void paddledetectleft(Paddle p)
    {
        Pongrave.noStroke();
        Pongrave.fill(255, 0, 0);
        Pongrave.rectMode(CENTER);

        /*debug code
        // Pongrave.rect(p.posx, p.posy, p.x, p.y);
        // Pongrave.text(speedx, 50, 50);
        // Pongrave.text(x, 50, 70);
        // Pongrave.text(p.x, 50, 90);
        // Pongrave.text(p.posx, 50, 120);
        */
        if(x - 15 < p.posx + p.x/2 && y < p.posy + p.y/1.5 && y > p.posy - p.y/1.5)
        {
            speedx *= -1;
        }
    }

    void paddledetectright(Paddle p)
    {
        if(x + 15 > p.posx + p.x/2 && y < p.posy + p.y/1.5 && y > p.posy - p.y/1.5)
        {
            speedx *= -1;
        }
    }

    void PlayPause()
    {
        println(speedy);
        println(tempyspeed);
        if(playing == false)
        {
            tempxspeed = speedx;
            tempyspeed = speedy;
            speedx = 0;
            speedy = 0;
        }
        if(playing == true)
        {
            speedx = tempxspeed;
            speedy = tempyspeed;
        }
        
    }

    void speedcontrol()
    {
        tempxspeed = speedx;
        tempyspeed = speedy;
    }

    void render() 
    {
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float h = bands[i];
            h = (h + 10f) % 255;
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            // Pongrave.ellipse(x, y, 25, 25);
            Pongrave.translate(x, y);
            Pongrave.lights();
            Pongrave.strokeWeight(0.5f);
            Pongrave.stroke(255, 255, 255);
            Pongrave.fill(255, 255, 255);
            Pongrave.sphere(20);
            // Pongrave.ellipse(x, y, 50, 50);
            Pongrave.popMatrix();
        }
    }
    void update()
    {
        x = x + speedx;
        y = y + speedy;
    }
    void reset()
    {
        //gives puck random angle and sets puck speed
        rot = random(-PI/4, PI/4);
        speedx = 10 * cos(rot);
        speedy = 10 * sin(rot);
        
        //sets puck to middle
        x = Pongrave.width / 2;
        y = Pongrave.height / 2;

        //randomises puck direction
        if(random(1) < 0.5)
        {
            speedx *= -1;
        }
    }

    void edgedetect(Score scr) 
    {
        if(y - 12.5 < 0 || y + 12.5 > Pongrave.height)
        {
            speedy *= -1;
        }
        if(x > Pongrave.width)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().trigger();
            scr.scrL += 1;
            reset();
        }
        if(x < 0)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().trigger();
            scr.scrR += 1;
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
