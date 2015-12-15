package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Weapon_Forge extends Forge {

	public Weapon_Forge(int x_pos, int y_pos, int b, int v){
		
		type = "weapon";
		
		x = x_pos;
		y = y_pos;
		benefit = b;
		variance = v;
		cost = 10*benefit-variance+(int)(Math.random()*2*variance);
		
		image = new Texture(Gdx.files.internal("assets/Weapon Rack 2.jpg"));
	}
	@Override
	boolean shop() {
		//check user's decision and return
		return false;
	}

}
