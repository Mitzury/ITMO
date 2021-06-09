using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;

namespace calculator
{
    public partial class Form1 : Form
    {
        Calc C;

        public object backgroundWorkerFactorial { get; private set; }

        public Form1()
        {
            InitializeComponent();

            C = new Calc();

            labelNumber.Text = "0";
        }

        //кнопка Очистка (CE)
        private void buttonClear_Click(object sender, EventArgs e)
        {
            labelNumber.Text = "0";
            textBox1.Text = "";
            C.Clear_A();
            FreeButtons();
            textBox2.Visible = false;
            progressBar1.Visible = false;

        }

        //кнопка изменения знака у числа
        private void buttonChangeSign_Click(object sender, EventArgs e)
        {
            if (labelNumber.Text[0] == '-')
                labelNumber.Text = labelNumber.Text.Remove(0, 1);
            else
                labelNumber.Text = "-" + labelNumber.Text;
        }

        private void buttonPoint_Click(object sender, EventArgs e)
        {
            if ((labelNumber.Text.IndexOf(",") == -1) && (labelNumber.Text.IndexOf("∞") == -1))
                labelNumber.Text += ",";
        }

        private void button0_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "0";

            CorrectNumber();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "1";

            CorrectNumber();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "2";

            CorrectNumber();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "3";

            CorrectNumber();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "4";

            CorrectNumber();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "5";

            CorrectNumber();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "6";

            CorrectNumber();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "7";

            CorrectNumber();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "8";

            CorrectNumber();
        }

        private void button9_Click(object sender, EventArgs e)
        {
            labelNumber.Text += "9";

            CorrectNumber();
        }

        //удаляем лишний ноль впереди числа, если таковой имеется
        private void CorrectNumber()
        {
            //если есть знак "бесконечность" - не даёт писать цифры после него
            if (labelNumber.Text.IndexOf("∞") != -1)
                labelNumber.Text = labelNumber.Text.Substring(0, labelNumber.Text.Length - 1);

            //ситуация: слева ноль, а после него НЕ запятая, тогда ноль можно удалить
            if (labelNumber.Text[0] == '0' && (labelNumber.Text.IndexOf(",") != 1))
                labelNumber.Text = labelNumber.Text.Remove(0, 1);

            //аналогично предыдущему, только для отрицательного числа
            if (labelNumber.Text[0] == '-')
                if (labelNumber.Text[1] == '0' && (labelNumber.Text.IndexOf(",") != 2))
                    labelNumber.Text = labelNumber.Text.Remove(1, 1);
        }

        //кнопка Равно
        private void buttonCalc_Click(object sender, EventArgs e)
        {
            if (!buttonMult.Enabled)
                labelNumber.Text = C.Multiplication(Convert.ToDouble(labelNumber.Text)).ToString();
            if (!buttonDiv.Enabled && labelNumber.Text != "0")
                labelNumber.Text = C.Division(Convert.ToDouble(labelNumber.Text)).ToString();
            if (!buttonPlus.Enabled)
                labelNumber.Text = C.Sum(Convert.ToDouble(labelNumber.Text)).ToString();
            if (!buttonMinus.Enabled)
                labelNumber.Text = C.Subtraction(Convert.ToDouble(labelNumber.Text)).ToString();
            if (!buttonSqrtX.Enabled)
                labelNumber.Text = C.SqrtX(Convert.ToDouble(labelNumber.Text)).ToString();
            if (!buttonDegreeY.Enabled)
                labelNumber.Text = C.DegreeY(Convert.ToDouble(labelNumber.Text)).ToString();

            C.Clear_A();
            FreeButtons();
        }

        //кнопка Умножение
        private void buttonMult_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));

                buttonMult.Enabled = false;

                labelNumber.Text = "0";
            }
        }

        //кнопка Деление
        private void buttonDiv_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                buttonDiv.Enabled = false;
                labelNumber.Text = "0";
            }
        }

        //кнопка Сложение
        private void buttonPlus_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));

                buttonPlus.Enabled = false;

                labelNumber.Text = "0";
            }
        }

        //кнопка Вычитание
        private void buttonMinus_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                buttonMinus.Enabled = false;
                labelNumber.Text = "0";
            }
        }

        //кнопка Корень произвольной степени
        private void buttonSqrtX_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                buttonSqrtX.Enabled = false;
                labelNumber.Text = "0";
            }
        }

        //кнопка Возведение в произвольную степень
        private void buttonDegreeY_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                buttonDegreeY.Enabled = false;
                labelNumber.Text = "0";
            }
        }

        //кнопка Корень квадратный
        private void buttonSqrt_Click(object sender, EventArgs e)
        {
            if (CanPress())
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                labelNumber.Text = C.Sqrt().ToString();
                C.Clear_A();
                FreeButtons();
            }
        }

        //кнопка Квадрат числа
        private void buttonSquare_Click(object sender, EventArgs e)
        {

            C.Put_A(Convert.ToDouble(labelNumber.Text));
            labelNumber.Text = C.Square().ToString();
            C.Clear_A();
            FreeButtons();

        }
        //кнопка обратного числа
        private void buttonRevers_Click(object sender, EventArgs e)
        {
            C.Put_A(Convert.ToDouble(labelNumber.Text));
            labelNumber.Text = C.Reverse().ToString();
            C.Clear_A();
            FreeButtons();
        }
        //кнопка корня третьей степени
        private void buttonSqrt3_Click(object sender, EventArgs e)
        {
            C.Put_A(Convert.ToDouble(labelNumber.Text));
            labelNumber.Text = C.Sqrt3().ToString();
            C.Clear_A();
            FreeButtons();
        }
        //кнопка Факториал
        private void buttonFactorial_Click(object sender, EventArgs e)
        {
            if ((Convert.ToDouble(labelNumber.Text) == (int)(Convert.ToDouble(labelNumber.Text))) &&
                ((Convert.ToDouble(labelNumber.Text) >= 0.0)))
            {
                C.Put_A(Convert.ToDouble(labelNumber.Text));
                labelNumber.Text = C.Factorial().ToString();
                C.Clear_A();
                FreeButtons();
            }
            else
                MessageBox.Show("Число должно быть >= 0 и целым!");

        }

        //проверяет не нажата ли еще какая-либо из кнопок мат.операций
        private bool CanPress()
        {
            if (!buttonMult.Enabled)
                return false;

            if (!buttonDiv.Enabled)
                return false;

            if (!buttonPlus.Enabled)
                return false;

            if (!buttonMinus.Enabled)
                return false;

            if (!buttonSqrtX.Enabled)
                return false;

            if (!buttonDegreeY.Enabled)
                return false;
            return true;
        }

        //снятие нажатия всех кнопок мат.операций
        private void FreeButtons()
        {
            buttonMult.Enabled = true;
            buttonDiv.Enabled = true;
            buttonPlus.Enabled = true;
            buttonMinus.Enabled = true;
            buttonSqrtX.Enabled = true;
            buttonDegreeY.Enabled = true;
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            TopMost = true;
            groupBox3.Visible = false;

            // Create the ToolTip and associate with the Form container.
            ToolTip toolTip1 = new ToolTip();

            // Set up the delays for the ToolTip.
            toolTip1.AutoPopDelay = 5000;
            toolTip1.InitialDelay = 500;
            toolTip1.ReshowDelay = 250;
            // Force the ToolTip text to be displayed whether or not the form is active.
            toolTip1.ShowAlways = true;

            // Set up the ToolTip text for the Button and Checkbox.
            toolTip1.SetToolTip(this.buttonSqrt, "Квадрантый корень числа");
            toolTip1.SetToolTip(this.buttonDegreeY, "Возведение в степень");
            toolTip1.SetToolTip(this.buttonSquare, "Квадрат числа");
            toolTip1.SetToolTip(this.buttonFactorial, "Факториал");
            toolTip1.SetToolTip(this.buttonSqrtX, "Корень в степени");
            toolTip1.SetToolTip(this.buttonRevers, "Расчет обратного числа");
            toolTip1.SetToolTip(this.buttonSqrt3, "Расчет корня третьей степени");
            //Простые операции
            toolTip1.SetToolTip(this.buttonPlus, "Сложение");
            toolTip1.SetToolTip(this.buttonMinus, "Вычитание");
            toolTip1.SetToolTip(this.buttonMult, "Умножение");
            toolTip1.SetToolTip(this.buttonDiv, "Деление");
        }

        // Инженерный калькулятор
        private void инженерныйToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox3.Visible = true;
        }

        private void обычныйToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox3.Visible = false;
        }

        // Кнопка стереть
        private void ButtonDel_Click(object sender, EventArgs e)
        {
            if (labelNumber.Text.Length > 1)
            {
                labelNumber.Text = labelNumber.Text.Remove(labelNumber.Text.Length - 1);
            }
            if (labelNumber.Text.Length == 1)
            {
                labelNumber.Text = "0";
            }
        }
        // Кнопка квадратного уравнения
        private void buttonUr2_Click(object sender, EventArgs e)
        {
            double value1 = 0;
            double value2 = 0;
            double value3 = 0;
            InputBox("Расчет кв. ур.", "Введите значения:", ref value1, ref value2, ref value3);


            // Расчет квадратного уравнения
            // Открываем текст бокс
            textBox1.Visible = true;
            int dd;
            double x1;
            double x2;
            if (Ur2.Deskr(value1, value2, value3) >= 0)
            {
                dd = Ur2.Gg(value1, value2, value3, out x1, out x2);
                textBox1.Text = "D= " + dd + "; x1 =" + x1 + "; x2= " + x2;
                // Console.WriteLine(dd + "\n x1= {0} \n x2= {1}", x1, x2);
            }
            else
            {
                dd = -1;
                textBox1.Text = "D= " + dd + " Корней нет";
            }

        }
        // Диалоговое окно ввода трех параметров
        public static DialogResult InputBox(string title, string promptText, ref double value1, ref double value2, ref double value3)
        {
            Form form = new Form();
            Label label = new Label();
            TextBox textBox1 = new TextBox();
            TextBox textBox2 = new TextBox();
            TextBox textBox3 = new TextBox();
            Button buttonOk = new Button();
            Button buttonCancel = new Button();
            form.TopMost = true;

            form.Text = title;
            label.Text = promptText;

            buttonOk.Text = "OK";
            buttonCancel.Text = "Cancel";
            buttonOk.DialogResult = DialogResult.OK;
            buttonCancel.DialogResult = DialogResult.Cancel;

            label.SetBounds(9, 18, 500, 20);
            textBox1.SetBounds(12, 50, 50, 20);
            textBox2.SetBounds(12, 71, 50, 20);
            textBox3.SetBounds(12, 91, 50, 20);
            buttonOk.SetBounds(12, 120, 60, 23);

            buttonCancel.SetBounds(75, 120, 60, 23);

            textBox1.Anchor = textBox1.Anchor | AnchorStyles.Left;
            textBox2.Anchor = textBox2.Anchor | AnchorStyles.Left;
            textBox3.Anchor = textBox3.Anchor | AnchorStyles.Left;
            buttonOk.Anchor = AnchorStyles.Bottom | AnchorStyles.Left;
            buttonCancel.Anchor = AnchorStyles.Bottom | AnchorStyles.Left;

           

            form.ClientSize = new Size(145, 150);
            form.Controls.AddRange(new Control[] { label, textBox1, textBox2, textBox3, buttonOk, buttonCancel });
            form.FormBorderStyle = FormBorderStyle.FixedDialog;
            form.StartPosition = FormStartPosition.CenterScreen;
            form.MinimizeBox = false;
            form.MaximizeBox = false;
            form.AcceptButton = buttonOk;
            form.CancelButton = buttonCancel;

            DialogResult dialogResult = form.ShowDialog();

            if (dialogResult == DialogResult.OK)
                try
                {
                    value1 = Convert.ToDouble(textBox1.Text);
                    value2 = Convert.ToDouble(textBox2.Text);
                    value3 = Convert.ToDouble(textBox3.Text);
                }
                catch (FormatException ex)
                {
                    MessageBox.Show(ex.Message);
                }
          
                return dialogResult;
            
        }

        class Ur2
        {
            public static int Gg(double value1, double value2, double value3, out double x1, out double x2)
            {
                double d = Deskr(value1, value2, value3);
                if (d > 0)
                {
                    x1 = (-value2 + Math.Sqrt(d)) / (2 * value1);
                    x2 = (-value2 - Math.Sqrt(d)) / (2 * value1);
                    return 1;
                }

                else
                {
                    x1 = (-value2 + Math.Abs(d)) / (2 * value1);
                    x2 = x1;
                    return 0;
                }
            }

            public static double Deskr(double value1, double value2, double value3)
            {
                double d = value2 * value2 - 4 * value1 * value3;
                return d;

            }
        }

        private void выходToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();

        }

        private void buttonFactorialHT_Click(object sender, EventArgs e)
        {
            if ((Convert.ToDouble(labelNumber.Text) == (int)(Convert.ToDouble(labelNumber.Text))) &&
                          ((Convert.ToDouble(labelNumber.Text) >= 0.0)))
            {
                textBox2.Visible = true;
                progressBar1.Visible = true;
                textBox2.Text = labelNumber.Text;
                labelNumber.Text = "0";
                backgroundWorker1.RunWorkerAsync(textBox2.Text);
            }
            else
            {
                MessageBox.Show("Число должно быть >= 0 и целым!");
            }
        }

        private void backgroundWorker1_DoWork(object sender, DoWorkEventArgs e)
        {
            double n = Convert.ToDouble(textBox2.Text);
            int factorial = 1;

            for (int i = 2; i <= n; i++)
            {
                factorial = factorial * i;
            }
            for (int i = 1; i <= 5; i++)
            {
                Thread.Sleep(1000);
                backgroundWorker1.ReportProgress(i * 20);
            }
            //Thread.Sleep(5000);
            e.Result = factorial;
        }

        private void backgroundWorker1_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            textBox2.Text = e.Result.ToString();

        }

        private void backgroundWorker1_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {

            this.progressBar1.Value = e.ProgressPercentage;

        }

        private void progressBar1_Click(object sender, EventArgs e)
        {

        }
    }
}