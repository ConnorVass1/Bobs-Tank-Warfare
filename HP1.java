import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP1 extends HPBars
{
    int HP;
    PlayerOne player;
    public HP1(PlayerOne p1)
    {
        player= p1;
    }
    
    
    public void act()
    {
        if(player.HP>0)
        {
            String image="hearts/"+player.HP+".png";
            setImage(image);
        }
        else if (player.HP==0)
        {
            setImage("folder/hp0.png");
        }
    }
}
