import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class LevelScreen extends BaseScreen
{
    //the initial things we need to get like the sounds and the name of objects
    Sound pH,Ph;//any variation of PH is just a placeholder
    Music PH;

    Submarine submarine;
    int coreHealth, score;
    Label CoreLabel, ScoreLabel;

    double laserTimer;
    Label laserStatus;
    double alienTimer;

    public void initialize()
    {
                BaseActor background = new BaseActor(0,0, mainStage);
        background.setAnimator( new Animator("assets/images/water.jpg") );
        background.setSize(800,800);
         
        submarine = new Submarine(300, 25, mainStage);

        //WE NEED TO BUILD A WALL
        Core leftWall = new Core(0,0, mainStage);
        leftWall.setSize(150, 800);
        leftWall.setBoundaryRectangle();

        Wall bottomtWall = new Wall(0,0, mainStage);
       bottomtWall.setSize(100,100);
        bottomtWall.setBoundaryRectangle();

        Wall topWall = new Wall(0,700, mainStage);
        topWall.setSize(800,100);
        topWall.setBoundaryRectangle();
        
        // ready to shoot immediately
        laserTimer = 1;
        //Alien spawn timer
        alienTimer = 0;

        
        score = 0;
        ScoreLabel = new Label("Score: " + score, BaseGame.labelStyle);
        ScoreLabel.setFontScale(0.5f);

        uiTable.add( ScoreLabel ).expandX().expandY().left().top().pad(20);
        uiTable.add().expandX();
        uiTable.add();
        uiTable.row();
        uiTable.add();
        uiTable.row();
        uiTable.add().expandY();
        uiTable.add();
        uiTable.add();

        
        
        
        
        
        
    }

    public void update(float deltaTime)
    {
        // move paddle to the left and to the right
        if (Gdx.input.isKeyPressed(Keys.UP))
            submarine.physics.accelerateAtAngle(90);

        if (Gdx.input.isKeyPressed(Keys.DOWN))
            submarine.physics.accelerateAtAngle(-90);

        laserTimer += deltaTime;
        alienTimer += deltaTime;

if ( submarine.isOnStage() )
        {
            // you can only shoot if:
            // 1. you just pressed the space key
            // 2. the submarine is still on the stage (still visible)
            // 3. at least one second has passed since previous shot (laserTimer > 1)
            if ( Gdx.input.isKeyJustPressed( Keys.SPACE ) && laserTimer > 1)
            {
                Laser laser = new Laser(0,0, mainStage);
                laser.centerAt( submarine );
                // reset timer, so player can not shoot until time goes by
                laserTimer = 0;
            }


            if (alienTimer >= 10)
            {
                float f;
                double RAND=Math.random() *600;
 
                EnemySub alien = new EnemySub(800, (float) RAND, mainStage);
                alienTimer= 0;
            }
}

        
        
                // stop paddle from passing through walls
        for (BaseActor wall : BaseActor.getList(mainStage, "Wall"))
        {
            submarine.preventOverlap(wall);
        }
        //ITEMS SPAWN
        for (BaseActor actor : BaseActor.getList(mainStage, "Item"))
        {
            Item item = (Item)actor;

            if ( submarine.overlaps(item) )
            {
                item.remove();

                if (item.itemName.equals("NAMED"))
                {
                    //WHAT IT DOES
                }
                else if (item.itemName.equals("")){
                }
            }
        }

    }
}