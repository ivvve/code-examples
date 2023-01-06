import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Sets {

    @Test
    void HashSet_순서_보장_X() {
        final var set = new HashSet<String>();
        set.add("bbb");
        set.add("ddd");
        set.add("aaa");
        set.add("ccc");
        set.add("aaa");

        for (final var element : set) {
            System.out.println(element);
        }
    }

    @Test
    void TreeMap_element를_기준으로_정렬() {
        final var set = new TreeSet<String>();
        set.add("bbb");
        set.add("ddd");
        set.add("aaa");
        set.add("ccc");

        final var elements = set.stream().toList();
        assertEquals(elements.get(0), "aaa");
        assertEquals(elements.get(1), "bbb");
        assertEquals(elements.get(2), "ccc");
        assertEquals(elements.get(3), "ddd");
    }

    @Test
    void LinkedHashSet_입력_순서_보장() {
        final var set = new LinkedHashSet<String>();
        set.add("bbb");
        set.add("ddd");
        set.add("aaa");
        set.add("ccc");
        set.add("aaa");

        final var elements = set.stream().toList();
        assertEquals(elements.get(0), "bbb");
        assertEquals(elements.get(1), "ddd");
        assertEquals(elements.get(2), "aaa");
        assertEquals(elements.get(3), "ccc");
    }

    @Test
    void EnumSet_enum을_element로_사용() {
        final var set = EnumSet.noneOf(DayOfWeek.class);
        set.add(DayOfWeek.SATURDAY);
        set.add(DayOfWeek.SUNDAY);
        set.add(DayOfWeek.MONDAY);
        set.add(DayOfWeek.TUESDAY);
        set.add(DayOfWeek.WEDNESDAY);
        set.add(DayOfWeek.THURSDAY);
        set.add(DayOfWeek.FRIDAY);

        final var elements = set.stream().toList();
        assertEquals(elements.get(0), DayOfWeek.MONDAY);
        assertEquals(elements.get(1), DayOfWeek.TUESDAY);
        assertEquals(elements.get(2), DayOfWeek.WEDNESDAY);
        assertEquals(elements.get(3), DayOfWeek.THURSDAY);
        assertEquals(elements.get(4), DayOfWeek.FRIDAY);
        assertEquals(elements.get(5), DayOfWeek.SATURDAY);
        assertEquals(elements.get(6), DayOfWeek.SUNDAY);
    }
}
