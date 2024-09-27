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

    // Линейная по времени и константная по памяти
    public static int findMissingNumberUsingSum(int[] arr) {
        int n = arr.length;
        // Рассчитываем ожидаемую сумму последовательности от 0 до N
        int expectedSum = (n * (n + 1)) / 2;

        // Рассчитываем фактическую сумму элементов массива
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Разница между ожидаемой и фактической суммой — это пропущенное число
        return expectedSum - actualSum;
    }

    // Линейная по времени и константная по памяти
    public static int findMissingNumberUsingXOR(int[] arr) {
        int n = arr.length;
        int xorArray = 0;
        int xorFull = 0;

        // XOR всех элементов массива
        for (int num : arr) {
            xorArray ^= num;
        }

        // XOR всех чисел от 0 до N
        for (int i = 0; i <= n; i++) {
            xorFull ^= i;
        }

        // Разница между xorArray и xorFull даст пропущенное число
        return xorArray ^ xorFull;
    }
}