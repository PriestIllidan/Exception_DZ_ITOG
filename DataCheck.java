public class DataCheck {
    // 1. Прверка на количество ввода данных:
    public String[] checkDate(String str) throws MyEx {
        String[] date = str.split(" ");
        if (date.length != 6) {
            throw new MyEx("Данные введены не в полном или в большем объеме!");
        }
        return date;
    }

    // 2. Проверка данных (номера):
    public boolean isCorrectNumber(String str) { // str [4]
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Некорректно введен номер телефона " + e);
            return false;
        }
    }

    // 3. Проверка данных (пол):
    public boolean isCorrectGender(String str) { // str [5]
        char[] chars = str.toCharArray();
        if (chars.length == 1 && (chars[0] == 'f' || chars[0] == 'm')) {
            return true;
        } else {
            System.out.println("Данные по полу введены некорректно!");
            return false;
        }
    }

    // 4.Проврка данных (дата рождения):
    public boolean isCorrectData(String str) { // str [3]
        try {
            String[] res = str.split("\\.");
            if (res.length == 3 &&
                    Integer.parseInt(res[0]) > 0 && Integer.parseInt(res[0]) < 32 &&
                    Integer.parseInt(res[1]) > 0 && Integer.parseInt(res[1]) < 13 &&
                    Integer.parseInt(res[2]) > 0 && Integer.parseInt(res[2]) < 2024) {
                return true;
            } else {
                System.out.println("Некорректно указана дата!");
                return false;
            }
        } catch (
                NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(e);
            return false;
        }
    }
}
