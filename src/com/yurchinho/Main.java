package com.yurchinho;

import java.util.Random;
import java.util.Scanner;

public class Main {


    static void InputArr(int[] arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть елементи масива:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int j = arr.length - 1;
        int count = 0;
        for (;j > 0; j--)
        {
            if(arr[j] < 0)
            {
                count++;
            }
        }
        if(count == arr.length - 1)
        {
            System.out.println("У масиві всі елементи від'ємні. Введіть елементи ще раз!");
            InputArr(arr);
        }
    }

    static void RandomInput(int[] arr) {
        double num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = Math.random() * 200 - 100;
            arr[i] = (int) num;
        }
        int j = arr.length - 1;
        int count = 0;
        for (;j > 0; j--)
        {
            if(arr[j] < 0)
            {
                count++;
            }
        }
        if(count == arr.length)
        {
            System.out.println("У масиві всі елементи від'ємні. Введіть елементи ще раз!");
            RandomInput(arr);
        }

    }

    static void OutputArr(int[] arr) {
        System.out.println("Масив цілих чисел:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void Task1(int[] arr) {
        int[]duplicate = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                duplicate[i] = 1;
            } else if (arr[i] < 0) {
                duplicate[i] = 0;
            }
        }
        System.out.println("Результат роботи:");
        OutputArr(duplicate);
    }

    //добуток додатних елементів масиву
    static void Task2(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res = res * arr[i];
            }
        }
        System.out.println("Результат завдання: " + res);
    }

    //  суму елементів масиву, розташованих до останнього додатного елемента.
    static void Task2_2(int[] arr) {
        int k = arr.length - 1 ;
        int sum = 0;
        while (arr[k] < 0) {
            k--;
        }
        for (int i = 0; i < k ; i++) {

                sum += arr[i];

        }
        OutputArr(arr);
        System.out.println("Результат завдання: " + sum);
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("Введіть кількість елементів в масиві:");
        int size = in.nextInt();
        int[] arr = new int[size];
        System.out.println("Яким чином заповнити масив?:\n\t1 - з клавіатури;\n\t2 - рандомними числами від -100 до 100");
        int choice2 = in.nextInt();
        if(choice2 == 1) InputArr(arr);
        else if(choice2 == 2) RandomInput(arr);
        else {
            System.out.println("Невірно введнені дані! Спробуйте ще раз.");
            return;
        }
        boolean bool = true;
        int choice = 0;

        while (bool) {
            System.out.println("Головне меню.\n\t1 - Завдання №1.\n\t2 - Завдання №2");
            System.out.print("Введіть цифру від 1 до 2: ");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                        System.out.println("\tДано  масив  цілих  чисел, замінити  в  масиві  всі  додатні  елементи одиницями, а всі від’ємні –нулями.:");
                        OutputArr(arr);
                        Task1(arr);
                        break;
                }
                case 2: {
                    System.out.println("Завдання 2.\n\t1 - Перше завдання;\n\t2 - Друге завдання;");
                    int choice3 = in.nextInt();
                 if(choice3 == 1) {
                     System.out.println("Визначити добуток додатних елементів масиву:");
                     Task2(arr);
                     OutputArr(arr);
                 }else if(choice3 == 2) {
                     System.out.println("Визначити суму елементів масиву, розташованих до останнього додатного елемента:");
                     Task2_2(arr);
                 }else {
                     System.out.println("Невірно введнені дані! Спробуйте ще раз.");
                 }
                 break;
                 }
                default: {
                    System.out.println("Введено помилкове значення!");
                }

            }
            System.out.println("Якщо хочете прожовжити або закінчити програму натисніть:\n\t1 - Якщо хочете продовжити.\n\t2 - Якщо хочете закінчити.");
            int choice4 = in.nextInt();
            if (choice4 == 1) {
                bool = true;
            } else {
                bool = false;
            }
        }
    }
}


