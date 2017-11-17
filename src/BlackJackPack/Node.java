package BlackJackPack;


class Node<E> {
	E item;
    Node<E> next;

    Node() {
      item = null;
      next = null;
    }

    Node(E item) {
      this.item = item;
      next = null;
    }

    Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }

    Node(Node<E> n) {
      this.item = n.item;
      this.next = n.next;
    }
}
