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

public class badguysclosein implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;
    int j;
    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x;
    public badguysclosein(gameproto gp){
        this.gp=gp;
        x="louis: hurry now , i think there are many, use your pendant get out of here but be close , and then find who has it.\n" +
                "ben uses the pendant  from getting caught as well as to not let them witness the  magical power. he teleports away from the soldiers, but not far \n" +
                "he kept an eye on where they will take louis. And as louis was caught and being taken to prison, he sees the pendant worn by the soldier who is taking him to prison, as he was being taken louis shouts that he sees the pendant as the soldiers   don't understand , bens presence is not hinted .\n" +
                "ben : how can i get him and pendant back from prison? If cant get the pendant i am struck here forever.....";
        batch=new SpriteBatch(); i=0;
        j=0;
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
        bmf.draw(batch,s, 10, c.viewportHeight-50, 1920, -1, true);
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

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }if (i>=x.length()-2){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new allislost(this.gp));
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
