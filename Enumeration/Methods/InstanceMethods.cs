using System;
using Enumeration.Enums;

namespace Enumeration.Methods
{
    internal static class InstanceMethods
    {
        internal static void CompareTo(DaysOfWeek enum1, DaysOfWeek enum2)
        {
            Console.WriteLine("Is {0} same as {1}: {2}", enum1, enum2, enum1.CompareTo(enum2) == 0); // If enum1 == enum2 = 0 
            Console.WriteLine("Is {0} after {1}: {2}", enum1, enum2, enum1.CompareTo(enum2) > 0);    // If enum1 > enum2 = +1
            Console.WriteLine("Is {0} before {1}: {2}", enum1, enum2, enum1.CompareTo(enum2) < 0);   // If enum1 < enum2 = -1
            Console.WriteLine();
        }

        internal static void ToString(DaysOfWeek day, string format)
        {
            Console.WriteLine(day.ToString(format));
        }

        internal static void HasFlag()
        {
            // Becuase Saturday is associated with the the value 7, 0111 in binary,
            // HasFlag will always return true because every other value from 0 to 7 is within 0111, 
            var saturday = DaysOfWeek.Saturday;
            foreach (DaysOfWeek day in Enum.GetValues(typeof(DaysOfWeek)))
            {
                Console.WriteLine("Does {0} have flags on {1}: {2}", saturday, day, saturday.HasFlag(day));
            }
            Console.WriteLine();
            // Because Unknown is associated with the value 0 (zero), 0000 in binary,
            // HasFlag will only return true for itself (Unknown).
            var unknown = DaysOfWeek.Unknown;
            foreach (DaysOfWeek day in Enum.GetValues(typeof(DaysOfWeek)))
            {
                Console.WriteLine("Does {0} have flags on {1}: {2}", unknown, day, unknown.HasFlag(day));
            }
            Console.WriteLine();
            // Because Tuesday is associated with the value 3, 0011 in binary,
            // HasFlag will return true for Unknown, Monday & Tuesday
            var tuesday = DaysOfWeek.Tuesday;
            foreach (DaysOfWeek day in Enum.GetValues(typeof(DaysOfWeek)))
            {
                Console.WriteLine("Does {0} have flags on {1}: {2}", tuesday, day, tuesday.HasFlag(day));
            }
        }

        internal static void GetTypeCode()
        {
            DaysOfWeek thursday = DaysOfWeek.Thursday;
            Console.WriteLine("{0} type code is {1}.", thursday, thursday.GetTypeCode());
        }
    }
}
