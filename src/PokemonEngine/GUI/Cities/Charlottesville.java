package PokemonEngine.GUI.Cities;

import PokemonEngine.Map.Building;
import PokemonEngine.Map.City;
import PokemonEngine.PlayGame;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Charlottesville extends City {

    @FXML
    AnchorPane mainPane;

    @FXML
    ScrollPane scroll;

    @FXML
    ImageView mySprite, background, rotunda;

    private Building theRotunda;

    public void initialize(){
        this.xPixels = this.background.getImage().getWidth();
        this.yPixels = this.background.getImage().getHeight();

        scrollPane = this.scroll;
        sprite = this.mySprite;

        this.theRotunda = new Building();
        this.theRotunda.face = rotunda;
        building = this.theRotunda;

        this.theRotunda = new Building();

        this.mySprite.setImage(PlayGame.getMe().overworldFront);
        scroll.setVvalue(0.5);

    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        keyPress(event);
    }

    @FXML
    private void handleKeyRelease(KeyEvent event){
        keyRelease(event);
    }

}
