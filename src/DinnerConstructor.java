import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

    public class DinnerConstructor {
        public static HashMap<String, ArrayList<String>> menu; //будет таблица с типом блюд(п:напитки) и списком значений(п:сок, чай)

        DinnerConstructor() {

            menu = new HashMap<>(); //создали таблицу
        }

        public static void dishMenu(String dishType, String dishName) { //вносим значения введенные пользователем
            if (menu.containsKey(dishType)) {  // проверяем ключ, если такой есть
                ArrayList<String> dishNames = menu.get(dishType);// получаем список
                dishNames.add(dishName); // добавляем в него значение
            } else {
                ArrayList<String> dishNames = new ArrayList<>(); // если ключа нет - создаём новый список "типа"
                dishNames.add(dishName); // добавляем блюдо
                menu.put(dishType, dishNames); // ключ и список сохраняем в таблицу
            }
        }

        static boolean checkType(String nextItem) { // этот метод должен возвращать true или false
            // метод принимает значение ключа его нужно сравнить с ключами в первой хеш.таб
            boolean check = menu.containsKey(nextItem);   // проверяем ключ, если такой есть
            return check;
        }

        public static void generateCombos(int numberOfCombos, ArrayList<String> typeForCombo) { //для генерации комбо  список типов и количество
            HashMap<String, ArrayList<String>> setCombo = new HashMap<>(); //в таблицу сохраняется ключ (комбо) и список блюд по одному каждого вида numberOfCombos;
            // Combo;  //"борщ", "винегрет", "сок"
            for (int i = 0; i < numberOfCombos; i++) {
                String dish = null;
                ArrayList<String> сombo = new ArrayList<>();

                for (String dishType : typeForCombo) {
                    if (menu.containsKey(dishType)) {
                        ArrayList<String> strings = menu.get(dishType);
                        int x = strings.size();
                        int randomInt = new Random().nextInt(x - 1); // здесь должна быть длина списка -1
                        dish = strings.get(randomInt);
                    }
                }
                сombo.add(dish);
                setCombo.put("Комбо", сombo);
            }
            int i = 0;
            for (String lunchCombo : setCombo.keySet()) { // цикл должен пройтись по ключам
                System.out.println(lunchCombo + " № " + (i + 1) + ": ");
                ArrayList<String> value = setCombo.get(lunchCombo);
                System.out.println(value);
            }
        }
    }
