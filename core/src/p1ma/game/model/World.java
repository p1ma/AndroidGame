package p1ma.game.model;

import p1ma.game.view.GameScreen;

/**
 * Created by p1ma on 28/07/16.
 */
public class World {

    private GameScreen gameScreen;

    //world's elements
    private Cube[][] cubes;

    // width and height
    public static int WIDTH = 6;
    public static int HEIGHT = 10;

    public World(GameScreen game){
        this.gameScreen = game;

        /*
        obj
           when HEIGHT = 0 ; cubes pop but not visibles by the user
           when HEIGHT = 12 : cubes die
         */
        this.cubes = new Cube[HEIGHT + 2][WIDTH] ;

    }
}
