import domain.Fridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomDB {
    public static List<Fridge> fridgeList = new ArrayList<>();

    public void create(Fridge fridge){
        fridge.setId(UUID.randomUUID());
        fridgeList.add(fridge);
    }
    public List<Fridge> getByTitle(String title){
        if(title == null || title.isBlank()){
            return fridgeList;
        }
        return fridgeList.stream()
                .filter(fridge -> title.equals(fridge.getTitle()))
                .toList();
    }
    public void delete(UUID uuid){
        Optional<Fridge> first = fridgeList.stream()
                .filter(fridge -> fridge.getId().equals(uuid))
                .findFirst();


        first.ifPresent(fridge -> fridgeList.remove(fridge));
    }

}
