package ratings;

import java.util.*;

public class DegreesOfSeparation {
    private ArrayList<Movie> movies;

    public DegreesOfSeparation(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public int degreesOfSeparation(String name1, String name2) {
        HashMap<String, ArrayList<String>> Graph = BuildGraph();
        if(name1.equals(name2)){
            return 0;
        }
        if (!Graph.containsKey(name1) || (!Graph.containsKey(name2))){
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(name1);
        visited.add(name1);

        int degrees = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentActor = queue.poll();
                if (currentActor.equals(name2)) {
                    return degrees;
                }
                for (String secondactor : Graph.get(currentActor)) {
                    if (visited.add(secondactor)) {
                        queue.add(secondactor);
                    }
                }
            }
            degrees++;
        }

        return -1;
    }

    public HashMap<String, ArrayList<String>> BuildGraph() {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (Movie movie : movies) {
            for (String cast : movie.getCast()) {
                if (!graph.containsKey(cast)) {
                    graph.put(cast, new ArrayList<>());
                }
                for (String cast2 : movie.getCast()) {
                    if (!cast2.equals(cast) &&
                            !graph.get(cast).contains(cast2)) {
                        graph.get(cast).add(cast2);
                    }
                }
            }
        }
        return graph;
    }
}


