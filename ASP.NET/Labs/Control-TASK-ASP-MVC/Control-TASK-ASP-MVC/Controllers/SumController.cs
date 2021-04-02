using Control_TASK_ASP_MVC.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace Control_TASK_ASP_MVC.Controllers
{
    public class SumController : Controller
    {
        

        private StudentContext db = new StudentContext();
        
        // GET: Sum
        public ActionResult Index()
            {
                var totalAmount = 0;
               GetStudents();
                //var allStudents = db.Students.ToList<Student>();
                foreach (var item in db.Students)
                    {
                        totalAmount += item.Mark;
                    }
                ViewBag.totalAmount = totalAmount;
                return View();
            }
        public ActionResult Ranking()
        {
                 var StudentsFiveBest = db.Students.ToList<Student>().OrderByDescending(s=>s.Mark).Take(5);
                var StudentsFiveWorth = db.Students.ToList<Student>().OrderBy(s => s.Mark).Take(5);
                ViewBag.StudentsFiveBest = StudentsFiveBest;
                ViewBag.StudentsFiveWorth = StudentsFiveWorth;
            return View();
        }
        private void GetStudents()
            {
                var allStudents = db.Students.ToList<Student>();
                ViewBag.Students = allStudents;
            }
        public FileStreamResult CreateFile()
        {

            var students = "Строка вывода:   ";
            foreach (var item in db.Students)
            {
                students += item.FirstName + " " + item.LastName + "группа:" + item.Group;
            }
            var byteArray = Encoding.UTF8.GetBytes(students);
            var file = new MemoryStream(byteArray);
            return File(file, "text/plain", "Список.txt");
        }
        
    }
}