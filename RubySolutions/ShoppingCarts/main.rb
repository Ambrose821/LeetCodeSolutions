# ===== Replace this with your solution =====
def total_cost(items)
  tota_cost_int = 0


  items.each do |item|
    quantity = item[:quantity]
    price = item[:price]
    discount = item[:discount]

    if discount.nil?
      tota_cost_int += quantity * price
      next
    end
    free_items_per_quantity = discount[0] - discount[1]
    num_free_items = (quantity/discount[0]) * free_items_per_quantity
    quantity_paid = quantity - num_free_items
    tota_cost_int += quantity_paid * price
  end
  return tota_cost_int
end
# ===========================================

def run(name, items, expect)
  got = total_cost(items)
  puts "#{name} -> got=#{got} expect=#{expect} #{got == expect ? 'PASS' : 'FAIL'}"
end

run("Example", [{price: 10, quantity: 5, discount: [3,2]}, {price: 20, quantity: 2, discount: nil}], 80)
run("No discount", [{price: 15, quantity: 3, discount: nil}], 45)
run("Exact multiple", [{price: 5, quantity: 6, discount: [2,1]}], 15) # BOGO
run("Remainder group", [{price: 10, quantity: 5, discount: [4,3]}], 40)
