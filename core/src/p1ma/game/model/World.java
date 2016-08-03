package p1ma.game.model;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import p1ma.game.view.GameScreen;

/**
 * Created by p1ma on 28/07/16.
 */
public class World {

    private GameScreen gameScreen;

    // cubes
    private ArrayList<Cube> cubes;

    // width and height
    public final static int HEIGHT = 24;
    public final static int WIDTH = 8;

    // space between 2 cubes
    public final static float SPACE = 0.10f; // test

    //cube's speed
    public static float speed = 4.04f;

    // freeze time/duration & coefficient
    public boolean speedFrozen;
    public static long freezeStart;
    public static long freezeDuration = 5000; // 5000 ms = 5s
    public final static float freeze = 2.02f;

    public World(GameScreen game){
        this.gameScreen = game;

        this.speedFrozen = false;

        /*
        obj
           when HEIGHT = 0 ; cubes pop but not visibles by the user
           when HEIGHT = 12 : cubes die
         */
        this.cubes = new ArrayList<Cube>();

        // TEST CUBES (x,y)
        //cubes.add(new BlackCube(new Vector2(0,6)));
        //cubes.add(new RedCube(new Vector2(1,6)));
        //cubes.add(new YellowCube(new Vector2(2,6)));
        //cubes.add(new BlueCube(new Vector2(3,6)));
        //cubes.add(new BlackCube(new Vector2(4,6)));
        //cubes.add(new YellowCube(new Vector2(5,1)));

        /*
            Try to complete all screen with cubes
         */
       /* for(int i = 0 ; i < WIDTH ; i++)
        {
            for(int j = 0 ; j < HEIGHT ; j++)
            {
                Cube c = randomCube(i, j);
                if(putCube()) {
                    c.setVisible(true);
                }else{
                    c.setVisible(false);
                }
                cubes.add(c);
            }
        }*/

        for(int i = 0 ; i < HEIGHT ; i++){
            for(int j = 0 ; j < WIDTH ; j++){
                Cube c = randomCube(j, i);
                if(putCube()) {
                    c.setVisible(true);
                }else{
                    c.setVisible(false);
                }
                cubes.add(c);
            }
        }
    }

    public Iterator<Cube> cubeIterator(){
        return  cubes.iterator();
    }

    public void update(float delta){
        long time = System.currentTimeMillis();
        if(time >= freezeStart + freezeDuration && speedFrozen){
            speed += freeze;
            speedFrozen = false;
            normalGame();
        }
        ArrayList<Cube> deadCubes = new ArrayList<Cube>();
        for(Cube c : cubes){
            c.move(delta);
            if(!(c.isAlive())){
                deadCubes.add(c);
            }
        }
        updateCubeArray(deadCubes);
    }

    public Cube randomCube(int i, int j){
        Random r = new Random();
        int choice = r.nextInt(100);
        /*
            if choice E [0,5[ => BlueCube
            if choice E [5,30[ => BlackCube
            if choice E [30,70[ => RedCube
            if choice E [70,100] => YellowCube
         */
        Vector2 position = new Vector2(i + i*SPACE,j + j*SPACE);
        if( choice < 5 ){
            return new BlueCube(position);
        }
        if ( choice >= 5 && choice < 30 ){
            return new BlackCube(position);
        }
        if(choice >= 30 && choice < 70){
            return new RedCube(position);
        }
        return new YellowCube(position);
    }

    public Cube renewCube(float i, float j){
        Random r = new Random();
        int choice = r.nextInt(100);
        /*
            if choice E [0,5[ => BlueCube
            if choice E [5,30[ => BlackCube
            if choice E [30,70[ => RedCube
            if choice E [70,100] => YellowCube
         */
        Vector2 position = new Vector2(i,j);
        if( choice < 5 ){
            return new BlueCube(position);
        }
        if ( choice >= 5 && choice < 30 ){
            return new BlackCube(position);
        }
        if(choice >= 30 && choice < 70){
            return new RedCube(position);
        }
        return new YellowCube(position);
    }

    /*
        TEST : 10% of cube per line
     */
    public boolean putCube(){
        float pourcent = 0.1f * WIDTH;
        Random r = new Random();
        float ind = (r.nextFloat() * 10)%WIDTH;
        return (ind < pourcent);
    }

    public void setCubesPosition() {
        for(Cube c : cubes){
            c.incrY((HEIGHT - 1 ) + HEIGHT * SPACE) ; // add c.y += HEIGHT ~ 25.4
            c.updateSpawn();
        }
    }

    public void updateCubeArray(ArrayList<Cube> deadCubes){
        if(deadCubes.size() > 0) {
            cubes.removeAll(deadCubes);
            int size = cubes.size() - 1;
            for (int i = size; i > (size - 8); i--) {
                Cube c = cubes.get(i);
                Cube cube = renewCube(c.getPosition().x, c.getPosition().y + SPACE + 1);
                if(putCube()){
                    cube.setVisible(true);
                }else{
                    cube.setVisible(false);
                }
                cubes.add(cube);
            }
        }
    }

    public void verify(float x, float y){
        System.out.println("Clicked at (" + x + " , " + y + ")");
        Vector2 pos = new Vector2(x,y);
        for(Cube c : cubes) {
            if (c.isVisible()) {
                if (c.collision(pos)) {
                    Cube.Colors color = c.getColor();
                    if (color == Cube.Colors.BLACK) {
                        System.out.println("Cube noir touché.");
                        gameScreen.minusOneLife();
                    }
                    if (color == Cube.Colors.BLUE){
                        if(!speedFrozen){
                            speedFrozen = true;
                            freezeGame();
                        }
                        System.out.println("Cube bleu : " + c + "touché.");
                    }
                    gameScreen.addScore(c.getPoint());
                    c.setVisible(false);
                    break;
                }
            }
        }
    }

    public void freezeGame(){
        speed -= freeze;
        freezeStart = System.currentTimeMillis();
        for(Cube c : cubes){
            c.freezeSpeed(freeze);
        }
    }
    public void normalGame(){
        for(Cube c : cubes){
            c.setSpeed(speed);
        }
    }
}
