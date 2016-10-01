package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

   protected SkipListNode<T> root;
   protected SkipListNode<T> NIL;

   protected int height;
   protected int maxHeight;

   protected boolean USE_MAX_HEIGHT_AS_HEIGHT = false;
   protected double PROBABILITY = 0.5;

   public SkipListImpl(int maxHeight) {
      if (USE_MAX_HEIGHT_AS_HEIGHT) {
         this.height = maxHeight;
      } else {
         this.height = 1;
      }
      this.maxHeight = maxHeight;
      root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
      NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
      connectRootToNil();
   }

   /**
    * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
    * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
    * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
    * metodo deve conectar apenas o forward[0].
    */
   private void connectRootToNil() {
      if (USE_MAX_HEIGHT_AS_HEIGHT) {
         for (int i = 0; i < maxHeight; i++) {
            root.forward[i] = NIL;
         }
      } else {
         root.forward[0] = NIL;
      }
   }

   /**
    * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no
    * metodo insert(int,V)
    */
   private int randomLevel() {
      int randomLevel = 1;
      double random = Math.random();
      while (Math.random() <= PROBABILITY && randomLevel < maxHeight) {
         randomLevel = randomLevel + 1;
      }
      return randomLevel;
   }

   @Override
   public void insert(int key, T newValue, int height) {
      if (height <= maxHeight) {
         fixRootRelationship(height);
         SkipListNode<T>[] update = new SkipListNode[this.height];
         SkipListNode<T> aux = root;
         for (int i = this.height - 1; i >= 0; i--) {
            while (aux.getForward(i) != null && aux.getForward(i).getKey() < key) {
               aux = aux.getForward(i);
            }
            update[i] = aux;
         }

         aux = aux.getForward(0);

         if (aux.getKey() == key) {
            aux.setValue(newValue);
         } else {

            aux = new SkipListNode<T>(key, height, newValue);

            for (int i = 0; i < height; i++) {
               aux.forward[i] = update[i].forward[i];
               update[i].forward[i] = aux;
            }
         }

      }
   }

   private void fixRootRelationship(int height) {
      if (USE_MAX_HEIGHT_AS_HEIGHT) {
         height = maxHeight;
      }

      if (this.height < height) {
         for (int i = this.height; i < height; i++) {
            root.forward[i] = NIL;
         }
         this.height = height;
      }
   }

   @Override
   public void remove(int key) {
      if (key != this.root.key && key != this.NIL.key) {
         SkipListNode<T>[] update = new SkipListNode[this.height];
         SkipListNode<T> aux = this.root;
         for (int i = this.height - 1; i >= 0; i--) {
            while (aux.getForward(i) != null && aux.getForward(i).key < key) {
               aux = aux.getForward(i);
            }
            update[i] = aux;
         }
         if (aux.getForward(0).key == key) {
            aux = aux.getForward(0);
            for (int i = aux.height - 1; i >= 0; i--) {
               update[i].forward[i] = aux.forward[i];
               if (!this.USE_MAX_HEIGHT_AS_HEIGHT && (update[i] == this.root) && (update[i].forward[i] == this.NIL)
                     && i != 0)
                  update[i].forward[i] = null;
            }
         }
      }
   }

   @Override
   public int height() {
      return this.height;
   }

   @Override
   public SkipListNode<T> search(int key) {
      if (key == this.root.key)
         return this.root;
      if (key == this.NIL.key)
         return this.NIL;
      SkipListNode<T> aux = this.root;
      for (int i = this.height - 1; i >= 0; i--) {
         while (aux.getForward(i) != null && aux.getForward(i).key < key) {
            aux = aux.getForward(i);
         }
      }
      if (aux.getForward(0) != null && aux.getForward(0).key == key) {
         return aux.getForward(0);
      }
      return null;
   }

   @Override
   public int size() {
      SkipListNode<T> aux = root;
      int size = 0;

      while (aux.getForward(0) != null) {
         aux = aux.getForward(0);
         size = aux.equals(NIL) ? size : size + 1;
      }

      return size;
   }

   @Override
   public SkipListNode<T>[] toArray() {
      @SuppressWarnings("unchecked")
      SkipListNode<T>[] array = new SkipListNode[size() + 2];
      SkipListNode<T> aux = this.root;
      for (int i = 0; i < array.length; i++) {
         array[i] = aux;
         aux = aux.getForward(0);
      }
      return array;
   }

}
