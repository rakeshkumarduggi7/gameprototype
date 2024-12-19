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
import java.util.Iterator;

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
    ArrayList<String> sa=new ArrayList<>();
    boolean a=false;
    ArrayList<Rectangle> cr;
    FreeTypeFontGenerator.FreeTypeFontParameter pa;
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
                "(gp : ben choses amap ways he can scare by using the magic power of pendant )\n" +
                "so he created a ruckus of pretending like a god and using pendant to travel in different directions and shout so the soldiers believe that he is omni present god,, a few soldiers attention was there at the beginning and later all the soldiers in the prison building were frightened and when ben got all of their attention he demanded that he release prof. and the pendant that was stolen from him. ");
          batch=new SpriteBatch(); i=0;
        j=0;
        count=0;   FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
         pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
        pa.size = 72;
        pa.color= Color.GRAY;
        bmf=ftf.generateFont(pa);
        ftf.dispose();
        c=new OrthographicCamera();
        c.setToOrtho(false,1920, 1080);
        vp=new FitViewport(1920,1080,c);
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        ar=new ArrayList<>();
        as=new ArrayList<>();
        ar.add(new Rectangle(350,200,100,72));
        ar.add(new Rectangle(500,200,100,72));
        ar.add(new Rectangle(650,200,100,72));
        as.add("go left ");
        as.add("go right ");
        as.add("go behind ");
sa.add("\nben goes to the left of the prison \n");
sa.add("\nben goes to the right of the prison \n");
sa.add("\nben goes to the behind the prison \n");
        cs=new ArrayList<>();
        cs.add("\nben: The light shall flee from your shadow, leaving you to drown in an abyss where even darkness fears to tread.\n");
        cs.add("\nben: With every breath, I will twist your fate into despair—your life, a crumbling ruin beneath my coils.\n");
        cs.add("\nben: Your hopes will rot before your eyes, devoured by my endless hunger. You will beg for oblivion—and even that, I shall deny you\n");
cr=new ArrayList<>();
        cr.add(new Rectangle(50,400,300,72));
        cr.add(new Rectangle(550,400,300,72));
        cr.add(new Rectangle(1050,400,300,72));
    }
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(c.combined);
        s=new StringBuilder(x.substring(j,i));
        vp.apply();
        ScreenUtils.clear(0,0,0,0);
        if(count==ref&&!a){
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
        if (a){
            int s=0;
            Iterator<Rectangle> ira=cr.iterator();
            while (ira.hasNext()){
                Rectangle q=ira.next();
                bmf.draw(batch,cs.get(s).substring(0,15),q.x,q.y+pa.size);
                if (Gdx.input.isTouched()){
                    tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                    c.unproject(tp);
                    if (q.contains(tp.x,tp.y)){
                        ira.remove( );
                        x.insert(i,cs.get(s));
                        cs.remove(s);
                        a=false;
                        ref++;
                        if (cs.size()==0){
                            ref=-1;
                            b=false;
                            j=i;
                        }
                        break;
                    }
                }
                s++;

            }
        }
      if (b){
          int s=0;
          for (Rectangle r:ar){
              Rectangle l=new Rectangle(r.x,r.y,r.width,r.height);
              bmf.draw(batch,as.get(s),l.x,l.y+pa.size);
              if (Gdx.input.isTouched()){
                  tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                  c.unproject(tp);
                  if (l.contains(tp.x,tp.y)){
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
              s++;

          }
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
                gp.setScreen(new finale(this.gp));
            }
        }
    }

    @Override
    public void resize(int width, int height) {
vp.update(width,height);
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
