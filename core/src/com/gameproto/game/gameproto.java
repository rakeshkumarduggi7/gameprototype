package com.gameproto.game;

import com.badlogic.gdx.Game;




public class gameproto extends Game {


	@Override

	public void create () {
		this.setScreen(new breakintoact3( this ));
	}
	public void resize(int w,int h){

	}
	@Override
	public void render () {
super.render();


	}
	@Override
	public void dispose () {

	}
}
