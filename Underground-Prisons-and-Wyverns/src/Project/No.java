package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class No extends Answer
{
	public No()
	{
		x = 1;
		y = 0;
				
		image = new Texture(Gdx.files.internal("assets/No.png"));
	}
	
}
