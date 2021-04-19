package example;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class RotatingAudioBands extends Visual {


    public void settings()
    {
        size(1080, 720, P3D);
        // fullScreen(P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (keyCode == ' ')
        {
            if(getAudioPlayer().isPlaying())
            {
                getAudioPlayer().pause();
            }
            else
            {
                getAudioPlayer().play();
            }
        }
        if (keyCode == ENTER)
        {
            getAudioPlayer().rewind();
            getAudioPlayer().play();
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);
        startMinim();
        loadAudio("DoomsGate.mp3");
        // loadAudio("DBZ.mp3");
        getAudioPlayer().play();
        getAudioPlayer().setGain(-5); 
        //startListening(); 
        
    }


    float radius = 200;

    float smoothedBoxSize = 0;

    float rot = 0;

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
        noFill();
        stroke(255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        
        
        int var = 1;
        boolean check = false;
        
        camera(0, -500, 500, 0, 0, 0, 0, 1, 0);

        // camera(0, -500, 500, mouseX*-1, mouseY*-1, 0, 0, 1, 0);
        //translate(0, 0, -250);
        
        rot += getAmplitude() / 8.0f;
        
        
        rotateY(rot);
        float[] bands = getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float theta = map(i, 0, bands.length, 0, TWO_PI);

            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            strokeWeight(2);
            float h = bands[i];
            float x = sin(theta) * (radius);
            float z = cos(theta) * (radius);
            pushMatrix();
            rotateZ(h + i);
            translate(x, z);
            
            // rotateY(theta);
            // box(50, h, 50);
            sphere(12.5f + h/50);
            popMatrix();

            pushMatrix();
            strokeWeight(1);
            sphere(h/2f);
            popMatrix();

            }

        }
    float angle = 0;

}