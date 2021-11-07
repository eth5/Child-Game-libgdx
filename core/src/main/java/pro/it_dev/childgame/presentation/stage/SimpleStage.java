package pro.it_dev.childgame.presentation.stage;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.VisImageButton;
import com.kotcrab.vis.ui.widget.VisTable;

public class SimpleStage extends BaseStage{

    @Override
    protected void resourceToLoad(AssetManager assetManager) {
        super.resourceToLoad(assetManager);
        assetManager.load("font/play_32.fnt", BitmapFont.class);
        assetManager.load("kits/default/kit.atlas", TextureAtlas.class);
    }

    @Override
    void onLoadResource() {
        setDebugAll(true);

        VisTable table = new VisTable();
        table.setHeight(getHeight());
        table.setWidth(getWidth());
        table.add("Ащбукварик").colspan(3).row();
        Array<Actor> contents = getContents();
        contents.shuffle();
        for (int i = 0; i < contents.size; i++) {
            table.add(contents.get(i)).align(Align.top).expand().fill();
        }
        table.row();


        table.add("Кнопка1")
                .getTable().add("Кнопка2")
                .getTable().add("Кнопка3").row();
        addActor(table);
    }
    private Array<Actor> getContents(){
        float size = getWidth()/3 * 0.95f;
        Array<Actor> content = new Array<>(3);
        content.add(getContentTable("item1",size));
        content.add(getContentTable("item2",size));
        content.add(getContentTable("item3",size));
        return content;
    }

    private static final int CELLS = 2;
    private Actor getContentTable(final String item, final float size){
        Image head = new Image(assets.getTexture(item + "/head"));
        VisTable table =  new VisTable();
        table.add(head).size(size).colspan(CELLS).row();
        float size2 = size/2f * 0.9f;
        boolean right;
        int align;
        for (int i = 1; i < 13; i++) {
            right = i % CELLS == 0;
            align = right ? Align.left : Align.right;
            table.add(new Image(assets.getTexture(item + "/"+i))).size(size2).align(align).pad(5);
            if (right) table.row();
        }

        return table;
    }
}
