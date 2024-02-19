package goorm_assignment;

public class Main {
    public static void main(String[] args) {
        // MyLinkedList 객체 생성
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // 데이터 추가
        myList.add(10);
        myList.add(20);
        myList.add(30);

        // 데이터 가져오기
        System.out.println("Data at index 0: " + myList.get(0)); // 10
        System.out.println("Data at index 1: " + myList.get(1)); // 20
        System.out.println("Data at index 2: " + myList.get(2)); // 30

        // 데이터 삭제
        int deletedData = myList.delete(1); // 삭제된 데이터: 20
        System.out.println("Deleted data at index 1: " + deletedData);
        System.out.println("Data at index 1 after deletion: " + myList.get(1)); // 30

        // 전체 리스트 출력
        System.out.println("List after deletion:");
        for (Integer data : myList) {
            System.out.println(data);
        }

    }
}



