import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1Selection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1Selection extends World
{
    boolean onstart = true;

    /**
     * Constructor for objects of class Player1Selection.
     * 
     */
    public Player1Selection()
    {    
        super(300, 300, 1);

        prepare();
    }
    
    public void act()
    {
        if(onstart == true)
        {
            System.out.println("Welcome to Bob's Tank Warfare! To play as player one, use");
            System.out.println("Wasd to control the tank, and spacebar to fire.");
            System.out.println("To control player two, use the arrow keys and enter to fire");
            onstart = false;
        }
        
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Cursor cursor = new Cursor();
        addObject(cursor,153,148);
        Bob bob = new Bob();
        addObject(bob,72,68);
        BigChonkers bigChonkers = new BigChonkers();
        addObject(bigChonkers,73,236);
        GlassCannon glassCannon = new GlassCannon();
        addObject(glassCannon,225,244);
        AmogusMKII amogusMKII = new AmogusMKII();
        addObject(amogusMKII,232,70);
    }
}
