package Project;

import com.badlogic.gdx.graphics.Texture;

public abstract class Forge {
	String type;
	int x;
	int y;
	int cost;
	int benefit = 1;
	Texture image;
	abstract boolean shop();
}
