package pro.it_dev.childgame.presentation.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Null;

public class TextureActor extends BaseActor {
    public static TextureActor getInstance() {
        return new TextureActor();
    }

    private TextureActor() {
    }

    @Null TextureAtlas.AtlasRegion atlasRegion;
    boolean isRegionsPresent = false;
    public void setTexture(@Null final TextureAtlas.AtlasRegion atlasRegion){
        this.atlasRegion = atlasRegion;
        isRegionsPresent = atlasRegion != null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isRegionsPresent)
            batch.draw(
                    atlasRegion,
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation()
            );
    }
}
