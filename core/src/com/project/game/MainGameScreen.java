package com.project.game;
/**
 * Created by ASUS on 11/10/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.Character.Monster;

public class MainGameScreen implements Screen {
    //Person
    private static final int PERSON_WIDTH = 170;
    private static final int PERSON_HEIGHT = 150;
    public static final float SPEED = 120;
    //Border
    private static final int BORDER_WIDTH = 300;
   private static final int BORDER_HEIGHT = 20;
    //Ladder
    private static final int LADDER_WIDTH = 70;
    private static final int LADDER_HEIGHT = 200;
    //0
    private static final int LADDER_X = ProjectGame.WIDTH/2 - LADDER_WIDTH;
    private static final int LADDER_Y = 0;
    //1
    private static final int LADDER1_X = ProjectGame.WIDTH/2 - LADDER_WIDTH;
    private static final int LADDER1_Y = 0;
    //2
    private static final int LADDER2_X = ProjectGame.WIDTH/2 - LADDER_WIDTH;
    private static final int LADDER2_Y = 0;

    SpriteBatch batch;
    //All Texture
    Texture img;
    Texture border;
    Texture border1;
    Texture border2;
    Texture border3;
    Texture ladder;
    Texture ladder1;
    Texture ladder2;


    //Input Control
    private float x = 0 ;
    private float y = 0 ;

    ProjectGame game;

    //constructor
    public MainGameScreen(ProjectGame game)
    {
        this.game = game;
    }

    @Override
    public void show(){
        img = new Texture("person.png");
        border = border1 = border2 = border3 = new Texture("wood.jpg");
        ladder = ladder1 = ladder2 = new Texture("ladder.png");
    }

    @Override
    public void render(float delta) {

        //Input Control -> person.png
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(x > LADDER_X && x < LADDER1_X+LADDER_WIDTH)  //Going up at Ladder
                y += SPEED * Gdx.graphics.getDeltaTime();
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(x > LADDER_X && x < LADDER1_X+LADDER_WIDTH)  //Going down at Ladder
                y -= SPEED * Gdx.graphics.getDeltaTime();
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= SPEED * Gdx.graphics.getDeltaTime();
            if(x < 0) //Set Left-Border
                x = 0;
        }else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += SPEED * Gdx.graphics.getDeltaTime();
            if(x+PERSON_WIDTH > ProjectGame.WIDTH)  //Set Right-Border
                x = ProjectGame.WIDTH - PERSON_WIDTH;
        }

        //Set Ground
        if( y < 0 )
            y = 0 ;
        
        Gdx.gl.glClearColor(0, 0, 0, 0); //Black Color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Running
        //We use game.batch because this object(game) is a main running
        //and batch is the part of this object(game)
        game.batch.begin();
            game.batch.draw(ladder, LADDER_X, LADDER_Y, LADDER_WIDTH, LADDER_HEIGHT);
            game.batch.draw(img, x, y, PERSON_WIDTH, PERSON_HEIGHT);
        game.batch.end();
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
