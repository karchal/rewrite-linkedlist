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

        boolean hasNext() {
            return getNext() != null;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }

        public String toString(){
            if (next == null) return value.toString();
            return value.toString() + "," + next.toString();
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
        if (head == null) {
            head = new Link(value);
        } else {
            Link last = head;
            while (last.hasNext()) {
                last = last.getNext();
            }
            last.setNext(new Link(value));
        }
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) {
        return getLink(index).getValue();
    }

    private Link getLink(int index) {
        Link elementWithIndex = head;
        int i = 0;
        if (elementWithIndex == null) throw new IndexOutOfBoundsException();
        while (i < index) {
            if (!elementWithIndex.hasNext()) throw new IndexOutOfBoundsException();
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
        Link elementWithValue = head;
        int i = 0;
        while (!value.equals(elementWithValue.getValue())) {
            if (!elementWithValue.hasNext()) return -1;
            elementWithValue = elementWithValue.getNext();
            i++;
        }
        return i;
    }
    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        if (head == null) return 0;
        Link currentElement = head;
        int size = 1 ;
        while (currentElement.hasNext()) {
            currentElement = currentElement.getNext();
            size++;
        }
        return size;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index Position of the new element
     * @param value Value to be inserted.
     */
    public void insert(int index, T value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            Link nextElement = head;
            head = new Link(value);
            head.setNext(nextElement);
        } else {
            Link elementBeforeIndex = getLink(index - 1);
            Link elementAtIndex = new Link(value);
            if (elementBeforeIndex.hasNext()) {
                Link elementAfterIndex = elementBeforeIndex.getNext();
                elementAtIndex.setNext(elementAfterIndex);
            }
            elementBeforeIndex.setNext(elementAtIndex);
        }
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

    @Override
    public String toString() {
        return "[" + head + "]";
    }
}
