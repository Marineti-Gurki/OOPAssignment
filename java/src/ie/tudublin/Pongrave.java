package ie.tudublin;


public class Pongrave extends Visual
{
    Puck p;
    Paddle padright;
    Paddle padleft;
    BG bg;
    Score scr;
    boolean[] keys = new boolean[1024];

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
        loadAudio("RuleTheWorld.mp3");
        getAudioPlayer().loop();
        getAudioPlayer().setGain(-8); 

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
        padright.rightInput();
        padright.update();
        padleft.render();
        padleft.leftInput();
        padleft.update();
    }

    // public void keyReleased()
    // {
    //     padright.control(0);
    //     padleft.control(0);
    // }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;

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

    public void keyReleased() {
        keys[keyCode] = false;
        padright.control(0);
        padleft.control(0);
    }

}
