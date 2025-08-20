#include <vector>
#include <iostream>
using namespace std;

struct Item {
    int price;
    int quantity;
    optional<pair<int,int>> discount; // nullopt if no discount
};

// ===== Replace this with your solution =====
int totalCost(const vector<Item>& items) {
  int total_cost =0;

  for(int i =0; i < items.size(); i++){
    Item item = items[i];
    if( !item.discount.has_value()){
        total_cost += item.price*item.quantity;
    }else{
        int free_items_per_quantity_bought = item.discount ->first - item.discount -> second;
        int num_free_items = (item.quantity/(item.discount->first))*free_items_per_quantity_bought;
        int how_many_to_pay_for = item.quantity - num_free_items;
        total_cost += how_many_to_pay_for * item.price;
    }

  }
  return total_cost;
}
// ===========================================

void run(const string& name, vector<Item> items, int expect) {
    int got = totalCost(items);
    cout << name << " -> got=" << got << " expect=" << expect
         << " " << (got == expect ? "PASS" : "FAIL") << "\n";
}

int main() {
    run("Example",
        { {10,5,make_pair(3,2)}, {20,2,nullopt} },
        80);

    run("No discount", { {15,3,nullopt} }, 45);

    run("Exact multiple", { {5,6,make_pair(2,1)} }, 15); // BOGO

    run("Remainder group", { {10,5,make_pair(4,3)} }, 40);

    return 0;
}
