package com.gameproto.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
public class theme    implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    Vector3 tp;
    String s; String x;
    boolean op;
    Rectangle opt;
    int j=0;
    public theme(gameproto gp){
        this.gp=gp;op=false;
        x="ben gets on the bus as he travels midway to his university he forgets his important report ,so he gets down on the next stop .and walks through a shortcut route ,which he never used as he is walking in the silent street he sees .....\n" +
                "an old lady who was sitting near her house door sad looking........\n" +
                "as he walked past her ,she pointing at his bag \n" +
                "lady :do u work in that university \n" +
                "ben :i am a student\n" +
                " lady :my husband works in that university\n" +
                "ben : what's his name, \n" +
                "lady: louis ,he works in the archeology department\n" +
                " ben: oh I once had a archeology class I might have got a lecture from him I don't remember ,\n" +
                " ben: anyway I am in a hurry ,have a good day, after ben walked a few seconds \n" +
                "lady :wait !! \n" +
                "ben: yes ,i am sorry I am in hurry what is it ,\n" +
                " lady: I need  help from you I will pay money for you \n" +
                "ben : I want to help but I cant I am in a hurry I have a class I cant miss today its very important ,what do u need mam , \n" +
                "lady: I cant find louis ,can u check in the university and get to me in the evening?\n" +
                "ben: mam I wont come this route in the evening , I am sorry but I have to go now . you can call the university  and find out.\n" +
                "ben walks away as he is in hurry.\n";
        batch=new SpriteBatch();
        i=0;
        count=0;
        tp=new Vector3();
        FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
        pa.size = 72;
        pa.color= Color.BLACK;
        bmf=ftf.generateFont(pa);
        ftf.dispose();
        c=new OrthographicCamera();
        c.setToOrtho(false,1920, 1080);
        vp=new FitViewport(1920,1080,c);
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        opt=new Rectangle(100,272,100,72);
    }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) { s=x.substring(j,i);
        ScreenUtils.clear(1,223f/255f,186f/255f,0);
batch.begin();
        bmf.draw(batch,s,10, c.viewportHeight-50, 1920, -1, true);
        bmf.draw(batch,"inventory :",100,100+72);
        if(op)bmf.draw(batch,"lady...",100,200+72);
        bmf.draw(batch,"keys",400,100+72);
batch.end();
        if (Gdx.input.isTouched()){
            tp.set(Gdx.input.getX(), Gdx.input.getY(),0);
            vp.unproject(tp);
            if( opt.contains(tp.x,tp.y)){
                count++;
                i++;
                op=false;
            }
        }
        if (i<x.length()-2&&x.charAt(i+1)=='\n'){
          if(count==0){
              op=true;
          }else if ((Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched() )){
              i++;
              count++;
          }
        } else {
            i++;
        }
        if(i==x.length()){
            i=x.length()-1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
        if(i==473){
            j=i;
        }  if (i>=x.length()-2){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new setup(this.gp));
            }
        }
    }
    @Override
    public void resize(int w, int h) {
        vp.update(w,h);
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
