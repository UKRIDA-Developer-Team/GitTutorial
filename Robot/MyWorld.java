import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Human human = new Human();
        addObject(human,30,36);
        brick brick = new brick();
        addObject(brick,59,122);
        brick brick2 = new brick();
        addObject(brick2,528,120);
        Block block = new Block();
        addObject(block,224,84);
        block.setLocation(219,122);
        brick brick3 = new brick();
        addObject(brick3,400,122);
        brick2.setLocation(528,136);
        brick2.setLocation(521,127);
        brick2.setLocation(512,123);
    }
}
