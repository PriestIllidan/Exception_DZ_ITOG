import java.util.*;

public class App {
    public void startApp() {
        InputData str = new InputData(); // создадим экземпляр ввода
        String inputData = str.inputDate(); // и присвоим его переменной.
        DataCheck check = new DataCheck(); // создадим экземпляр для проверок
        LinkedHashMap<String, String> map = new LinkedHashMap<>(); // создадим экземпляр словаря.
        boolean checking = true; // условие для выхода из цикла.
        WriteToFile file = new WriteToFile(); //  создадим экземпляр записи в файл
        final String PATH = "src/Data"; // и путь к файлу.
        while (checking == true) {
            try {
                String[] inputDataArr = check.checkDate(inputData); // проверим на количество введенных данных.

                if (check.isCorrectData(inputDataArr[3]) &&
                        check.isCorrectNumber(inputDataArr[4]) && check.isCorrectGender(inputDataArr[5])) {
                    map.put("Фамилия", inputDataArr[0]);
                    map.put("Имя", inputDataArr[1]);
                    map.put("Отчество", inputDataArr[2]);
                    map.put("дата рождения", inputDataArr[3]);
                    map.put("номер телефона", inputDataArr[4]);
                    map.put("пол", inputDataArr[5]);
                    file.write(map, PATH);
                    checking = false;
                }
                for (Map.Entry<String, String> value : map.entrySet()) {
                    System.out.print(value.getValue() + " ");
                }
                System.out.println();
                System.out.println("Данные успешно добавлены.");
            } catch (MyEx | RuntimeException e) {
                System.out.println(e);
                checking = true;
            }
        }
    }

//
//    // 1.
//    public static String inputDate() {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("Введие следующие данные через пробел: Фамилия, Имя, Отчество, дата рождения, номер телефона, пол");
//            return scanner.nextLine();
//        } catch (NoSuchElementException e) {
//            System.out.println(e);
//        }
//        return inputDate();
//    }
//
//    // 2.
//    public static String[] checkDate(String str) throws MyEx {
//        String[] date = str.split(" ");
//        if (date.length != 6) {
//            throw new MyEx("Данные введены не в полном или в большем объеме!");
//        } else {
//            return date;
//        }
//    }
//
//    // 3.
//    public static boolean isNumber(String str) {
//        try {
//            Double.parseDouble(str);
//            return true;
//        } catch (NumberFormatException e) {
//            System.out.println("Некорректно введен номер телефона " + e);
//            return false;
//        }
//    }
//
//    // 4.
//    public static boolean isGender(String str) {
//        char[] chars = str.toCharArray();
//        if (chars.length == 1 && (chars[0] == 'f' || chars[0] == 'm')) {
//            return true;
//        } else {
//            System.out.println("Данные по полу введены некорректно!");
//            return false;
//        }
//    }
//
//    public static boolean isCorrectData(String str) { // str [3]
//        try {
//            String[] res = str.split("\\.");
//            if (res.length == 3 &&
//                    Integer.parseInt(res[0]) > 0 && Integer.parseInt(res[0]) < 32 &&
//                    Integer.parseInt(res[1]) > 0 && Integer.parseInt(res[1]) < 13 &&
//                    Integer.parseInt(res[2]) > 0 && Integer.parseInt(res[2]) < 2024) {
//                return true;
//            } else {
//                System.out.println("Некорректно указана дата!");
//                return false;
//            }
//        } catch (
//                NumberFormatException | IndexOutOfBoundsException e) {
//            System.out.println(e);
//            return false;
//        }
//    }
}
