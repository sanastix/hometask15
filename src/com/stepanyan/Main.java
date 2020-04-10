package com.stepanyan;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Создать список случайных чисел. Используя Stream Api подсчитать среднее арифиметическое квадратов этих чисел.
        streamApiMethod();

        /*
        Задан отсортированный список который состоит из ListNode.
        Написать метод deleteDuplicates, который вернет список без дубликатов.
        Input: 1->1->2->3->3
        Output: 1->2->3
         */
        ListNode el = new ListNode(1);
        el.next = new ListNode(1);
        el.next.next = new ListNode(2);
        el.next.next.next = new ListNode(3);
        el.next.next.next.next = new ListNode(3);

        printEls(el);
        deleteDuplicates(el);
        System.out.println();
        printEls(el);

    }

    public static void streamApiMethod () {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i, random.nextInt(50) + 1);
        }
        System.out.println(list.stream().mapToInt((i) -> (int) Math.pow(i,2)).average());
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode deleteDuplicates (ListNode el) {
        if (el == null) {
            return null;
        }
        if (el.next == null) {
            return el;
        }
        ListNode tmpEl = deleteDuplicates(el.next);
        if (el.val == tmpEl.val) {
            el.next = tmpEl.next;
        }
        return el;
    }

    public static void printEls (ListNode el) {
        while (el != null) {
            System.out.print(el.val + " ");
            el = el.next;
        }
    }

}
