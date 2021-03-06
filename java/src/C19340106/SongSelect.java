package C19340106;
import processing.core.PApplet;
import processing.core.PVector;

public class SongSelect extends Pongrave{
    Pongrave Pongrave;
    int gap;
    String songname;
    boolean song1playing;
    boolean song2playing;
    boolean song3playing;

    float songbuttonx;
    float songbuttony;
    PVector hitbox;

    public SongSelect(Pongrave pongrave, int gap, String songname) 
    {
        Pongrave = pongrave;
        this.gap = gap;
        this.songname = songname;

        songbuttonx = Pongrave.width/2;
        songbuttony = Pongrave.height/2 - gap;
        
        hitbox = new PVector(gap + songbuttony/3, 40);
        //vector for checking if the button is pressed
        

    }
    
    void render()
    {
        Pongrave.pushMatrix();
        Pongrave.textAlign(CENTER);
        float textsize = Pongrave.textWidth(songname);                                                                                                                     //checks text overall size
        float fixedsize = PApplet.map(textsize, 0, Pongrave.width, Pongrave.mn.menubox.x - Pongrave.mn.menubox.x/2, Pongrave.mn.menubox.x + Pongrave.mn.menubox.x/2);      //maps the text size to the size of it's container so that it stays within the settings menu
        Pongrave.textSize(fixedsize/8);                                                                                                                                    //scales the text size down further as it is still too big
        Pongrave.fill(255);
        Pongrave.rectMode(CENTER);
        Pongrave.fill(0, 0, 0, 128);
        Pongrave.rect(songbuttonx, songbuttony - 10, fixedsize + fixedsize/6, hitbox.y);    //quickly added buttons behind the text in song menu
        Pongrave.popMatrix();
        Pongrave.getAudioPlayer().pause();

        //if songname is rule the world, it will check what the songnumber is currently selected. if it is selected then the text will turn blue
        if(songname == "Rule The World")
        {
            Pongrave.pushMatrix();
            Pongrave.colorMode(HSB);
            if(Pongrave.songnum == 1)
            {
                Pongrave.fill(0, 145, 255);
            }
            if(Pongrave.songnum != 1)
            {
                Pongrave.fill(0, 0, 255);
            }
            Pongrave.textSize(fixedsize/7);   
            Pongrave.text(songname, Pongrave.width/2, Pongrave.height/2 - gap);
            Pongrave.textSize(25);
            Pongrave.popMatrix();
            if(Pongrave.mousePressed == true
            && Pongrave.mouseX < songbuttonx + hitbox.x/2
            && Pongrave.mouseX > songbuttonx - hitbox.x/2
            && Pongrave.mouseY < songbuttony + hitbox.y/2
            && Pongrave.mouseY > songbuttony - hitbox.y/2 && Pongrave.check == 2)
            {
                Pongrave.songnum = 1;
                Pongrave.loadAudio("RuleTheWorld.mp3");     //if it the song name is clicked in the menu it will load this song.
            }
        }
        //if songname is dooms gate, it will check what the songnumber is currently selected. if it is selected then the text will turn blue
        if(songname == "Dooms Gate")
        {
            Pongrave.pushMatrix();
            if(Pongrave.songnum == 2)
            {
                Pongrave.fill(0, 145, 255);

            }
            if(Pongrave.songnum != 2)
            {
                Pongrave.fill(0, 0, 255);
            }
            Pongrave.colorMode(HSB);
            Pongrave.textSize(fixedsize/5);   
            Pongrave.text(songname, Pongrave.width/2, Pongrave.height/2 - gap);
            Pongrave.textSize(25);
            Pongrave.popMatrix();

            if(Pongrave.mousePressed == true
            && Pongrave.mouseX < songbuttonx + hitbox.x/2
            && Pongrave.mouseX > songbuttonx - hitbox.x/2
            && Pongrave.mouseY < songbuttony + hitbox.y/2
            && Pongrave.mouseY > songbuttony - hitbox.y/2 && Pongrave.check == 2)
            {
                Pongrave.songnum = 2;
                Pongrave.loadAudio("DoomsGate.mp3");    //if it the song name is clicked in the menu it will load this song.
            }
        }
        //if songname is hero planet, it will check what the songnumber is currently selected. if it is selected then the text will turn blue
        if(songname == "Hero Planet")
        {
            Pongrave.pushMatrix();
            if(Pongrave.songnum == 3)
            {
                Pongrave.fill(0, 145, 255);

            }
            if(Pongrave.songnum != 3)
            {
                Pongrave.fill(0, 0, 255);
            }
            Pongrave.colorMode(HSB);
            Pongrave.textSize(fixedsize/5);   
            Pongrave.text(songname, Pongrave.width/2, Pongrave.height/2 - gap);
            Pongrave.textSize(25);
            Pongrave.popMatrix();

            if(Pongrave.mousePressed == true
            && Pongrave.mouseX < songbuttonx + hitbox.x/2
            && Pongrave.mouseX > songbuttonx - hitbox.x/2
            && Pongrave.mouseY < songbuttony + hitbox.y/2
            && Pongrave.mouseY > songbuttony - hitbox.y/2 && Pongrave.check == 2)
            {
                Pongrave.songnum = 3;
                Pongrave.loadAudio("heroplanet.mp3");   //if it the song name is clicked in the menu it will load this song.
            }
        }
    }

}
