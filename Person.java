class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    String toString() {
//        return (name + " " + age);
//    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }

    String getName(){
        return name;
    }

    int getAge(){
        return age;
    }
}
class Node {
    Person info;
    Node nextNode;

    Node(Person x, Node p) {
        info = x;
        nextNode = p;
    }

    Node(Person x) {
        this(x, null);
    }

    void setInfo(String name, int age){
        this.info.setName(name);
        this.info.setAge(age);
    }

    void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    Person getInfo(){
        return this.info;
    }

    Node getNextNode(){
        return this.nextNode;
    }
}

class MyList {
    Node head, tail;

    MyList() {
            head = tail = null;
        }
    void clear() {
        head = tail = null;
    }
    boolean isEmpty() {
            return (head == null);
        }

    void add(Person x) {
        Node newNode = new Node(x);

        newNode.setNextNode(head);
        head = newNode;
        if (head.nextNode == null){
            tail = head;
        }
    }

    void addTail(Person x){
        Node newNode = new Node(x);

        if (this.head == null){
            add(x);
        }
        else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    void addMany(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++){
            Person newPerson = new Person(a[i], b[i]);
            addTail(newPerson);
        }
    }

    int length() {
        int length = 0;
        Node current = this.head;

        while (current != null){
            length++;
            current = current.getNextNode();
        }

        return length;
    }

    void traverse() {
        int length = length();
        Node current = this.head;

        for (int i = 1; i <= length; i++){
            System.out.println("Person: " + i);
            System.out.println(current.getInfo().getName() + " " + current.getInfo().getAge());
            current = current.getNextNode();
        }
    }

    void sortByName(String[] a, int[] b) {
        int length = length();

        Node current = this.head;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++){
                if(current.getInfo().getName().compareTo(current.nextNode.getInfo().getName()) > 0){
                    Node temp = current;
                    current = current.getNextNode();
                    current.setNextNode(temp);
                }
            }
        }
    }
}
