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
	int x_pos = 0;
	int y_pos = 0;
	ArrayList<Location> locs = new ArrayList<Location>();
	public static OrthographicCamera cam;
	
	public void create(){
		System.out.println("The frame was created successfully.");
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		
		for(int i=0; i<5; i++){
			locs.add(new Location(i,0));
		}
		locs.add(new Location(1,1));
		locs.add(new Location(1,2));
		locs.add(new Location(1,3));
		locs.add(new Location(4,1));
		
		//secret places
		locs.add(new Location(2,2,true));
		locs.add(new Location(3,2,true));
		locs.add(new Location(4,2,true));
		//Gdx.graphics.setContinuousRendering(false);
	}
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		ShapeRenderer sr = new ShapeRenderer();
		sr.begin(ShapeType.Filled);
		for(Location place:locs)
		{
			if(place.secret==false)
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
			sr.rect(ROOM_WIDTH*place.x,ROOM_HEIGHT*place.y,ROOM_WIDTH,ROOM_HEIGHT);
		}
		sr.setColor(1,0,0,1);
		sr.circle(25+ROOM_WIDTH*x_pos, 25+ROOM_WIDTH*y_pos, 5);
		sr.end();
		
		sr.begin(ShapeType.Line);
		sr.setColor(0,0,0,1);
		for(Location place:locs)
		{
			sr.rect(ROOM_WIDTH*place.x,ROOM_HEIGHT*place.y,ROOM_WIDTH,ROOM_HEIGHT);
		}
		sr.end();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			x_pos++;
			boolean valid=false;
			for(Location place:locs)
			{
				if((place.x==x_pos)&&(place.y==y_pos))
				{
					valid = true;
					place.visited = true;
				}
			}
			if(!valid)
			{
				x_pos--;
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			x_pos--;
			boolean valid=false;
			for(Location place:locs)
			{
				if((place.x==x_pos)&&(place.y==y_pos))
				{
					valid = true;
					place.visited = true;
				}
			}
			if(!valid)
			{
				x_pos++;
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			y_pos++;
			boolean valid=false;
			for(Location place:locs)
			{
				if((place.x==x_pos)&&(place.y==y_pos))
				{
					valid = true;
					place.visited = true;
				}
			}
			if(!valid)
			{
				y_pos--;
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			y_pos--;
			boolean valid=false;
			for(Location place:locs)
			{
				if((place.x==x_pos)&&(place.y==y_pos))
				{
					valid = true;
					place.visited = true;
				}
			}
			if(!valid)
			{
				y_pos++;
			}
		}
	}
	public void resize(int width, int height){}
	public void pause(){}
	public void resume(){}
	public void dispose(){
		System.out.println("You just closed the frame.");
	}
}
