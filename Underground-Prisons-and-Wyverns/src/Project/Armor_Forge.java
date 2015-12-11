package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Armor_Forge extends Forge {

	public Armor_Forge(int x_pos, int y_pos, int b, int v){
		
		type = "armor";
		
		x = x_pos;
		y = y_pos;
		benefit = b;
		variance = v;
		cost = 100*benefit-variance+(int)(Math.random()*2*variance);
		
		image = new Texture(Gdx.files.internal("assets/Anvil 2.jpg"));
	}
	@Override
	boolean shop() {
		//check user's decision and return
		return false;
	}

}
