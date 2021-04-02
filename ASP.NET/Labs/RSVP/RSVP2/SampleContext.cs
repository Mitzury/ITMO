using System.Data.Entity;
using RSVP2.Models;
using System.Linq;


namespace RSVP2

{
        public class SampleContext : DbContext
        {
            public SampleContext() : base("SeminarBD")
            { }
            public DbSet<GuestResponse> GuestResponses { get; set; }
            public DbSet<Report> Reports { get; set; }
        }
}