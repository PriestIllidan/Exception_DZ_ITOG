import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputData {
    public String inputDate() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введие следующие данные через пробел: Фамилия, Имя, Отчество, дата рождения, номер телефона, пол");
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        return inputDate();
    }
}
