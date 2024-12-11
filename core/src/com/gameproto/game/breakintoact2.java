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

public class breakintoact2 implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x;
    int j=0;
    public breakintoact2(gameproto gp){

        this.gp=gp;
        x="the old lady was out, and she says are you ready?\n" +
                "ben : maybe i don't know explain me about it what happened ? what is that magic? what is your name?\n" +
                "lady: its marge  .\n" +
                "ben: i am ben.\n" +
                "lady : ok ben , so my hsb brought these artifacts  from ......\n" +
                "after explanation by marge ben was ready for helping find his husband..\n" +
                "marge : come here to this street at night when no one can see or follow \n" +
                "ben : ok , i will try my best to find the prof..\n" +
                "ben then leaves to his house ...\n" +
                "ben reaches his house. And gets some sleep for his journey..\n" +
                "at night 10:45 he wakes up and sees time and decides to get ready for the  journey,  he eats dinner and looks out the window ,its night \n" +
                "and cold and quiet ,\n" +
                "ben : i am ready now.\n" +
                "\n" +
                "he heads to the street and he meets the lady standing near her house , she shows him pic of louis and she asks if he's ready\n" +
                "then ben confirms he is  ready  to find louis and he says holding the pendant in his hand..\n" +
                "\n" +
                "ben : take me where prof louis went!..**\n" +
                "ben was vanished in thin air .............";
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
        s=x.substring(j,i);
        ScreenUtils.clear(1,255f/255f,240f/255f,0);
        batch.begin();
        bmf.draw(batch,s,10, c.viewportHeight-50, 1920, -1, true);
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
        }
if (i==534){
    j=534;
}
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }if (i>=x.length()-2){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new bstory(this.gp));
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
