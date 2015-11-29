package Project;

import com.badlogic.gdx.graphics.Texture;

public class Enemy 
{
	int start_x;
	int start_y;
	int current_x;
	int current_y;
	int armor;
	int HP;
	int numOfDice;
	int diceSides;
	String name;
	boolean isLiving = true;
	Texture pic;
	Texture deadPic;
	/*
	public void setEnemy(String n, int h, int d, int de)
	{
		name = n;
		hp = h;
		damage = d;
		defense = de;
	}
	*/
	public void move(int character_x, int character_y)
	{
		//enemy movement
	}
}
