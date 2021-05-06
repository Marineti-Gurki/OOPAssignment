# Music Visualiser Project

Name: Matiss Priednieks

Student Number: C19340106

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
- This assignments prompt was as such: "Something beautiful to enjoy while listening to music."
- I first had planned to create multiple visuals to switch between, with some amount of user interactivity. 
  However, I changed my mind as I figured it would be more interesting and beneficial to learn how to create a functional game.
  I decided on creating the game pong with interesting and aesthetically pleasing visuals, and a main menu system with functional
  settings menus and a song selection menu. I was also going to create another game on top of this, however, I decided to instead polish
  and refine what I already had.

# Instructions
- When the game is launched, you will be greeted by a main menu screen with 4 buttons on it: Play, Songs, Settings and Exit.
![An image](images/Menu.png)
- Play: This will start the game of Pong and start playing whatever music is selected, and by default will play "Everybody Wants to Rule the World"
- Songs: This will go into a menu where you can select 3 songs: Everybody Wants to Rule the World, At Dooms Gate and Hero Planet. Only one can be selected at a time.
- Settings: This will bring you to a settings menu where you can adjust a few variables in the game, such as the puck starting speed and it's speed increase after each paddle hit. Can also change volume and mute the music.
- Exit: Exits the game.

# How it works



# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

