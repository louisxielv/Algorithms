package edu.nyu.lx463.questions.datastructureimplementation;

import java.util.NoSuchElementException;

/**
 * Created by LyuXie on 5/23/17.
 */
public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity has to be larger than zero");
        }
        this.array = new int[capacity];
        size = 0;
    }

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array cannot be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();

    }

    private void heapify() {
        for (int i = size/2 - 1; i >= 0; i--) {
            perlocateDown(i);
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void perlocateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = leftChildIndex + 1;
            int swapCandidate = leftChildIndex;
            if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
                swapCandidate = rightChildIndex;
            }

            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            }
            else {
                break;
            }

            index = swapCandidate;
        }
    }

    private void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void perlicateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[index] < array[parentIndex]){
                swap(array, index, parentIndex);
            }
            else {
                break;
            }

            index = parentIndex;
        }
    }

    private void copy(int[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
    }


    public int poll() {
        if (size <= 0) {
            throw new NoSuchElementException("heap is empty");
        }

        int result = array[0];
        array[0] = array[size - 1];
        size--;
        perlocateDown(0);
        return result;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public void offer(int ele) {
        if (size == array.length) {
            int[] newArray = new int[(int)(size * 1.5)];
            copy(newArray);
            array = newArray;
        }

        array[size++] = ele;
        perlicateUp(size - 1);
    }

    public int update (int index, int ele) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int result = array[index];
        if (ele > result) {
            perlocateDown(index);
        }
        else {
            perlicateUp(index);
        }

        return result;

    }

}
