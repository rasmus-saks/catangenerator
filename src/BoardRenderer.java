import java.util.List;

/**
 * Created by Al William "Rezo" Tammsaar on 10/4/2014.
 */
public abstract class BoardRenderer {
    public abstract void render();

    private static Hex getHexAt(List<Hex> hexes, Location loc) {
        for (Hex h : hexes) {
            if(h.getLoc().equals(loc))
                return h;
        }
        return null;
    }
}
