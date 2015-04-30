package com.me.DTP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

	static Texture citybg;
	static Texture PPlane;
	static Texture EPlane;
	static Texture title;
	static Texture tap;
	static Texture credits;
	static Texture gameover;
	static Texture score;
	static Texture dawn;
	static Texture day;
	static Texture night;
	static Texture best;
	//static Sound scoreup;
	
public AssetManager()
{
	citybg = new Texture(Gdx.files.internal("data/city.png"));
	PPlane = new Texture(Gdx.files.internal("data/Plane.png"));
	EPlane = new Texture(Gdx.files.internal("data/EPlane.png"));
	title = new Texture(Gdx.files.internal("data/title.png"));
	tap = new Texture(Gdx.files.internal("data/tap.png"));
	credits = new Texture(Gdx.files.internal("data/credits.png"));
	gameover = new Texture(Gdx.files.internal("data/gameover.png"));
	score = new Texture(Gdx.files.internal("data/score.png"));
	dawn = new Texture(Gdx.files.internal("data/dawn.png"));
	day = new Texture(Gdx.files.internal("data/day.png"));
	night = new Texture(Gdx.files.internal("data/night.png"));
	best = new Texture(Gdx.files.internal("data/best.png"));
	//scoreup = Gdx.audio.newSound(Gdx.files.internal("data/jump.wav"));
	
}
	
public void dispose()
{
	citybg.dispose();
	PPlane.dispose();
	EPlane.dispose();
	title.dispose();
	tap.dispose();
	credits.dispose();
	gameover.dispose();
	best.dispose();
	night.dispose();
	day.dispose();
	dawn.dispose();
	//scoreup.dispose();


}

}
