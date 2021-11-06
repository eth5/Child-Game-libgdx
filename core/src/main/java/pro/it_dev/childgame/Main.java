package pro.it_dev.childgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.czyzby.autumn.annotation.Inject;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;
	private BitmapFontCache fontCache;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("font/play_32.fnt"));
		fontCache = new BitmapFontCache(font);
		fontCache.addText("112233", 200,200);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.50f, 0.50f, 0.50f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		font.setColor(Color.BLACK);
		font.draw(batch,"112233",100f,100f);
		fontCache.draw(batch);

		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}