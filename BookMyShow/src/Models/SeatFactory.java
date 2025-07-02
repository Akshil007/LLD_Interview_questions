package Models;

public class SeatFactory {
    public static Seat createSeat(int seatId, Type type) {
        double price = getPriceByType(type);
        return new Seat(seatId, price, type, Status.AVAILABLE);
    }

    private static double getPriceByType(Type type) {
        return switch (type) {
            case SILVER -> 150.0;
            case GOLD -> 250.0;
            case PLATINUM -> 400.0;
        };
    }
}
