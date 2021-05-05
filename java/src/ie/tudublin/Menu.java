package ie.tudublin;
import processing.core.PVector;
import processing.core.PApplet;

public class Menu extends Pongrave
{
    Pongrave Pongrave;
    PVector menubox;
    PVector buttonsize;
    PVector buttonloc;
    String buttontext;
    float backbttnX;
    float backbttnY;
    int gap;

    public Menu(Pongrave pongrave, int gap, String buttontext) {
        Pongrave = pongrave;
        menubox = new PVector(Pongrave.width/4, Pongrave.height/1.5f);
        buttonsize = new PVector(Pongrave.width/4 - 50, Pongrave.height/10);
        buttonloc = new PVector(Pongrave.width/2, Pongrave.height/2 - gap);
        this.buttontext = buttontext;
        this.gap = gap;

        backbttnX = Pongrave.width/2 - menubox.x/1.3f;
        backbttnY = Pongrave.height/2 - buttonsize.y*2.65f;
    }

    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.rectMode(CENTER);
        Pongrave.colorMode(HSB);
        Pongrave.fill(117, 255, 150, 100);
        Pongrave.stroke(255);
        Pongrave.strokeWeight(5);
        Pongrave.rect(Pongrave.width/2, Pongrave.height/2, menubox.x, menubox.y);
        Pongrave.popMatrix();
    }

    void button()
    {
        Pongrave.pushMatrix();
        Pongrave.rectMode(CENTER);
        Pongrave.colorMode(RGB);
        Pongrave.fill(0, 0, 0, 150);
        Pongrave.stroke(255);
        Pongrave.strokeWeight(5);
        Pongrave.rect(buttonloc.x, buttonloc.y, buttonsize.x, buttonsize.y);
        Pongrave.popMatrix();

        Pongrave.pushMatrix();
        Pongrave.textAlign(CENTER);
        Pongrave.textSize(50);
        float textsize = Pongrave.textWidth(buttontext);
        float fixedsize = PApplet.map(textsize, 0, Pongrave.width, Pongrave.mn.buttonloc.x - Pongrave.mn.buttonsize.x/2, Pongrave.mn.buttonloc.x + Pongrave.mn.buttonsize.x/2);
        Pongrave.textSize(fixedsize/10);
        Pongrave.fill(255);
        Pongrave.text(buttontext, buttonloc.x, buttonloc.y + buttonsize.y/4);
        Pongrave.popMatrix();
    }

    void backbutton()
    {
        Pongrave.pushMatrix();
        Pongrave.rectMode(CENTER);
        Pongrave.fill(0, 0, 0, 150);
        Pongrave.stroke(255);
        Pongrave.rect(Pongrave.width/2 - menubox.x/1.3f, Pongrave.height/2 - buttonsize.y*2.65f, 130, 70);
        Pongrave.textAlign(CENTER);
        Pongrave.textSize(50);
        Pongrave.fill(255);
        Pongrave.text(buttontext, Pongrave.width/2 - menubox.x/1.3f, (Pongrave.height/2 - buttonsize.y*2.65f)+15);
        Pongrave.popMatrix();
    }

}
