package Project;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Tutorial_Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	public static int ROOM_WIDTH = 50;
	public static int ROOM_HEIGHT = 50;
	public static int WORLD_WIDTH = 1000;//boundaries of world; for now, 2W
	public static int WORLD_HEIGHT = 800;//for now, 2H
	
	boolean cameraMode = false;
	int x_pos = 0;
	int y_pos = 0;
	int direction = 0;//0 = right, increasing counterclockwise
	int cam_pos_x = 0;
	int cam_pos_y = 0;
	int reset_cam_x = 0;
	int reset_cam_y = 0;
	ArrayList<Location> locs = new ArrayList<Location>();
	public static OrthographicCamera cam;
	
	public void create(){
		//System.out.println("The frame was created successfully.");
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(WIDTH, HEIGHT);//setting the camera to look down at the entirety of the board's dimensions (at first) as seen in Tutorial_Main
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		//It should be noted that the board's dimensions start at 0 for both x and y so the starting tile we see is at (0,0)
		for(int i=0; i<15; i++){
			locs.add(new Location(i,0));//Adding 14 yellow tiles going in the horizontal or x direction
		}
		for(int i=0; i<12; i++){
			locs.add(new Location(1,i));//Adding 11 yellow tiles going in the y direction
		}
		locs.add(new Location(4,1));
		
		//secret places
		locs.add(new Location(2,2,true));
		locs.add(new Location(3,2,true));
		locs.add(new Location(4,2,true));
		//Gdx.graphics.setContinuousRendering(false);
		//System.out.println("X: "+cam_pos_x+"/n"+"Y: "+cam_pos_y);
	}
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		ShapeRenderer sr = new ShapeRenderer();
		sr.begin(ShapeType.Filled);
		for(Location place:locs)
		{
			if((Math.abs(place.x-x_pos)<=2)&&(Math.abs(place.y-y_pos)<=2)&&(place.secret==false))
			{
				place.visited=true;
			}
			if((place.secret==false)&&(place.visited==true))//if the place isn't secret and you've been there
			{
				sr.setColor(1,1,0,1);
			}
			else
			{
				if(place.visited==false)
					sr.setColor(0,0,0,1);
				else
					sr.setColor(0,0,2,1);
			}
			sr.rect(ROOM_WIDTH*place.x+cam_pos_x,ROOM_HEIGHT*place.y+cam_pos_y,ROOM_WIDTH,ROOM_HEIGHT);
		}
		sr.setColor(1,0,0,1);
		sr.circle(25+ROOM_WIDTH*x_pos+cam_pos_x, 25+ROOM_WIDTH*y_pos+cam_pos_y, 5);//pretty sure this is the little character circle
		if(direction==0)
		{
			//the little triangle showing you which way you're going/facing
			sr.triangle(25+ROOM_WIDTH*x_pos+cam_pos_x+ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y-ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x+ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y+ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x+2*ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y);
		}
		else if(direction==1)
		{
			//the little triangle showing you which way you're going/facing
			sr.triangle(25+ROOM_WIDTH*x_pos+cam_pos_x-ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y+ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x+ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y+ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x, 25+ROOM_WIDTH*y_pos+cam_pos_y+2*ROOM_HEIGHT/5);
		}
		else if(direction==2)
		{
			//the little triangle showing you which way you're going/facing
			sr.triangle(25+ROOM_WIDTH*x_pos+cam_pos_x-ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y-ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x-ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y+ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x-2*ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y);
		}
		else
		{
			//the little triangle showing you which way you're going/facing
			sr.triangle(25+ROOM_WIDTH*x_pos+cam_pos_x-ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y-ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x+ROOM_WIDTH/5, 25+ROOM_WIDTH*y_pos+cam_pos_y-ROOM_HEIGHT/5, 25+ROOM_WIDTH*x_pos+cam_pos_x, 25+ROOM_WIDTH*y_pos+cam_pos_y-2*ROOM_HEIGHT/5);
		}
		sr.end();
		
		sr.begin(ShapeType.Line);
		sr.setColor(0,0,0,1);
		for(Location place:locs)
		{
			sr.rect(ROOM_WIDTH*place.x+cam_pos_x,ROOM_HEIGHT*place.y+cam_pos_y,ROOM_WIDTH,ROOM_HEIGHT);
		}
		sr.end();
		if(!cameraMode)//if you haven't pressed c (camera is based on character)
		{
			if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){//if you press the right key, you move to the right once
				x_pos++;
				direction=0;
				boolean valid=false;
				for(Location place:locs)
				{
					if((place.x==x_pos)&&(place.y==y_pos))
					{
						valid = true;
						place.visited = true;
					}
				}
				if(!valid)//if this movement is not possible, you do not move at all
				{
					x_pos--;
				}
				else//if the movement is valid, the camera will move based on location
				{
					if(x_pos+reset_cam_x/ROOM_WIDTH>=WIDTH/ROOM_WIDTH)//!
					{
						reset_cam_x-=ROOM_WIDTH;
						cam_pos_x-=ROOM_WIDTH;
					}
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){//if you press the left arrow key, you will move to the left once
				x_pos--;
				direction=2;
				boolean valid=false;
				for(Location place:locs)
				{
					if((place.x==x_pos)&&(place.y==y_pos))
					{
						valid = true;
						place.visited = true;
					}
				}
				if(!valid)//if this movement is impossible, you don't move at all
				{
					x_pos++;
				}
				else//if it is valid, move or leave the camera based on location
				{
					if(-1*reset_cam_x/ROOM_WIDTH>x_pos)
					{
						reset_cam_x+=ROOM_WIDTH;
						cam_pos_x+=ROOM_WIDTH;
					}
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){//if the up arrow is pressed, move up once
				y_pos++;
				direction=1;
				boolean valid=false;
				for(Location place:locs)
				{
					if((place.x==x_pos)&&(place.y==y_pos))
					{
						valid = true;
						place.visited = true;
					}
				}
				if(!valid)//if this movement is not valid, don't move
				{
					y_pos--;
				}
				else//if the movement is valid move the camera 
				{
					if(y_pos+reset_cam_y/ROOM_HEIGHT>=HEIGHT/ROOM_HEIGHT)
					{
						reset_cam_y-=ROOM_HEIGHT;
						cam_pos_y-=ROOM_HEIGHT;
					}
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){//if the down arrow is pressed, then move down one
				y_pos--;
				direction=3;
				boolean valid=false;
				for(Location place:locs)
				{
					if((place.x==x_pos)&&(place.y==y_pos))
					{
						valid = true;
						place.visited = true;
					}
				}
				if(!valid)//if this movement is not valid, then do not move
				{
					y_pos++;
				}
				else//if it is valid, modify the camera
				{
					if(-1*reset_cam_y/ROOM_HEIGHT>y_pos)
					{
						reset_cam_y+=ROOM_HEIGHT;
						cam_pos_y+=ROOM_HEIGHT;
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
			if(Gdx.input.isKeyJustPressed(Input.Keys.C)){//if you press c, you can move the camera
				cameraMode=true;
				System.out.println("Camera Mode on");
				//reset_cam_x = cam_pos_x;
				//reset_cam_y = cam_pos_y;
			}
		}
		else
		{
			if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){//if you press the right arrow
				//System.out.println("X: "+cam_pos_x+"/n"+"Y: "+cam_pos_y);
				cam_pos_x -= ROOM_WIDTH;
				if(cam_pos_x<=WIDTH-WORLD_WIDTH)
				{
					cam_pos_x = WIDTH-WORLD_WIDTH;
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){//if you press the left arrow 
				//System.out.println("X: "+cam_pos_x+"/n"+"Y: "+cam_pos_y);
				cam_pos_x += ROOM_WIDTH;
				if(cam_pos_x>=0)
				{
					cam_pos_x = 0;
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){//if you press the up arrow
				//System.out.println("X: "+cam_pos_x+"/n"+"Y: "+cam_pos_y);
				cam_pos_y -= ROOM_HEIGHT;
				if(cam_pos_y<=HEIGHT-WORLD_HEIGHT)
				{
					cam_pos_y = HEIGHT-WORLD_HEIGHT;
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){//if you press the down arrow
				//System.out.println("X: "+cam_pos_x+"/n"+"Y: "+cam_pos_y);
				cam_pos_y += ROOM_HEIGHT;
				if(cam_pos_y>=0)
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
	public void attack(){
		
	}
	public void resize(int width, int height){}
	public void pause(){}
	public void resume(){}
	public void dispose(){
		System.out.println("You just closed the frame.");
	}
}
