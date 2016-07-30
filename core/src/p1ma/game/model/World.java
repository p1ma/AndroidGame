package p1ma.game.model;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

import p1ma.game.view.GameScreen;

/**
 * Created by p1ma on 28/07/16.
 */
public class World {

    private GameScreen gameScreen;

    // world's elements table
    private Cube[][] table;

    // cubes
    private ArrayList<Cube> cubes;

    // width and height
    public static int HEIGHT = 10;
    public static int WIDTH = 6;

    public World(GameScreen game){
        this.gameScreen = game;

        /*
        obj
           when HEIGHT = 0 ; cubes pop but not visibles by the user
           when HEIGHT = 12 : cubes die
         */
        this.table = new Cube[HEIGHT + 2][WIDTH] ;

        this.cubes = new ArrayList<Cube>();

        // TEST CUBES (x,y)
        cubes.add(new BlackCube(new Vector2(0,0)));
        cubes.add(new RedCube(new Vector2(1,1)));
        cubes.add(new YellowCube(new Vector2(2,2)));
        cubes.add(new BlueCube(new Vector2(3,3)));
        cubes.add(new BlackCube(new Vector2(4,4)));
        cubes.add(new YellowCube(new Vector2(5,5)));
    }

    public Iterator<Cube> cubeIterator(){
        return  cubes.iterator();
    }


}
