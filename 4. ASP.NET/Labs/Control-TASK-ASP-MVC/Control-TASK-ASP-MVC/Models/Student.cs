using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Control_TASK_ASP_MVC.Models
{
    public class Student
    {
        public virtual int StudentId { get; set; }
        public virtual string FirstName { get; set; }
        public virtual string LastName { get; set; } 
        public virtual int Age { get; set; } 
        public virtual string Group { get; set; }
        public virtual string Course { get; set; }
        public virtual int Mark { get; set; }
        public virtual DateTime AddDate { get; set; }
        
    }
}