package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Yes extends Answer
{
	public Yes()
	{
		x = -1;
		y = 0;
				
		image = new Texture(Gdx.files.internal("assets/Yes.png"));
	}
	
}