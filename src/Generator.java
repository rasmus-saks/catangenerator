public abstract class Generator {
    /**
     * Generate the game board. {@link CatanGenerator} contains some useful static fields to help with this.
     *
     * @return The generated game board
     * @see CatanGenerator#SEA_HEXES
     * @see CatanGenerator#LAND_HEXES
     * @see CatanGenerator#ALL_LOCATIONS
     * @see CatanGenerator#ALL_NUMBERS
     */
    public abstract GameBoard generateGameBoard();
}
