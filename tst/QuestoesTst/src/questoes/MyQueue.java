//package questoes;

import java.util.Scanner;

class MyQueue {

    private LinkedList list;

    public MyQueue() {
        this.list = new LinkedList();
    }

    public void add(Integer data) {
        this.list.addData(data);
    }

    public void remove() {
        if (!this.list.isEmpty()) {
            this.list.removeFirst();
        } else {
            System.out.println("empty");
        }

    }

    public void element() {
        if (!this.list.isEmpty()) {
            System.out.println(this.list.getHead().toString());
        }else {
            System.out.println("empty");
        }
    }

    public void search(Integer data) {
        System.out.println(this.list.search(data));

    }

    public void print() {
        if (list.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(this.list);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue myQueue = new MyQueue();

        String[] opcao;
        do {
            opcao = sc.nextLine().split(" ");

            if (opcao[0].equals("add")) {
                myQueue.add(Integer.parseInt(opcao[1]));

            } else if (opcao[0].equals("remove")) {
                myQueue.remove();

            } else if (opcao[0].equals("element")) {
                myQueue.element();

            } else if (opcao[0].equals("search")) {
                myQueue.search(Integer.parseInt(opcao[1]));

            } else if (opcao[0].equals("print")) {
                myQueue.print();

            }

        } while (!opcao[0].equals("end"));

        sc.close();
    }

}

class LinkedList {
    private Node head;

    public LinkedList() {
        setHead(new Node());
    }

    public boolean isEmpty() {
        return getHead().isNil();
    }

    public void addData(Integer data) {
        getHead().addData(data);
    }

    public void removeLast() {
        getHead().removeData();
    }

    public void removeFirst() {
        if (!getHead().isNil()) {
            setHead(head.getNext());
            getHead().setPrevious(null);
        }
    }

    public Integer element() {
        return getHead().getData();
    }

    public int search(Integer data) {
        return getHead().searchIndex(data);
    }

    @Override
    public String toString() {
        return head.toStringArray();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}

class Node {

    private Node next;
    private Node previous;
    private Integer data;

    public Node() {
    }

    public Node(Node previous, Integer data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getData() {
        return this.data;
    }

    public void addData(Integer data) {
        if (isNil()) {
            this.data = data;
            setNext(new Node());
            getNext().setPrevious(this);
        } else {
            getNext().addData(data);
        }
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public boolean isNil() {
        return this.data == null;
    }

    @Override
    public String toString() {
        Integer resp = getData();
        return resp != null ? resp.toString() : "NIL";
    }

    public void removeData() {
        if (isNil()) {
            if (getPrevious() != null) {
                getPrevious().setData(null);
                getPrevious().setNext(null);
            }
        } else {
            getNext().removeData();
        }

    }

    public int searchIndex(Integer data) {
        if (isNil()) {
            return -1;
        } else {
            if (getData().equals(data)) {
                return 0;
            } else {
                int result = getNext().searchIndex(data);
                return result == -1 ? -1 : 1 + result;
            }
        }

    }

    public String toStringArray() {
        if (isNil())
            return "";

        StringBuffer result = new StringBuffer();
        result.append(getPrevious() == null ? "" : " ");
        result.append(isNil() ? "" : getData());
        result.append(getNext().isNil() ? "" : getNext().toStringArray());
        return result.toString();

    }
}
