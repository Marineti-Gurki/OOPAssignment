package C19340106;

import processing.core.PApplet;

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
        Pongrave.startspeed = 5;
        Pongrave.loadSample("tabletennis.mp3");
        Pongrave.loadSample("buzzer.mp3");
        Pongrave.speedincrease = 1.05f;
    }

    void paddledetectleft(Paddle p)
    {
        //Left side paddle detection. If the puck x and y are touching the paddle, puck reverses speed and angle changes to depending on what part of paddle was hit.
        if(x - 15 <= p.posx + p.x/2 && y - 10 <= p.posy + p.y/2 && y + 10 >= p.posy - p.y/2)
        {
            if(p.posx-p.posx/2 <= x)
            {
                Pongrave.loadSample("tabletennis.mp3"); //loads puck sound
                //calculates the paddles sections so puck can bounce in the correct direction basedo on where it hits
                float rads = PApplet.radians(45);
                float diff = y - (p.posy - p.y/2);
                float angle = PApplet.map(diff, 0, p.y, -rads, rads);
                if(speedx < 14 || speedx > -14)
                {
                    speedx *= -Pongrave.speedincrease; //reverses direction of puck and multiplies by the user selected multiplier
                }
                if(speedx > 14 || speedx < -14)
                {
                    speedx = 14;
                }
                //changes the angle of the puck based on where it hit.
                speedy = Pongrave.startspeed * sin(angle);

                //plays puck sound whenever it hits something
                Pongrave.getAs().setGain(Pongrave.gainvaluesample);
                Pongrave.getAs().trigger();
            }
        }
    }

    void paddledetectright(Paddle p)
    {
        //Right side paddle detection. If the puck x and y are touching the paddle, puck reverses speed and angle changes to depending on what part of paddle was hit.
        if(x + 15 >= p.posx - p.x/2 && y - 10 <= p.posy + p.y/2 && y + 10 >= p.posy - p.y/2)
        {
            if(p.posx+p.posx/2 >= x)
            {
                Pongrave.loadSample("tabletennis.mp3"); //loads puck sound
                //calculates the paddles sections so puck can bounce in the correct direction basedo on where it hits
                float rads2 = PApplet.radians(135);
                float diff = y - (p.posy - p.y/2f);
                float angle = PApplet.map(diff, 0, p.y, -rads2, rads2);

                if(speedx < 14 || speedx > -14)
                {
                    speedx *= -Pongrave.speedincrease; //reverses direction of puck and multiplies by the user selected multiplier
                }
                if(speedx > 14 || speedx < -14)
                {
                    speedx = -14;
                }
                //changes the angle of the puck based on where it hit.
                speedy = Pongrave.startspeed * sin(angle);

                //plays puck sound whenever it hits something
                Pongrave.getAs().setGain(Pongrave.gainvaluesample);
                Pongrave.getAs().trigger();
            }
        }
    }

    void PlayPause()
    {
        if(playing == false)
        {
            //stores puck speed and direction when paused
            tempxspeed = speedx;
            tempyspeed = speedy;
            //sets puck speed and direction to 0 when paused
            speedx = 0;
            speedy = 0;
        }
        if(playing == true)
        {
            //returns pucks speed and direction after unpausing
            speedx = tempxspeed;
            speedy = tempyspeed;
        }
        
    }

    void speedcontrol()
    {
        //buffer for pausing the game, so that when unpaused, puck can return to play from where it left off.
        tempxspeed = speedx;
        tempyspeed = speedy;
    }

    void render() 
    {
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            //draws the puck
            float h = bands[i];
            h = (h + 10f) % 255;
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            Pongrave.translate(x, y);
            Pongrave.lights();
            Pongrave.strokeWeight(0.5f);
            Pongrave.stroke(255, 50, 255);
            Pongrave.fill(255, 0, 255);
            Pongrave.sphere(20);
            Pongrave.popMatrix();

            //if game is paused and not in menu, shows a pause/play sign and has a black transparent backdrop
            if(playing == true && Pongrave.check == 1)
            {
                Pongrave.pushMatrix();
                Pongrave.rectMode(CENTER);
                Pongrave.colorMode(RGB);
                Pongrave.noStroke();
                Pongrave.fill(0, 0, 0, 50);
                Pongrave.rect(Pongrave.width/2, Pongrave.height/2, Pongrave.width, Pongrave.height);        //this is what gives the black transparent background, literally just a big rectangle with halved opacity
                Pongrave.popMatrix();

                Pongrave.pushMatrix();
                Pongrave.colorMode(RGB);
                Pongrave.noStroke();
                Pongrave.fill(0);
                Pongrave.triangle(Pongrave.width/2 - 80, Pongrave.height/2 - 100, Pongrave.width/2 - 80, Pongrave.height/2 + 100, Pongrave.width/2 + 100, Pongrave.height/2);       //draws a triangle when paused
                Pongrave.popMatrix();
            }
        }
    }
    void update()
    {
        x = x + speedx; //updates x position of puck
        y = y + speedy; //updates y position of puck
    }
    void reset()
    {
        //gives puck random angle and sets puck speed
        rot = random(-PI/4, PI/4);
        
        speedx = Pongrave.startspeed * cos(rot);
        speedy = Pongrave.startspeed * sin(rot);
        
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
        //if the puck goes off screen, gives score to the player opposite of where it went off. plays a sound everytime someone scores.
        if(y - 12.5 <= 0 || y + 12.5 >= Pongrave.height)
        {
            Pongrave.loadSample("tabletennis.mp3"); 
            speedy *= -1;
            Pongrave.getAs().setGain(Pongrave.gainvaluesample);
            Pongrave.getAs().trigger();     //plays tabletennis sound
        }

        //plays buzzer when someone scores and updates score
        if(x > Pongrave.width)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().setGain(Pongrave.gainvaluesong);
            Pongrave.getAs().trigger();     //plays buzzer when someone scores
            scr.scrL += 1;  //adds +1 to score on left side if the puck goes off the right side
            reset();
        }
        //plays buzzer when someone scores and updates score
        if(x < 0)
        {
            Pongrave.loadSample("buzzer.mp3");
            Pongrave.getAs().setGain(Pongrave.gainvaluesong);
            Pongrave.getAs().trigger(); 
            scr.scrR += 1;  //adds +1 to score on right side if the puck goes off the left side
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
