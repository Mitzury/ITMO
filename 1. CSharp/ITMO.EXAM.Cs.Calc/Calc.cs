using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace calculator
{
    //класс, реализующий интерфейс InterfaceCalc
    public class Calc : InterfaceCalc
    {
        private double a = 0;
        public void Put_A(double a)
        {
            this.a = a;
        }

        public void Clear_A()
        {
            a = 0;
        }

        public double Multiplication(double b)
        {
            return a * b;
        }

        public double Division(double b)
        {
                return a / b;
        }

        public double Sum(double b)
        {
            return a + b;
        }

        public double Subtraction(double b)
        {
            return a - b;
        }

        public double SqrtX(double b)
        {
            return Math.Pow(a, 1 / b);
        }

        public double DegreeY(double b)
        {
            return Math.Pow(a, b);
        }

        public double Sqrt()
        {
            return Math.Sqrt(a);
        }

        public double Square()
        {
            return Math.Pow(a, 2.0);
        }

        public double Factorial()
        {
            double f = 1;

            for (int i = 1; i <= a; i++)
                f *= (double)i;

            return f;
        }

        public double Reverse()
        {
            return 1 / a;

        }
        public double Sqrt3()
        {
            return Math.Pow(a, 1 / 3.0);
        }
        public string Error()
        {
            string err = "Ошибка";
            return err;
        }
    }
}
