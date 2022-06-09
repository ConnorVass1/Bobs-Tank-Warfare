import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2Selection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2Selection extends World
{

    /**
     * Constructor for objects of class Player2Selection.
     * 
     */
    public Player2Selection()
    {    
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cursor cursor = new Cursor();
        addObject(cursor,62,132);
        AmogusMKII amogusMKII = new AmogusMKII();
        addObject(amogusMKII,589,4);
        BigChonkers bigChonkers = new BigChonkers();
        addObject(bigChonkers,148,312);
        Bob bob = new Bob();
        addObject(bob,298,305);
        removeObject(cursor);
        CursorP2 cursorP2 = new CursorP2();
        addObject(cursorP2,84,110);
    }
}
