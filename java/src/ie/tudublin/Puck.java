package ie.tudublin;

public class Puck extends Pongrave
{
    Pongrave Pongrave;
    float x, y;
    float speedx, speedy;
    float rot;
    boolean playing;
    float tempxspeed, tempyspeed;
    float startspeed;

    public Puck(Pongrave pongrave, float x, float y, float speedx, float speedy, boolean playing) {
        Pongrave = pongrave;
        this.x = x;
        this.y = y;
        this.speedx = speedx;
        this.speedy = speedy;
        this.playing = playing;
        rot = random(TWO_PI);
        startspeed = 5;
    }

    void paddledetectleft(Paddle p)
    {
        //Left side paddle detection. If the puck x and y are touching the paddle, puck reverses speed and angle changes to depending on what part of paddle was hit.
        if(x - 10 <= p.posx + p.x/2 && y - 10 <= p.posy + p.y/2 && y + 10 >= p.posy - p.y/2)
        {
            if(x >= p.posx)
            {
                Pongrave.loadSample("tabletennis.mp3");
                float rads = radians(45);
                float diff = y - (p.posy - p.y/2);
                float angle = map(diff, 0, p.y, -rads, rads);
                if(speedx < 14 || speedx > -14)
                {
                    speedx *= -1.05f;
                }
                if(speedx > 14 || speedx < -14)
                {
                    speedx = 14;
                }
                speedy = startspeed * sin(angle);
                Pongrave.getAs().setGain(-4);
                Pongrave.getAs().trigger();
            }
        }
    }

    void paddledetectright(Paddle p)
    {
        //Right side paddle detection. If the puck x and y are touching the paddle, puck reverses speed and angle changes to depending on what part of paddle was hit.
        if(x + 10 >= p.posx - p.x/2 && y - 10 <= p.posy + p.y/2 && y + 10 >= p.posy - p.y/2)
        {
            if(x <= p.posx)
            {
                Pongrave.loadSample("tabletennis.mp3");
                float rads2 = radians(135);
                float diff = y - (p.posy - p.y/2);
                float angle = map(diff, 0, p.y, -rads2, rads2);
                if(speedx < 15)
                {
                    speedx *= -1.05f;
                }
                if(speedx > 15)
                {
                    speedx = 15;
                }
                speedy = startspeed * sin(angle);
                Pongrave.getAs().setGain(-4);
                Pongrave.getAs().trigger();
            }
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
        println(speedx);

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
            Pongrave.stroke(255, 50, 255);
            Pongrave.fill(255, 0, 255);
            Pongrave.sphere(20);
            // Pongrave.ellipse(x, y, 50, 50);
            Pongrave.popMatrix();

            if(playing == true && Pongrave.check == 1)
            {
                Pongrave.pushMatrix();
                Pongrave.rectMode(CENTER);
                Pongrave.colorMode(RGB);
                Pongrave.noStroke();
                Pongrave.fill(0, 0, 0, 50);
                Pongrave.rect(Pongrave.width/2, Pongrave.height/2, Pongrave.width, Pongrave.height);
                Pongrave.popMatrix();

                Pongrave.pushMatrix();
                Pongrave.colorMode(RGB);
                Pongrave.noStroke();
                Pongrave.fill(0);
                Pongrave.triangle(Pongrave.width/2 - 80, Pongrave.height/2 - 100, Pongrave.width/2 - 80, Pongrave.height/2 + 100, Pongrave.width/2 + 100, Pongrave.height/2);
                Pongrave.popMatrix();
            }
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
        
        speedx = startspeed * cos(rot);
        speedy = startspeed * sin(rot);
        
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
            Pongrave.loadSample("tabletennis.mp3");
            speedy *= -1;
            Pongrave.getAs().setGain(-4);
            Pongrave.getAs().trigger();
        }
        if(x > Pongrave.width)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().setGain(-8);
            Pongrave.getAs().trigger();
            scr.scrL += 1;
            reset();
        }
        if(x < 0)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().setGain(-8);
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
