using System;
using Enumeration.Enums;

namespace Enumeration.Methods
{
    internal static class ParseEnumMethods
    {
        internal static void StringToEnum(string day)
        {
            //Console.WriteLine(favoriteDay); // Not possible, enum has not been initialized.
            DaysOfWeek favoriteDay; // Declare a variable of type DaysOfWeek that CANNOT be initialized.
            if (Enum.TryParse(day, out favoriteDay))
            {
                Console.WriteLine("Your favorite Day of the Week is {0}", favoriteDay);
            }
            else
            {
                // Even if the conversion fails, the enum will still be set to its default value, Sunday.
                Console.WriteLine("There is no such day as {0}", day);
                // Uncomment the line below to check that favoriteDay is now 0 (zero).
                // Since there is no identifier associated with this value, the value itself gets printed out.
                Console.WriteLine("I failed Star Wars and now I am {0}", favoriteDay);
            }
        }

        internal static void StringToEnumIgnoreCase(string day)
        {
            // From C# 7.0 on it is possible to declare the out variable within the method call like so.
            if (Enum.TryParse(day, true, out DaysOfWeek favoriteDay))
            {
                Console.WriteLine("Your favorite Day of the Week is {0}", favoriteDay);
            }
            else
            {
                Console.WriteLine("There is no such day as {0}", day);
            }
        }

        internal static void StringToObject(string enumeration)
        {
            // If parse fails it will throw an Exception.
            object day = Enum.Parse(typeof(DaysOfWeek), enumeration);
            Console.WriteLine(day);
        }

        internal static void StringToObjectIgnoreCase(string enumeration)
        {
            // If parse fails it will throw an Exception.
            object day = Enum.Parse(typeof(DaysOfWeek), enumeration, true);
            Console.WriteLine(day);
        }
    }
}
