package com.me.DTP;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	
	static Sprite plane;
	Vector2 pos;
	Rectangle bounds;
	float speedy;
	float rotation;
	
	
	public Player(float x,float y,float w,float h)
	{	
		
		rotation = -10;
		pos = new Vector2();
		plane = new Sprite(AssetManager.PPlane);
		pos.x = x;
		pos.y = y;
		plane.setOrigin(3*w/40, h/10);
		Player.plane.rotate(-10);
		
		plane.setBounds(pos.x, pos.y, w/8, h/10);
		bounds = plane.getBoundingRectangle();
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
