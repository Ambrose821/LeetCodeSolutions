package RecommendedProducts;
import java.util.*;

public class Main {

    // ===== Solution you can tweak =====
    static List<List<Integer>> recommend(int[][] purchases, int K) {

            // store I and j coordinates of purchased items
            HashMap<Integer,Integer> purchased = new HashMap<>();
            List<List<Integer>> recommendations = new ArrayList<>();
            for(int i =0; i <purchases.length; i++){
                recommendations.add(i,new ArrayList<>());
            }

            //know the coordinates of everything purchased. access at o(1)
            for(int i =0; i <purchases.length; i++){
                for(int j =0; j< purchases[0].length; j++){
                    if(purchases[i][j] ==1){
                        purchased.put(j,i);
                    }
                }
            }
            
     
            for(int i =0; i <purchases.length; i++){
                for(int j =0; j< purchases[0].length; j++){
                    if(purchases[i][j] ==0 ){
                        if(purchased.containsKey(j)){
                           
                           recommendations.get(i).add(j);
                           
                        }
                    }
                }
            }
            


       return recommendations;
    }
    // ===================================

    private static void run(String name, int[][] purchases, List<List<Integer>> expect) {
        List<List<Integer>> got = recommend(purchases, 3);
        System.out.printf("%s -> got=%s expect=%s %s%n",
                name, got, expect, got.equals(expect) ? "PASS" : "FAIL");
    }

    public static void main(String[] args) {
        run("Example",
            new int[][]{
                {1,0,1},
                {0,1,1},
                {1,1,0}
            },
            Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0),
                Arrays.asList(2)
            )
        );

        // Extra quick checks
        run("No co-occur",
            new int[][]{
                {1,0,0},
                {0,1,0}
            },
            Arrays.asList(
                Arrays.asList(), // no shared co-occurrence -> no recs
                Arrays.asList()
            )
        );
    }
}
