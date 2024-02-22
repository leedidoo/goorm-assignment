package groom_assignment;

import java.util.Map;
import java.util.HashMap;

class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
        System.out.println(product.getName() + " " + quantity + "개 담기");
    }

    public void removeProduct(Product product, int quantity) {
        int currentQuantity = items.getOrDefault(product, 0);
        if (currentQuantity <= quantity) {
            items.remove(product);
            System.out.println(product.getName() + " 모두 제거");
        } else {
            items.put(product, currentQuantity - quantity);
            System.out.println(product.getName() + " " + quantity + "개 빼기");
        }
    }

    public void showItems() {
        System.out.println("장바구니에 담긴 상품 목록:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + "개");
        }
    }
}
