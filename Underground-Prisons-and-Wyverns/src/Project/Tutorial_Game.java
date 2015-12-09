package Project;

import java.sql.Time;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Tutorial_Game implements ApplicationListener{
	
	private SpriteBatch batch;
    private BitmapFont font;
	
	
	Stage stage;
	TextButton button;
	
	public static int WIDTH;
	public static int HEIGHT;
	public static int ROOM_WIDTH = 75;
	public static int ROOM_HEIGHT = 75;
	public static int WORLD_WIDTH = 2000;//My map didn't fit, making these bigger
	public static int WORLD_HEIGHT = 1800;
	public static int level = 0;
	
	public static int OFFSET_X;//offsets all display so that you are centered
	public static int OFFSET_Y;//offsets all display so that you are centered
	
	boolean delay = false;
	
	boolean cameraMode = false;
	int x_pos = 0;
	int y_pos = 0;
	int direction = 0;//0 = right, increasing counterclockwise
	int cam_pos_x = 0;
	int cam_pos_y = 0;
	int reset_cam_x = 0;
	int reset_cam_y = 0;
	
	Level levelList [];
	
	public static OrthographicCamera cam;
	
	Character character;
	
	SpriteBatch sb;
	Texture scroll;
	Texture terrain;
	Texture attack;
	Texture hit;
	Texture t;
	Texture right;
	Texture up;
	Texture left;
	Texture down;
	Finish portal;
	Texture gameover;
	
	public void create()
	{ 
		levelList = new Level[1];//will be changed later to different number
		levelList[0] = new Level();
		  
        font = new BitmapFont();
        font.setColor(Color.RED);
		
		character = new Character(15, 9, 14, "Jacob");
		
        /*
		try {
			character = new Character();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		gameover = new Texture(Gdx.files.internal("assets/Gameover.jpg"));
		scroll = new Texture(Gdx.files.internal("assets/scroll 2.png"));
		portal = new Finish(4,20);
		sb = new SpriteBatch();
		terrain = new Texture(Gdx.files.internal("assets/tile2.jpg"));
		attack = new Texture(Gdx.files.internal("assets/melee 2.png"));
		hit = new Texture(Gdx.files.internal("assets/hit.png"));
		right = new Texture(Gdx.files.internal("assets/character0.png"));
		up = new Texture(Gdx.files.internal("assets/character1.png"));
		left = new Texture(Gdx.files.internal("assets/character2.png"));
		down = new Texture(Gdx.files.internal("assets/character3.png"));

		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		OFFSET_X = WIDTH/2;
		OFFSET_Y = HEIGHT/2;
		cam = new OrthographicCamera(WIDTH, HEIGHT);//setting the camera to look down at the entirety of the board's dimensions (at first) as seen in Tutorial_Main
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		//It should be noted that the board's dimensions start at 0 for both x and y so the starting tile we see is at (0,0)
		cam.position.set(0,0,0);
		levelGeneration.generate(levelList[0].locs);
		
		
		BaseScreen x = new BaseScreen();
		x.render(30);
		
		//enemies
		Enemy temp = new Bat(-7,13,-8,-2,11,14); //x_spawn, y_spawn, bot_left_x, top_right_x, bot_left_y, top_right_y
		levelList[0].enems.add(temp);
		Enemy temp2 = new Goblin(4,12,3,5,11,13);
		levelList[0].enems.add(temp2);
		
		//forges
		Forge f = new Weapon_Forge(0,1,3,10);
		levelList[0].forges.add(f);
		Forge f2 = new Armor_Forge(0,-1,3,10);
		levelList[0].forges.add(f2);
		
	}
	public void render(){
		
		if(!character.isLiving)
		{
			gameOver();
			character.isLiving = true;//for now, you resurrect when you die
		}
			
		if(delay)
		{
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				//do nothing
			}
			delay = false;
		}
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
			sb.begin();		
			for(Location place:levelList[level].locs)
			{
				//displaying portal
				boolean display_finish = false;
				
				boolean display_enemy = false;
				if((Math.abs(place.x-x_pos)<=2)&&(Math.abs(place.y-y_pos)<=2)&&(place.secret==false))
				{
					place.visited=true;
				}
				if((place.secret==false)&&(place.visited==true))
				{
					sb.setColor(1,1,1,1);
					display_enemy = true;
				}
				else
				{
					if(place.visited==false)
					{
						sb.setColor(0,0,0,1);
					}
					else
					{
						sb.setColor(0,0,2,1);
						display_enemy = true;
					}
				}
				t = terrain;
				for(Forge f:levelList[level].forges)
				{
					if((place.x==f.x)&&(place.y==f.y))
					{
						t = f.image;
						sb.setColor(1,1,1,1);
					}
				}
				sb.draw(t, OFFSET_X+ROOM_WIDTH*place.x+cam_pos_x,OFFSET_Y+ROOM_HEIGHT*place.y+cam_pos_y,ROOM_WIDTH,ROOM_HEIGHT);
			
				if(display_enemy)//if there is an enemy in sight
				{
					for(Enemy e: levelList[level].enems)
					{
						if((e.current_x==place.x)&&(e.current_y==place.y))
						{
							if(e.isLiving)//enemy is alive
							{
								t = e.pic;
							}
							else//enemy is dead
							{
								t = e.deadPic;
							}
							sb.setColor(1,1,1,1);
							sb.draw(t, OFFSET_X+ROOM_WIDTH*place.x+cam_pos_x+ROOM_WIDTH/5,OFFSET_Y+ROOM_HEIGHT*place.y+cam_pos_y+ROOM_WIDTH/5,3*ROOM_WIDTH/5,3*ROOM_HEIGHT/5);
						}
					}
				}
				
				//Checking for portal in sight
				if((Math.abs(place.x-x_pos)<=2)&&(Math.abs(place.y-y_pos)<=2)&&(place.secret==false))
				{
					place.visited=true;
				}
				if((place.secret==false)&&(place.visited==true))
				{
					sb.setColor(1,1,1,1);
					display_finish = true;
				}
				else
				{
					if(place.visited==false)
					{
						sb.setColor(0,0,0,1);
					}
					else
					{
						sb.setColor(0,0,2,1);
						display_finish = true;
					}
				}
				
				//displaying portal
				if(display_finish)
				{
					if((portal.location_x==place.x)&&(portal.location_y==place.y))
						{
							t = portal.picture;
							sb.setColor(1,1,1,1);
							sb.draw(t, OFFSET_X+ROOM_WIDTH*place.x+cam_pos_x+ROOM_WIDTH/5,OFFSET_Y+ROOM_HEIGHT*place.y+cam_pos_y+ROOM_WIDTH/5,3*ROOM_WIDTH/5,3*ROOM_HEIGHT/5);
						}
				}
				
			}
			sb.setColor(1,1,1,1);
			if(character.hurt)
			{
				delay = true;
				t = hit;
				character.hurt = false;
			}
			else
			{
				t = face(direction);
			}
			sb.draw(t,OFFSET_X+25+ROOM_WIDTH*x_pos+cam_pos_x-20, OFFSET_Y+25+ROOM_WIDTH*y_pos+cam_pos_y-20,60,60);
			
			
			sb.draw(scroll, (int)(WIDTH-(ROOM_WIDTH*1.25)), (int)(HEIGHT/2-(ROOM_HEIGHT*1.5)), (int)(ROOM_WIDTH * 1.25), ROOM_HEIGHT*3);
			font.draw(sb, character.liveHP + "/" + character.maxHP, 450, HEIGHT/2);
			
			if(character.liveHP <= 0)
			{
				sb.draw(gameover, 0, 0, WIDTH, HEIGHT);

			}
			
			sb.end();
			
			if(!cameraMode)//if you haven't pressed c (camera is based on character)
			{
				if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){//if you press the right key, you move to the right once
					x_pos++;
					direction=0;
					boolean valid=false;
					for(Location place:levelList[level].locs)
					{
						if((place.x==x_pos)&&(place.y==y_pos))
						{
							valid = true;
							place.visited = true;
							for (Enemy e: levelList[level].enems)
							{
								if((e.isLiving)&&(e.current_x==x_pos)&&(e.current_y==y_pos))
								{
									valid = false;
								}
							}
						}
					}
					if(!valid)//if this movement is not possible, you do not move at all
					{
						x_pos--;
					}
					else//the camera will move based on location
					{

						reset_cam_x-=ROOM_WIDTH;
						cam_pos_x-=ROOM_WIDTH;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs);
							}
						}
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){//if you press the left arrow key, you will move to the left once
					x_pos--;
					direction=2;
					boolean valid=false;
					for(Location place:levelList[level].locs)
					{
						if((place.x==x_pos)&&(place.y==y_pos))
						{
							valid = true;
							place.visited = true;
							for (Enemy e: levelList[level].enems)
							{
								if((e.isLiving)&&(e.current_x==x_pos)&&(e.current_y==y_pos))
								{
									valid = false;
								}
							}
						}
					}
					if(!valid)//if this movement is impossible, you don't move at all
					{
						x_pos++;
					}
					else//move or leave the camera based on location
					{
						reset_cam_x+=ROOM_WIDTH;
						cam_pos_x+=ROOM_WIDTH;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs);
							}
						}
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){//if the up arrow is pressed, move up once
					y_pos++;
					direction=1;
					boolean valid=false;
					for(Location place:levelList[level].locs)
					{
						if((place.x==x_pos)&&(place.y==y_pos))
						{
							valid = true;
							place.visited = true;
							for (Enemy e: levelList[level].enems)
							{
								if((e.isLiving)&&(e.current_x==x_pos)&&(e.current_y==y_pos))
								{
									valid = false;
								}
							}
						}
					}
					if(!valid)//if this movement is not valid, don't move
					{
						y_pos--;
					}
					else//move the camera 
					{
						reset_cam_y-=ROOM_HEIGHT;
						cam_pos_y-=ROOM_HEIGHT;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs);
							}
						}
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){//if the down arrow is pressed, then move down one
					y_pos--;
					direction=3;
					boolean valid=false;
					for(Location place:levelList[level].locs)
					{
						if((place.x==x_pos)&&(place.y==y_pos))
						{
							valid = true;
							place.visited = true;
							for (Enemy e: levelList[level].enems)
							{
								if((e.isLiving)&&(e.current_x==x_pos)&&(e.current_y==y_pos))
								{
									valid = false;
								}
							}
						}
					}
					if(!valid)//if this movement is not valid, then do not move
					{
						y_pos++;
					}
					else//modify the camera
					{
						reset_cam_y+=ROOM_HEIGHT;
						cam_pos_y+=ROOM_HEIGHT;
					} 
					
					 for(Enemy e: levelList[level].enems)
					 {
					 	if(e.isLiving)
					 	{
					 		e.move(x_pos, y_pos, character, levelList[level].locs);
					 	}
					 }
					 
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.S)){//if you press s, you can move the directional arrow clockwise
					direction--;
					if(direction<0)
					{
						direction = 3;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.A)){//if you press a, you can move the directional arrow counter-clockwise
					direction = (direction+1)%4;
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
					attack();
				}
				
				cam.position.x = x_pos;
				cam.position.y = y_pos;
				cam.update();

				
				if(Gdx.input.isKeyJustPressed(Input.Keys.C)){//if you press c, you can move the camera
					cameraMode=true;
					System.out.println("Camera Mode on");
				}
			}
			else
			{
				if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){//if you press the right arrow
					cam_pos_x -= ROOM_WIDTH;
					if(cam_pos_x<=WIDTH-WORLD_WIDTH)
					{
						cam_pos_x = WIDTH-WORLD_WIDTH;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){//if you press the left arrow 
					cam_pos_x += ROOM_WIDTH;
					if(cam_pos_x>=WORLD_WIDTH)
					{
						cam_pos_x = 0;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){//if you press the up arrow
					cam_pos_y -= ROOM_HEIGHT;
					if(cam_pos_y<=HEIGHT-WORLD_HEIGHT)
					{
						cam_pos_y = HEIGHT-WORLD_HEIGHT;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){//if you press the down arrow
					cam_pos_y += ROOM_HEIGHT;
					if(cam_pos_y>=WORLD_HEIGHT)
					{
						cam_pos_y = 0;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.C)){//if you press C a second time, turn off mobile camera
					cameraMode=false;
					System.out.println("Camera Mode off");
					cam_pos_x = reset_cam_x;
					cam_pos_y = reset_cam_y;
				}
			}
	}
	public void attack()
	{
		int attack_x = x_pos;
		int attack_y= y_pos;
		if(direction==0)
		{
			attack_x++;
		}
		else if(direction==1)
		{
			attack_y++;
		}
		else if(direction==2)
		{
			attack_x--;
		}
		else
		{
			attack_y--;
		}
		boolean valid = false;
		for(Location place:levelList[level].locs)
		{
			if((place.x==attack_x)&&(place.y==attack_y))
			{
				valid = true;
			}
		}
		if(valid)
		{
			delay = true;
			sb.begin();
			sb.setColor(1,1,1,1);
			sb.draw(attack, OFFSET_X+attack_x*ROOM_WIDTH+cam_pos_x, OFFSET_Y+attack_y*ROOM_HEIGHT+cam_pos_y, ROOM_WIDTH, ROOM_HEIGHT);
			sb.end();
			//damages enemy if there is an enemy there
			for (Enemy e:levelList[level].enems)
			{
				if((e.current_x==attack_x)&&(e.current_y==attack_y))
				{
					Utilities.charAttack(character, e);
				}
			}
			for(Enemy e: levelList[level].enems)
			{
				if(e.isLiving)
				{
					e.move(x_pos, y_pos, character, levelList[level].locs);
				}
			}
		}
	}
	public void resize(int width, int height){}
	public void pause(){}
	public void resume(){}
	public void dispose()
	{
		System.out.println("You just closed the frame.");
	}
	public Texture face(int d){
		Texture r;
		switch (d){
		case 0: r = right;
		break;
		case 1: r = up;
		break;
		case 2: r = left;
		break;
		default: r = down;
		break;
		}
		return r;
	}
	public void gameOver(){
		System.out.println("Game over");//change to displaying text
		//Gdx.app.exit();//ends program
	}
}
