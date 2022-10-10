using System;

namespace Enumeration.Enums
{
    static class EnumExtension
    {
        public static void Print(this DaysOfWeek day)
        {
            switch (day)
            {
                case DaysOfWeek.Sunday:
                    Console.WriteLine("{0} is the {1}st day of the Week!", day, (byte)day);
                    break;
                case DaysOfWeek.Monday:
                    Console.WriteLine("{0} is the {1}nd day of the Week!", day, (byte)day);
                    break;
                case DaysOfWeek.Tuesday:
                    Console.WriteLine("{0} is the {1}rd day of the Week!", day, (byte)day);
                    break;
                case DaysOfWeek.Wednesday:
                case DaysOfWeek.Thursday:
                case DaysOfWeek.Friday:
                case DaysOfWeek.Saturday:
                    Console.WriteLine("{0} is the {1}th day of the Week!", day, (byte)day);
                    break;
                default:
                    Console.WriteLine("Sorry, not a day");
                    break;
            }
        }
    }
}
