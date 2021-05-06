package C19340106;

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
        //draws the score on the right
        Pongrave.pushMatrix();
        Pongrave.fill(0);
        Pongrave.textSize(35);
        Pongrave.textAlign(CENTER);
        Pongrave.text(scrR, (Pongrave.width / 2) + 50, 50);
        Pongrave.popMatrix();
    }
    void scoredisplayleft()
    {
        //draws the score on the left
        Pongrave.pushMatrix();
        Pongrave.fill(0);
        Pongrave.textSize(35);
        Pongrave.textAlign(CENTER);
        Pongrave.text(scrL, (Pongrave.width / 2) - 50, 50);
        Pongrave.popMatrix();
    }

    void scorereset()
    {
        //resets the score
        scrL = 0;
        scrR = 0;
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
