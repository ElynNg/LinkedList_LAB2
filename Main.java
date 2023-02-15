public class Main {
    public static void main(String[] args) {
        String[] a = {"C", "E", "A"};
        int[] b = {25,17,30};
        MyList t = new MyList();
        Person firstPerson = new Person(a[0], b[0]);
        t.add(firstPerson);

        t.addMany(a, b);

        System.out.println("Traverse: ");
        t.traverse();

        System.out.println("Sort by name: ");
        t.sortByName(a, b);
        t.traverse();
    }
}