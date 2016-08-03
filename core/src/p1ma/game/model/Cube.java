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

    public enum Colors{
        RED,YELLOW,BLACK,BLUE
    }

    private Direction direction;
    protected Colors color;

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
        return this.spawnPosition;
    }

    public void updateSpawn(){
        this.spawnPosition = new Vector2(this.position);
    }

    public boolean isVisible(){
        return this.visible;
    }

    public void setVisible(boolean b){
        this.visible = b;
    }

    public boolean collision(Vector2 pos){
        return this.boundingBox.contains(pos);
    }

    public boolean isTouchable(){
        return this.touchable;
    }

    public void setSpeed(float spd){
        this.speed = spd;
    }

    public void setDefaultSpeed(){
        this.speed = 4.04f;
    }

    public Colors getColor(){
        return this.color;
    }
}
