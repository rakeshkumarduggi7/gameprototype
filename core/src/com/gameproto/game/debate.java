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
public class debate implements Screen {
   gameproto gp;
   BitmapFont bmf;
   int count;
   int i;    OrthographicCamera c;
   Viewport vp;
   SpriteBatch batch;
   StringBuilder s=new StringBuilder(); StringBuilder x; int j=2338;
   Rectangle o1;
   Rectangle o2;
   Rectangle pen;
   String op1="ben teleports near clg where no one can witness near a tree\n";
   String op2="i dont think anyone should witness the magic of teleporting!\n";
   boolean pc=false;
int ref=24;
boolean wa=false;
 public debate(gameproto gp){
    this.gp=gp;
    x=new StringBuilder("ben : i don't know i will think about it, but now i have to hurry!\n" +
            "lady : ok, take this you will find out soon what i am talking about ..\n" +
            "ben : ok? \n" +
            "lady gives a pendant of sort to ben , he takes it and keeps it in his pocket ,\n" +
            "lady : where you want to go hold the pendant and say where you want to go.\n" +
            "ben : ok\n" +
            "and ben hurries into the street to reach his home.\n" +
            "ben: what a situation , so i think i have a chance for staying in the university , i just have to go and check my credits if i failed or not and then,\n" +
            "ben  keeps his hand in his pocket where the pendant is and holds it in his pocket ,\n" +
            "ben : before that i have to go to home ....**\n" +
            "suddenly ben was  blacked out for a second everything seemed suddenly dark, he doesn't feel like air is moving, and sudden silence no wind sound and echo sensation came unto him just a few secs later he realizes he is inside his house just a moment ago he was .... ben keeps his hands in his pocket takes out the pendant , and sees to get what that lady talked about, he sees his surroundings takes his bag, and holds the pendant close observes it carefully and..\n" +
            "ben : take me where i came from...**\n" +
            "ben was teleported suddenly his eyes were closed because of the sudden movement from darkness inside his house to suddent outdoor bright light, a few seconds later after adjusting he sees that he is back in the street he came from , he checks his bag it is there so he did go to his house.. as he getting it together a sensation of someone's hand felt on his shoulder he looks back in startle and there is the lady .\n" +
            "lady : don't be afraid , did u see it for yourself? \n" +
            "ben : yes but ,what is it , how is it poss..\n" +
            "lady : i don't know and i want to get it to authorities but am afraid they will make everything and everyone vanish because of the power it possesses , i don't know who i can trust, u seemed good so i don't have other choice ,\n" +
            "ben : what is it i have to do? where did prof . louis tell or mention he is going ?\n" +
            "lady : he talked about when and where the pendant was made , and where he and his team found it , \n" +
            "ben : ok ok , it seems it will take time for explanations but i have to go now i will come back after university finishes.\n" +
            "lady : but ... ok ok u need to finish Ur college i understand. you know where to find me. you can go now.\n" +
            "ben : ok .\n" +
            " lady goes back in her house\n" +
            "ben as he walks to the bus stop.. he looks at his time ,, its 9:26 am  \n" +
            "ben :omg, omg !! i will be late today they will detain me from university. what should i do...? \n" +
            "after finishing the university he returns back to the house, it is evening sun is about to set \n");
    batch=new SpriteBatch(); i=2338;
    count=22;   FreeTypeFontGenerator ftf=new FreeTypeFontGenerator(Gdx.files.internal("gamefont.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter pa=new FreeTypeFontGenerator.FreeTypeFontParameter();
    pa.size = 72;
    pa.color= Color.BLACK;
    bmf=ftf.generateFont(pa);
    ftf.dispose();
    c=new OrthographicCamera();
    c.setToOrtho(false,1920, 1080);
    vp=new FitViewport(1920,1080,c);
    Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
     pen = new Rectangle(400, 100, 200, 72);
 }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(c.combined);
        s=new StringBuilder(x.substring(j,i));
       ScreenUtils.clear(1,255f/255f,240f/255f,0);
       batch.begin();
       bmf.draw(batch,s, 10, c.viewportHeight-50, 1920, -1, true);
       bmf.draw(batch,"inventory :",100,100);
       bmf.draw(batch,"keys",400,100);
       if (count>=3){
bmf.draw(batch,"pendant",pen.x,  172);
       }
       if (pc){
             bmf.draw(batch,"take me near clg!",o1.x,o1.y+72);
             if (wa) {
                 bmf.draw(batch, "take me inside clg?", o2.x, o2.y + 72);
             }
       }

       batch.end();
       if (count!=ref) {
          if (i < x.length() - 2 && x.charAt(i + 1) == '\n') {
             if ((Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isTouched())) {
                i++;
                count++;
             }
          } else {
             i++;
          }
       }
        if(count==ref) {
            if (Gdx.input.isTouched()) {
                Vector3 tp = new Vector3();
                tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                c.unproject(tp);
                o1 = new Rectangle(350, 200, 200, 72);
                o2 = new Rectangle(850, 200, 200, 72);
                if (pen.contains(tp.x, tp.y)) {
                    pc = true;
                    wa=true;
                } else if (o1.contains(tp.x, tp.y)) {
                    x.insert(i,op1);
                    ref=0;
                    pc=false;
                } else if (o2.contains(tp.x, tp.y)) {
                    x.insert(i,op2);
                     ref++;i+=2;
                     wa=false;
                }
            }
        }
       if(i==x.length()){
          i=x.length()-1;
       }
       if(i==513){
          j=i;
       }
       else if(i==1561 ) {
          j = i;
       } else if (i==2338) {
          j=i;
       }



       if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
          Gdx.app.exit();
       }
       if (i>=x.length()-2){
          if(Gdx.input.isKeyPressed(Input.Keys.ENTER)||Gdx.input.isTouched()){
             gp.setScreen(new breakintoact2(this.gp));
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
