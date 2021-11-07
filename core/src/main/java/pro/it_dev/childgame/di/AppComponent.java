package pro.it_dev.childgame.di;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {FontModule.class})
@Singleton
public interface AppComponent {
    BitmapFont getFont();
}


