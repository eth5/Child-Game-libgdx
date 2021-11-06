package pro.it_dev.childgame.assets.font;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontBuilder {
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
    // private float widht;
    private FreeTypeFontGenerator generator;

    public FontBuilder file(FileHandle fh){
        generator = new FreeTypeFontGenerator(fh);
        return this;
    }
    public BitmapFontCache buildCacheFont(int fonSize, Color fontColor, boolean markup){
        BitmapFont bitmapFont = buildFont(fonSize, fontColor, markup);
        return new BitmapFontCache(bitmapFont);
    }

    public BitmapFont buildFont(int fonSize, Color fontColor, boolean markup){
        if (generator == null) throw new NullPointerException("Необходимо установить файл!");
        BitmapFont bitmapFont = generate(fonSize,fontColor,markup);
        generator.dispose();
        generator = null;
        return bitmapFont;
    }

    private BitmapFont generate(FreeTypeFontGenerator.FreeTypeFontParameter parameter, boolean markup){
        BitmapFont font = generator.generateFont( parameter );
        font.getData().markupEnabled = markup;
        // font.getData().setScale( widht/1000 );
        return font;
    }

    private BitmapFont generate(int fonSize, Color fontColor, boolean markup){
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARACTERS;
        parameter.size = fonSize;
        parameter.color = fontColor;
        return generate(parameter, markup);
    }
}
