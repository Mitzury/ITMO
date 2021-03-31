using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;


namespace Control_TASK_ASP_MVC.Models
{
    public class StudentContext: DbContext 
    {
        public DbSet<Student> Students { get; set; }
    }
}