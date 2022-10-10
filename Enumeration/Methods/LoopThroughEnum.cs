using System;
using Enumeration.Enums;
using Enumeration.UserDefinedEnums;

namespace Enumeration.Methods
{
    internal static class LoopThroughEnum
    {
        internal static void PrintEnumUsingForLoop()
        {
            Console.WriteLine("Days of the Week with a regular loop:");
            var day = DaysOfWeek.Sunday;
            while ((byte)day < Enum.GetValues(typeof(DaysOfWeek)).Length)
            {
                Console.WriteLine(day++); // You can treat enums in C# as you would with any numeric value.
            }
        }

        internal static void PrintEnumValues()
        {
            Console.WriteLine("Days of the Week as byte:");
            // It is possible to cast directly to whatever type the enum was specified.
            foreach (byte day in Enum.GetValues(typeof(DaysOfWeek))) // Works like a charm
            {
                Console.WriteLine(day);
            }
        }

        internal static void PrintEnumNames()
        {
            Console.WriteLine("Days of the Week as string:");
            // UNCOMMENT TO THROW AN InvalidCastException.
            //foreach (string day in Enum.GetValues(typeof(DaysOfWeek)))
            //{
            //    Console.WriteLine(day); //Throws InvalidCastException
            //}
            foreach (string day in Enum.GetNames(typeof(DaysOfWeek)))
            {
                Console.WriteLine(day);
            }
        }

        internal static void PrintEnums()
        {
            // We must call the static method GetValues in the Enum class to iterate over the enums.
            foreach (object day in Enum.GetValues(typeof(DaysOfWeek)))
            {
                Console.WriteLine("{0} Integer value is {1}", day, (byte)day); // Explicit cast to int
            }
        }

        internal static void PrintEnumFlags()
        {
            for (int i = 0; i <= 128; i += 2)
            {
                Console.WriteLine("{0,3} - {1:G}", i, (Binary)i);
            }
        }

        internal static void PrintWeekdays()
        {
            foreach (Weekday day in Enum.GetValues(typeof(Weekday)))
            {
                Console.WriteLine("{0} value is {1}", day, (int)day);
                Console.WriteLine("{0} is a Business day: {1}", day, day.IsBusinessDay(day));
                Console.WriteLine("{0} is a Weekend day: {1}", day, day.IsWeekend(day));
                Console.WriteLine();
            }
        }

        internal static void ContainWeekdays(Weekday[] weekdays)
        {
            foreach (Weekday day in Enum.GetValues(typeof(Weekday)))
            {
                Console.WriteLine("Does the Array contain {0}? {1}", day, weekdays.Contains(day));
            }
            Console.WriteLine();
        }

        internal static void EqualsWeekday(Weekday otherDay)
        {
            foreach (Weekday day in Enum.GetValues(typeof(Weekday)))
            {
                Console.WriteLine("Is {0} equals to {1}? {2}", day, otherDay, day.IsEqualsTo(otherDay));
            }
            Console.WriteLine();
        }

        internal static void PrintDeveloperLevels()
        {
            foreach (var level in DeveloperLevel.GetLevels())
            {
                Console.WriteLine("Developer Level: {0}.", level);
                // How much each level would get paid weekly working 44 hours.
                Console.WriteLine("Salary: {0:##0.00}.", level.GetSalary(44));
                Console.WriteLine("Bonus: {0:##0.00}.", level.GetBonus());
                Console.WriteLine("Vacation Compensation Period: {0}.", level.GetVacationCompensation());
                Console.WriteLine();
            }
        }

        internal static void PrintPackages()
        {
            foreach (Package e in Enum.GetValues(typeof(Package)))
            {
                Console.WriteLine(e.GetEnumDisplayName());
                Console.WriteLine(e.GetEnumWeight());
                Console.WriteLine(e.GetEnumSize());
                Console.WriteLine();
            }
        }

        internal static void PrintErrorMessages(ErrorMessage e)
        {
            // The join() method returns a string that consists of all the elements in the array.
            // separated by the delimiter specified, first argument, in this case, a new liner.
            Console.WriteLine(string.Join("\n", e.GetEnumDescriptions()));
        }
    }
}
