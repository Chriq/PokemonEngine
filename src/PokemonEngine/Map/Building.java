package PokemonEngine.Map;

import PokemonEngine.PlayGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Building {

    public ImageView face;

    private Scene starterSelectionScene;

    public void enter() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PokemonEngine/GUI/StarterSelection.fxml"));
        starterSelectionScene = new Scene(root);
        PlayGame.getWindow().setScene(starterSelectionScene);
    }

}
