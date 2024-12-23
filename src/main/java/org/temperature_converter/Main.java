package org.temperature_converter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Temp tmp = new Temp();
        String temp_1 = "c";
        String temp_2 = "f";
        String temp_3 = "k";

        int inputed_temp = 0;
        String counting = "";
        String target_temp = "";


        System.out.println("Введите температуру: ");
        inputed_temp = input.nextInt();
        System.out.println("Введите единицу измерения(С - градусы Цельсия, F - градусы Фаренгейта, K - градусы Кельвина): ");
        counting = input.next();
        System.out.println("Введите желаемую единицу измерения температуры(С - градусы Цельсия, F - градусы Фаренгейта, K - градусы Кельвина): ");
        target_temp = input.next();
        tmp.convert(inputed_temp, counting, target_temp);
        System.out.println("Изменненная температура равна = " + tmp.convert(inputed_temp, counting, target_temp ) + " Градуса " + target_temp.toUpperCase());
        input.close();
    }


}
class Temp{

    int convert(int tmp, String setted_temperature, String target) {
        if (setted_temperature.equalsIgnoreCase(target)) {
            return tmp; // Если единицы совпадают, возвращаем исходное значение
        }

        // Преобразования из Цельсия
        if (setted_temperature.equalsIgnoreCase("C") && target.equalsIgnoreCase("K")) {
            return tmp + 273; // Цельсий в Кельвин
        }
        if (setted_temperature.equalsIgnoreCase("C") && target.equalsIgnoreCase("F")) {
            return (int) (tmp * 1.8 + 32); // Цельсий в Фаренгейт
        }

        // Преобразования из Кельвина
        if (setted_temperature.equalsIgnoreCase("K") && target.equalsIgnoreCase("C")) {
            return tmp - 273; // Кельвин в Цельсий
        }
        if (setted_temperature.equalsIgnoreCase("K") && target.equalsIgnoreCase("F")) {
            return (int) ((tmp - 273) * 1.8 + 32); // Кельвин в Фаренгейт
        }

        // Преобразования из Фаренгейта
        if (setted_temperature.equalsIgnoreCase("F") && target.equalsIgnoreCase("C")) {
            return (int) ((tmp - 32) / 1.8); // Фаренгейт в Цельсий
        }
        if (setted_temperature.equalsIgnoreCase("F") && target.equalsIgnoreCase("K")) {
            return (int) ((tmp - 32) / 1.8 + 273); // Фаренгейт в Кельвин
        }

        System.out.println("Неправильные значения");
        return Integer.MIN_VALUE; // Возвращаем значение для ошибки
    }
}