package ie.tudublin;
import processing.core.PApplet;

public class SongSelect extends Pongrave{
    Pongrave Pongrave;
    int gap;
    String songname;
    boolean songplaying;

    public SongSelect(Pongrave pongrave, int gap, String songname, boolean songplaying) {
        Pongrave = pongrave;
        this.gap = gap;
        this.songname = songname;
        this.songplaying = songplaying;
    }
    
    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.textAlign(CENTER);
        float textsize = Pongrave.textWidth(songname);                                                                                                                          //checks text overall size
        float fixedsize = PApplet.map(textsize, 0, Pongrave.width, Pongrave.mn.menubox.x - Pongrave.mn.menubox.x/2, Pongrave.mn.menubox.x + Pongrave.mn.menubox.x/2); //maps the text size to the size of it's container so that it stays within the settings menu
        Pongrave.textSize(fixedsize/8);                                                                                                                                    //scales the text size down further as it is still too big
        Pongrave.fill(255);
        Pongrave.text(songname, Pongrave.width/2, Pongrave.height/2 - gap);
        Pongrave.popMatrix();
    }
}
