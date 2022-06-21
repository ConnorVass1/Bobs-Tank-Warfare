import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class PlayerOne extends Players
{
    //String setImage("folder/hp"+player.hp+".png"):
    //creates variables for player one, and identifies any objects needed, such as the tank selected on the selection screen
    int HP=0;
    int speedX = 0;
    int speedY = 0;
    int damage;
    int FrameCount = 0;
    int HPFrameCount;
    int PowerUpframecount=0;
    int PowerUpframecount2=0;
    int KnockbackFrameCount = 0;
    int P1class;
    int P2class;
    boolean onstart = true;
    GreenfootSound damagepower = new GreenfootSound("Ac130.mp3");
    

    
    GreenfootSound shoot = new GreenfootSound("shoot.mp3");
    GreenfootSound move = new GreenfootSound("move.mp3");

    
    AmogusMKII amog= new AmogusMKII();
    BigChonkers chonk= new BigChonkers();
    Bob bob= new Bob();
    GlassCannon glass= new GlassCannon();
    
    
    MyWorld myworld;
    
    
    //allows playerone to check the tank selected for player one and two.
    public PlayerOne(int sel, int sel2)
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
        if (HP==0||myworld.player2.HP==0)
        {
            return;
        }
        movement();
        HPMechanics();
        bulletmovement();
        collision();
        PowerUps();
        Knockback();

        

        
        PlayerOne player2;

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
        
        
        
        
        
        PlayerTwo s3=(PlayerTwo) getOneObjectAtOffset(0- getImage().getWidth()/2,0, PlayerTwo.class);
        if (s3!=null) 
        {
            setLocation(s3.getX()+s3.getImage().getWidth()/2
            +getImage().getWidth()/2,getY());
        }
        
        PlayerTwo s4=(PlayerTwo) getOneObjectAtOffset(0+ getImage().getWidth()/2,0,PlayerTwo.class);
        if (s4!=null) 
        {
            setLocation(s4.getX()-s4.getImage().getWidth()/2
            -getImage().getWidth()/2,getY());   
        }
        
        PlayerTwo pf3=(PlayerTwo) getOneObjectAtOffset(0, getImage().getHeight()/2, PlayerTwo.class);
        if (pf3!=null) 
        {
            setLocation(getX(),pf3.getY()-pf3.getImage().getHeight()/2
            -getImage().getHeight()/2+1);
        }
        
        PlayerTwo sg4=(PlayerTwo) getOneObjectAtOffset(0,- getImage().getHeight()/2, PlayerTwo.class);
        if (sg4!=null) 
        {
            setLocation(getX(), sg4.getY()+sg4.getImage().getHeight()/2
            +getImage().getHeight()/2);
        }
        
        
        
        
        
        
    }
    
    
    public void movement()
    {
        //movement controls for tank, and sets rotation to face towards the other tank
        
        
        if(Greenfoot.isKeyDown("D"))
        {
            turn(speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("A"))
        {
            turn(-speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("W"))
        {
            move(speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("S"))
        {
            move(-speedX);
            move.play();
        }
    }
    
    
    public void bulletmovement()
    {
        //allows for bullet to shot when enter is pressed.
        FrameCount++;
        if(Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
             Bullet bullet = new Bullet(5,0);
             bullet.setRotation(getRotation());
             getWorld().addObject(bullet, getX(), getY());
             shoot.play();
             FrameCount = 0;
        }
    }
    
    public void HPMechanics()
    {
        //detects if player has taken damage, and changes hp based on playerones current damage.      
        HPFrameCount++;
        if(isTouching(Bullet2.class) && HPFrameCount > 96||isTouching(PlayerTwo.class)&& HPFrameCount > 96)
        {
            HP = HP - myworld.player2.damage;
            HPFrameCount = 0;
        }
        
        if (HP==0)
        {
            getWorld().addObject(new PlayerTwoWins(), 500, 300);
            
        }
    }
    
    
    
    public void PowerUps()
    {
          
        if(isTouching(Heal.class) && HP < 15)
        {
            HP = HP + 1;
        }
        
        if(isTouching(Speed.class))
        {
            
            if(PowerUpframecount<=100)
            {
                speedX=speedX+5;
            }
        }
        
        if(speedX >= 7)
        {
            PowerUpframecount++;
        }
        
        if (PowerUpframecount > 300)
        {
            speedX=speedX-5;
            PowerUpframecount = 0;
        }
        
        if(isTouching(Damage.class))
        {
            damagepower.play();
            PowerUpframecount2++;
            if(PowerUpframecount2<=100)
            {
                damage=damage+1;
            }
        }

        if(PowerUpframecount2 > 0)
        {
            PowerUpframecount2++;
        }
        
        if(PowerUpframecount2 > 400)
        {
            damage = damage - 1;
            PowerUpframecount2 = 0;
        }
    }
    
    public void setclass()
    {
        //based on playerone selection, sets the hp, speed, and damage of the tanks.
        if(P1class==1)
        {
            HP= amog.HP;
            speedX=amog.speedX;
            speedY=amog.speedX;
            damage= amog.damage;
            setImage("SpeedTank.png");
        }
        
        if(P1class==2)
        {
            HP= chonk.HP;
            speedX=chonk.speedX;
            speedY=chonk.speedX;
            damage= chonk.damage;
            setImage("Tanky.png");
        }
        
        if(P1class==3)
        {
            HP= bob.HP;
            speedX=bob.speedX;
            speedY=bob.speedX;
            damage= bob.damage;
            setImage("Normp1.png");
        }
        
        if(P1class==4)
        {
            HP= glass.HP;
            speedX=glass.speedX;
            speedY=glass.speedX;
            damage= glass.damage;
            setImage("dmgTank.png");
        }
    }
    
    public void Knockback()
    {
        //detects if bullet is touching a side of the tank, and knocks it back depending on where bullet hit.
        Bullet2 a1=(Bullet2) getOneObjectAtOffset(0 + getImage().getWidth()/2,0, Bullet2.class);
        if (a1!=null) 
        {
            setLocation(getX() - speedX/2, getY());  
        }
        Bullet2 a2=(Bullet2) getOneObjectAtOffset(0 - getImage().getWidth()/2,0, Bullet2.class);
        if (a2!=null) 
        {
            setLocation(getX() + speedX/2, getY());  
        }
        Bullet2 a3=(Bullet2) getOneObjectAtOffset(0, 0 - getImage().getHeight()/2, Bullet2.class);
        if (a3!=null) 
        {
            setLocation(getX(), getY() + speedX/2);  
        }
        Bullet2 a4=(Bullet2) getOneObjectAtOffset(0, 0 + getImage().getHeight()/2, Bullet2.class);
        if (a4!=null) 
        {
            setLocation(getX(), getY() - speedX/2);  
        }
        
        
    }
    
}
