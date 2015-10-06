package Project;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Tutorial_Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	public static int ROOM_WIDTH = 50;
	public static int ROOM_HEIGHT = 50;
	
	public static OrthographicCamera cam;
	
	public void create(){
		System.out.println("The frame was created successfully.");
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();		
	}
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		ShapeRenderer sr = new ShapeRenderer();
		sr.begin(ShapeType.Filled);
		sr.setColor(1,1,0,1);
		for(int i=0; i<3; i++)
		{
			sr.rect(100+(ROOM_WIDTH*i),100,ROOM_WIDTH,ROOM_HEIGHT);
		}
		sr.setColor(1,0,0,1);
		sr.circle(125, 125, 5);
		sr.end();
	}
	public void resize(int width, int height){}
	public void pause(){}
	public void resume(){}
	public void dispose(){
		System.out.println("You just closed the frame.");
	}
}
