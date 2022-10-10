using System;
using Enumeration.Enums;

namespace Enumeration.Methods
{
    internal class DataAnnotationMethods
    {
        internal static void EnumFromDisplayAttribute(string att)
        {
            Package p;
            if ((p = EnumPackage.EnumFromDisplayAttribute(att)) != 0)
            {
                Console.WriteLine("Attribute found in {0}: {1}.", p, att);
            }
            else
            {
                Console.WriteLine("Attribute NOT found in {0}: {1}.", p.GetType().Name, att);
            }
        }

        internal static void EnumFromWeightAttribute(double att)
        {
            Package p;
            if ((p = EnumPackage.EnumFromWeightAttribute(att)) != 0)
            {
                Console.WriteLine("Attribute found in {0}: {1}.", p, att);
            }
            else
            {
                Console.WriteLine("Attribute NOT found in {0}: {1}.", p.GetType().Name, att);
            }
        }

        internal static void EnumFromSizeAttribute(string att)
        {
            Package p;
            if ((p = EnumPackage.EnumFromSizeAttribute(att)) != 0)
            {
                Console.WriteLine("Attribute found in {0}: {1}.", p, att);
            }
            else
            {
                Console.WriteLine("Attribute NOT found in {0}: {1}.", p.GetType().Name, att);
            }
        }
    }
}
