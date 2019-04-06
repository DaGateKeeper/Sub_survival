
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class InstructionScreen extends BaseScreen
{
    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.setAnimator( new Animator("assets/images/water.jpg") );
        background.setSize(800,600);

       BaseActor tenMore = new BaseActor(0,0, mainStage);
       tenMore.setAnimator( new Animator ("assets/images/extra-ammo.png"));
       tenMore.setSize(64,64);
       
       BaseActor core = new BaseActor(0,0, mainStage);
       core.setAnimator( new Animator ("assets/images/the-core.png"));
       core.setSize(64,64);
       
       BaseActor bomb = new BaseActor(0,0, mainStage);
       bomb.setAnimator( new Animator ("assets/images/bombOption3.jpg"));
       bomb.setSize(64,64);
       
       BaseActor piercing = new BaseActor(0,0, mainStage);
       piercing.setAnimator( new Animator ("assets/images/piercing.jpg"));
       piercing.setSize(64,64);
       
       BaseActor rapidFire = new BaseActor(0,0, mainStage);
       rapidFire.setAnimator( new Animator ("assets/images/rapidFire.jpg"));
       rapidFire.setSize(64,64);



        Label title = new Label("Instructions", BaseGame.labelStyle);
        title.setFontScale(1.5f);
        title.setColor( Color.BLUE );

        Label back = new Label("Press 'S' to Return", BaseGame.labelStyle);
        back.setColor( Color.CYAN );
        
        Label goal = new Label("Defend the Core!", BaseGame.labelStyle);
        goal.setColor( Color.CYAN );
        
         Label powerup1 = new Label("Powerup gives +10 Ammo", BaseGame.labelStyle);
        powerup1.setColor( Color.CYAN );
        
         Label powerup2 = new Label("Powerup destroys all Subs", BaseGame.labelStyle);
         powerup2.setColor( Color.CYAN );
        
        Label powerup3 = new Label("Powerup pierces Subs", BaseGame.labelStyle);
        powerup3.setColor( Color.CYAN );
        
        Label powerup4 = new Label("Powerup allows Rapid-shots", BaseGame.labelStyle);
        powerup4.setColor( Color.CYAN );
        
        
        //Label controls = new Label("Arrow Keys Move Turtle", BaseGame.labelStyle2);
       // instructions.setColor( Color.CYAN);
        
        //Label credits = new Label("Made by Angelo Morales", BaseGame.labelStyle2);
        //instructions.setColor( Color.CYAN );

        uiTable.add(title).colspan(2);
        uiTable.row();
        uiTable.add(core);
        uiTable.add(goal);
       // uiTable.row();
        uiTable.row();
        uiTable.add(tenMore);
        uiTable.add(powerup1);
        uiTable.row();
        uiTable.add(bomb);
        uiTable.add(powerup2).pad(10);
        uiTable.row();
        uiTable.add(piercing);
        uiTable.add(powerup3).pad(10);
        uiTable.row();
        uiTable.add(rapidFire);
        uiTable.add(powerup4).pad(10);
        uiTable.row();
        //uiTable.add(destroyPaddle);
       // uiTable.add(destroypaddleLabel).pad(10);
       // uiTable.row();
       // uiTable.add(ballSpeed);
       // uiTable.add(ballspeedLabel).pad(10);
        uiTable.row();
       // uiTable.add(paddle);
       // uiTable.add(instructions).pad(5);
        uiTable.row();
        //uiTable.add(instructions);
        uiTable.row();
        //uiTable.add(credits);
        
        

    }

    public void update(float deltaTime)
    {
        
         if (Gdx.input.isKeyJustPressed(Keys.S))
            BaseGame.setActiveScreen( new MenuScreen() );    
    }

    
}