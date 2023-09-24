package iterator.service.impl;

import iterator.service.Iterator;

import java.util.List;

public class NumbersIteratorImpl<T> implements Iterator<T> {
    private final List<T> entity;
    private int idx = -1;

    public NumbersIteratorImpl(List<T> entity) {
        this.entity = entity;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -2;
    }

    @Override
    public T next() {
        idx = findNextIdx();
        if (idx != -2) {
            return entity.get(idx);
        }
        return null;
    }
    private int findNextIdx() {
        var tempIdx = idx;
        while (true) {
            tempIdx++;
            if (tempIdx >= entity.size()) {
                tempIdx = -2;
                break;
            }
            if (entity.get(tempIdx) != null) {
                break;
            }
        }
        return tempIdx;
    }
}
