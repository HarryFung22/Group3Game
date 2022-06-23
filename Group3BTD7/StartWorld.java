import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the start world, where the player can navigate our main menu.
 * Players can start the world or check the instructions on how to play.
 * 
 * <p> Game Music: https://www.youtube.com/watch?v=edwooGpMg8g
 * 
 * @author Aiden S
 * @version June 7, 2022
 */
public class StartWorld extends World
{
    GreenfootImage background = new GreenfootImage("BTD700 Background.jpg");
    private UserInfo userInfo;
    private String displayText;
    private GreenfootImage welcomeText;

    GreenfootSound main = new GreenfootSound("Intro.wav");

    //Constructor for the StartWorld
    public StartWorld()
    {    
        super(800, 600, 1);
        background.scale(800,600);
        setBackground(background);
        if(UserInfo.isStorageAvailable()){
            userInfo = UserInfo.getMyInfo();
            if(userInfo != null){
                displayText = "Welcome " + userInfo.getUserName();
            } else{
                displayText = "Welcome player, please login to save your scores!";
            }
        } else{
            displayText = "Note: Storage is full.";
        }
        welcomeText = new GreenfootImage(displayText, 24, Color.WHITE,null);
        getBackground().drawImage(welcomeText, 335, 400);
    }

    /**
     * Checks for user input
     */
    public void act(){
        //plays the intro background music
        main.setVolume(20);
        main.playLoop();
        if(Greenfoot.isKeyDown("space")){
            main.stop();
            Greenfoot.setWorld(new GameWorld());
        }else if(Greenfoot.isKeyDown("i")){
            main.stop();
            Greenfoot.setWorld(new InstructionWorld());
        }
    }
}
