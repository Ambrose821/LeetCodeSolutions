package Solutions.Warehouse;


import java.util.*;

public class Main {

    // ===== Replace this with your solution =====
    // Simulates sequential fulfillment warehouse-by-warehouse, order-by-order.
    static int unfulfilledItems(int[] orders, int[] warehouses) {
        int order_index = 0;
        int warehouse_index =0;
        int not_fulfilled =0;

        while(order_index<orders.length &&warehouse_index<warehouses.length){
            if(orders[order_index] == 0){
                order_index++;
                continue;
            }
            if(warehouses[warehouse_index] ==0 && warehouse_index != warehouses.length){
                warehouse_index++;
                continue;
            }
            if(warehouses[warehouse_index] ==0 && warehouse_index == warehouses.length-1){
                break;
            }
            orders[order_index] --;
            warehouses[warehouse_index]--;

            

        }
        for(int i =0; i<orders.length; i ++){
            not_fulfilled += orders[i];
        }


        return not_fulfilled;
    }
    // ===========================================

    // Simple runner
    private static void run(String name, int[] orders, int[] warehouses, int expect) {
        int got = unfulfilledItems(orders, warehouses);
        System.out.printf("%s -> got=%d expect=%d %s%n",
                name, got, expect, (got == expect ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        run("Example", new int[]{3,5,4}, new int[]{8,2,5}, 0);
        run("Deficit", new int[]{5,7}, new int[]{4,3}, 5);      // total need 12, stock 7 -> 5 unfulfilled
        run("All zero", new int[]{}, new int[]{10}, 0);
        run("No stock", new int[]{2,2,2}, new int[]{}, 6);
        run("Exact fit", new int[]{2,3,4}, new int[]{5,4}, 0);
        run("Surplus late", new int[]{4,4}, new int[]{1,10}, 0);
    }
}

