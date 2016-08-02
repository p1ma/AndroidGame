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
    protected float speed;
    private Vector2 position;
    private Rectangle boundingBox;
    private Vector2 spawnPosition;
    private boolean visible;
    private boolean touchable;

    public enum Direction{
        LEFT,RIGHT,UP,DOWN
    }

    private Direction direction;

    public Cube(int value, Vector2 pos, boolean touch){
        this.point = value ;
        this.position = pos;
        this.spawnPosition = new Vector2(pos);
        this.boundingBox = new Rectangle(position.x, position.y,1,1);
        this.direction = Direction.DOWN;
        this.speed = 4.04f;
        this.visible = true;
        this.touchable = touch;
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

    public String toString(){
        return "( " + position.toString() + " )";
    }

    public abstract void move(float delta);

    public void moveDown(float spd){
        this.position.y -= spd;
        this.boundingBox.y -= spd;
    }

    public void incrY(float y){
        this.position.y += y;
        this.boundingBox.y += y;
    }

    public void incrX(float x){
        this.position.x += x;
        this.boundingBox.x += x;
    }

    public boolean isAlive(){
        return (this.position.y >= -1.1f);
    }

    public Vector2 getSpawnPosition(){
        return spawnPosition;
    }

    public void updateSpawn(){
        this.spawnPosition = new Vector2(this.position);
    }

    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean b){
        visible = b;
    }

    public boolean collision(Vector2 pos){
        return boundingBox.contains(pos);
    }

    public boolean isTouchable(){
        return touchable;
    }
}
