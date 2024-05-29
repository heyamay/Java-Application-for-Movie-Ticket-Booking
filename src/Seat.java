public class Seat {
    private int row;
    private int number;
    private boolean isBooked;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.isBooked = false;
    }

    public boolean book() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }
}
