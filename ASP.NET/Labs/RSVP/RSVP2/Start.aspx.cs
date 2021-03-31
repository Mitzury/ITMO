using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RSVP2
{
    public partial class Start : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Button1.Text = "А не надо было нажимать";
            
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("Reg.aspx"); 
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            Response.Redirect("Summary.aspx");
        }

        protected void Button4_Click(object sender, EventArgs e)
        {
            Response.Redirect("About.aspx");
        }
    }
}