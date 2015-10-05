package Project;

import Project.Tutorial_Game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Tutorial_Main {
	public static void main(String args[]){
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Sample Title";
		cfg.width = 500;
		cfg.height = 400;
		
		new LwjglApplication(new Tutorial_Game(), cfg);
	}
}
