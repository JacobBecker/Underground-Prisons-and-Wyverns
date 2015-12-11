package Project;

import com.badlogic.gdx.graphics.Texture;

public abstract class Forge {
	String type;
	int x;
	int y;
	int cost;
	int benefit;
	int variance;
	Texture image;
	abstract boolean shop();
}
