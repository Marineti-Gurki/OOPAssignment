package ie.tudublin;

// import processing.core.PApplet;
import processing.core.PVector;

public class BG extends Pongrave
{
    Pongrave Pongrave;
    float rot = 0;
    PVector size;

    public BG(Pongrave pongrave) {
        Pongrave = pongrave;
        size = new PVector(Pongrave.width/1.44f, Pongrave.width/1.44f);
        halfH = Pongrave.height/2;
        halfW = Pongrave.width/2;
    }
    
    void render()
    {
        halfH = Pongrave.height/2;
        halfW = Pongrave.width/2;
        size.x = Pongrave.width/1.44f;
        size.y = Pongrave.width/1.44f;
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
            Pongrave.translate(halfW, halfH);
            Pongrave.rotateY(rot/4);
            float spheresize = Pongrave.width/2 + Pongrave.height/2; 
            Pongrave.sphere(spheresize);
            Pongrave.popMatrix();
            
            Pongrave.pushMatrix();
            Pongrave.hint(DISABLE_OPTIMIZED_STROKE);
            Pongrave.rectMode(CENTER);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.rect(Pongrave.width - Pongrave.width/4, halfH, size.x/1.5f, size.y);
            Pongrave.popMatrix();
            
            Pongrave.pushMatrix();
            // Pongrave.hint(DISABLE_OPTIMIZED_STROKE);
            Pongrave.rectMode(CENTER);
            Pongrave.stroke(150+h, 50, 100);
            Pongrave.strokeWeight(2);
            Pongrave.rect(Pongrave.width/4, halfH, size.x/1.5f, size.y);
            Pongrave.popMatrix();
        }
    }
    void renderbars()
    {
        // Pongrave.hint(ENABLE_OPTIMIZED_STROKE);
        Pongrave.colorMode(HSB);
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float h = bands[i];
            Pongrave.pushMatrix();
            float gap = Pongrave.width / (float) Pongrave.getBands().length;
            Pongrave.stroke(0, 125, 0);
            Pongrave.fill(h, 125, 255);
            Pongrave.rect(0, i * gap, -Pongrave.getSmoothedBands()[i] * 1f, gap); 
            Pongrave.rect(Pongrave.width, i * gap, -Pongrave.getSmoothedBands()[i] * 1f, gap); 
            Pongrave.popMatrix();

        }
    }
}
