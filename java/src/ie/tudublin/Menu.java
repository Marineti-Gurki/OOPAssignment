package ie.tudublin;
import processing.core.PVector;


public class Menu extends Pongrave
{
    Pongrave Pongrave;
    PVector menubox;
    PVector buttonsize;
    PVector buttonloc;

    public Menu(Pongrave pongrave, int gap) {
        Pongrave = pongrave;
        menubox = new PVector(Pongrave.width/4, Pongrave.height/1.5f);
        buttonsize = new PVector(Pongrave.width/4 - 50, Pongrave.height/10);
        buttonloc = new PVector(Pongrave.width/2, gap);
    }

    // void Setup()
    // {
    //     menubox = new PVector(Pongrave.width/4, height - 50);
    // }

    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.rectMode(CENTER);
        Pongrave.colorMode(RGB);
        Pongrave.fill(0);
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
        Pongrave.fill(0);
        Pongrave.stroke(255);
        Pongrave.strokeWeight(5);
        Pongrave.rect(buttonloc.x, buttonloc.y, buttonsize.x, buttonsize.y);
        Pongrave.popMatrix();
        if(mouseX < buttonloc.x - buttonsize.x/2 && mouseX > buttonloc.x + buttonsize.x/2 && mouseY < buttonloc.y - buttonsize.y/2 && mouseY > buttonloc.y - buttonsize.y/2)
        {
            // Pongrave.check++;
            println("test");
        }
        else
        {
            Pongrave.check = 0;
        }
        
    }

    // public void mousePressed()
    // {

    // }

}
