package ie.tudublin;

import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}
	public void Quake()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}
	public void Doom()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
	}
	public void PongRave()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Pongrave());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.PongRave();
	}
	// public static void main(String[] args)
	// {
	// 	Main main = new Main();
	// 	main.Quake();
	// }
}
