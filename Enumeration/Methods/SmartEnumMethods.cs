using System;
using Enumeration.UserDefinedEnums;

namespace Enumeration.Methods
{
    internal class SmartEnumMethods
    {
        internal static void PrintSmartEnum()
        {
            foreach (var error in ErrorSmartEnum.List)
            {
                Console.WriteLine("Error code number {0}, message: {1}", error.Value, error); // Same as error.Name
            }
        }

        internal static void TryFromValue(int value)
        {
            if (ErrorSmartEnum.TryFromValue(value, out ErrorSmartEnum error))
            {
                Console.WriteLine("Successfully parsed: {0}", error);
            }
            else
            {
                Console.WriteLine("Not an enum value!");
            }
        }

        internal static void TryFromName(string name)
        {
            if (ErrorSmartEnum.TryFromName(name, out ErrorSmartEnum error))
            {
                Console.WriteLine("Successfully parsed: {0}", error);
            }
            else
            {
                Console.WriteLine("Not an enum name!");
            }
        }

        internal static void FromValue(int value)
        {
            // Will throw an Exception if not found.
            Console.WriteLine("From value: {0}", ErrorSmartEnum.FromValue(value));
        }

        internal static void FromName(string name)
        {
            // Will throw an Exception if not found.
            Console.WriteLine("From name: {0}", ErrorSmartEnum.FromName(name));
        }
    }
}
