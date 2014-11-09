import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Al William "Rezo" Tammsaar on 11/9/2014.
 */
public class JFXBoardRenderer extends Application implements BoardRenderer{

    public static List<Hex> hexes;

    public JFXBoardRenderer() {

    }

    public JFXBoardRenderer(List<Hex> hexes) {
        JFXBoardRenderer.hexes = hexes;
    }

    @Override
    public void render() {
        launch(new String[2]);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 800, 650));
        String[][] rowlist =
                       {{"f", "0", "f", "1", "f", "0", "f"},
                        {"0", "f", "1", "f", "1", "f", "0"},
                        {"f", "1", "f", "1", "f", "1", "f"},
                        {"1", "f", "1", "f", "1", "f", "1"},
                        {"f", "1", "f", "1", "f", "1", "f"},
                        {"1", "f", "1", "f", "1", "f", "1"},
                        {"f", "1", "f", "1", "f", "1", "f"},
                        {"1", "f", "1", "f", "1", "f", "1"},
                        {"f", "1", "f", "1", "f", "1", "f"},
                        {"1", "f", "1", "f", "1", "f", "1"},
                        {"f", "1", "f", "1", "f", "1", "f"},
                        {"0", "f", "1", "f", "1", "f", "0"},
                        {"f", "0", "f", "1", "f", "0", "f"}};
        BorderPane bPane = new BorderPane();
        root.getChildren().add(bPane);
        GridPane gPane = new GridPane();
        bPane.setCenter(gPane);
        gPane.setAlignment(Pos.CENTER);
        gPane.setPrefSize(800, 650);

        int cx = 0;
        int cy = 0;
        int width = 45;
        int height = 40;
        for (String[] row: rowlist){
            for (String element: row){
                Polygon poly;
                if (element.equals("f")){
                    poly = getEmptyPoly(width, height);
                } else if (element.equals("0")){
                    poly = getEmptyPoly(width, height);
                } else {
                    poly = getHexPoly(cx,cy, width, height);
                }
                gPane.add(poly,cx,cy);
                cx += 1;
            }
            cy += 1;
            cx = 0;
        }

        gPane.autosize();
        primaryStage.show();
    }
    public Polygon getHexPoly(int x, int y, double width, double height){
        Location location = new Location(x, y);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                (3/13.0) * width, 0.0, //Left top
                (10/13.0) * width, 0.0, //Right top
                width, height/2.0, //Right middle
                (10/13.0) * width, height, //Right bottom
                (3/13.0) * width, height, //Left bottom
                0.0, height/2.0); //Left middle
        Hex hex = HexUtils.getHexAt(hexes,location);
        polygon.setFill(hex.getType().getColor());
        polygon.setScaleX(1.8);
        polygon.setScaleY(1.8);
        return polygon;
    }

    public Polygon getEmptyPoly(double width, double height){
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                (20.0/13) * width, (5/12.0) * height,
                0.0, (5/12.0) * height);
        polygon.resize(0.1f,0.1f);
        return polygon;
    }
}
