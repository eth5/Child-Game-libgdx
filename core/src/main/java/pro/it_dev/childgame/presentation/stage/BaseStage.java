package pro.it_dev.childgame.presentation.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pro.it_dev.childgame.Main;
import pro.it_dev.childgame.assets.AssetWrapper;
import pro.it_dev.childgame.assets.IAssets;
import pro.it_dev.childgame.presentation.actor.LoadResourceActor;

public abstract class BaseStage extends Stage {
    protected final IAssets assets;
    public BaseStage(){
        super(Main.viewport());
        AssetManager assetManager = Main.assetManager();
        assets = new AssetWrapper(assetManager);
        resourceToLoad(assetManager);
        Group loader = new LoadResourceActor(assetManager, this::onAllResourceIsLoaded);
        addActor(loader);
    }
    private void onAllResourceIsLoaded(final Actor actor){
        ((AssetWrapper)assets).prepareAfterLoad();
        actor.remove();
        Gdx.app.postRunnable(this::onLoadResource);
    }
    abstract void onLoadResource();
    protected void resourceToLoad(AssetManager assetManager){
        assetManager.load("ui/ui.atlas", TextureAtlas.class);
    }

    public void clearResource() {
        assets.clear();
    }
    @Override
    public void dispose() {
        super.dispose();
        assets.dispose();
    }
}
