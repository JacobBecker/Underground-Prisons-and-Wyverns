package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import Project.Tutorial_Game;

public class Tutorial_Main {
	public static void main(String args[]){
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Sample Title";
		cfg.width = 500;
		cfg.height = 400;
		
		new LwjglApplication(new Tutorial_Game(), cfg);

		MyTextInputListener listener = new MyTextInputListener();
		Gdx.input.getTextInput(listener, "Dialog Title", "Test Text", null);
	}
}
