package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BaseScreen implements Screen {
    Skin skin;
    Stage stage;
    Table root;
    OrthographicCamera guiCamera;
    ScreenViewport guiViewport;
    SpriteBatch batch;
    
    public BaseScreen () {
      guiCamera = new OrthographicCamera();
      guiViewport = new ScreenViewport(guiCamera);
        
      //batch = new SpriteBatch();
        
      skin = new Skin(Gdx.files.internal("assets/uiskin.json"));
      //stage = new Stage(guiViewport, batch);
      stage = new Stage(guiViewport);
      
        
      root = new Table();
      root.setFillParent(true);
      stage.addActor(root);
        
      Gdx.input.setInputProcessor(stage);
        
        
        
      TextButton newGameButton = new TextButton("New Game", skin);
      TextButton continueGameButton = new TextButton("Continue Game", skin);   
      root.add(newGameButton);
      root.add(continueGameButton);
    }
    
    public void render (float delta) {
      Gdx.gl.glClearColor(0, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      stage.act(delta);
      stage.draw();
   }

   public void resize (int width, int height) {
      guiViewport.update(width, height, true);
   }

   public void hide () {
      dispose();
   }

   public void dispose () {
      //batch.dispose();
      stage.dispose();
      skin.dispose();
   }

@Override
public void pause() {
	// TODO Auto-generated method stub
	
}

@Override
public void resume() {
	// TODO Auto-generated method stub
	
}

@Override
public void show() {
	// TODO Auto-generated method stub
	
}
}