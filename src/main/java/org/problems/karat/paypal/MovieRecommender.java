package org.problems.karat.paypal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRecommender {
    public static List<String> movieRecommender(String member, String[][] ratings){
        List<String> result = new ArrayList<>();
        // build member and movie rating table
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(String [] rating: ratings){
            String user = rating[0];
            String movie = rating[1];
            int rate = Integer.parseInt(rating[2]);
            map.putIfAbsent(user, new HashMap<>());
            map.get(user).put(movie, rate);
        }
        // get target user movies and ratings
        Map<String, Integer> targetUserRatingsMap = map.getOrDefault( member, new HashMap<>());

        // iterate each user and check if he has similar taste watched same movie
        // if watched then add to the recommended collection
        for(String otherMember : map.keySet()){
            Map<String, Integer> otherMemberRatings = map.get(otherMember);
            if(otherMember.equals(member))
                continue;
            boolean isSimilar = false;

            // A user with similar taste movie
            for(String movie: targetUserRatingsMap.keySet()){
                if(otherMemberRatings.containsKey(movie)){
                    isSimilar = true;
                    break;
                }
            }

            // A user with similar taste collect movie with rate 4 or 5 which are not watched
            if(isSimilar){
                for(String movie: otherMemberRatings.keySet()){
                    int rating = otherMemberRatings.get(movie);
                    if(!targetUserRatingsMap.containsKey(movie) && rating >= 4){
                        result.add(movie);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] argv) {
        String[][] ratings = {
                {"Alice", "Frozen", "5"},
                {"Bob", "Mad Max", "5"},
                {"Charlie", "Lost In Translation", "4"},
                {"Charlie", "Inception", "4"},
                {"Bob", "All About Eve", "3"},
                {"Bob", "Lost In Translation", "5"},
                {"Dennis", "All About Eve", "5"},
                {"Dennis", "Mad Max", "4"},
                {"Charlie", "Topsy-Turvy", "2"},
                {"Dennis", "Topsy-Turvy", "4"},
                {"Alice", "Lost In Translation", "1"},
                {"Franz", "Lost In Translation", "5"},
                {"Franz", "Mad Max", "5"}
        };
        List<String> recommendedMovies = movieRecommender("Charlie", ratings);
        System.out.println("Size of recommended Movies " + recommendedMovies.size());
        System.out.println("Movie recommended to Charlie: ");
        for (String movie: recommendedMovies)
            System.out.print(" " + movie);
    }
}
