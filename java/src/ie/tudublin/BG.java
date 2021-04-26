package ie.tudublin;

import processing.core.PVector;

public class BG extends Pongrave
{
    Pongrave Pongrave;
    float rot = 0;
    PVector size;

    public BG(Pongrave pongrave) {
        Pongrave = pongrave;
        size = new PVector(1000, 1000);
    }
    
    void render()
    {
        Pongrave.colorMode(HSB);
        rot += Pongrave.getAmplitude() / 5.0f;
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float h = bands[i];
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            h = (h + 10f) % 255;
            Pongrave.fill(h, 50, 255, 100);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.translate(Pongrave.width/2, Pongrave.height/2);
            Pongrave.rotateY(rot/4);
            Pongrave.sphere(1000);
            Pongrave.popMatrix();

            Pongrave.pushMatrix();
            Pongrave.rectMode(CENTER);
                        
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.rect(Pongrave.width/2, Pongrave.height/2, size.x, size.y);
            Pongrave.popMatrix();
        }
    }
    void renderbars()
    {
        float gap = Pongrave.width / (float) Pongrave.getBands().length;
        Pongrave.noStroke();
        for(int j = 0 ; j < Pongrave.getBands().length ; j ++)
        {
            Pongrave.fill(Pongrave.map(j, 0, Pongrave.getBands().length, 255, 0), 255, 255);
            Pongrave.rect(j * gap, Pongrave.height, gap,-Pongrave.getSmoothedBands()[j] * 0.6f); 
        }
    }
}
