﻿using System.Web;
using System.Web.Mvc;

namespace Control_TASK_ASP_MVC
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
