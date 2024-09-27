package me.yurasevv;

import java.util.Arrays;

public class MissingNumberFinder {
    public static void main(String[] args) {

    }

    // Сложность O(Nlog(N) + M(log(M)), так как используется сортировка + поиск
    public static int findMissingNumberUsingSearch(int[] arr) {
        // Сортируем массив
        Arrays.sort(arr);

        // Итерируем по отсортированному массиву и ищем пропущенное число
        for (int i = arr[0]; i < arr[arr.length - 1]; i++) {
            if (Arrays.binarySearch(arr, i) < 0) {
                return i;  // Возвращаем пропущенное число
            }
        }

        // Если пропусков в последовательности нет, возвращаем следующее число после последнего
        return arr[arr.length - 1] + 1;
    }

    public static int findMissingNumberUsingSum(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        // Найдем минимальное и максимальное значения в массиве
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Рассчитаем ожидаемую сумму для последовательности от min до max
        int expectedSum = (max * (max + 1)) / 2 - (min * (min - 1)) / 2;

        // Рассчитаем фактическую сумму элементов массива
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Пропущенное число — разница между ожидаемой и фактической суммой
        return expectedSum - actualSum;
    }

    public static int findMissingNumberUsingXOR(int[] arr) {
        int n = arr.length;
        int xorArray = 0;
        int xorFull = 0;
        int min = arr[0];
        int max = arr[0];

        // Найдем минимальное и максимальное значения в массиве
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // XOR всех элементов массива
        for (int num : arr) {
            xorArray ^= num;
        }

        // XOR всех чисел от 0 до N
        for (int i = min; i <= max; i++) {
            xorFull ^= i;
        }

        // Разница между xorArray и xorFull даст пропущенное число
        return xorArray ^ xorFull;
    }
}