using System;
using Enumeration.Enums;

namespace Enumeration.Methods
{
    internal static class OtherEnumMethods
    {
        internal static void GetUnderlyingType()
        {
            Type underlyingType = Enum.GetUnderlyingType(typeof(DaysOfWeek));
            Console.WriteLine("My type is: {0}", underlyingType.Name);
            Console.WriteLine("Am I a value type: {0}", underlyingType.IsValueType);
        }

        internal static void GetName(object value)
        {
            string day = Enum.GetName(typeof(DaysOfWeek), value);
            if (day != null)
            {
                Console.WriteLine("It is a valid enum: {0}", day);
            }
            else
            {
                Console.WriteLine("Not a valid enum!");
            }
        }

        internal static void ToObject(object value)
        {
            object day = Enum.ToObject(typeof(DaysOfWeek), value);
            Console.WriteLine("It is a valid enum: {0}", day);
        }

        internal static void IsDefinied(object value)
        {
            if (Enum.IsDefined(typeof(DaysOfWeek), value))
            {
                Console.WriteLine(Enum.Parse(typeof(DaysOfWeek), value.ToString()));
            }
        }

        internal static void Format(DaysOfWeek value)
        {
            // If value is equal to a named enumerated constant, the name of that constant is returned;
            // otherwise, the decimal equivalent of value is returned.
            Console.WriteLine(Enum.Format(typeof(DaysOfWeek), value, "G")); // Also "g"
            // Represents value in hexadecimal format without a leading "0x".
            Console.WriteLine(Enum.Format(typeof(DaysOfWeek), value, "X")); // Also "x"
            // Represents value in decimal form.
            Console.WriteLine(Enum.Format(typeof(DaysOfWeek), value, "D")); // Also "d"
            // Behaves identically to "G" or "g",
            // Except that the FlagsAttribute is not required to be present on the Enum declaration.
            Console.WriteLine(Enum.Format(typeof(DaysOfWeek), value, "F")); // Also "f"
        }
    }
}
