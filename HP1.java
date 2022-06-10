import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP1 extends HPBars
{
    
    int P1class;
    int P2class;
    public HP1(int sel, int sel2)
    {
        P1class=sel;
        P2class=sel2;
    }
    PlayerOne p1= new PlayerOne(P1class, P2class);
    
    
    public void act()
    {
        while(p1.HP>0)
        {
            String image="hearts/"+p1.HP+".png";
            setImage("image");
        }
        if (p1.HP==0)
        {
            setImage("folder/hp0.png");
        }
    }
}
