package ie.tudublin;

public class BG extends Pongrave
{
    Pongrave Pongrave;
    float rot = 0;

    public BG(Pongrave pongrave) {
        Pongrave = pongrave;
    }

    void render()
    {
        rot += Pongrave.getAmplitude() / 8.0f;
        Pongrave.calculateFrequencyBands();
        float[] bands = Pongrave.getSmoothedBands();
        for(int i = 0 ; i < bands.length; i ++)
        {
            float h = bands[i];
            Pongrave.pushMatrix();

            Pongrave.fill(100, 0, 0, 40-h);
            Pongrave.stroke(255, 0, 0);
            Pongrave.strokeWeight(2);;

            Pongrave.translate(Pongrave.width/2, Pongrave.height/2);
            Pongrave.rotateY(rot/4);
            Pongrave.sphere(1000);

            Pongrave.popMatrix();
        }
    }
}
