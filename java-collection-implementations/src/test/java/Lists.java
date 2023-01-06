import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lists {

    @Test
    void ArrayList_() {
        final var list = new ArrayList<String>();
        list.add("bbb");
        list.add("ddd");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");

        assertEquals(list.get(0), "bbb");
        assertEquals(list.get(1), "ddd");
        assertEquals(list.get(2), "aaa");
        assertEquals(list.get(3), "ccc");
        assertEquals(list.get(4), "aaa");
    }

    @Test
    void LinkedList_() {
        final var list = new LinkedList<String>();
        list.add("bbb");
        list.add("ddd");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");

        assertEquals(list.get(0), "bbb");
        assertEquals(list.get(1), "ddd");
        assertEquals(list.get(2), "aaa");
        assertEquals(list.get(3), "ccc");
        assertEquals(list.get(4), "aaa");

        System.out.println("list.getFirst() = " + list.getFirst()); // bbb
        System.out.println("list.getLast() = " + list.getLast()); // aaa
    }

    @Test
    void Vector_thread_safe() {
        final var list = new Vector<String>();
        list.add("bbb");
        list.add("ddd");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");

        assertEquals(list.get(0), "bbb");
        assertEquals(list.get(1), "ddd");
        assertEquals(list.get(2), "aaa");
        assertEquals(list.get(3), "ccc");
        assertEquals(list.get(4), "aaa");
    }

    @Test
    void Stack_() {
        final var list = new Stack<String>();
        list.add("bbb");
        list.add("ddd");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");

        assertEquals(list.get(0), "bbb");
        assertEquals(list.get(1), "ddd");
        assertEquals(list.get(2), "aaa");
        assertEquals(list.get(3), "ccc");
        assertEquals(list.get(4), "aaa");

        System.out.println("list.peek() = " + list.peek()); // last in 값 확인 - aaa
        System.out.println("list.pop() = " + list.pop()); // last in 값 빼오기 - aaa
    }
}
