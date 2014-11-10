import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class GameBoard implements Serializable {
    private List<Hex> hexes;

    public GameBoard(List<Hex> hexes) {
        this.hexes = hexes;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    public void setHexes(List<Hex> hexes) {
        this.hexes = hexes;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameBoard gameBoard = (GameBoard) o;

        return !(hexes != null ? !hexes.equals(gameBoard.hexes) : gameBoard.hexes != null);

    }

    @Override
    public int hashCode() {
        return hexes != null ? hexes.hashCode() : 0;
    }
}
