package com.gameproto.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
public class openimage implements Screen {
    SpriteBatch batch;
    BitmapFont bmf;
    OrthographicCamera c;
    Viewport vp;
    Texture morning;
    String x;
    int i=0;
    float cu;
    String s;
gameproto gp;
int count;

Rectangle item;
    public   openimage( gameproto gp){

       this.gp=gp;
        batch = new SpriteBatch();
        x="the time is 8:32 am it is well past the usual time ben wakes up for his university. He has slept in..Zzz \n" +
                " a few secs later ben wakes up ...... \n" +
                " ben starts getting ready for the day... \n" +
                " ben finishes chores  and  searches for the house keys and finds them. and puts in pocket(inventory now has keys) helloworld\n" +
                " ben combs his hair   . and he heads to the main door opens it and gets out.\n" +
                " ben closes the door and ...... \n" +
                " ben locks the door and turns and heads for his bus stop .";
        FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
        pa.size = 72; // Use a larger size if clarity is an issue
        pa.color= Color.BLACK;
        pa.borderColor=Color.BLUE;
        bmf=ftf.generateFont(pa);
        morning=new Texture(Gdx.files.internal("mor.jpg"));
        ftf.dispose();
        c=new OrthographicCamera();
        c.setToOrtho(false,1920, 1080);
        vp=new FitViewport(1920,1080,c);
         Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        cu=Gdx.graphics.getHeight()-50;
        count=0;

    }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        s=x.substring(0,i);
        vp.apply();
        ScreenUtils.clear(0, 0, 0 , 0);
        batch.begin();
        batch.draw(morning,0,0);
        bmf.draw(batch,s,10,cu);
        bmf.draw(batch,"inventory :",100,100+72);
        if(count>=3)bmf.draw(batch,"keys",400,172);
        batch.end();
      if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
           Gdx.app.exit();
        }
        if (i>=x.length()-1){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
                gp.setScreen(new theme(this.gp));
            }
        }
        if (i<x.length()-2&&x.charAt(i+1)=='\n'){
            if (count!=5&&(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched() )){
                i++;
                count++;
            }
        }else {
            i++;
        }
        if(i==x.length()){
            i=x.length()-1;
        }if (count>=3){
            item=new Rectangle(400,100,100,72);
        }
        if (s.length()==x.length()){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
            gp.setScreen(new theme(this.gp));
            }
        }
        if (count==5 ){
         if (Gdx.input.isTouched()){
         Vector3    tp=new Vector3();
           tp.set(Gdx.input.getX(), Gdx.input.getY(),0);
           vp.unproject(tp);
          if(item.contains(tp.x,tp.y)){
              count++;
              i++;
          }
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
        batch.dispose();
        bmf.dispose();
     }
}
