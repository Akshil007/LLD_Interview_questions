import Models.City;
import Models.Movie;

import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> movieList;

    public MovieController(Map<City, List<Movie>> movieList) {
        this.movieList = movieList;
    }
}
