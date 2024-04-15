import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PracticumDinner {

    static DinnerConstructor dc; // обьявили конструктор
    static Scanner scanner;  // обьявили сканер
    static Random random;  // обьявили рандом

    public static void main(String[] args) {
        dc = new DinnerConstructor(); // создали объект
        scanner = new Scanner(System.in);
        random = new Random();
        while (true) {  //бесконечный цикл
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        DinnerConstructor.dishMenu(dishType, dishName); // вызвали класс заполняющий таблицу со списком
        // добавьте новое блюдо
    }

    private static void generateDishCombo() { //здесь должно создаваться комбо на основе ранее введённых данных в таблицу
        /* Для этого пользователь указывает набор типов блюд, которые должны входить в бизнес-ланч. Например,
         Первое, Второе и Напиток. В ответ программа выводит одну или несколько возможных комбинаций из блюд
         этих типов.  */
        int numberOfCombos = 0; // сохраняем количество комбо
        String nextItem = null; // сохраняем введенный тип блюда(ключ от хэш таб.)

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        numberOfCombos = scanner.nextInt();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> typeForCombo = new ArrayList<>(); // здесь сохраняем в список nextItem

        while (true) {     // цикл должен вводить данные в список, пока не встретит пустую строку
            // НА ЭТОМ ЭТАПЕ НАЧИНАЮТСЯ ОШИБКИ
            nextItem = scanner.nextLine(); { // хранит введенное значение
                // эта штука должна проверять есть ли введённый ключ в первой хеш таб.
                if (nextItem.isEmpty()){  // если строка пуста то вышли(для завершения ввода пользователь должен ещё раз нажать Enter;)
                    break;
                }
                else if (DinnerConstructor.checkType(nextItem)) {  //если checkType - true, то добавляем nextItem в список typeForCombo
                    typeForCombo.add(nextItem);
                }
                else {     //если checkType - false
                    System.out.println("Такого типа нет."); //если пользователь ввёл несуществующий тип, программа должна вывести предупреждающее сообщение и предложить ввести другой тип
                }
            }
            DinnerConstructor.generateCombos(numberOfCombos,typeForCombo);
        }
    }
}