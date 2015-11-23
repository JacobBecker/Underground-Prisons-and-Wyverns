package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import Project.Tutorial_Game;

public class Tutorial_Main {
	public static void main(String args[]){
		
		//Character character = new Character();
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Underground Prisons and Wyverns";//title that shows on the top of the window
		cfg.width = 500;//width of the window in which the game is displayed
		cfg.height = 400;//height--
		
		new LwjglApplication(new Tutorial_Game(), cfg);
	}
}
