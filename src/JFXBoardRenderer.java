import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class JFXBoardRenderer extends Application implements BoardRenderer{

    public static List<Hex> hexes;
    /**
     * f - filler polygon. this shape buffers hexes between each other
     * 0 - this polygon is an empty polygon that doesn't do anything
     * 1 - this polygon is a hex, which is then rendered
     */
    private final String[][] rowlist = new String[][]{{"f", "0", "f", "1", "f", "0", "f"},
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
    private BorderPane borderPane;

    public JFXBoardRenderer() {

    }

    @Override
    public void render(List<Hex> hexes) {
        JFXBoardRenderer.hexes = hexes;
        launch();
    }

    @Override
    public void regenerated(List<Hex> hexes) {
        JFXBoardRenderer.hexes = hexes;
        if(borderPane != null)
            borderPane.setCenter(getCenterPane());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CatanGenerator.renderer = this;
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Katani mänguvälja generaator");
        primaryStage.setMinWidth(1150);
        primaryStage.setMinHeight(850);

        primaryStage.setWidth(primaryStage.getMinWidth());
        primaryStage.setHeight(primaryStage.getMinHeight());

        primaryStage.setScene(scene);

        borderPane = new BorderPane();
        root.getChildren().add(borderPane);

        Pane centerPane = getCenterPane();
        borderPane.setCenter(centerPane);

        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.prefHeightProperty().bind(scene.heightProperty());

        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(5));
        BorderPane leftPane = new BorderPane(vbox);
        leftPane.setBottom(new Label("Rasmus Saks ja Al William Tammsaar 2014"));
        TextField seedField = new TextField();
        Button regenButton = new Button("Genereeri");
        Label title = new Label("Katani generaator");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18pt");
        vbox.getChildren().addAll(
                title,
                new Label("Seeme"),
                seedField,
                new Label("Sama seeme genereerib samasuguse mänguvälja"),
                new Label("Jäta tühjaks, et genereerida suvaline mänguväli"),
                regenButton);
        borderPane.setRight(leftPane);

        regenButton.setOnAction(e -> {
            String seed = seedField.getText();
            if(seed.isEmpty()) {
                CatanGenerator.regenerate(System.currentTimeMillis());
            } else {
                long s = 0;
                for (int i = 0; i < seed.length(); i++) {
                    s += (int) seed.charAt(i);
                }
                CatanGenerator.regenerate(s);
            }
        });
        primaryStage.show();
    }

    public Pane getCenterPane() {
        Pane pane = new BorderPane(getGridPane());
        pane.setStyle("-fx-background-color: lightblue");
        return pane;
    }

    public GridPane getGridPane() {
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);

        /*gPane.scaleXProperty().bind(gPane.widthProperty().multiply(gPane.heightProperty()).divide(630 * 900));
        gPane.scaleYProperty().bind(gPane.scaleXProperty());*/

        int cx = 0;
        int cy = 0;
        int width = 60;
        int height = 55;
        for (String[] row: rowlist){
            for (String element: row){
                Node poly;
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
        return gPane;
    }
    public Node getHexPoly(int x, int y, double width, double height){
        StackPane stackPane = new StackPane();
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
        polygon.setScaleX(1.9);
        polygon.setScaleY(1.9);
        Text text = new Text(hex.getType().getName());
        if(hex.getNumber() != null)
            text.setText(text.getText() + "\n" + hex.getNumber().getValue());
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(0.7);
        //text.setStrokeType(StrokeType.OUTSIDE);
        text.setStyle("-fx-font-size: 13pt; -fx-font-weight: bold");
        text.setTextAlignment(TextAlignment.CENTER);

        stackPane.getChildren().addAll(polygon, text);
        return stackPane;
    }

    public Node getEmptyPoly(double width, double height){
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                (20.0/13) * width, (5/12.0) * height,
                0.0, (5/12.0) * height);
        polygon.resize(0.1f,0.1f);
        return polygon;
    }
}
