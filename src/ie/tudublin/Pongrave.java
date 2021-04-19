package ie.tudublin;

public class Pongrave extends Visual
{
    Puck p;
    Paddle padright;
    Paddle padleft;
    BG bg;
    Score scr;

    float halfW = width / 2;
    float halfH = height / 2;

    public void settings()
    {
        size(1080, 720, P3D);
        // fullScreen(P3D);
    }
 
    public void setup()
    {
        colorMode(RGB);
        noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("DoomsGate.mp3");
        getAudioPlayer().play();
        getAudioPlayer().setGain(-5); 

        p = new Puck(this, width/2, height/2, random(5, 8), random(5, 8), false);
        
        padright = new Paddle(this, 10, 100, 20, height / 2, width - 15, 10, false);
        padleft = new Paddle(this, 10, 100, 20, height / 2, 15, 10, true);
        
        bg = new BG(this);
        
        scr = new Score(this, 0, 0);
        p.reset();
        p.speedcontrol();
    }
    
    public void draw()
    {

        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        calculateFrequencyBands();
        background(0);
        bg.render();
        p.render();
        p.update();
        p.edgedetect(scr);
        p.paddledetectleft(padleft);
        p.paddledetectright(padright);
        
        scr.scoredisplayright();
        scr.scoredisplayleft();
        
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


        if (keyCode == ' ')
        {
            p.PlayPause();
            if(getAudioPlayer().isPlaying())
            {
                getAudioPlayer().pause();
            }
            else
            {
                getAudioPlayer().play();
            }
            if(p.playing == true)
            {
                p.playing = false;
            }
            else
            {
                p.playing = true;
            }
        }
        if (keyCode == ENTER)
        {
            getAudioPlayer().rewind();
            getAudioPlayer().play();
        }
    }

}
