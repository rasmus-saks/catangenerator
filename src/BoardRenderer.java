import java.util.List;

public interface BoardRenderer {
    public abstract void render();

    default Hex getHexAt(List<Hex> hexes, Location loc) {
        for (Hex h : hexes) {
            if(h.getLoc().equals(loc))
                return h;
        }
        return null;
    }
}
