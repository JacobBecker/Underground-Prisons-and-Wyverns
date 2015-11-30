package Project; 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Finish
{
	int location_x;
	int location_y;
	Texture picture;
	public Finish(int x, int y)
	{
		int location_x = x;
		int location_y = y;
		Texture picture = new Texture(Gdx.files.internal("assets/portal.png"));
	}

}
