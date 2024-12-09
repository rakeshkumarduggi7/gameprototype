package com.gameproto.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class setup implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x;
    public setup(gameproto gp){
        this.gp=gp;
        x="after getiing back home and collecting what he wants ,ben reaches his university,\n" +
                "jack: why so late ben?\n" +
                "ben: i forgot the project report , i have to stop mid way , walk back home and come.\n" +
                "jack: oh , what about the report what have you prepared on?\n" +
                "ben: ######## #####  \n" +
                "jack: oh man, you will fail if you really did that.\n" +
                "ben: why ? \n" +
                "jack: because the topic is on ******** , ##### ####  that was not for ours.\n" +
                "ben : oh my i am failed for sure now i wont finish college now .i will not have enough creds.\n" +
                "the day at the university is finished and ben  heads home late with disappointment.";
        batch=new SpriteBatch(); i=0;
        count=0;   FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
        pa.size = 72;
        pa.color= Color.BLACK;
        bmf=ftf.generateFont(pa);
        ftf.dispose();
        c=new OrthographicCamera();
        c.setToOrtho(false,1920, 1080);
        vp=new FitViewport(1920,1080,c);
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        s=x.substring(0,i);
        ScreenUtils.clear(1,255f/255f,240f/255f,0);
        batch.begin();
        bmf.draw(batch,s,10,1030);
        bmf.draw(batch,"inventory :",100,100+72);
        bmf.draw(batch,"keys",400,100+72);
        batch.end();   if (i<x.length()-2&&x.charAt(i+1)=='\n'){
            if ((Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched() )){
                i++;
                count++;
            }
        } else {
            i++;
        } if(i==x.length()){
            i=x.length()-1;
        }    if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }if (i>=x.length()-2){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new catalyst(this.gp));
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
