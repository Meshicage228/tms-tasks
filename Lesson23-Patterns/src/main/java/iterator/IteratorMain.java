package iterator;

import iterator.domain.IteratorContent;
import iterator.service.CheckIteratorService;

import java.util.List;

public class IteratorMain {
    public static void main(String[] args) throws InterruptedException {
            IteratorContent checkIterator = new IteratorContent(List.of(12,5,65,263,-152,-6132));
            CheckIteratorService.showAllInfo(checkIterator);

    }
}
