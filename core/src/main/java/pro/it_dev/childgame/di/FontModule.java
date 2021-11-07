package pro.it_dev.childgame.di;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import dagger.Provides;

import javax.inject.Singleton;

public class FontModule {

    @Singleton
    @Provides
    public BitmapFont provideFont(){
        return new BitmapFont(Gdx.files.internal("font/play_32.fnt"));
    }
}
