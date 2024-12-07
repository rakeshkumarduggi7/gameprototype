package com.gameproto.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class theme    implements Screen {
    gameproto gp;
    int count;
    int i;
    SpriteBatch batch;
    Vector3 tp;
    Rectangle item;
    String s;
    public theme(gameproto gp){
        this.gp=gp;
        s="ben gets on the bus as he travels midway to his university he forgets his important report ,so he gets down on the next stop .and walks through a shortcut route ,which he never used as he is walking in the silent street he sees .....\\n\n" +
                "an old lady who was sitting near her house door sad looking......../n\n" +
                "as he walked past her ,she pointing at his bag /n\n" +
                "lady :do u work in that university /n\n" +
                "ben :i am a student/n\n" +
                " lady :my husband works in that university/n\n" +
                "ben : what's his name, /n\n" +
                "lady: louis ,he works in the archeology department/n\n" +
                " ben: oh I once had a archeology class I might have got a lecture from him I don't remember ,/n\n" +
                " ben: anyway I am in a hurry ,have a good day, after ben walked a few seconds /n\n" +
                "lady :wait !! /n\n" +
                "ben: yes ,i am sorry I am in hurry what is it ,/n\n" +
                " lady: I need  help from you I will pay money for you /n\n" +
                "ben : I want to help but I cant I am in a hurry I have a class I cant miss today its very important ,what do u need mam , /n\n" +
                "lady: I cant find louis ,can u check in the university and get to me in the evening?/n\n" +
                "ben: mam I wont come this route in the evening , I am sorry but I have to go now . you can call the university  and find out./n\n" +
                "ben walks away as he is in hurry./n";
        batch=new SpriteBatch();
        i=0;count=0;
        tp=new Vector3();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,223f/255f,186f/255f,0);
batch.begin();

batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
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
