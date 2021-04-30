package ie.tudublin;


public class Pongrave extends Visual
{
    Puck p;
    Paddle padright;
    Paddle padleft;
    BG bg;
    Score scr;
    boolean[] keys = new boolean[1024];
    float[] lerpedBuffer;
    Menu bttn1;
    Menu bttn2;
    Menu bttn3;
    Menu bttn4;
    Menu backbttn;
    Menu mn;
    Settingsmenu setting1;
    Settingsmenu setting2;
    Settingsmenu setting3;
    Settingsmenu setting4;

    public int check;
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
        // noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("RuleTheWorld.mp3");
        lerpedBuffer = new float[width];
        check = 0;
        mn = new Menu(this, 0, "Menu");
        bttn1 = new Menu(this, 180, "Play");
        bttn2 = new Menu(this, 80, "Songs");
        bttn3 = new Menu(this, -20, "Settings");
        bttn4 = new Menu(this, -120, "Exit");
        backbttn = new Menu(this, -120, "Back");

        setting1 = new Settingsmenu(this, 180, "Puck Speed", false, true, false, false, false);
        setting2 = new Settingsmenu(this, 80, "Volume", false, false, true, false, false);
        setting3 = new Settingsmenu(this, -20, "Mute", true, false, false, true, false);
        setting4 = new Settingsmenu(this, -120, "Speed Boost", false, false, false, false, true);

        p = new Puck(this, width/2, height/2, random(5, 8), random(5, 8), false);

        padright = new Paddle(this, 10, 100, 20, height / 2, width - 15, 10, false, false);
        padleft = new Paddle(this, 10, 100, 20, height / 2, 15, 10, true, false);
        
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

        if(mousePressed == true && mouseX < bttn1.buttonloc.x + bttn1.buttonsize.x/2 && mouseX > bttn1.buttonloc.x - bttn1.buttonsize.x/2 && mouseY < bttn1.buttonloc.y + bttn1.buttonsize.y/2 && mouseY > bttn1.buttonloc.y - bttn1.buttonsize.y/2 && check == 0)
        {
            check = 1;
            // println("test");
            p.reset();
            scr.scorereset();
        }
        if(mousePressed == true && mouseX < bttn2.buttonloc.x + bttn2.buttonsize.x/2 && mouseX > bttn2.buttonloc.x - bttn2.buttonsize.x/2 && mouseY < bttn2.buttonloc.y + bttn2.buttonsize.y/2 && mouseY > bttn2.buttonloc.y - bttn2.buttonsize.y/2 && check == 0)
        {
            check = 2;
        }

        if(mousePressed == true && mouseX < bttn3.buttonloc.x + bttn3.buttonsize.x/2 && mouseX > bttn3.buttonloc.x - bttn3.buttonsize.x/2 && mouseY < bttn3.buttonloc.y + bttn3.buttonsize.y/2 && mouseY > bttn3.buttonloc.y - bttn3.buttonsize.y/2 && check == 0)
        {
            check = 3;
        }

        if(mousePressed == true && mouseX < bttn4.buttonloc.x + bttn4.buttonsize.x/2 && mouseX > bttn4.buttonloc.x - bttn4.buttonsize.x/2 && mouseY < bttn4.buttonloc.y + bttn4.buttonsize.y/2 && mouseY > bttn4.buttonloc.y - bttn4.buttonsize.y/2 && check == 0)
        {
            check = 4;
        }

        if(mousePressed == true && mouseX < backbttn.backbttnX + backbttn.backbttnX/5 && mouseX > backbttn.backbttnX - backbttn.backbttnX/5 && mouseY < backbttn.backbttnY + backbttn.backbttnY/5 && mouseY > backbttn.backbttnY - backbttn.backbttnY/5 && (check == 2 || check == 3))
        {
            println("test");
            check = 0;
        }


        if(checkKey('M'))
        {
            p.playing = false;
            check = 0;
        }

        switch(check)
        {
            case 0:
                mn.render();
                bttn1.button();
                bttn2.button();
                bttn3.button();
                bttn4.button();
                getAudioPlayer().loop();
                getAudioPlayer().setGain(-8); 
                break;

            case 1:
                Pong();
            break;

            case 2:
                mn.render();
                backbttn.backbutton();
                getAudioPlayer().pause();
            break;

            case 3:
                mn.render();
                backbttn.backbutton();
                setting1.render();
                setting2.render();
                setting3.render();
                setting4.render();
                getAudioPlayer().pause();
            break;

            case 4:
                getAudioPlayer().pause();
                exit();
            break;
        }
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void Pong()
    {
        bg.render();
        
        bg.renderbars();
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

    public void mousePressed() 
    {

    }

    public void keyPressed() {
        keys[keyCode] = true;

        if (keyCode == ' ' && check == 1)
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
                padleft.playing = false;
                padright.playing = false;
            }
            else
            {
                p.playing = true;
                padleft.playing = true;
                padright.playing = true;
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
