using System;
using Enumeration.Enums;
using Enumeration.UserDefinedEnums;

namespace Enumeration.Methods
{
    internal static class EnhancedEnumMethods
    {
        internal static void Print()
        {
            DaysOfWeek unk = DaysOfWeek.Unknown;
            DaysOfWeek sun = DaysOfWeek.Sunday;
            DaysOfWeek mon = DaysOfWeek.Monday;
            DaysOfWeek tue = DaysOfWeek.Tuesday;
            DaysOfWeek sat = DaysOfWeek.Saturday;
            unk.Print();
            sun.Print();
            mon.Print();
            tue.Print();
            sat.Print();
        }

        internal static void EnhancedEnum()
        {
            // Let's test our method to retrieve all the Continents
            foreach (var c in Continents.GetValues())
            {
                Console.WriteLine(c); // Because we overridden the ToString() method we don't need to do it here.
                Console.WriteLine("{0} density is {1:##0.00}", c.Name, c.GetDensity());
                Console.WriteLine("{0} represents {1:##0.00} of the global population.", c.Name, c.GetPopulatioPercentage());
                Console.WriteLine("{0} represents {1:##0.00} of the global area.", c.Name, c.GetAreaPercentage());
                Console.WriteLine();
            }
        }

        internal static void MoreEnhancedEnum()
        {
            Continents northAmericaStr = Continents.StringToContinent("North America"); // return null if not found.
            Continents northAmerica = Continents.NorthAmerica;
            Console.WriteLine("{0} is equal to {1}", northAmerica.Name, northAmericaStr.Name);
            Console.WriteLine(northAmerica == northAmericaStr); // Should yield true.
            Console.WriteLine();
            Continents africa = Continents.Africa;
            Continents africaVal = Continents.ValueToContinent(2); // Africa's value is 2
            //Continents unknown = Continents.ValueToContinent(0); // UNCOMMENT TO THROW AN EXCEPTION
            Console.WriteLine("{0} is equal to {1}", africa.Name, africaVal.Name);
            Console.WriteLine(northAmerica == northAmericaStr); // Should yield true.
        }
    }
}
