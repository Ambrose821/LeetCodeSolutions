import java.util.HashMap;

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
        for(int i =0; i < map.size(); i++){
            int occurence = map.get(arr[i]);
            map.remove(arr[i]);
            if(map.containsValue(occurence)){
                return false;
            }

        }
        return true;
    
}
    public static void main(String[] args) throws Exception {
        int [] arr = {1,2,2,1,1,3};
        boolean unique = uniqueOccurrences(arr);
        System.out.println(unique);

    }
}
