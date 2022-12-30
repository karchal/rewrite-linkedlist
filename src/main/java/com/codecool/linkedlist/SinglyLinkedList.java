package com.codecool.linkedlist;

public class SinglyLinkedList <T> {

    private class Link {

        private T value;
        private Link next;

        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(T value) {
        if (head == null){
            head = new Link(value);
        }
        Link last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(new Link(value));
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public Link get(int index) {
        Link elementWithIndex = head;
        int i = 0;
        if (elementWithIndex == null) throw new IndexOutOfBoundsException();
        while (i < index){
            if (elementWithIndex.getNext() == null) throw new IndexOutOfBoundsException();
            elementWithIndex = elementWithIndex.getNext();
            i++;
        }
        return elementWithIndex;
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param value value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(T value) {
        if (head == null) return -1;
        Link elementWithIndex = head;
        int i = 0;
        while (elementWithIndex.getValue() != value){
            if (elementWithIndex.getNext() == null) return -1;
            elementWithIndex = elementWithIndex.getNext();
            i++;
        }
        return i;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param value Value to be inserted.
     */
    public void insert(int index, T value) {
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        if (head == null) return 0;
        Link currentElement = head;
        int size = 1;
        while(currentElement.getNext() != null){
            currentElement = currentElement.getNext();
            size++;
        }
        return size;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
