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
    public class ConnToSql
    {
        public static void SqlQuery(string SqlCom)
        {
            string ConStr = "Integrated Security = SSPI; Persist Security Info = False; Initial Catalog = stuff; Data Source =(local)";
            using (SqlConnection connection = new SqlConnection(ConStr))
            {
                connection.Open();
                using (SqlCommand cmd = new SqlCommand(SqlCom, connection))
                {
                    cmd.ExecuteNonQuery();
                }
                connection.Close();
            }
        }
        public static void Message(string Msg)
        {
            MessageBox.Show(Msg);
        }
    }
}