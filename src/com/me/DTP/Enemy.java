package com.me.DTP;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	
	Sprite eplane;
	Vector2 pos;
	Rectangle bounds;
	float speedy;
	float rotation;
	
	
	public Enemy(float x,float y,float w,float h)
	{	
		
		rotation = -10;
		pos = new Vector2();
		eplane = new Sprite(AssetManager.EPlane);
		pos.x = MathUtils.random(w, 2*w);
		pos.y = y;
		eplane.setOrigin(3*w/40, h/10);
		eplane.rotate(10);
		
		eplane.setBounds(pos.x, pos.y, w/8, h/10);
		bounds = eplane.getBoundingRectangle();
		speedy =0;
	}

	
	public Rectangle getBounds() {
		return bounds;
	}


	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}


	public float getRotation() {
		return rotation;
	}


	public void setRotation(float rotation) {
		this.rotation = rotation;
	}


	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	


}
