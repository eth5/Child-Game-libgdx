package pro.it_dev.childgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.czyzby.autumn.annotation.Inject;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import pro.it_dev.childgame.presentation.stage.BaseStage;
import pro.it_dev.childgame.presentation.stage.SimpleStage;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private Viewport viewport;
	private AssetManager assetManager;
	private Stage stage;


	public static Main self(){
		return (Main) Gdx.app.getApplicationListener();
	}
	public static Viewport viewport(){
		return self().viewport;
	}
	public static AssetManager assetManager(){
		return self().assetManager;
	}

	public static void setStage(final Stage stage){
		// threadsafe
		Gdx.app.postRunnable(()-> self().stage = stage );
	}
	@Override
	public void create() {
		assetManager = new AssetManager();
		viewport = createViewPort(400,640, new OrthographicCamera());
		VisUI.load();
		this.stage = new SimpleStage();
	}

	private Viewport createViewPort(int width, int height, OrthographicCamera camera){
		Viewport viewport = new ExtendViewport( width,height, camera);
		viewport.update(width, height, false);
		return viewport;
	}

	private float delta;
	@Override
	public void render() {
		Gdx.gl.glClearColor(0.50f, 0.50f, 0.50f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		delta = Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}