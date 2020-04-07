package PokemonEngine.Map;

import PokemonEngine.PlayGame;
import javafx.animation.Transition;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;

public class City {
    public String name;
    public Route inbound;
    public Route outbound;
    public PokemonCenter pokemonCenter;
    public Building[] buidings;

    protected double xPixels;
    protected double yPixels;

    protected Transition down;
    protected Transition up;

    protected ScrollPane scrollPane;
    protected ImageView sprite;
    protected Building building;

    public City(){

        this.down = new Transition() {
            {
                setCycleDuration(Duration.INDEFINITE);
            }
            @Override
            protected void interpolate(double v) {
                scrollPane.setVvalue(scrollPane.getVvalue() + 0.002);
            }
        };

        this.up = new Transition() {
            {
                setCycleDuration(Duration.INDEFINITE);
            }
            @Override
            protected void interpolate(double v) {
                scrollPane.setVvalue(scrollPane.getVvalue() - 0.002);
            }
        };
    }

    protected void keyPress(KeyEvent event) throws IOException {
        switch (event.getCode()){
            case W:
                if(!isClose(sprite, building.face)) {
                    PlayGame.getMe().backWalk(this.sprite);
                    up.play();
                }else{
                    up.stop();
                    sprite.setImage(PlayGame.getMe().overworldBack);
                }
                break;
            case A:
                break;
            case S:
                PlayGame.getMe().frontWalk(this.sprite);
                down.play();
                break;
            case D:
                break;
            case ENTER:
                if(isClose(sprite, building.face)){
                    this.building.enter();
                }
                break;
        }
    }

    protected void keyRelease(KeyEvent event){
        switch (event.getCode()){
            case W:
                up.stop();
                sprite.setImage(PlayGame.getMe().overworldBack);
                break;
            case A:
                break;
            case S:
                down.stop();
                sprite.setImage(PlayGame.getMe().overworldFront);
                break;
            case D:
                break;
        }
    }

    private boolean isClose(ImageView mySprite, ImageView building){
        double buildingY = building.getLayoutY() + building.getFitHeight();
        double myY = mySprite.getLayoutY() + (scrollPane.getVvalue()*yPixels) + mySprite.getFitHeight();
        return myY - buildingY <= 10;
    }
}
