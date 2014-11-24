import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JFXBoardRenderer extends Application implements BoardRenderer {

    public static GameBoard gameBoard;
    /**
     * This is a roundabout method of getting a GridPane to display a board of hexes.
     * It involves having filler shapes to space out the hexes, and then the hexes which are resized to cover
     * substantially more usual. Namely this resize makes the hex go out of it's defined grid box.
     * f - filler polygon. this shape buffers hexes between each other
     * 0 - this polygon is an empty polygon that doesn't do anything (slightly deprecated, might as well be f)
     * 1 - this polygon is a hex, which is then rendered
     */
    private final String[][] rowlist = new String[][]{
            {"f", "0", "f", "1", "f", "0", "f"},
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
    public void render(GameBoard board) {
        JFXBoardRenderer.gameBoard = board;
        launch();
    }

    @Override
    public void regenerated(GameBoard board) {
        JFXBoardRenderer.gameBoard = board;
        if (borderPane != null)
            borderPane.setCenter(getCenterPane());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CatanGenerator.renderer = this;
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Katani mänguvälja generaator");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(700);

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

        seedField.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.ENTER)) {
                regenButton.fire();
            }
        });

        Button saveButton = new Button("Salvesta");
        saveButton.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
            File file = chooser.showSaveDialog(primaryStage);
            if (file == null) {
                return;
            }
            WritableImage img = centerPane.snapshot(new SnapshotParameters(), null);
            BufferedImage bImg = SwingFXUtils.fromFXImage(img, null);
            try {
                ImageIO.write(bImg, "png", file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

        Button importBtn = new Button("Impordi");
        Button exportBtn = new Button("Ekspordi");

        exportBtn.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Catan", "*.ctn"));
            File file = chooser.showSaveDialog(primaryStage);
            if (file == null) {
                return;
            }
            try {
                CatanGenerator.saveBoard(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        importBtn.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Catan", "*.ctn"));
            File file = chooser.showOpenDialog(primaryStage);
            if (file == null) {
                return;
            }
            try {
                GameBoard board = CatanGenerator.loadBoard(file);
                regenerated(board);
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        vbox.getChildren().addAll(
                title,
                new HBox(new Label("Seeme "),
                errorLabel),
                seedField,
                new Label("Sama seeme genereerib samasuguse mänguvälja"),
                new Label("Jäta tühjaks, et genereerida suvaline mänguväli"),
                regenButton,
                new Separator(),
                new Label("Salvesta mänguväli pildina:"),
                saveButton,
                new Separator(),
                new Label("Ekspordi/Impordi"),
                new HBox(10, exportBtn, importBtn));
        borderPane.setRight(leftPane);

        regenButton.setOnAction(e -> {
            String seed = seedField.getText();
            if (seed.isEmpty()) {
                CatanGenerator.regenerate(System.currentTimeMillis());
            } else {
                try {
                    long s = Long.parseLong(seedField.getText());
                    CatanGenerator.regenerate(s);
                    errorLabel.setText("");
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Palun sisesta arv!");
                }
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
        int width = 50;
        int height = 45;
        for (String[] row : rowlist) {
            for (String element : row) {
                Node poly;
                switch (element) {
                    case "f":
                        poly = getEmptyPoly(width, height);
                        break;
                    case "0":
                        poly = getEmptyPoly(width, height);
                        break;
                    default:
                        poly = getHexPoly(cx, cy, width, height);
                        break;
                }
                gPane.add(poly, cx, cy);
                cx += 1;
            }
            cy += 1;
            cx = 0;
        }

        gPane.autosize();
        return gPane;
    }

    /**
     * Generates a StackPane with the information of the hex with the given position.
     * @param x the x coordinate of the hex
     * @param y the y coordinate of the hex
     * @param width the width of the hex
     * @param height the height of the hex
     * @return a StackPane with the colored hex and corresponding text.
     */
    public Node getHexPoly(int x, int y, double width, double height) {
        StackPane stackPane = new StackPane();
        Location location = new Location(x, y);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                (3 / 13.0) * width, 0.0, //Left top
                (10 / 13.0) * width, 0.0, //Right top
                width, height / 2.0, //Right middle
                (10 / 13.0) * width, height, //Right bottom
                (3 / 13.0) * width, height, //Left bottom
                0.0, height / 2.0); //Left middle
        Hex hex = HexUtils.getHexAt(gameBoard, location);
        polygon.setFill(hex.getType().getColor());
        polygon.setScaleX(1.9);
        polygon.setScaleY(1.9);
        Text text = new Text(hex.getType().getName());
        if (hex.getNumber() != null)
            text.setText(text.getText() + "\n" + hex.getNumber().getValue());
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(0.8);
        //text.setStrokeType(StrokeType.OUTSIDE);
        text.setStyle("-fx-font-size: 15px; -fx-font-weight: bold");
        text.setTextAlignment(TextAlignment.CENTER);

        stackPane.getChildren().addAll(polygon, text);
        return stackPane;
    }

    public Node getEmptyPoly(double width, double height) {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                (20.0 / 13) * width, (5 / 12.0) * height,
                0.0, (5 / 12.0) * height);
        polygon.resize(0.1f, 0.1f);
        return polygon;
    }
}
