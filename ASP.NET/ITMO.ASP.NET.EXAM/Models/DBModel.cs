using System;
using System.Data.Entity;
using System.Linq;

namespace ITMO.ASP.NET.EXAM.Models
{
    public class DBModel : DbContext
    {
        // Контекст настроен для использования строки подключения "DBModel" из файла конфигурации  
        // приложения (App.config или Web.config). По умолчанию эта строка подключения указывает на базу данных 
        // "ITMO.ASP.NET.EXAM.Models.DBModel" в экземпляре LocalDb. 
        // 
        // Если требуется выбрать другую базу данных или поставщик базы данных, измените строку подключения "DBModel" 
        // в файле конфигурации приложения.
        public DBModel()
            : base("name=DBModel")
        {
        }

        public System.Data.Entity.DbSet<ITMO.ASP.NET.EXAM.Models.Student> Students { get; set; }

        // Добавьте DbSet для каждого типа сущности, который требуется включить в модель. Дополнительные сведения 
        // о настройке и использовании модели Code First см. в статье http://go.microsoft.com/fwlink/?LinkId=390109.

        // public virtual DbSet<MyEntity> MyEntities { get; set; }
    }

    //public class MyEntity
    //{
    //    public int Id { get; set; }
    //    public string Name { get; set; }
    //}
    public class Student
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string SurName { get; set; }
        public int Age { get; set; }
        public string Discipline { get; set; }
        public string DisciplineRate { get; set; }
    }

}