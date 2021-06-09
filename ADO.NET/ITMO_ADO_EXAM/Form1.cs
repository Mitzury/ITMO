using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace ITMO_ADO_EXAM
{
    public partial class Form1 : Form
    {
     
        public Form1()
        {
            InitializeComponent();
        }
        // SELECT ALL
        private void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            string ConStr = "Integrated Security = SSPI; Persist Security Info = False; Initial Catalog = stuff; Data Source =(local)";
            try
            {
                using (SqlConnection connection = new SqlConnection(ConStr))
                {
                    connection.Open(); 
                    using (SqlCommand cmd = new SqlCommand("SELECT [id], [name], [surname], [fname] FROM [dbo].[current_st]", connection))
                    {
                        using (SqlDataReader read = cmd.ExecuteReader())
                        {
                            while (read.Read())
                                listBox1.Items.Add(read.GetValue(0) + " " + read.GetString(1) + " " + read.GetString(2) + " " + read.GetString(3));
                        }
                        connection.Close();

                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Нет соединения с базой данный"); 
            }
         }
        // DELETE
        private void button3_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count != 0 && listBox1.SelectedIndex != -1)
            {
                var ForDel = listBox1.SelectedItem.ToString();
                int ForDelId;
                int.TryParse(string.Join("", ForDel.Where(c => char.IsDigit(c))), out ForDelId);
                string SqlCom = "DELETE FROM [dbo].[current_st] WHERE [id]=" + ForDelId;
                ConnToSql.SqlQuery(SqlCom);
                ConnToSql.Message("Удаление успешно. Обновите базу.");
            }
            else
            {
                ConnToSql.Message("Перед тем как удалить сотрудника, обновите базу и выберите");
            }
        }
        // INSERT NEW
        private void button1_Click(object sender, EventArgs e)
        {
            string addname = textBox1.Text;
            string addsurname = textBox2.Text;
            string addfname = textBox3.Text;
            string SqlCom = "INSERT INTO [dbo].[current_st] VALUES ('" + addname + "', '" + addsurname + "', '" + addfname + "')";
            ConnToSql.SqlQuery(SqlCom);
            
        }

        // SELECT FOR USE
        private void button4_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count != 0 && listBox1.SelectedIndex != -1)
            {
                button1.Enabled = false;
                var ForDel = listBox1.SelectedItem.ToString();
                int ForDelId;
                int.TryParse(string.Join("", ForDel.Where(c => char.IsDigit(c))), out ForDelId);
                string ConStr = "Integrated Security = SSPI; Persist Security Info = False; Initial Catalog = stuff; Data Source =(local)";

                    using (SqlConnection connection = new SqlConnection(ConStr))
                    {
                        connection.Open();
                        using (SqlCommand cmd = new SqlCommand("SELECT [id], [name], [surname], [fname] FROM [dbo].[current_st] WHERE [id]=" + ForDelId, connection))
                        {
                            string addname = textBox1.Text;
                            string addsurname = textBox2.Text;
                            string addfname = textBox3.Text;
                            using (SqlDataReader read = cmd.ExecuteReader())
                            {
                                read.Read();
                                textBox1.ForeColor = Color.Black;
                                textBox2.ForeColor = Color.Black;
                                textBox3.ForeColor = Color.Black;
                                textBox1.Text = read.GetString(1).ToString();
                                textBox2.Text = read.GetString(2).ToString();
                                textBox3.Text = read.GetString(3).ToString();
                                button5.Enabled = true;
                                label1.Text = read.GetValue(0).ToString();
                            }
                            connection.Close();
                        }
                    }
            }

        }
          // UPDATE
           private void button5_Click(object sender, EventArgs e)
        { 
               string name = textBox1.Text;
               string surname = textBox2.Text;
               string fname = textBox3.Text;
               string uid = label1.Text;
               string SqlCom = "UPDATE[dbo].[current_st] SET[name] = '" + name + "', [surname] = '" + surname + "', [fname] = '" + fname + "' WHERE[id] = " + uid;
               ConnToSql.SqlQuery(SqlCom);
            button1.Enabled = true;
            label1.Text = "";
            textBox1.Text = "Имя";
            textBox1.ForeColor = Color.Gray;
            textBox2.Text = "Фамилия";
            textBox2.ForeColor = Color.Gray;
            textBox3.Text = "Отчество";
            textBox3.ForeColor = Color.Gray;
        }
        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button6_Click(object sender, EventArgs e)
        {
           
        }

        private void Form1_Load(object sender, EventArgs e)
        {
          
            textBox1.Text = "Имя";
            textBox1.ForeColor = Color.Gray;
            textBox2.Text = "Фамилия";
            textBox2.ForeColor = Color.Gray;
            textBox3.Text = "Отчество";
            textBox3.ForeColor = Color.Gray;
        }

        private void textBox1_Enter(object sender, EventArgs e)
        {
            textBox1.Text = null;
            textBox1.ForeColor = Color.Black;
           
        }

        private void textBox2_Enter(object sender, EventArgs e)
        {
            textBox2.Text = null;
            textBox2.ForeColor = Color.Black;
        }
        private void textBox3_Enter(object sender, EventArgs e)
        {
            textBox3.Text = null;
            textBox3.ForeColor = Color.Black;
        }

        private void textBox1_Leave(object sender, EventArgs e)
        {
            if (textBox1.Text == string.Empty)
            {
                textBox1.Text = "Имя";
                textBox1.ForeColor = Color.Gray;
            }
            else
            {

            }
        }

        private void textBox2_Leave(object sender, EventArgs e)
        {
            if (textBox2.Text == string.Empty)
            {
                textBox2.Text = "Фамилия";
                textBox2.ForeColor = Color.Gray;
            }
            else
            {

            }
        }

        private void textBox3_Leave(object sender, EventArgs e)
        {
            if (textBox3.Text == string.Empty)
            { 
            textBox3.Text = "Отчество";
            textBox3.ForeColor = Color.Gray;
        }
            else
            {

            }
        }
        private void connection_StateChange(object sender, System.Data.StateChangeEventArgs e)

        {


        }
    }
}
