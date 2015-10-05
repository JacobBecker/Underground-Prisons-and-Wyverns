package Project;

import com.badlogic.gdx.ApplicationListener;

public class Tutorial_Game implements ApplicationListener {
	public void create(){
		System.out.println("The frame was created successfully.");
	}
	public void render(){}
	public void resize(int width, int height){}
	public void pause(){}
	public void resume(){}
	public void dispose(){
		System.out.println("You just closed the frame.");
	}
}
