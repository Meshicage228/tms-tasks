package iterator.domain;

import iterator.service.impl.NumbersIteratorImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class SomeObject<T> {
    private List<T> entityList = new ArrayList<>();

    public SomeObject() {
    }
    public void add(T entity){
        entityList.add(entity);
    }
    public NumbersIteratorImpl iterator(){
        return new NumbersIteratorImpl(entityList);
    }
}
