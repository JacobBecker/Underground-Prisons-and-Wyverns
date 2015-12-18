package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//heal()
public class Fountain extends FountainStuff
{
	public Fountain(int x_pos, int y_pos)
	{
		type = "fountain";
		x = x_pos;
		y = y_pos;
		
		image2 = new Texture(Gdx.files.internal("assets/fountaintile.jpg"));
	}
}