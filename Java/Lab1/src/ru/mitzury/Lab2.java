/*
===========================================================

Напишите программу, которая выводит на консоль нечетные числа от 1 до 99.
Каждое число печатается с новой строки.

        for (int i = 1; i <= 99; i++) {
            System.out.println("Строка №" + i);
        }

===========================================================

Напишите программу, которая выводит числа от 1 до 100,
которые делятся на 3, 5 и на то и другое (то есть и на 3 и на 5).

        System.out.print("Числа делятся на 3: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0)
                System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.print("Числа делятся на 5: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0)
                System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.print("Числа делятся на 3 и 5: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 3 == 0)
                System.out.print(i + " ");
        }

===========================================================

Напишите программу, чтобы вычислить сумму двух целых чисел и вернуть true,
если сумма равна третьему целому числу.

        System.out.print("\n");
        System.out.println("ВВедите число 1: ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.print("ВВедите число 2: ");
        Scanner scanner2 = new Scanner(System.in);
        int num2 = scanner2.nextInt();
        System.out.print("ВВедите число 3: ");
        Scanner scanner3 = new Scanner(System.in);
        int num3 = scanner3.nextInt();
        if (num1 + num2 == num3)
            System.out.print("true");
        else
            System.out.print("false");

===========================================================

Напишите программу, которая принимает от пользователя три целых числа и возвращает true,
если второе число больше первого числа, а третье число больше второго числа.

        System.out.print("\n");
        System.out.println("ВВедите число 1: ");
        Scanner scanner4 = new Scanner(System.in);
        int num11 = scanner.nextInt();
        System.out.print("ВВедите число 2: ");
        Scanner scanner5 = new Scanner(System.in);
        int num12 = scanner2.nextInt();
        System.out.print("ВВедите число 3: ");
        Scanner scanner6 = new Scanner(System.in);
        int num13 = scanner3.nextInt();
        if (num11 < num12 && num13 > num12)
            System.out.print("true");
        else
            System.out.print("false");

===========================================================

Напишите программу, чтобы проверить, является ли число 3 как
первый или последний элемент массива целых чисел.
Длина массива должна быть больше или равна двум.

        System.out.print("\n");
        int[] nums = new int[] { 3, 2, 3, 5, 3 };
        System.out.print("array = { ");
        for (int i = 0 ; i < nums.length; i++ )
        {
            System.out.print(nums[i]);
            if (i < nums.length -1)
            {
                System.out.print(",");
            }
            else
            {
                System.out.print(" }");
            }
        }
        if (nums[0] == 3 && nums[nums.length-1]==3)
        {
            System.out.print("\n");
            System.out.println("true");
        }

===========================================================

Напишите программу, чтобы проверить, что массив содержит число 1 или 3.

        System.out.print("\n");
        int[] nums = new int[] { 3, 2, 3, 1, 5, 3 };
        for (int i = 0 ; i < nums.length ; i++)
        {
            if (nums[i] == 1)
            {
                System.out.println("Массив содержит 1");
            }
            if (nums[i] == 3)
            {
                System.out.println("Массив содержит 3");
            }
        }

    }
}
*/