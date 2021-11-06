package pro.it_dev.childgame.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import pro.it_dev.childgame.assets.font.FontBuilder;

public class AssetWrapper implements IAssets{
    private final ObjectMap<String, TextureAtlas.AtlasRegion> textures = new ObjectMap<>();
    private final ObjectMap<String, BitmapFont> fonts = new ObjectMap<>();
    private final AssetManager am;
    public AssetWrapper(AssetManager assetManager){
        if (!assetManager.isFinished()) throw new IllegalStateException("Принимается только загруженный ассет!");
        am = assetManager;
        prepareAssetManager();
    }
    private void prepareAssetManager() {
        Array<TextureAtlas> array = new Array<>();
        am.getAll(TextureAtlas.class, array);
        for (TextureAtlas atlas : array) {
            putTexturesByName(atlas, textures);
        }
    }
    private void putTexturesByName(TextureAtlas atlas, ObjectMap<String, TextureAtlas.AtlasRegion> map) {
        Array<TextureAtlas.AtlasRegion> regions = atlas.getRegions();
        for (TextureAtlas.AtlasRegion region : regions) {
            if (map.containsKey(region.name)) throw new Error("дублирование имени текстуры!");
            map.put(region.name, region);
        }
    }

    @Override
    public TextureAtlas.AtlasRegion getTexture(String name) {
        return textures.get(name);
    }

    @Override
    public Array<TextureAtlas.AtlasRegion> getArrayTextures(String animationName, int frames) {
        Array<TextureAtlas.AtlasRegion> array = new Array<>(frames);
        for (int i = 0; i < frames; i++) {
            array.add(getTexture(animationName + "/" + i));
        }
        return array;
    }

    @Override
    public BitmapFont getFont(String name, int size) {
        String key = name + "_" + size;
        if (fonts.containsKey(key)) return fonts.get(key);
        else {
            return null;
        }
    }

    @Override
    public void dispose() {

    }
}
