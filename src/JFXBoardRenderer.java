import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                25.0, 25.0,
                60.0, 25.0,
                75.0, 50.0,
                60.0, 75.0,
                25.0, 75.0,
                10.0, 50.0);
        polygon.setFill(Color.BLACK);

        Polygon buffpoly = new Polygon();
        buffpoly.getPoints().addAll(
                00.0, 25.0,
                60.0, 25.0);
        buffpoly.setFill(Color.BLACK);

        int cx = 0;
        int cy = 0;
        for (String[] row: rowlist){
            for (String element: row){
                Polygon poly;
                if (element.equals("f")){
                    poly = getFiller();
                } else if (element.equals("0")){
                    poly = getEmptyPoly();
                } else {
                    poly = getHexPoly(cx,cy);
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
    public Polygon getHexPoly(int x, int y){
        Location location = new Location(x, y);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                25.0, 20.0,
                60.0, 20.0,
                75.0, 50.0,
                60.0, 80.0,
                25.0, 80.0,
                10.0, 50.0);
        Hex hex = HexUtils.getHexAt(hexes,location);
        System.out.println(hex);
        polygon.setFill(hex.getType().getColor());
        polygon.setScaleX(1.8);
        polygon.setScaleY(1.8);
        return polygon;
    }

    public Polygon getEmptyPoly(){
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                110.0, 25.0,
                10.0, 25.0);
        polygon.resize(0.1f,0.1f);
        return polygon;
    }

    public Polygon getFiller(){
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                110.0, 25.0,
                10.0, 25.0);
        polygon.resize(0.1f,0.1f);
        return polygon;
    }
}
