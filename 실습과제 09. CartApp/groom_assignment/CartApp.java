package groom_assignment;

import java.util.HashSet;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {

        Set<Product> productSet = new HashSet<>();
        // 상품 목록 생성
        productSet.add(new Product(1, "우유", 2.5));
        productSet.add(new Product(2, "사과", 1.2));
        productSet.add(new Product(3, "빵", 3.0));

        // 상품 목록 확인
        System.out.println("고유한 상품 목록: ");
        for (Product product : productSet) {
            System.out.println(product.getName() + ":" + product.getPrice());
        }

        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(new Product(1, "우유", 2.5), 2);
        myCart.addProduct(new Product(2, "사과", 1.2), 1);
        myCart.addProduct(new Product(3, "빵", 3.0), 3);

        // 장바구니에 담긴 상품 확인
        myCart.showItems();

        // 상품을 장바구니에서 제거
        myCart.removeProduct(new Product(1, "우유", 2.5), 1);

        // 장바구니에 담긴 상품 확인
        myCart.showItems();
    }
}
