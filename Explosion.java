import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
// TAKEN FROM SPACE ROCKS animation might not work.
public class Explosion extends BaseActor
{

    public Explosion(float x, float y, Stage stage)
    {
        super(x,y,stage);
        setAnimator( new Animator("assets/images/explosion.png", 5, 8, 0.02f, false) );
    }
    
    public void act(float deltaTime)
    {
        super.act(deltaTime);
        
        if ( this.animator.isAnimationFinished() )
            remove();
    }

}
