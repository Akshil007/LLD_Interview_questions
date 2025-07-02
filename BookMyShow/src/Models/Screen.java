package Models;

import java.util.List;

public class Screen {
    int screenId;
    List<Seat> seatList;
    List<Show> showList;

    public Screen(int screenId, List<Show> showList, List<Seat> seatList) {
        this.screenId = screenId;
        this.showList = showList;
        this.seatList = seatList;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public int getScreenId() {
        return screenId;
    }
}
