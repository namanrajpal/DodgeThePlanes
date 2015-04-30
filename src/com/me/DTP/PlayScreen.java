package com.me.DTP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;


public class PlayScreen implements Screen {
	
	DodgeThePlanes game;
	AssetManager Assets;
	Sprite c1,c2,title,tap,credits,gameover,scor,highscore,best,credit,back1,back2,back3,back11,back22,back33;
	float w,h;
	float bgx,bgxx;
	Player plane;
	boolean moveup;
	float Gamespeed;
	Enemy p1,p2,p3,p4;
	Rectangle a,b,c,restart;
	Intersector i;
	Pixmap p;
	int score;
	boolean startnow,endnow;
	float xx,yy;
	Timer t = new Timer();
	private Preferences pref;
	BitmapFont s2;
	
	public enum gamestate{
		
		starting,playing,gameover;
	}
	
	gamestate state;	
	
	public PlayScreen(DodgeThePlanes gam) {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		this.game= gam;
		Assets = new AssetManager();
		plane = new Player(w/6,h/3,w,h);
		p1 = new Enemy(w,h/3,w,h);
		p2 = new Enemy(w+w/3,2*h/3,w,h);
		p3 = new Enemy(2*w-2/6,h-h/5,w,h);
		//p4 = new Enemy(w,h/2,w,h);
		state = gamestate.starting;
		i = new Intersector();
		c = new Rectangle();
		a = new Rectangle();
		b = new Rectangle();
		startnow = false;
		endnow = false;
		pref = Gdx.app.getPreferences("pre");
		s2 = new BitmapFont();
	}

	@Override
	public void show() {
		
		bgx = w;
		score =0;
		c1 = new Sprite(AssetManager.citybg);
		c2 = new Sprite(AssetManager.citybg);
		c1.setBounds(0, 0, w, h);
		c2.setBounds(w, 0, w, h);
		 moveup = false;
		 Gamespeed = w/150;
		 game.font.scale(w/400);
		 game.font.setColor(0, 0, 0, 1);
		 s2.scale(w/400);
		 s2.setColor(0, 0, 0, 1);
		 p1.eplane.setPosition(MathUtils.random(w, 2*w), h/3);
			p2.eplane.setPosition(MathUtils.random(w, 2*w), 2*h/3);
			p3.eplane.setPosition(MathUtils.random(w, 2*w), h-h/5);
			title = new Sprite(AssetManager.title);
			tap = new Sprite(AssetManager.tap);
			credits = new Sprite(AssetManager.credits);
			gameover = new Sprite(AssetManager.gameover);
			scor = new Sprite(AssetManager.score);
			title.setBounds(w/3-w/6, h/2, w/2, h/4);
			 xx = w/6;
			 yy=w/2-w/10;
			 back1 = new Sprite(AssetManager.day);
			 back2 = new Sprite(AssetManager.dawn);
			 back3 = new Sprite(AssetManager.night);
			 back11 = new Sprite(AssetManager.day);
			 back22 = new Sprite(AssetManager.dawn);
			 back33 = new Sprite(AssetManager.night);
			 best = new Sprite(AssetManager.best);
			 credit = new Sprite(AssetManager.credits);
			back1.setBounds(0, 0, w, h);
			back2.setBounds(0, 0, w, h);
			back3.setBounds(0, 0, w, h);
			back11.setBounds(0, 0, w, h);
			back22.setBounds(0, 0, w, h);
			back33.setBounds(0, 0, w, h);
			
			bgxx = bgx;
			
			
		 
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		/*back1.setBounds(bgxx-w, 0, w, h);
		back2.setBounds(bgxx-w, 0, w, h);
		back3.setBounds(bgxx-w, 0, w, h);
		back11.setBounds(bgxx, 0, w, h);
		back22.setBounds(bgxx, 0, w, h);
		back33.setBounds(bgxx, 0, w, h);*/
		
		credit.setBounds(w/3-w/6, 0, 2*w/3, h/6);
		
		c1.setBounds(bgx-w, 0, w, h);
		c2.setBounds(bgx, 0, w, h);
		bgx-=Gamespeed/2;
		bgxx-=Gamespeed/3;
		if(bgx<=0)
		{
			bgx=w;
		}
		
		if(bgxx<=0)
			bgxx=w;
		
		
		
		
		switch(state){
		
		case starting:
			
			System.out.println("Starting State");
			Player.plane.setPosition(plane.pos.x, plane.pos.y);
			
			
			
			title.setBounds(xx-w/12, h/2+h/12, w/2+w/3, h/3);
			tap.setBounds(yy, h/3, w/3+w/12, h/7);
			
			if(Gdx.input.justTouched())
			{
				
				startnow=true;
			}
			
			if(startnow)
			{
				xx-=Gamespeed*Gamespeed;
			}
			
			if(title.getX()<0-title.getWidth())
			{
				yy+=Gamespeed*Gamespeed;
					
			}
			
			if(yy>w)
			{
				state = gamestate.playing;
			}
			game.batch.begin();
			
			if(score<=20)
			{
			back1.draw(game.batch);
			back11.draw(game.batch);
			}
		if(score>20 && score<=30)
			{
			back2.draw(game.batch);
			back22.draw(game.batch);
			}
		if(score>30)
			{
			back3.draw(game.batch);
			back33.draw(game.batch);
			}
			
			c1.draw(game.batch);
			c2.draw(game.batch);
			Player.plane.draw(game.batch);
			title.draw(game.batch);
			tap.draw(game.batch);
			credit.draw(game.batch);
			
			
			game.batch.end();
			
			
			
			break;
			
		case playing:
			
			//p.drawRectangle(p1.eplane.getX(), p1.eplane.getX(), p1.eplane.getWidth(), p1.eplane.getHeight());
			
			
			
			
			System.out.println("Playing State");
			Gamespeed += (Gdx.graphics.getDeltaTime())/10;
			System.out.println("gameSpeed =" +Gamespeed);
			
			Player.plane.setPosition(plane.pos.x, plane.pos.y);
			p1.eplane.setPosition(p1.pos.x, p1.pos.y);
			p2.eplane.setPosition(p2.pos.x, p2.pos.y);
			p3.eplane.setPosition(p3.pos.x, p3.pos.y);
			
			p1.pos.x-=Gamespeed;
			p2.pos.x-=Gamespeed;
			p3.pos.x-=Gamespeed;
			
			
			//Respawning p1 
			if(p1.pos.x<0-p1.eplane.getWidth())
				{
				//AssetManager.scoreup.play();
				score++;
				p1.pos.x = MathUtils.random( w,2*w);
				p1.pos.y = MathUtils.random(0, h/3-p1.eplane.getHeight());
				if(p2.pos.x>w)
				{
					if(p1.pos.x-p2.pos.x<w/3 || p2.pos.x-p1.pos.x<w/3)
					{
						p1.pos.x+=w/3;
					}
				}
				if(p3.pos.x>w)
				{
					if(p1.pos.x-p3.pos.x<w/3 || p3.pos.x-p1.pos.x<w/3)
					{
					p1.pos.x+=w/4;
					}
				}
				}
			
			//Respawning p2
			if(p2.pos.x<0-p2.eplane.getWidth())
			{
				//AssetManager.scoreup.play();
				score++;
			p2.pos.x = MathUtils.random(w, 2*w);
			p2.pos.y = MathUtils.random( h/3,2*h/3-p2.eplane.getHeight());
			
			if(p3.pos.x>w)
			{
				if(p2.pos.x-p3.pos.x<w/3 || p3.pos.x-p2.pos.x<w/3)
				{
				p2.pos.x+=w/3;
				}
			}
			if(p1.pos.x>w)
			{
				if(p2.pos.x-p1.pos.x<w/3 || p1.pos.x-p2.pos.x<w/3)
				{
					p2.pos.x+=w/3;
				}
			}
			
			
			
			}
			
			
			//Respawning p3
			if(p3.pos.x<0-p3.eplane.getWidth())
			{
				//AssetManager.scoreup.play();
				score++;
			p3.pos.x = MathUtils.random(w+w/3,2*w);
			p3.pos.y = MathUtils.random(2*h/3, h-p3.eplane.getHeight());
			if(p2.pos.x>w)
			{
				if(p3.pos.x-p2.pos.x<w/3 || p2.pos.x-p3.pos.x<w/3)
				{
					p3.pos.x+=w/4;
				}
			}
			if(p1.pos.x>w)
			{
				if(p3.pos.x-p1.pos.x<w/3 || p1.pos.x-p3.pos.x<w/3)
				{
					p3.pos.x+=w/4;
				}
			}
			}
			//spawn code above.
			//it ended here
			//drawing part below
			
			if(plane.pos.y>h- Player.plane.getHeight()||plane.pos.y<0)
			{
				state = gamestate.gameover;
			}
			
			
			game.batch.begin();
			
			if(score<20)
				{
				back1.draw(game.batch);
				back11.draw(game.batch);
				}
			if(score>20 && score < 30)
				{
				back2.draw(game.batch);
				back22.draw(game.batch);
				}
			if(score>30)
				{
				back3.draw(game.batch);
				back33.draw(game.batch);
				}
				
			c1.draw(game.batch);
			c2.draw(game.batch);
			Player.plane.draw(game.batch);
			p1.eplane.draw(game.batch);
			p2.eplane.draw(game.batch);
			p3.eplane.draw(game.batch);
			
			game.font.draw(game.batch, "choot : "+ score , 0, h-h/20);
			
			game.batch.end();
			
			checkinput();
			
			if(checkcollision(p1)||
			checkcollision(p2)||
			checkcollision(p3))
			{
			
			state = gamestate.gameover;
			
			}
			
			
			
			
			
			break;
			
		case gameover:
			
			Gamespeed=w/150;
			if(score >= pref.getInteger("HighScore"))
			{
			pref.putInteger("HighScore",score );
			pref.flush();
			}
			
			gameover.setBounds(xx, h/2, w/2+w/6, h/3);
			scor.setBounds(w/2-w/12-xx,h/20,w/2,h/3+h/12);
			
			
			System.out.println("gameOver");
			System.out.println("score is : "+score);
			game.batch.begin();
			
			if(score<20)
			{
			/*back1.draw(game.batch);
			back11.draw(game.batch);*/
				back2.draw(game.batch);
				back22.draw(game.batch);
			}
		if(score>20 && score < 30)
			{
			back2.draw(game.batch);
			back22.draw(game.batch);
			}
		if(score>30)
			{
			back3.draw(game.batch);
			back33.draw(game.batch);
			}
			c1.draw(game.batch);
			c2.draw(game.batch);
			Player.plane.draw(game.batch);
			p1.eplane.draw(game.batch);
			p2.eplane.draw(game.batch);
			p3.eplane.draw(game.batch);
			gameover.draw(game.batch);
			scor.draw(game.batch);
			game.font.draw(game.batch, Integer.toString(score), w-w/4-xx, h/3+h/20);
			
			s2.draw(game.batch, Integer.toString(pref.getInteger("HighScore")), w-w/4-xx, h/3-h/10);
			
			game.batch.end();
			
			
			if(xx>=w/3-w/6)
			{
				
				xx =w/3-w/6;
				endnow = true;
			}else
				xx+=Gamespeed*Gamespeed;
			
			
			
			if(endnow)
			{
				if(Gdx.input.justTouched())
				{
					
					restart();
					state = gamestate.starting;
					
				}
				
			}
			
			
			
			
			break;
		
		
		}
		
		
		
		
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		Assets.dispose();
		s2.dispose();
		
	}
	
	
	public void checkinput()
	{
		if(Gdx.input.justTouched()||Gdx.input.isKeyPressed(Keys.SPACE))
		{
			if(moveup==true)
				moveup=false;
			else
				moveup=true;
		}
		
		
		
		
		
		if(moveup)
		{
			plane.speedy =  (Gdx.graphics.getDeltaTime()*40);
			plane.pos.y = plane.pos.y + Gamespeed*plane.speedy;
			Player.plane.rotate(plane.speedy/2);
		}
		else
		{
			plane.speedy =  (Gdx.graphics.getDeltaTime()*50);
			plane.pos.y = plane.pos.y - Gamespeed*plane.speedy;
			Player.plane.rotate(-plane.speedy/2);
		}
		
	}
	
	public boolean checkcollision(Enemy bb)
	{	
		
		
		
		a.x= plane.pos.x+w/30;
		a.y = plane.pos.y+h/24;
		a.height = Player.plane.getHeight() - h/24;
		a.width = Player.plane.getWidth() - w/25;
		
		b.x=bb.pos.x + w/30;
		b.y = bb.pos.y +h/24;
		b.height = bb.eplane.getHeight() - h/24;
		b.width = bb.eplane.getWidth() - w/25;
		
		
		System.out.println(bb.bounds.height+" "+bb.bounds.width);
		System.out.println(bb.bounds.x+" "+bb.bounds.y);
		
		
		if(Intersector.intersectRectangles(a, b, c))
		{
			System.out.println("Collision");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void restart(){
	plane.speedy = 0;
	moveup = false;
	 Gamespeed = w/150;
	 score =0;
	 game.font.setColor(0, 0, 0, 1);
	 p1.pos.x=MathUtils.random(w, 2*w);
	 p2.pos.x=MathUtils.random(w, 2*w);
	 p3.pos.x=MathUtils.random(w, 2*w);
	 p1.eplane.setPosition(p1.pos.x, h/3);
		p2.eplane.setPosition(p2.pos.x, 2*h/3);
		p3.eplane.setPosition(p3.pos.x, h-h/5);
		/*Player.plane.setPosition(w/6,h/3);
		plane.pos.y=h/3;
		
		Player.plane.rotate(10);
	*/
		plane = new Player(w/6,h/3,w,h);
		xx = w/6;yy=w/2-w/10;
		startnow = false;
		endnow=false;
		
		
	}

}
