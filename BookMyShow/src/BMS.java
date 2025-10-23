import Models.*;

import java.util.*;

public class BMS {
     TheaterController theaterController;
     MovieController movieController;
     private static BMS instance;
    private BMS(){
        init();
    }

    // singelton pattern
    public static BMS getInstance(){
        if(instance == null)
            instance = new BMS();
        return instance;
    }

    public void init(){
        Movie dhoom = new Movie("DHOOM");
        Movie dhoom2 = new Movie("DHOOM2");
        Movie dhoom3 = new Movie("DHOOM3");

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("DHOOM"));
        movieList.add(new Movie("DHOOM2"));
        movieList.add(new Movie("DHOOM3"));

        City city = new City("Bangalore");

        Map<City, List<Movie>> movieMap = new HashMap<>();
        movieMap.put(city, movieList);

        MovieController movieController1 = new MovieController(movieMap);

        this.movieController = movieController1;

        List<Show> showList = new ArrayList<>();
        // generateShow
        int k = 0;
        for(int j=0;j<2;j++) {
            // generate seat
            List<Seat> seatList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                seatList.add(SeatFactory.createSeat(k++, Type.GOLD));
                seatList.add(SeatFactory.createSeat(k++, Type.SILVER));
                seatList.add(SeatFactory.createSeat(k++, Type.PLATINUM));
            }
            Show show = new Show(j, j, dhoom2, Integer.toString(j*10), seatList);
            showList.add(show);
        }

        Theater theater = new Theater(showList, city, "Whitefield");

        List<Theater> theaterList = new ArrayList<>();
        theaterList.add(theater);

        Map<City, List<Theater>> theaterMap = new HashMap<>();
        theaterMap.put(city, theaterList);

        TheaterController theaterController1 = new TheaterController(theaterMap);

        this.theaterController = theaterController1;
    }

    void start() {

        System.out.println("user session: " + Thread.currentThread().getName());


        Scanner sc = new Scanner(System.in);
        System.out.println(theaterController.toString());

//        System.out.println("Select a seatID:");
//        int seatId = sc.nextInt();
        int seatId = 0;

        Theater theater =  theaterController.cityTheaterMap.get(new City("Bangalore")).get(0);

        Show show = theater.getShow(0);

        List<Seat> seats = show.getSeat(new HashSet<>(Arrays.asList(seatId)));

        for(Seat seat: seats) {
            try {
                if (seat.reserve())
                    System.out.println("for user " + Thread.currentThread().getName() + seat.toString() + " got successfully reserved");
                else {
                    System.out.println("for user " + Thread.currentThread().getName() + seat.toString() + " already booked");
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
