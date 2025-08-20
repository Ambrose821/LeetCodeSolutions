package ShoppingCart;
import java.util.*;

class Item {
    int price;
    int quantity;
    int[] discount; // null if no discount

    Item(int price, int quantity, int[] discount) {
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
}

public class Main {

    // ===== Replace this with your solution =====
    static int totalCost(List<Item> items) {
        int total_cost =0;

        for(Item item: items){
            if(item.discount == null){
                total_cost += item.price * item.quantity;
            }else{
                int free_amount_per_quantity = item.discount[0] - item.discount[1];
                int num_free_items = (item.quantity/item.discount[0]) * free_amount_per_quantity;
                int items_to_pay_for = item.quantity - num_free_items;
                total_cost+= item.price *items_to_pay_for;
            }
        }

        return total_cost;
    }
    // ===========================================

    private static void run(String name, List<Item> items, int expect) {
        int got = totalCost(items);
        System.out.printf("%s -> got=%d expect=%d %s%n",
                name, got, expect, (got == expect ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        run("Example",
            Arrays.asList(
                new Item(10, 5, new int[]{3,2}),
                new Item(20, 2, null)
            ),
            80);

        run("No discount",
            Arrays.asList(new Item(15, 3, null)),
            45);

        run("Exact multiple",
            Arrays.asList(new Item(5, 6, new int[]{2,1})), // BOGO
            15);

        run("Remainder group",
            Arrays.asList(new Item(10, 5, new int[]{4,3})), // Buy4 pay3
            40);
    }
}
