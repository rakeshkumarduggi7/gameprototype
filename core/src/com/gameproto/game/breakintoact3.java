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
import java.util.ArrayList;
import java.util.HashMap;

public class breakintoact3 implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;
    int j;
    OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    StringBuilder s; StringBuilder x;
    Rectangle o1;
    Rectangle o2;
    Rectangle o3;
    Rectangle p;
    ArrayList<Rectangle> ar;
    ArrayList<String> as;
    int ref=8;
    boolean b=false; Vector3 tp=new Vector3();
    HashMap<Rectangle,String> hm;
    ArrayList<String> sa=new ArrayList<>();
    boolean a=false;
    ArrayList<Rectangle> cr;

    ArrayList<String> cs;
    public breakintoact3(gameproto gp){
        this.gp=gp;
        x=new StringBuilder("louis: how can i get out of here? If i cant not only me ben too will be struck here forever.\n" +
                "as louis is thinking to himself ,a soldier comes in a hurried manner  to another soldier in a frightened  way \n" +
                "soldier 1: the  -Apophis- is cursing us!!! we are surrounded.!!!!\n" +
                "soldier 2: what happened !!!\n" +
                "soldier 3: we are cursed we will die oh my god!!\n" +
                "soldier 2: what's going on !! ......\n" +
                "meanwhile....\n" +
                "ben : this is my only shot it should scare them pretty much....\n" +
                "(gp : ben choses amap ways he can scare by using the magic power of pendant and his knowledge of how)\n" +
                "so he created a ruckus of pretending like a god and using pendant to travel in different directions and shout so the soldiers believe that he is omni present god,, a few soldiers attention was there at the beginning and later all the soldiers in the prison building were frightened and when ben got all of their attention he demanded that he release prof. and the pendant that was stolen from him. ");
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
        o1=new Rectangle(350,200,100,72);
        o2=new Rectangle(500,200,100,72);
        o3=new Rectangle(650,200,100,72);
        ar=new ArrayList<>();
        as=new ArrayList<>();
        ar.add(o1);
        ar.add(o2);
        ar.add(o3);
        as.add("go left ");
        as.add("go right ");
        as.add("go behind ");
sa.add("\nben goes to the left of the prison \n");
sa.add("\nben goes to the right of the prison \n");
sa.add("\nben goes to the behind the prison \n");
cr=new ArrayList<>();
Rectangle c1=new Rectangle();
        Rectangle c2=new Rectangle();
        Rectangle c3=new Rectangle();
        cs=new ArrayList<>();



    }
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        s=new StringBuilder(x.substring(j,i));
        ScreenUtils.clear(1,255f/255f,240f/255f,0);
        if(count==ref){
            p=new Rectangle(500,100,100,72);

            tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            c.unproject(tp);
            if (Gdx.input.isTouched()&&p.contains(tp.x,tp.y)){
b=true;
            }
        }
        batch.begin();
        bmf.draw(batch,s, 10, c.viewportHeight-50, 1920, -1, true);
        bmf.draw(batch,"inventory :",100,100+72);
        bmf.draw(batch,"keys",400,100+72);
        bmf.draw(batch,"pendant",500,172);
      if (b){
          int s=0;
          for (Rectangle r:ar){
              r=new Rectangle(r.x,r.y,r.width,r.height);
              bmf.draw(batch,as.get(s),r.x,r.y+72);
              if (Gdx.input.isTouched()){
                  tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                  c.unproject(tp);
                  if (r.contains(tp.x,tp.y)){
                    ar.remove(ar.size()-1);
                    as.remove(s);
                    b=false;
                     x.insert(i,sa.get(s));
                    sa.remove(s);
                    ref++;
                      a=true;
                    break;
                  }
              }
              if (as.size()==0)break;
              s++;

          }
      }
        if (a){

        }
        batch.end();
        if (count!=ref){
        if (i<x.length()-2&&x.charAt(i+1)=='\n'){
            if ((Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched() )){
                i++;
                count++;
            }
        } else {
            i++;
        }
        } if(i==x.length()){
            i=x.length()-1;
        }
        if(i==398){
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
