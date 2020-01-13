package lesson4;

import java.util.ListIterator;

public interface ListIterable<Item> extends Iterable<Item> {

    ListIterator<Item> listIterator();
}
