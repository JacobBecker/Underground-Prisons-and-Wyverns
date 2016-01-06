package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Weapon_Forge extends Forge {

	public Weapon_Forge(int x_pos, int y_pos, int c){
		
		type = "weapon";
		
		x = x_pos;
		y = y_pos;
		cost = c;	
		image = new Texture(Gdx.files.internal("assets/Weapon Rack 2.jpg"));
	}
	@Override
	boolean shop() {
		//check user's decision and return
		return false;
	}

}
