using System;
using System.Reflection;

namespace Enumeration.UserDefinedEnums
{
    internal sealed class Continents
    {
        public byte Value { get; private set; }
        public string Name { get; private set; }
        public long Area { get; private set; }
        public long Population { get; private set; }

        private Continents(byte value, string name, long area, long population)
        {
            Value = value;
            Name = name;
            Area = area;
            Population = population;
        }

        public static readonly Continents Asia = new Continents(1, "Asia", 44_579_000, 4_721_383_274);
        public static readonly Continents Africa = new Continents(2, "Africa", 30_370_000, 1_426_730_933);
        public static readonly Continents NorthAmerica = new Continents(3, "North America", 24_709_000, 600_296_136);
        public static readonly Continents SouthAmerica = new Continents(4, "South America", 17_840_000, 436_816_608);
        public static readonly Continents Antarctica = new Continents(5, "Antarctica", 14_200_000, 4_490);
        public static readonly Continents Europe = new Continents(6, "Europe", 10_180_000, 743_147_538);
        public static readonly Continents Oceania = new Continents(7, "Oceania", 8_600_000, 26_180_437);

        public static Continents[] GetValues()
        {
            // We will be using reflection to get all public static Fields in Continents.
            FieldInfo[] fields = typeof(Continents).GetFields(BindingFlags.Static | BindingFlags.Public);
            Continents[] continents = new Continents[fields.Length];
            for (int i = 0; i < fields.Length; i++)
            {
                FieldInfo field = fields[i];
                if (field.IsInitOnly) // Checks whether this field can only be set by a Constructor.
                {
                    continents[i] = (Continents)field.GetValue(typeof(Continents));
                }
            }
            return continents;
        }

        public static Continents StringToContinent(string continent)
        {
            foreach (var cont in GetValues())
            {
                if (cont.Name == continent)
                    return cont;
            }
            return null;
        }

        public static Continents ValueToContinent(byte value)
        {
            foreach (var cont in GetValues())
            {
                if (cont.Value == value)
                    return cont;
            }
            throw new ArgumentException("Value does not correspond to any Continent!");
        }

        public override string ToString()
        {
            return String.Format("{0} has an area of {1} and its current population is {2}", this.Name, this.Area, this.Population);
        }
    }

    internal static class Extension
    {
        public static double GetDensity(this Continents c)
        {
            return c.Population / c.Area;
        }

        public static double GetPopulatioPercentage(this Continents c)
        {
            double total = 0;
            foreach (var continent in typeof(Continents).GetFields(BindingFlags.Static | BindingFlags.Public))
            {
                if (continent.IsInitOnly)
                {
                    Continents cont = (Continents)continent.GetValue(typeof(Continents));
                    total += cont.Population;
                }
            }
            return c.Population / total * 100;
        }

        public static double GetAreaPercentage(this Continents c)
        {
            double total = 0;
            foreach (var continent in typeof(Continents).GetFields(BindingFlags.Static | BindingFlags.Public))
            {
                if (continent.IsInitOnly)
                {
                    Continents cont = (Continents)continent.GetValue(typeof(Continents));
                    total += cont.Area;
                }
            }
            return c.Area / total * 100;
        }
    }
}