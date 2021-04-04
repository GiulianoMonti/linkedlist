package ds.cs61b;

public class Main {

    public static void main(String[] args) {
        /* Creates a list of one Interger, namely 10 */
        LinkedListDeque<Integer> L = new LinkedListDeque<>(100);

        L.addFirst(299);
        L.addFirst(20);
        L.addFirst(1000);
        L.addLast(2010238);
        L.addLast(12);
        L.addFirst(14);

        System.out.println(L.getFirst()+ " is the first item in the list ");
        System.out.println("item "+ L.get(2));
        L.printDeque();

//        System.out.println(L.getFirst());

    }
}
