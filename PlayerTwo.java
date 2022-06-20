import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Players
{   
    //creates variables for player one, and identifies any objects needed, such as the tank selected on the selection screen
    int HP=0;
    int speedX;
    int speedY;
    int damage;
    int FrameCount;
    int HPFrameCount;
    int P1class;
    int P2class;
    int PowerUpframecount;
    boolean onstart = true;
    GreenfootSound damagepower = new GreenfootSound("Ac130.mp3");
    //class initializations
    AmogusMKII amog= new AmogusMKII();
    BigChonkers chonk= new BigChonkers();
    Bob bob= new Bob();
    GlassCannon glass= new GlassCannon();
    int Powerupframecount;
    int Powerupframecount2;
    MyWorld myworld;
    
    //allows playerone to check the tank selected for player one and two.
    public PlayerTwo(int sel, int sel2)
    {
        P1class=sel;
        P2class=sel2;
        setclass();
    }
    
    //Used to identify main play area and add objects to main play area.
    protected void addedToWorld​(World world)
    {
        myworld= (MyWorld) world;
    }
    
    public void act()
    {
        if (HP==0||myworld.player1.HP==0)
        {
            return;
        }
        movement();
        HPMechanics();

        Knockback();
        

        bulletmovement();
        collision();
        PowerUps();
        System.out.println(speedX);
    }
    
    public void collision()
    {
        //detects if the tank is in contact with a wall, and if so, does not allow the tank to pass through.
        Wall s1=(Wall) getOneObjectAtOffset(0- getImage().getWidth()/2,0, Wall.class);
        if (s1!=null) 
        {
            setLocation(s1.getX()+s1.getImage().getWidth()/2
            +getImage().getWidth()/2,getY());
        }
        
        Wall s2=(Wall) getOneObjectAtOffset(0+ getImage().getWidth()/2,0, Wall.class);
        if (s2!=null) 
        {
            setLocation(s2.getX()-s2.getImage().getWidth()/2
            -getImage().getWidth()/2,getY());   
        }
        
        Wall pf=(Wall) getOneObjectAtOffset(0, getImage().getHeight()/2, Wall.class);
        if (pf!=null) 
        {
            setLocation(getX(),pf.getY()-pf.getImage().getHeight()/2
            -getImage().getHeight()/2+1);
        }
        
        Wall sg=(Wall) getOneObjectAtOffset(0,- getImage().getHeight()/2, Wall.class);
        if (sg!=null) 
        {
            setLocation(getX(), sg.getY()+sg.getImage().getHeight()/2
            +getImage().getHeight()/2);
        }

    }
    
    public void PowerUps()
    {
        //changes tank variables depending on what power up is collected, as well as frame counts to remove powerup effects.
        if(isTouching(Heal.class) && HP < 15)
        {
            HP = HP + 1;
        }
        
        if(isTouching(Speed.class))
        {
            
            if(PowerUpframecount<=300)
            {
                speedX=speedX+5;
            }
        }
        
        if (PowerUpframecount > 300)
        {
            speedX=speedX-5;
            PowerUpframecount = 0;
        }
        
        if(speedX >= 7)
        {
            PowerUpframecount++;
        }
        
        if(isTouching(Damage.class))
        {
            Powerupframecount2++;
            if(Powerupframecount2<=100)
            {
                damage=damage+1;
            }
        }

        if(Powerupframecount2 > 0)
        {
            Powerupframecount2++;
        }
    
        
        
        if(Powerupframecount2 > 400)
        {
            damage = damage - 1;
            Powerupframecount2 = 0;
        }
    }
    
    public void movement()
    {
        //movement controls for tank, and sets rotation to face towards the other tank
        
        if(Greenfoot.isKeyDown("Right"))
        {
            turn(speedX);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            turn(-speedX);
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            move(speedX);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            move(-speedX);
        }
    
    }
    
    public void bulletmovement()
    {
        //allows for bullet to shot when enter is pressed.
        FrameCount++;
        
        if(Greenfoot.isKeyDown("Enter") && FrameCount > 30)
        {
             Bullet2 bullet2 = new Bullet2(5,0);
             bullet2.setRotation(getRotation());
             getWorld().addObject(bullet2, getX(), getY());
             FrameCount = 0;
        }
    }
    
    public void HPMechanics()
    {
        //detects if player has taken damage, and changes hp based on playerones current damage.
        HPFrameCount++;
        if(isTouching(Bullet.class) && HPFrameCount > 96||isTouching(PlayerOne.class)&& HPFrameCount > 96)
        {
            HP = HP - myworld.player1.damage;
            HPFrameCount = 0;
        }
        
        if (HP==0)
        {
            getWorld().addObject(new PlayerOneWins(), 500, 300);
        }
        
        
        
        
    }
    
    public void setclass()
    {
        
        //based on playertwo selection, sets the hp, speed, and damage of the tanks.
        if(P2class==1)
        {
            HP= amog.HP;
            speedX=amog.speedX;
            damage= amog.damage;
            setImage("SpeedTankp.png");
        }
        
        if(P2class==2)
        {
            HP= chonk.HP;
            speedX=chonk.speedX;
            damage= chonk.damage;
            setImage("Tankyp.png");
        }
        
        if(P2class==3)
        {
            HP= bob.HP;
            speedX=bob.speedX;
            damage= bob.damage;
            setImage("Normp2.png");
        }
        
        if(P2class==4)
        {
            HP= glass.HP;
            speedX=glass.speedX;
            damage= glass.damage;
            setImage("dmgTankp.png");
        }
    }
    
    public void Knockback()
    {
        //detects if bullet is touching a side of the tank, and knocks it back depending on where bullet hit.
        Bullet a1=(Bullet) getOneObjectAtOffset(0 + getImage().getWidth()/2,0, Bullet.class);
        if (a1!=null) 
        {
            setLocation(getX() - speedX/2, getY());  
        }
        Bullet a2=(Bullet) getOneObjectAtOffset(0 - getImage().getWidth()/2,0, Bullet.class);
        if (a2!=null) 
        {
            setLocation(getX() + speedX/2, getY());  
        }
        Bullet a3=(Bullet) getOneObjectAtOffset(0, 0 - getImage().getHeight()/2, Bullet.class);
        if (a3!=null) 
        {
            setLocation(getX(), getY() + speedX/2);  
        }
        Bullet a4=(Bullet) getOneObjectAtOffset(0, 0 + getImage().getHeight()/2, Bullet.class);
        if (a4!=null) 
        {
            setLocation(getX(), getY() - speedX/2);  
        }
        
        
    }
}
