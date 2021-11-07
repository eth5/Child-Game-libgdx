package pro.it_dev.childgame.presentation.actor;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.kotcrab.vis.ui.widget.VisLabel;
import pro.it_dev.childgame.interfaces.Action;

public class LoadResourceActor extends Group {
    private final static String LOAD_TEXT = "Loading...";
    final AssetManager assetManager;
    final Action.Arg1<Actor> onLoad;
    final VisLabel label;

    public LoadResourceActor(AssetManager assetManager, Action.Arg1<Actor> onLoad){
        this.assetManager = assetManager;
        this.onLoad = onLoad;
        this.label = new VisLabel(LOAD_TEXT);
        addActor(label);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        label.setText(LOAD_TEXT + (int)(assetManager.getProgress()*100) + "%");
        if ( assetManager.update() ){
            onLoad.invoke(this);
        }
    }
}
