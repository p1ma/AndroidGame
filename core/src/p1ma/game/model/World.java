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

    // cubes
    private ArrayList<Cube> cubes;

    // width and height
    public final static int HEIGHT = 24;
    public final static int WIDTH = 8;

    public World(GameScreen game){
        this.gameScreen = game;

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
        for(int i = 0 ; i < WIDTH ; i++)
        {
            for(int j = 0 ; j < HEIGHT ; j++)
            {
                if(j%2 == 0) {
                    if (i % 2 == 0) {
                        cubes.add(new RedCube(new Vector2(i, j)));
                    } else {
                        cubes.add(new BlackCube(new Vector2(i, j)));
                    }
                }
            }
        }
    }

    public Iterator<Cube> cubeIterator(){
        return  cubes.iterator();
    }

    public void update(float delta){
        for(Cube c : cubes){
            c.move(delta);
        }
    }
}
