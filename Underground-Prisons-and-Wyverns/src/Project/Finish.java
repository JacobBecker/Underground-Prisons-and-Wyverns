package Project; 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Finish
{
	int location_x;
	int location_y;
	Texture picture = new Texture(Gdx.files.internal("assets/portal.png"));
	public Finish(int x, int y)
	{
		location_x = x;
		location_y = y;
	}

}
