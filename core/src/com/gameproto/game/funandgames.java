package com.gameproto.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

public class funandgames implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;
    int j;
    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x;
    Rectangle p;
    Vector3 tp;boolean b=false;
    Rectangle ch;
    String[] sa={"get me bhind that tree..behind louis... ","take me back behind the rock across i came from","take me near the fire place"};
    public funandgames(gameproto gp){
        this.gp=gp;
        x= "present..\n" +
                "\n" +
                "ben appears in the ancient Egypt in the delta region with clothes of style that are very alien to the people living in that era.\n" +
                "the time should be close to 10pm and its pitch dark with little moon light and he could see some glow from a distance near some houses .\n" +
                "he walks towards the glow , as he gets closer he finds that it is a fire place and there are people near it ,looking like soldiers.to not get caught he hides near a tree and some bushes behind a big rock , he sees some soldiers drunk , sleepy near the fire place and on the other side of the fire place he sees a man tied up to a tree , he doesn't move , his clothes are modern like bens, he finally realized it should be  prof. louis .\n" +
                "ben : i have to get near him, but how if there are soldiers , how to distract them?\n" +
                "ben : i cant distract them, they will be alerted than , its better they are drunk and sleepy, but how do i pass the path?\n" +
                "(ben uses his pendant and in a sec he get behind the tree prof. louis is hanged to.)\n" +
                " he stays calm for a couple of minutes behind the tree to gain confidence , ben tries to check if he is alive and he can hear breathing so he thinks he is sleeping , so he tries to touch near his to wake him up, prof. louis wakes up ,then ben whispers from behind him..\n" +
                "ben : prof .louis i am here to save you , your wife marge told me about what happened ,with the pendant power and everything , \n" +
                "louis : marge sent you ,but how did you get here? ohh!! there is another pendant , the scripture described about it , it can only be used to find the other half which i have. but it doesn't have all the powers the pendant i have.\n" +
                "louis: ok, untie me ,legs first.\n" +
                "ben slowly crawls and unties his legs and hands , for a few seconds they keep an eye on the soldiers if they are being watched. And.  slowly backs away from them silently couching...but a  few seconds later a soldier notices louis is not there, so he alerts the soldiers......\n" +
                "\n" +
                "2 minutes later.....\n" +
                "\n" +
                "they all start searching near the tree and they see a shade of a person in the dark at a distance , and they call out that direction to run towards..\n" +
                "ben knowing the soldiers found their location , knowing if he and louis are both caught there is no chance getting back home soo....\n" +
                "ben decided to ....";
        batch=new SpriteBatch(); i=0;
        j=0;
        count=0;   FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
        pa.size = 72;
        pa.color= Color.GOLD;
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

        ScreenUtils.clear(0,0,0,0);
        if (count==7){
            p=new Rectangle(500,100,150,72);
            if (Gdx.input.isTouched()) {
                tp=new Vector3();
                tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                c.unproject(tp);
                if (p.contains(tp.x,tp.y)){
                    b=true;
                }
                    ch = new Rectangle(500, 200, 200, 72);

            }
            if (b) {
                if (ch.contains(tp.x, tp.y)) {
                    count++;
                    i++;
                    b=false;
                }
            }
        }
        batch.begin();
        bmf.draw(batch,s, 10, c.viewportHeight-50, 1920, -1, true);
        bmf.draw(batch,"inventory :",100,100+72);
        bmf.draw(batch,"keys",400,100+72);
        bmf.draw(batch,"pendant",500,100+72);
     if(b){
         ch = new Rectangle(500, 200, 200, 72);
         bmf.draw(batch,"get me bhind that tree..behind louis... ",500,272) ;
     }
        batch.end();
        if(count!=7) {
            if (i < x.length() - 2 && x.charAt(i + 1) == '\n') {
                if ((Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isTouched())) {
                    i++;
                    count++;
                }
            } else {
                i++;
            }
        }

        if(i==x.length()){
            i=x.length()-1;
        }
        if(i==797){
            j=i;
        }
        else if (i==1632){
    j=i;
        }
        else if(i==2115){
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
