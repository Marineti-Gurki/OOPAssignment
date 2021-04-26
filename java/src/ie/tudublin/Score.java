package ie.tudublin;

public class Score extends Pongrave 
{
    Pongrave Pongrave;
    int scrL;
    int scrR;
    
    public Score(Pongrave pongrave, int scrL, int scrR) {
        Pongrave = pongrave;
        this.scrL = scrL;
        this.scrR = scrR;
    }
    
    void scoredisplayright()
    {
        Pongrave.pushMatrix();
        Pongrave.fill(0);
        Pongrave.textSize(35);
        Pongrave.textAlign(CENTER);
        Pongrave.text(scrR, (Pongrave.width / 2) + 50, 50);
        Pongrave.popMatrix();
    }
    void scoredisplayleft()
    {
        Pongrave.pushMatrix();
        Pongrave.fill(0);
        Pongrave.textSize(35);
        Pongrave.textAlign(CENTER);
        Pongrave.text(scrL, (Pongrave.width / 2) - 50, 50);
        Pongrave.popMatrix();
    }

    void scorereset()
    {
        
    }

    public Pongrave getPongrave() {
        return Pongrave;
    }

    public void setPongrave(Pongrave pongrave) {
        Pongrave = pongrave;
    }

    public int getScrL() {
        return scrL;
    }

    public void setScrL(int scrL) {
        this.scrL = scrL;
    }

    public int getScrR() {
        return scrR;
    }

    public void setScrR(int scrR) {
        this.scrR = scrR;
    }


    
}
