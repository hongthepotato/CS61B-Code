public class OffByN implements CharacterComparator {

    private int offNum;

    /** The constructor of OffByN class. */
    public OffByN(int N) {
        offNum = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == this.offNum) {
            return true;
        }
        return false;
    }
}
