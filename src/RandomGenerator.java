import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator extends Generator {
    @Override
    public List<Hex> generateHexes() {
        List<Hex> hexes = new ArrayList<Hex>(CatanGenerator.LAND_HEXES);
        List<Number> nums = new ArrayList<Number>(CatanGenerator.ALL_NUMBERS);
        Collections.shuffle(CatanGenerator.LAND_LOCATIONS);
        Collections.shuffle(nums);
        int j = 0;
        for(int i = 0; i < hexes.size(); i++) {
            hexes.get(i).setLoc(CatanGenerator.LAND_LOCATIONS.get(i));
            if(hexes.get(i).getType() != HexType.DESERT) {
                hexes.get(i).setNumber(nums.get(j));
                j++;
            }
        }
        Collections.shuffle(CatanGenerator.SEA_LOCATIONS);
        for (int i = 0; i < CatanGenerator.SEA_HEXES.size(); i++) {
            Hex hex = CatanGenerator.SEA_HEXES.get(i);
            hex.setLoc(CatanGenerator.SEA_LOCATIONS.get(i));
            hexes.add(hex);
        }
        return hexes;
    }

}
