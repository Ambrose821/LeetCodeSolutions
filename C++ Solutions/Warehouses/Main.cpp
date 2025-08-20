#include <vector>
#include <iostream>
using namespace std;

// ===== Replace this with your solution =====
// Simulates sequential fulfillment.
int unfulfilledItems(vector<int>& orders, vector<int>& warehouses) {

    int order_index =0;
    int warehouse_index =0;
    int not_fulfilled =0;


    while(order_index <orders.size() && warehouse_index <warehouses.size()){
        if(orders[order_index] == 0){
            order_index++;
            continue;
        }
        if(warehouses[warehouse_index] ==0 && warehouse_index != warehouses.size()-1){
            warehouse_index++;
            continue;
        }
         if(warehouses[warehouse_index] ==0 && warehouse_index == warehouses.size()-1){
            break;
        }

        orders[order_index] = orders[order_index]-1;
        warehouses[warehouse_index] = warehouses[warehouse_index]-1;

    }

    for(int i=0; i<orders.size(); i++){
        not_fulfilled += orders[i];
    }
    return not_fulfilled;
}
// ===========================================

void run(const string& name, vector<int> orders, vector<int> warehouses, int expect) {
    int got = unfulfilledItems(orders, warehouses);
    cout << name << " -> got=" << got << " expect=" << expect
         << " " << (got == expect ? "PASS" : "FAIL") << "\n";
}

int main() {
    run("Example", {3,5,4}, {8,2,5}, 0);
    run("Deficit", {5,7}, {4,3}, 5);
    run("All zero", {}, {10}, 0);
    run("No stock", {2,2,2}, {}, 6);
    run("Exact fit", {2,3,4}, {5,4}, 0);
    run("Surplus late", {4,4}, {1,10}, 0);
    return 0;
}
