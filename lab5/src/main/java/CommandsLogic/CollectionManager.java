package CommandsLogic;

import Data.Dragon;
import database.CSVDataBase;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class CollectionManager {
    private Vector<Dragon> collection;


    public CollectionManager(Vector<Dragon> collection) {
        this.collection = collection;
    }

    public void add(Dragon dragon){
        collection.add(dragon);
    }

   public void info(){
        System.out.println("Number of elements "+collection.size()+ "\n"+
                           "Collection type "+collection.getClass().getName()+"\n"+
                            "Initialization date "+new Date());
    }
    public void show(){
        collection.forEach(System.out::println);
    }

    public boolean isThereDragon(int id) {
        for (Dragon dragon : collection) {
            if (dragon.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void updateId(int id , Dragon dragon) {
        if (collection.size() == 0)
            return;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId() == id) {
                collection.set(i , dragon);
                return;
            }
        }
    }
    public void clearCollection(){
        collection.clear();
    }
    public void sort (){
        Collections.sort(collection);
    }
    public void reorder(){
        collection.sort(new Comparator<Dragon>() {
            @Override
            public int compare(Dragon o1, Dragon o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }
    public void removeById(int id){
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId() == id) {
                collection.remove(i);
                return;
            }
        }
    }
    public void sumOfAge(){
        int totalAge = 0;
        for (Dragon dragon : collection) {
            totalAge += dragon.getAge();
        }
        System.out.println("Sum of age dragon is "+totalAge);
    }

    public void filterContainsName(String searchSubstring){
        for (Dragon dragon : collection) {
            if (dragon.getName().contains(searchSubstring)) {
                System.out.println(dragon.getName() + " (" + dragon.getAge() + ")");
            }
        }
    }
    public void maxByCoordinates(){
        Comparator<Dragon> coordinatesComparator = Comparator.comparing(dragon -> dragon.getCoordinates().getX() + dragon.getCoordinates().getY());
        Dragon dragonWithMaxCoordinates = Collections.max(collection, coordinatesComparator);

        System.out.println("Dragon with max coordinates:");
        System.out.println(dragonWithMaxCoordinates.getName() + " (" + dragonWithMaxCoordinates.getCoordinates().getX() + ", " + dragonWithMaxCoordinates.getCoordinates().getY() + ")");
    }
    public void saveCollection(){
        String fileName = "csv_data.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            CSVDataBase.writePersonsToCsv(fileName , collection);
            System.out.println("Data written to file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }
    }
}
