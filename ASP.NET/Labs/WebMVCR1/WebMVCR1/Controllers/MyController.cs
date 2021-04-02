using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebMVCR1.Controllers
{
    public class MyController : Controller
    {
        // GET: My
        public string Index() 
        { int hour = DateTime.Now.Hour; 
            string Greeting = hour < 12 ?
                "Доброе утро" : "Добрый день";
            return Greeting; }
    }
}