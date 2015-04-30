package com.me.DTP;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DodgeThePlanes extends Game {
		
		SpriteBatch batch;
		BitmapFont font;
		
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		setScreen(new PlayScreen(this));
		
		
	}
	@Override
	public void render()
	{
		super.render();
		
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
		batch.dispose();
		font.dispose();
	}

}

