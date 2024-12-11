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

public class bstory implements Screen {
    gameproto gp;
    BitmapFont bmf;
    int count;
    int i;
    int j;OrthographicCamera c;
    Viewport vp;
    SpriteBatch batch;
    String s; String x;
    int ref=36;
    Rectangle p;
    Rectangle mc;
    boolean b=false;
    public bstory(gameproto gp){
        this.gp=gp;
        p=new Rectangle();
        mc=new Rectangle();
        x="3 weeks earlier.......\n" +
                "\n" +
                "louis an archeologist working at the university travelled to  delta region near Egypt at midday, with a few more men hired for digging purposes were at a site , searching for a sand submerged underground warehouse , while reportedly discovered a week back by a local, they were assigned there for a routine survey to figure out details or any findings.\n" +
                "as day passes on louis collects some old preserved pots and things thought to be a ware house of an ordinary person who lived in that house 3000 years back. Though some things were discovered louis is disappointed because he expected to find ancient Egypt secrets or valuables so as the government head Omar Youssef ,who appointed louis and the team for excavating the area ,the head is not considering the finding s as any value as there are not any different than tons they have discovered over the years.\n" +
                "Omar Youssef : louis, the discovered items are not of any significance i understand you are disappointed ,but as the museum has a lot of them already how about you can take it for yourself .if you would like to..\n" +
                "louis : well my house will get a good collection of ancient Egypt artifacts , i will take them. thanks Omar.\n" +
                "o y: so when are u heading back home ?\n" +
                "louis : it will be take a couple of hours , will see u later good friend.\n" +
                "louis is now free for a few weeks or until next assignment ,so he heads back home that day.\n" +
                "\n" +
                "the next day :\n" +
                "louis knocks on a door ...marge opens it ,\n" +
                "louis: hi I'm back!!.\n" +
                "marge : you came back quick this time anything happened?\n" +
                "louis: the job was very little , so , anyway I've brought something special the company let me keep.\n" +
                "marge : what ??\n" +
                "louis show the box of artifacts he brought with him. Marge looks for a few seconds and they both put it in the house ,\n" +
                "the day passes on and it is night now ,louis went out and will be back any minute, marge finished cooking dinner and went to the store room ,she notices the box louis brought , marge picks up the items one by one to observe up close ,she picks up one particular square bowl\n" +
                "which looks broken and fixed up it weighs little out of balance ,and ...\n" +
                "louis: i found, those ....\n" +
                "as louis suddenly started speaking , marge was startled as she didn't realize he was back, and the bowl has slipped from her hand. and it shattered into pieces on the floor...\n" +
                "marge was very shocked at what happened\n" +
                "marge: i am so sorry...\n" +
                "louis: its alright they were given for free, there are more left so don't worry about it.\n" +
                "as louis consoled marge to not worry about it...he sees near marge's feet on the floor a pebble like thing, as he gets closer he sees a pendant and  A miniature scripture. he takes them from the floor and asks marge..\n" +
                "louis : are these yours?\n" +
                "louis : where did these come from?\n" +
                "marge : i think there are store inside it , as i was observing i felt its weight is off balanced and  i saw some broken pattern sealed up and then u made me drop it ....\n" +
                "louis : ok then i will take them inside to my table and see what they are. Why they are stored that secretively..\n" +
                "marge : ok , but i am sorry for dropping.\n" +
                "louis : i think its a good thing otherwise we would never know what we found. don't worry.\n" +
                "as some time as passed , louis started to understand the note and decodes on a sheet, he hurried to marge and says about the pendant and what the note says about it. marge sees him very excited and smiles and doesn't really listens what he actually meant, but louis is very shocked and eccentric at what he found out, he goes back to his room and he reads the instructions from the note gets ready doubtfully and goofily to do what the instructions say, and then ....\n" +
                "he holds the pendant in his hand as the instructions say and says...\n" +
                "louis: take me to the living room. \n" +
                "and he in a blink of an eye present in his living room , he was stunned and in disbelief for a few seconds he just stares at the living room and he goes back to his room and sit down in his chair and writes about what he just witnessed , he goes to marge to reveal.\n" +
                "louis : marge this pendant we found is no ordinary one and its power is not of this world. observe carefully .\n" +
                "(gp: he chooses one of the ways to show the power)\n" +
                "marge : oh my god what just happened i am not feeling well i think i am not well...\n" +
                "louis: you are fine what u just witnessed is real , i am a witness too.\n" +
                "that day was over after marge and louis talk about what it is and what louis should do about ...\n" +
                "then a day later louis disappeared and marge sees the note on his table mentioning that he will go to the place and time why , where ,when this pendant is made ,...\n";
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
        if (count==36){
            p = new Rectangle(550, 100, 100, 72);
            if(Gdx.input.isTouched()) {
                Vector3 tp = new Vector3();
                tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                c.unproject(tp);
                if (p.contains(tp.x, tp.y)) {
                    b = true;
                }
                if (b) {
                    if (mc.contains(tp.x, tp.y)) {
                        count++;
                        i++;
                    }
                }
            }
        }
        batch.begin();
        bmf.draw(batch,s, 10, c.viewportHeight-50, 1920, -1, true);
        bmf.draw(batch,"inventory :",100,100+72);
        bmf.draw(batch,"keys",400,100+72);
        if (count==36){
            bmf.draw(batch,"pendant",(p.x),p.y+72);
            if (b){
                mc = new Rectangle(500, 200, 200, 72);
                bmf.draw(batch,"take me to living room?!",mc.x,mc.y+72);
            }
        }
        batch.end();
        if(count!=36) {
            if ( i < x.length() - 2 && x.charAt(i + 1) == '\n') {
                if ((Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isTouched())) {
                    i++;
                    count++;
                }
            } else {
                i++;
            }
        }if(i==x.length()){
            i=x.length()-1;
        }

        if(i==885){
            j=i;
        }
        else if(i==885+527){
            j=i;
        }
        else if(i==885+527+748){
            j=i;
        }
        else if(i==885+527+748+608){
            j=i;
        }
        else if(i==885+527+748+608+885){
            j=i;
        }
        else if(i==885+527+748+608+885+689){
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
