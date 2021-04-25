package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("DoomsGate.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
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
    }
    // public void keyPressed() {

    //     if (keyCode == ' ') {
    //         if (ap.isPlaying()) {
    //             ap.pause();
    //         } else {
    //             //ap.rewind(); rewind disabled here because I didn't like it rewninding everytime I unpaused the track
    //             ap.play();
    //         }
    //     }
    //     //pressing enter rewinds the track
    //     if (keyCode == ENTER)
    //     {
    //         ap.rewind();
    //     }
    // } 

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        wf.render();
        abv.render();
    }
}
