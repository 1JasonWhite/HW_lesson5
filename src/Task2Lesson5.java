import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task2Lesson5 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Иван Иванов");
        names.add("Светлана Петрова");
        names.add("Кристина Белова");
        names.add("Анна Мусина");
        names.add("Анна Крутова");
        names.add("Иван Юрин");
        names.add("Петр Лыков");
        names.add("Павел Чернов");
        names.add("Петр Чернышов");
        names.add("Мария Федорова");
        names.add("Марина Светлова");
        names.add("Мария Савина");
        names.add("Мария Рыкова");
        names.add("Марина Лугова");
        names.add("Анна Владимирова");
        names.add("Иван Мечников");
        names.add("Петр Петин");
        names.add("Иван Ежов");

        HashMap<String, Integer> nameCounts = new HashMap<>();
        for (String name : names) {
            String firstName = name.split(" ")[0];
            if (nameCounts.containsKey(firstName)) {
                int count = nameCounts.get(firstName);
                nameCounts.put(firstName, count + 1);
            } else {
                nameCounts.put(firstName, 1);
            }
        }

        TreeMap<Integer, ArrayList<String>> sortedCounts = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            String firstName = entry.getKey();
            int count = entry.getValue();
            if (count > 1) {
                if (sortedCounts.containsKey(count)) {
                    ArrayList<String> namesList = sortedCounts.get(count);
                    namesList.add(firstName);
                } else {
                    ArrayList<String> namesList = new ArrayList<>();
                    namesList.add(firstName);
                    sortedCounts.put(count, namesList);
                }
            }
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : sortedCounts.descendingMap().entrySet()) {
            int count = entry.getKey();
            ArrayList<String> namesList = entry.getValue();
            System.out.println(count + " раз повторяются имена: " + namesList);
        }
    }
}
