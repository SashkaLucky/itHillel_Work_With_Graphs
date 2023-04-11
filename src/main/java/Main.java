import workWithGraphs.SimpleTree;

public class Main {
    public static void main(String[] args) {
        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(6);
        tree.add(1);
        tree.add(10);
        tree.add(14);
        tree.add(13);
        tree.add(4);
        tree.add(7);
        for (Integer value : tree) {
            System.out.print(value + " ");
        }
    }
}