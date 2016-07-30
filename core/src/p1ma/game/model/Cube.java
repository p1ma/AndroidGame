package p1ma.game.model;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by p1ma on 28/07/16.
 */
public abstract class Cube {

    public static int CUBE_DIM = 64;
    private int point;
    private float speed;
    private Vector2 position;
    private Rectangle boundingBox;


    public Cube(int value, Vector2 pos){
        this.point = value ;
        this.speed = 9.81f;
        this.position = pos;
    }

    public abstract Texture getTexture();

    public int getPoint(){
        return point;
    }

    public void setBoundingBox(Rectangle rec){
        boundingBox = rec;
    }

    public Vector2 getPosition(){
        return position;
    }
}
