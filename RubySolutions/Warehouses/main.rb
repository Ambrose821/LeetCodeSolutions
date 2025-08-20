# ===== Replace this with your solution =====
# Simulates sequential fulfillment, warehouse-by-warehouse and order-by-order.
def unfulfilled_items(orders, warehouses)
  orders_index = 0
  warehouse_index =0
  unfulfilled =0

  while orders_index < orders.length && warehouse_index < warehouses.length

    if orders[orders_index] == 0
        orders_index +=1
        next
    end
    if warehouses[warehouse_index] == 0 &&  warehouse_index != warehouses.length-1
        warehouse_index +=1
        next
    end 
    if warehouses[warehouse_index] == 0 && warehouse_index == warehouses.length-1
        break
    end
    orders[orders_index] -=1
    warehouses[warehouse_index] -=1
  end

  orders.each do |quantity|
    unfulfilled += quantity
  end

  return unfulfilled
  
end
# ===========================================

def run(name, orders, warehouses, expect)
  got = unfulfilled_items(orders, warehouses)
  puts "#{name} -> got=#{got} expect=#{expect} #{got == expect ? 'PASS' : 'FAIL'}"
end

run("Example", [3,5,4], [8,2,5], 0)
run("Deficit", [5,7], [4,3], 5)
run("All zero", [], [10], 0)
run("No stock", [2,2,2], [], 6)
run("Exact fit", [2,3,4], [5,4], 0)
run("Surplus late", [4,4], [1,10], 0)
