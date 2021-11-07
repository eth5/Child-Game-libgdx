package pro.it_dev.childgame.assets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public interface IAssets {
    TextureAtlas.AtlasRegion getTexture(String name);
    Array<TextureAtlas.AtlasRegion> getArrayTextures(String animationName, int frames);
    BitmapFont getFont(String name, int size);
    void dispose();
    void clear();
}
