package adt.btree;

import java.util.LinkedList;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

   protected BNode<T> root;
   protected int order;

   public BTreeImpl(int order) {
      this.order = order;
      this.root = new BNode<T>(order);
   }

   @Override
   public BNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return this.root.isEmpty();
   }

   @Override
   public int height() {
      if (isEmpty()) {
         return -1;
      }
      return height(this.root);
   }

   private int height(BNode<T> node) {
      if (node.isLeaf()) {
         return 0;
      } else {
         return 1 + height(node.getChildren().getFirst());

      }
   }

   @Override
   public BNode<T>[] depthLeftOrder() {
      BNode<T>[] result = new BNode[nodesSize()];
      depthLeftOrder(getRoot(), result, 0);
      return result;
   }

   private void depthLeftOrder(BNode<T> node, BNode<T>[] result, int i) {
      if (i < result.length) {
         result[i++] = node;
         for (BNode<T> ch : node.getChildren()) {
            depthLeftOrder(ch, result, i++);
         }
      }
   }

   private int nodesSize() {
      return nodesSize(getRoot());
   }

   private int nodesSize(BNode<T> node) {
      int result = 1;
      if (!node.isLeaf()) {
         for (BNode<T> nd : node.getChildren()) {
            result += nodesSize(nd);
         }
      }

      return result;
   }

   @Override
   public int size() {
      return size(getRoot());
   }

   private int size(BNode<T> node) {
      return node.getElements().size() + (node.isLeaf() ? 0 : size(node.getChildren()));
   }

   private int size(LinkedList<BNode<T>> nodeChildren) {
      int sum = 0;
      for (BNode<T> bNode : nodeChildren) {
         sum += size(bNode);
      }

      return sum;
   }

   @Override
   public BNodePosition<T> search(T element) {
      return search(getRoot(), element);
   }

   private BNodePosition<T> search(BNode<T> node, T element) {
      int position = 0;

      while (position < node.getElements().size() && element.compareTo(node.elements.get(position)) > 0) {
         position++;
      }

      if (position <= node.getElements().size() && element.equals(node.getElements().get(position))) {
         return new BNodePosition<>(node, position);
      }

      if (node.isLeaf()) {
         return new BNodePosition<>(null, -1);
      }

      return search(node.getChildren().get(position), element);
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         insert(getRoot(), element);
         root = root.getRoot();
      }
   }

   private void insert(BNode<T> node, T element) {
      if (node != null) {
         if (node.isLeaf()) {
            if (node.isFull()) {
               node.addElement(element);
               split(node);
            } else {
               node.addElement(element);
            }
         } else {
            int position = researchPosition(node.getElements(), element);
            insert(node.getChildren().get(position), element);
         }

      }
   }

   private int researchPosition(LinkedList<T> list, T element) {
      int index = 0;
      for (T t : list) {
         if (element.compareTo(t) > 0) {
            index++;
         }
      }
      return index;
   }

   private void split(BNode<T> node) {
      node.split();
      // TODO Implement your code here
   }

   private void promote(BNode<T> node) {
      node.promote();
      // TODO Implement your code here
   }

   // NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
   @Override
   public BNode<T> maximum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public BNode<T> minimum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public void remove(T element) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

}
