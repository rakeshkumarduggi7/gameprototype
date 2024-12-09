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

public class catalyst implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x; int j=0;
    public catalyst(gameproto gp){
        this.gp=gp;
        x="the next day comes and the time is 8:12 am ben has slept in today , a few seconds later ben wakes up in panic and looks at the time realizing he is late, he is already panicking from yesterday that ben : i wont be able to finish college because i failed in the project report ,now late 2days in a row, i am gonna get kicked out of the univers... \n" +
                "ben though he is late gets up  and combs his hair and walks for the bus to catch up to reach on time. skipping breakfast and other unimportant routine.\n" +
                "ben again after entering the bus he realizes he forgot his bag. today too he has to get off at the next stop. and run in the silent street.\n" +
                "the old lady was again there near her door ,sitting as ben sees her he remembered her asking about prof. louis and he forgot to enquire about it, but as he gets close to her house ,she looks at ben then ben says i am sorry i haven't seen prof. louis in university,\n" +
                "lady: i know where he is but i don't have the energy to go , i need your help ....\n" +
                "ben: i am sorry i am on my way to university i cant .\n" +
                "lady : i will pay u money.\n" +
                "ben: i already lost credits yesterday ,if i don't go on time i will be kicked out of college what can money do ? sorry bye;\n" +
                "lady : prof louis will give u credits if you help him? Is that feasible?\n" +
                "ben: keep talking..\n" +
                "lady : ok, see i don't know where he went but he showed me some ancient artifacts he collected from his workshop in Egypt recently, \n" +
                "he said something about it seemed very weird and strange until i used it myself but i don't have the energy to find him where he went so u could be helpful and prof . louis will get your credits ? savvy?";
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
        if(i==473){
            j=i;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }if (i>=x.length()-2){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new debate(this.gp));
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
