public class Manager {
    private Movie[] movies = new Movie[0];
    private int limit=10;

    public Manager(){}

    public Manager(int limit){
        this.limit=limit;
    }

    public void add(Movie movie){
        Movie[] tmp = new Movie[movies.length+1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[movies.length]=movie;
        movies=tmp;
    }

    public Movie[] findAll(){
        return movies;
    }

    public Movie[] findLast(){
        int resultLength = Math.min(movies.length, limit);
        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }
}
