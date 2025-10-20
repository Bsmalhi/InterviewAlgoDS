package org.problems.karat.paypal;

import java.util.*;

public class NumOfConnections {
    // O(E) O(E)
    public static List<List<String>> numOfConnections(String[][] events, int n){
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        // build map from events
        for(String [] event : events){
            String e = event[0];
            String user1 = event[1];
            String user2 = event[2];
            // initialize
            if(map.get(user1) == null)
                map.put(user1, new HashSet<>());
            if(map.get(user2) == null)
                map.put(user2, new HashSet<>());
            // connect the users
            if(e.equals("CONNECT")){
                map.get(user1).add(user2);
                map.get(user2).add(user1);
            } else if(e.equals("DISCONNECT")){
                map.get(user1).remove(user2);
                map.get(user2).remove(user1);
            }
        }
        // find users with less than N connections
        List<String> lessThanN = new ArrayList<>();
        List<String> greaterThanN = new ArrayList<>();
        for(String user: map.keySet()){
            Set<String> set = map.get(user); // list of connections for user

            if(set.size() < n){ // populate less than N list
                lessThanN.add(user);
            } else { // populate greater than N list
                greaterThanN.add(user);
            }
        }
        result.add(lessThanN);
        result.add(greaterThanN);

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
    }
}
