using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Control_TASK_ASP_MVC.Models;

namespace Control_TASK_ASP_MVC.Controllers
{
    public class HomeController : Controller
    {
        private StudentContext db = new StudentContext();
        public ActionResult Index()
        {
            var allStudents = db.Students.ToList<Student>();
            ViewBag.students = allStudents;
            return View();
        }
        [HttpGet]
        public ActionResult AddStudent()
        {
            GetStudents();
            var allStd = db.Students.ToList<Student>();
            ViewBag.SSS = allStd;
            return View();
        }
        [HttpPost]
        public string AddStudent(Student newSTD)
        {
            newSTD.AddDate = DateTime.Now;
            db.Students.Add(newSTD);
            db.SaveChanges(); 
            return "<b>" + newSTD.FirstName + "</b>, данные введены";
         }

            private void GetStudents()
        {
            var allStudents = db.Students.ToList<Student>();
            ViewBag.Students = allStudents;
        }

    }
}
