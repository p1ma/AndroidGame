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

    // cubes table
    private Cube[][] cubesTable;

    public World(GameScreen game){
        this.gameScreen = game;

        /*
        obj
           when HEIGHT = 0 ; cubes pop but not visibles by the user
           when HEIGHT = 12 : cubes die
         */
        this.cubes = new ArrayList<Cube>();
        this.cubesTable = new Cube[WIDTH][HEIGHT];

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
        for(int i = 0 ; i < WIDTH ; i++)
        {
            for(int j = 0 ; j < HEIGHT ; j++)
            {
                if(putCube()) {
                    cubes.add(randomCube(i, j));
                }
            }
        }
    }

    public Iterator<Cube> cubeIterator(){
        return  cubes.iterator();
    }

    public void update(float delta){
        ArrayList<Cube> deadCubes = new ArrayList<Cube>();
        for(Cube c : cubes){
            c.move(delta);
            if(!(c.isAlive())){
                deadCubes.add(c);
            }
        }
        updateCubeArray(deadCubes);
    }

    public void addCube(int i, int j, Cube c){
        this.cubesTable[i][j] = c;
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
        if( choice < 5 ){
            return new BlueCube(new Vector2(i + i*SPACE,j + j*SPACE));
        }
        if ( choice >= 5 && choice < 30 ){
            return new BlackCube(new Vector2(i + i*SPACE,j + j*SPACE));
        }
        if(choice >= 30 && choice < 70){
            return new RedCube(new Vector2(i + i*SPACE,j + j*SPACE));
        }
        return new YellowCube(new Vector2(i + i*SPACE,j + j*SPACE));
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
        if( choice < 5 ){
            return new BlueCube(new Vector2(i,j));
        }
        if ( choice >= 5 && choice < 30 ){
            return new BlackCube(new Vector2(i,j));
        }
        if(choice >= 30 && choice < 70){
            return new RedCube(new Vector2(i,j));
        }
        return new YellowCube(new Vector2(i,j));
    }

    /*
        TEST : 60% of cube per line
     */
    public boolean putCube(){
        float pourcent = 0.6f * WIDTH;
        Random r = new Random();
        float ind = (r.nextFloat() * 10)%WIDTH;
        return (ind < pourcent) ? true : false;
    }

    public void setCubesPosition() {
        for(Cube c : cubes){
            c.incrY(HEIGHT) ; // add c.y += HEIGHT
        }
    }

    public void updateCubeArray(ArrayList<Cube> deadCubes){
        cubes.removeAll(deadCubes);
        for(Cube c : deadCubes){
            if(putCube()){
                System.out.println("World (updateCubeArray) Respawn at : \n\t " + c.getSpawnPosition());
                Cube cube = renewCube(c.getSpawnPosition().x, c.getSpawnPosition().y);
                cube.incrY(HEIGHT);
                cubes.add(cube);
            }
        }
    }
}
