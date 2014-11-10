import java.util.List;

public interface BoardRenderer {
    public void render(List<Hex> hexes);
    public void regenerated(List<Hex> hexes);
}
