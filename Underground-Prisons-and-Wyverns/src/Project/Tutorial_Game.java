package Project;

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

/*
 * 
 * HEY EVERYONE! YOU CAN PRESS X TO SKIP LEVELS, FOR TESTING PURPOSES.
 * 
 */


public class Tutorial_Game implements ApplicationListener{
	
	Forge currentForge;
	int currentLevel;
	int current_cam_x;
	int current_cam_y;
	
    private BitmapFont font;
	
	
	Stage stage;
	TextButton button;
	
	public static int WIDTH;
	public static int HEIGHT;
	public static int TILE_WIDTH = 75;
	public static int TILE_HEIGHT = 75;
	public static int WORLD_WIDTH = 2000;//My map didn't fit, making these bigger
	public static int WORLD_HEIGHT = 2000;
	public static int level = 1;
	public static int finalLevel = 7;
	
	public static int OFFSET_X;//offsets all display so that you are centered
	public static int OFFSET_Y;//offsets all display so that you are centered
	
	boolean delay = false;
	boolean shopDelay = false;
	boolean firstDeath = false;
	boolean firstWin = false;
	
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
	Texture box;
	Texture scroll;
	Texture terrain;
	Texture attack;
	Texture hit;
	Texture n;
	Texture t;
	Texture right;
	Texture up;
	Texture left;
	Texture down;
	Finish portal;
	Texture gameover;
	Texture win;
	
	public void create()
	{ 
		
		levelList = new Level[finalLevel];//will be changed later to different number
		for(int i=0; i<finalLevel; i++)
		{
			levelList[i] = new Level();
		}
		
				
        font = new BitmapFont();
        font.setColor(Color.RED);
        	
		character = new Character(15, 15, 14, "Jacob");
		
        
		/*try {
			character = new Character();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		box = new Texture(Gdx.files.internal("assets/White Box.JPG"));
		gameover = new Texture(Gdx.files.internal("assets/Gameover.jpg"));
		win = new Texture(Gdx.files.internal("assets/win.jpg"));
		scroll = new Texture(Gdx.files.internal("assets/scroll 2.png"));
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
		OFFSET_X = WIDTH/2 - 50;
		OFFSET_Y = HEIGHT/2;
		cam = new OrthographicCamera(WIDTH, HEIGHT);//setting the camera to look down at the entirety of the board's dimensions (at first) as seen in Tutorial_Main
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		//It should be noted that the board's dimensions start at 0 for both x and y so the starting tile we see is at (0,0)
		cam.position.set(0,0,0);
		
		//finishes
		levelList[0].portal = new Finish(20,20);
		levelList[1].portal = new Finish(4,20);
		levelList[2].portal = new Finish(5,5);

		levelList[4].portal = new Finish(0,-2);

		levelList[3].portal = new Finish(17,-1);
		
		levelList[5].portal = new Finish(0,23);
		levelList[6].portal = new Finish(11,15);
		
		//locations
		levelGeneration.generateYesNo(levelList[0].locs);
		levelGeneration.generate(levelList[1].locs);
		levelGeneration.generate2(levelList[2].locs);
		levelGeneration.generate3(levelList[3].locs);
		levelGeneration.generate4(levelList[4].locs);
		levelGeneration.generate5(levelList[5].locs);
		levelGeneration.generate6(levelList[6].locs);
		
		BaseScreen x = new BaseScreen();
		x.render(30);
		
		//Don't worry about it
		
		//enemies
		Enemy temp = new Bat(-7,13,-8,-2,11,14); //x_spawn, y_spawn, bot_left_x, top_right_x, bot_left_y, top_right_y
		levelList[1].enems.add(temp);
		Enemy temp2 = new Bat(-4,14,-8,-2,11,14);
		levelList[1].enems.add(temp2);
		Enemy temp3 = new Goblin(4,12,3,5,11,13);
		levelList[1].enems.add(temp3);
		Enemy temp4 = new Goblin(-6,4,-7,-4,4,7);
		levelList[1].enems.add(temp4);
		Enemy temp5 = new Bat(7,-1,7,15,-2,2);
		levelList[1].enems.add(temp5);
		Enemy temp6 = new Goblin (11,2,7,15,-2,2);
		levelList[1].enems.add(temp6);
		Enemy temp7 = new Goblin (13,0,7,15,-2,2);
		levelList[1].enems.add(temp7);
		
		levelList[2].enems.add(new Slime(4,4,0,5,0,5));
		levelList[2].enems.add(new Slime(5,5,0,5,0,5));
		

		//hallways
		levelList[4].enems.add(new Slime(4,10,4,4,10,10));
		levelList[4].enems.add(new Slime(-4,10,-4,-4,10,10));
		//middle room
		levelList[4].enems.add(new Slime(0,6,-1,1,4,6));
		levelList[4].enems.add(new Goblin(0,5,-1,1,4,6));
		//left pocket
		levelList[4].enems.add(new Goblin(-7,5,-7,-6,4,6));
		levelList[4].enems.add(new Slime(-6,5,-7,-6,4,6));
		//right pocket
		levelList[4].enems.add(new MetalSlime(8,5,7,8,4,6));
		//bottom left
		levelList[4].enems.add(new Goblin(-6,-1,-6,-4,-3,-1));
		levelList[4].enems.add(new Bat(-5,-2,-6,-4,-3,-1));
		//bottom right
		levelList[4].enems.add(new Goblin(6,-1,4,6,-3,-1));
		levelList[4].enems.add(new Bat(5,-2,4,6,-3,-1));
		//bottom middle
		levelList[4].enems.add(new Bat(-1,-3,-1,-1,-3,-3));
		levelList[4].enems.add(new Bat(1,-3,1,1,-3,-3));

		levelList[3].enems.add(new Snake(-1,6,-2,3,5,8));//room above spawn
		levelList[3].enems.add(new BlackSmoke(2,7,-2,3,5,8));
		levelList[3].enems.add(new Snake(-8,8,-11,-8,8,12));//most left room
		levelList[3].enems.add(new Snake(-11,11,-11,-8,8,12));
		levelList[3].enems.add(new BlackSmoke(12,9,10,12,5,9));//top right room
		levelList[3].enems.add(new BlackSmoke(6,1,5,9,-2,2));//room right of spawn
		levelList[3].enems.add(new Snake(1,7,-2,2,-9,-6));//room below spawn
		levelList[3].enems.add(new BlackSmoke(-1,-8,-2,2,-9,-6));
		levelList[3].enems.add(new Snake(1,-9,-2,2,-9,-6));
		levelList[3].enems.add(new Snake(14,0,13,17,-3,1));//portal room
		levelList[3].enems.add(new Snake(17,1,13,17,-3,1));
		levelList[3].enems.add(new Snake(17,-3,13,17,-3,1));
		
		//first room
		levelList[5].enems.add(new Bat(-2,0,-2,2,-2,2));
		levelList[5].enems.add(new Bat(2,0,-2,2,-2,2));
		levelList[5].enems.add(new Bat(0,2,-2,2,-2,2));
		levelList[5].enems.add(new Bat(0,-2,-2,2,-2,2));
		//left room
		levelList[5].enems.add(new Goblin(-7,0,-9,-6,-1,1));
		//left side room
		levelList[5].enems.add(new Goblin(-11,5,-12,-10,4,6));
		//upper left room
		levelList[5].enems.add(new Bat(-9,12,-9,-5,10,12));
		levelList[5].enems.add(new Bat(-5,12,-9,-5,10,12));
		levelList[5].enems.add(new GiantFerret(-8,11,-9,-5,10,12));
		levelList[5].enems.add(new GiantFerret(-6,11,-9,-5,10,12));
		//right room
		levelList[5].enems.add(new Goblin(7,0,6,9,-1,1));
		levelList[5].enems.add(new Slime(9,0,9,9,0,0));
		//right side room
		levelList[5].enems.add(new Bat(10,4,10,12,4,6));
		levelList[5].enems.add(new Bat(10,6,10,12,4,6));
		levelList[5].enems.add(new Bat(11,5,10,12,4,6));
		//upper right room
		levelList[5].enems.add(new GiantFerret(7,11,5,9,10,12));
		//top room
		levelList[5].enems.add(new Goblin(-1,18,-5,5,18,23));
		levelList[5].enems.add(new Goblin(1,18,-5,5,18,23));
		levelList[5].enems.add(new Bat(-5,20,-5,5,18,23));
		levelList[5].enems.add(new Bat(-5,21,-5,5,18,23));
		levelList[5].enems.add(new Bat(-5,22,-5,5,18,23));
		levelList[5].enems.add(new Bat(5,20,-5,5,18,23));
		levelList[5].enems.add(new Bat(5,21,-5,5,18,23));
		levelList[5].enems.add(new Bat(5,22,-5,5,18,23));
		levelList[5].enems.add(new GiantFerret(-1,23,-5,5,18,23));
		levelList[5].enems.add(new GiantFerret(1,23,-5,5,18,23));
		//middle room/ secret
		levelList[5].enems.add(new MetalSlime(0,9,-2,2,5,9));
		levelList[5].enems.add(new MetalSlime(1,9,-2,2,5,9));
		levelList[5].enems.add(new MetalSlime(2,9,-2,2,5,9));
		levelList[5].enems.add(new Goblin(0,5,-2,2,5,9));
		levelList[5].enems.add(new Goblin(1,6,-2,2,5,9));
		levelList[5].enems.add(new Goblin(2,7,-2,2,5,9));
		levelList[5].enems.add(new Slime(1,5,-2,2,5,9));
		levelList[5].enems.add(new Slime(2,6,-2,2,5,9));
		//bat room/ secret
		levelList[5].enems.add(new Bat(16,0,15,17,0,2));
		levelList[5].enems.add(new Bat(16,2,15,17,0,2));
		levelList[5].enems.add(new Bat(17,0,15,17,0,2));
		levelList[5].enems.add(new Bat(17,1,15,17,0,2));
		levelList[5].enems.add(new Bat(17,2,15,17,0,2));
		//slime room
		levelList[5].enems.add(new Slime(8,-4,7,9,-7,-4));
		levelList[5].enems.add(new Slime(7,-5,7,9,-7,-5));
		levelList[5].enems.add(new Slime(9,-5,7,9,-7,-5));
		levelList[5].enems.add(new Slime(7,-7,7,9,-7,-5));
		levelList[5].enems.add(new Slime(9,-7,7,9,-7,-5));
		levelList[5].enems.add(new BigSlime(8,-6,8,8,-6,-6));
		//extra room/ secret
		levelList[5].enems.add(new MetalSlime(7,-12,6,8,-12,-10));
		
		//first hall
		levelList[6].enems.add(new Snake(9,3,6,9,3,3));
		levelList[6].enems.add(new Bat(14,3,10,14,3,3));
		//second hall
		levelList[6].enems.add(new Slime(18,5,18,18,3,7));
		//third hall
		levelList[6].enems.add(new BigSlime(15,7,15,17,7,7));
		levelList[6].enems.add(new MetalSlime(11,7,11,14,7,7));
		levelList[6].enems.add(new Snake(3,7,3,10,7,7));
		//fourth hall
		levelList[6].enems.add(new BlackSmoke(3,13,3,3,8,13));
		levelList[6].enems.add(new Snake(3,17,3,3,14,17));
		//fifth hall
		levelList[6].enems.add(new Bat(5,22,3,5,22,22));
		levelList[6].enems.add(new Bat(9,22,6,9,22,22));
		levelList[6].enems.add(new Bat(13,22,10,13,22,22));
		//Bat Cave
		levelList[6].enems.add(new Bat(4,29,3,5,29,30));
		levelList[6].enems.add(new Bat(7,29,6,8,29,30));
		levelList[6].enems.add(new Bat(5,31,3,5,30,31));
		levelList[6].enems.add(new Bat(6,31,6,8,30,31));
		levelList[6].enems.add(new Bat(3,32,3,5,31,32));
		levelList[6].enems.add(new Bat(8,32,6,8,31,32));
		//Snakes and Slime room
		levelList[6].enems.add(new Slime(15,24,15,15,22,24));
		levelList[6].enems.add(new Slime(19,24,16,19,24,24));
		levelList[6].enems.add(new Slime(23,25,22,24,24,26));
		levelList[6].enems.add(new Slime(25,25,24,26,24,26));
		levelList[6].enems.add(new Slime(28,25,27,29,24,26));
		levelList[6].enems.add(new MetalSlime(25,27,22,29,24,30));
		levelList[6].enems.add(new BigSlime(23,29,22,24,28,30));
		levelList[6].enems.add(new Slime(25,29,24,26,28,30));
		levelList[6].enems.add(new BigSlime(28,29,27,29,28,30));
		//sixth hall
		levelList[6].enems.add(new Slime(16,15,16,16,15,18));
		//seventh hall
		levelList[6].enems.add(new Snake(14,11,14,16,11,11));
		levelList[6].enems.add(new Snake(10,11,10,13,11,11));
		//eighth hall
		levelList[6].enems.add(new BlackSmoke(7,14,7,7,11,14));
		//final hall
		levelList[6].enems.add(new Bat(8,18,7,8,18,18));
		levelList[6].enems.add(new Snake(9,18,9,9,18,18));
		levelList[6].enems.add(new Slime(10,18,10,10,18,18));
		
		
		//forges
		levelList[1].forges.add(new Weapon_Forge(0,1,5));
		levelList[1].forges.add(new Armor_Forge(0,-1,5));
		
		levelList[2].forges.add(new Weapon_Forge(0,4,7));
		levelList[2].forges.add(new Armor_Forge(0,5,7));
		
		levelList[4].forges.add(new Weapon_Forge(-7,4,45));
		levelList[4].forges.add(new Armor_Forge(-7,6,45));

		levelList[3].forges.add(new Weapon_Forge(2,-2,70));
		levelList[3].forges.add(new Weapon_Forge(1,-15,70));
		levelList[3].forges.add(new Armor_Forge(-2,2,70));
		
<<<<<<< HEAD
		levelList[5].forges.add(new Weapon_Forge(-12,5,250));
		levelList[5].forges.add(new Weapon_Forge(9,12,250));
		levelList[5].forges.add(new Weapon_Forge(2,5,220));//this is very hidden should be cheaper
		levelList[5].forges.add(new Armor_Forge(-7,12,230));//this is slightly hidden should be slightly cheaper
		levelList[5].forges.add(new Armor_Forge(12,5,250));
=======
		levelList[5].forges.add(new Weapon_Forge(-12,5,160));
		levelList[5].forges.add(new Weapon_Forge(9,12,160));
		levelList[5].forges.add(new Weapon_Forge(2,5,130));//this is very hidden should be cheaper
		levelList[5].forges.add(new Armor_Forge(-7,12,150));//this is slightly hidden should be slightly cheaper
		levelList[5].forges.add(new Armor_Forge(12,5,160));
>>>>>>> branch 'master' of https://github.com/JacobBecker/Underground-Prisons-and-Wyverns.git
		
		levelList[6].forges.add(new Armor_Forge(17,20,320));
		levelList[6].forges.add(new Weapon_Forge(1,20,320));
		
		//fountains
		levelList[1].fountains.add(new Fountain(-1, 0));
		
		levelList[3].fountains.add(new Fountain(1,-14));
		
		levelList[4].fountains.add(new Fountain(0,1));
		
		levelList[5].fountains.add(new Fountain(-9,0));
		levelList[5].fountains.add(new Fountain(-2,8));
		
		levelList[6].fountains.add(new Fountain(5,1));
	}
	public void render(){
		
		if(firstWin)
		{
			win();
		}
		if(shopDelay)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				//do nothing
			}
			level = currentLevel;
			
			cam_pos_x =current_cam_x;
			cam_pos_y = current_cam_y;
			reset_cam_x = current_cam_x;
			reset_cam_y = current_cam_y;
			
			x_pos = currentForge.x;
			y_pos = currentForge.y;
			shopDelay = false;

		}
		if(firstDeath)
		{
			gameOver();
		}
		if(!character.isLiving)
		{
			sb.begin();
			sb.draw(gameover, 0, 0, WIDTH, HEIGHT);
			sb.end();
			firstDeath = true;
			//character.isLiving = true;//for now, you resurrect when you die
		}
		else
		{
		
		if((x_pos==levelList[level].portal.location_x)&&(y_pos==levelList[level].portal.location_y))
		{
			x_pos=0;
			y_pos=0;
			cam_pos_x = 0;
			reset_cam_x = 0;
			cam_pos_y = 0;
			reset_cam_y = 0;
			level++;
		
			if(level==finalLevel)
			{
				level--;
				firstWin = true;
			}
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
						sb.setColor(1,1,1,1);
						display_enemy = true;
					}
				}
				t = terrain;
				for(Forge f:levelList[level].forges)
				{
					if((place.x==f.x)&&(place.y==f.y))
					{
						t = f.image;
						//sb.setColor(1,1,1,1);
					}
				}
				
				
				for(FountainStuff a:levelList[level].fountains)
				{
					if((place.x==a.x)&&(place.y==a.y))
					{
						t = a.image2;
					}
				}
				
				
					
				sb.draw(t, OFFSET_X+TILE_WIDTH*place.x+cam_pos_x,OFFSET_Y+TILE_HEIGHT*place.y+cam_pos_y,TILE_WIDTH,TILE_HEIGHT);
				
				//Jacob's special level
				if(level == 0)
				{
					direction = 0; 
					sb.draw(t, OFFSET_X+TILE_WIDTH*place.x+cam_pos_x,OFFSET_Y+TILE_HEIGHT*place.y+cam_pos_y,TILE_WIDTH,TILE_HEIGHT);
					sb.draw(box, 125, 275, TILE_WIDTH*3, TILE_HEIGHT*2);
					
					font.draw(sb, "You may spend " + currentForge.cost + " gold \n" +
								  "To upgrade your " + currentForge.type + "\n" +
								  "Would you like to? \n" +
								  "(Y)es or (N)o",150, 400);
					
					
					if(Gdx.input.isKeyJustPressed(Input.Keys.Y))
					{
						if(character.gold >= currentForge.cost)
						{
							if(currentForge.type.equals("armor"))
							{
								Utilities.upgradeArmor(currentForge, character);
							}
							if(currentForge.type.equals("weapon"))
							{
								Utilities.upgradeWeapon(currentForge, character);
							}
							level = currentLevel;
							
							x_pos = currentForge.x;
							y_pos = currentForge.y;
														
							cam_pos_x =current_cam_x;
							cam_pos_y = current_cam_y;
							reset_cam_x = current_cam_x;
							reset_cam_y = current_cam_y;
						}
						else
						{
							sb.draw(box, 125, 275, TILE_WIDTH*3, TILE_HEIGHT*2);
							font.draw(sb, "You need " + (currentForge.cost - character.gold) + " more gold ",150, 400);
							shopDelay = true;
							
						}
					}
					else if(Gdx.input.isKeyJustPressed(Input.Keys.N))
					{
						level = currentLevel;
						
						x_pos = currentForge.x;
						y_pos = currentForge.y;
						
						cam_pos_x =current_cam_x;
						cam_pos_y = current_cam_y;
						reset_cam_x = current_cam_x;
						reset_cam_y = current_cam_y;

					}
				}

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
							sb.draw(t, OFFSET_X+TILE_WIDTH*place.x+cam_pos_x+TILE_WIDTH/5,OFFSET_Y+TILE_HEIGHT*place.y+cam_pos_y+TILE_WIDTH/5,3*TILE_WIDTH/5,3*TILE_HEIGHT/5);
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
					if((levelList[level].portal.location_x==place.x)&&(levelList[level].portal.location_y==place.y))
						{
							t = levelList[level].portal.picture;
							sb.setColor(1,1,1,1);
							sb.draw(t, OFFSET_X+TILE_WIDTH*place.x+cam_pos_x+TILE_WIDTH/5,OFFSET_Y+TILE_HEIGHT*place.y+cam_pos_y+TILE_WIDTH/5,3*TILE_WIDTH/5,3*TILE_HEIGHT/5);
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
			sb.draw(t,OFFSET_X+25+TILE_WIDTH*x_pos+cam_pos_x-20, OFFSET_Y+25+TILE_WIDTH*y_pos+cam_pos_y-20,60,60);
			
			sb.draw(scroll, (int)(WIDTH-(TILE_WIDTH*1.5)), (int)(HEIGHT/2-(TILE_HEIGHT *2)), (int)(TILE_WIDTH * 1.5), TILE_HEIGHT*4);
			font.draw(sb, character.name, 410, 300);
			font.draw(sb,character.line, 410, 299);
			font.draw(sb, character.chosenclass + "\nLevel: " + character.level + "\nHP: " + character.liveHP + "/" + character.maxHP + "\nGold: "+ character.gold + "\nExp: " + character.exp + "\nDmg: " + character.atkDiceSides + "\nDef: " + character.defence,410, 270);
			
			sb.end();
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
			{
				character.showHelp();
			}
			if(!cameraMode)//if you haven't pressed c (camera is based on character)
			{
				if(Gdx.input.isKeyJustPressed(Input.Keys.X))
				{
					x_pos = levelList[level].portal.location_x;
					y_pos = levelList[level].portal.location_y;
				}
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

						reset_cam_x-=TILE_WIDTH;
						cam_pos_x-=TILE_WIDTH;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs, levelList[level].enems);
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
						reset_cam_x+=TILE_WIDTH;
						cam_pos_x+=TILE_WIDTH;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs, levelList[level].enems);
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
						reset_cam_y-=TILE_HEIGHT;
						cam_pos_y-=TILE_HEIGHT;
						for(Enemy e: levelList[level].enems)
						{
							if(e.isLiving)
							{
								e.move(x_pos, y_pos, character, levelList[level].locs, levelList[level].enems);
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
						reset_cam_y+=TILE_HEIGHT;
						cam_pos_y+=TILE_HEIGHT;
					} 
					
					 for(Enemy e: levelList[level].enems)
					 {
					 	if(e.isLiving)
					 	{
					 		e.move(x_pos, y_pos, character, levelList[level].locs, levelList[level].enems);
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
				if(Gdx.input.isKeyJustPressed(Input.Keys.I))
				{
					checkShop();
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.H))
				{
					for(FountainStuff a: levelList[level].fountains)
					{
						if((a.x==x_pos)&&(a.y==y_pos))
						{
							Utilities.heal(character);
						}
					}
					
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
					cam_pos_x -= TILE_WIDTH;
					if(cam_pos_x<=WIDTH-WORLD_WIDTH)
					{
						cam_pos_x = WIDTH-WORLD_WIDTH;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){//if you press the left arrow 
					cam_pos_x += TILE_WIDTH;
					if(cam_pos_x>=WORLD_WIDTH)
					{
						cam_pos_x = 0;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){//if you press the up arrow
					cam_pos_y -= TILE_HEIGHT;
					if(cam_pos_y<=HEIGHT-WORLD_HEIGHT)
					{
						cam_pos_y = HEIGHT-WORLD_HEIGHT;
					}
				}
				if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){//if you press the down arrow
					cam_pos_y += TILE_HEIGHT;
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
			if(firstWin)
			{
				sb.begin();
				sb.draw(win, 0, 0, WIDTH, HEIGHT);
				sb.end();
			}
		}//end of living loop here
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
			sb.draw(attack, OFFSET_X+attack_x*TILE_WIDTH+cam_pos_x, OFFSET_Y+attack_y*TILE_HEIGHT+cam_pos_y, TILE_WIDTH, TILE_HEIGHT);
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
					e.move(x_pos, y_pos, character, levelList[level].locs, levelList[level].enems);
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
	public void checkShop()
	{
		for(Forge f: levelList[level].forges)
		{
			if((f.x==x_pos)&&(f.y==y_pos))
			{
				currentLevel = level;
				currentForge = f;
				level = 0;
				x_pos = 0;
				y_pos = 0;
				
				current_cam_x = cam_pos_x;
				current_cam_y = cam_pos_y;
				
				cam_pos_x = 0;
				cam_pos_y = 0;
				reset_cam_x = 0;
				reset_cam_y = 0;
			}
		}
	}
	public void gameOver(){
		System.out.println("Game over");//change to displaying text
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			//do nothing
		}
		Gdx.app.exit();//ends program
	}
	public void win(){
		System.out.println("You win");//change to displaying text
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			//do nothing
		}
		Gdx.app.exit();//ends program
	}
}
