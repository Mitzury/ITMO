using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ExceptionServices;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace ITMO.Lesson
{
    class Program
    {
        static int GetAge()
        {
            Random rnd = new Random();
            //Получить случайное число 
            int rage = rnd.Next(18, 88);
            //Вернуть полученное значение
            return rage;
        }
        static int GetHeight()
        {
            Random rnd2 = new Random();
            //Получить случайное число 
            int rheight = rnd2.Next(150, 250);
            //Вернуть полученное значение
            return rheight;
        }
        static void Main(string[] args)
        {
            //Приветствие
            Console.WriteLine("Добро пожаловать в программу поиска девушки");
            Console.WriteLine("Как Вас зовут?");
            string name = Console.ReadLine();
            Console.WriteLine("Привет, " + name);
            // Вопрос 1.
            Console.WriteLine("Введите желаемый рост девушки (150 - 250)");
            int height = int.Parse(Console.ReadLine());
            // Вопрос 2.
            Console.WriteLine("Введите желаемый возраст девушки (18-88)");
            int age = int.Parse(Console.ReadLine());
            // Итог
            Console.WriteLine("Ваш выбор, девушка с ростом: " + height + " и возрастом: " + age);
            // Задаем цикл
            Console.WriteLine("Введите количество раз, сколько будем искать (от 1 до бесконечности)");
            int n = int.Parse(Console.ReadLine());
            int i = 1;
            for (i = 1; i <= n; i++)
            {
                if (GetAge() == age && GetHeight() == height)
                {
                    Console.WriteLine("Ура, мы нашли для Вас девушку");
                    Console.WriteLine("Число просмотренных девушек в базе: " + i + " из " + n

                        );
                    break;
                }
                else
                {
                    Console.SetCursorPosition(0, 12);
                    Console.WriteLine("Ищем девушку, № в базе: " + i + " Текущий возраст: " + GetAge() + " Текущий рост:" + GetHeight());
                }
            }
            Console.WriteLine("Увы не нашли");
            //Конец
            Console.ReadKey();
        }
    }
}