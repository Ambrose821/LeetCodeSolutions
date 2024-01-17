import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueOccurrence {

    public static boolean uniqueOccurrences(int[] arr) {
        //<Value,Occurrence>
    
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<arr.length; i++){
            if (map.containsKey(arr[i])){
                int occurence = map.get(arr[i]);
             
                map.put(arr[i],++occurence);
                continue;
               
            }
            else{
                map.put(arr[i], 1);
            
            }

        }
        System.out.println(map);
        HashSet<Integer> set = new HashSet();
        for(int x: map.values()){
            set.add(x);


        }
        return set.size() == map.size();
    
}
    public static void main(String[] args) throws Exception {
        int [] arr = {0,0,-2,-1,4,8,-3,9,6};
        boolean unique = uniqueOccurrences(arr);
        System.out.println(unique);

    }
}
