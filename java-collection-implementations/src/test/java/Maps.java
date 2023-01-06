import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Maps {

    @Test
    void HashMap_순서_보장_X() {
        final var map = new HashMap<String, String>();
        map.put("bbb", "2");
        map.put("ddd", "4");
        map.put("aaa", "1");
        map.put("ccc", "3");

        for (final var entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    @Test
    void TreeMap_key를_기준으로_정렬() {
        final var map = new TreeMap<String, String>();
        map.put("bbb", "2");
        map.put("ddd", "4");
        map.put("aaa", "1");
        map.put("ccc", "3");

        final var keys = map.keySet().stream().toList();
        assertEquals(keys.get(0), "aaa");
        assertEquals(keys.get(1), "bbb");
        assertEquals(keys.get(2), "ccc");
        assertEquals(keys.get(3), "ddd");
    }

    @Test
    void LinkedHashMap_입력_순서_보장() {
        final var map = new LinkedHashMap<String, String>();
        map.put("bbb", "2");
        map.put("ddd", "4");
        map.put("aaa", "1");
        map.put("ccc", "3");
        map.put("aaa", "1X");

        final var keys = map.keySet().stream().toList();
        assertEquals(keys.get(0), "bbb");
        assertEquals(keys.get(1), "ddd");
        assertEquals(keys.get(2), "aaa");
        assertEquals(keys.get(3), "ccc");
    }

    @Test
    void EnumMap_enum을_key로_사용() {
        final var map = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        map.put(DayOfWeek.SATURDAY, DayOfWeek.SATURDAY.name());
        map.put(DayOfWeek.SUNDAY, DayOfWeek.SUNDAY.name());
        map.put(DayOfWeek.MONDAY, DayOfWeek.MONDAY.name());
        map.put(DayOfWeek.TUESDAY, DayOfWeek.TUESDAY.name());
        map.put(DayOfWeek.WEDNESDAY, DayOfWeek.WEDNESDAY.name());
        map.put(DayOfWeek.THURSDAY, DayOfWeek.THURSDAY.name());
        map.put(DayOfWeek.FRIDAY, DayOfWeek.FRIDAY.name());

        final var keys = map.keySet().stream().toList();
        assertEquals(keys.get(0), DayOfWeek.MONDAY);
        assertEquals(keys.get(1), DayOfWeek.TUESDAY);
        assertEquals(keys.get(2), DayOfWeek.WEDNESDAY);
        assertEquals(keys.get(3), DayOfWeek.THURSDAY);
        assertEquals(keys.get(4), DayOfWeek.FRIDAY);
        assertEquals(keys.get(5), DayOfWeek.SATURDAY);
        assertEquals(keys.get(6), DayOfWeek.SUNDAY);
    }
}
