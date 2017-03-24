package Personnage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Perso extends Sprite{
	Vector2 previousPosition;
	
	public Perso(Texture texture){
		super(texture);
		previousPosition = new Vector2(getX(), getY());
	}
	
	public boolean hasMoved(){
		if(previousPosition.x !=getX() || previousPosition.y != getY()){
			previousPosition.x =getX();
			previousPosition.y = getY();
			return true;
		}
		return false;
	}

	public void setPosition(double x, double y) {
		setX((float) x);
		setY((float) y);
		
	}
}
