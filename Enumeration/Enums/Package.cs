using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Reflection;

namespace Enumeration.Enums
{
    // Enum Package with the out-of-the-boc Display Attribute and two custom Attributes Weight and Size
    internal enum Package
    {
        [Weight(10)]
        [Size("15x15x20")]
        [Display(Name = "Small Package")]
        Small = 1,
        [Weight(20)]
        [Size("20x20x30")]
        [Display(Name = "Medium Package")]
        Medium = 2,
        [Weight(35)]
        [Size("25x25x40")]
        [Display(Name = "Large Package")]
        Large = 3,
        [Weight(50)]
        [Size("30x30x50")]
        [Display(Name = "Extra Large Package")]
        XLarge = 4,
    }

    // Double Attribute Weight
    internal class WeightAttribute : Attribute
    {
        public readonly double Weight;
        public WeightAttribute(double weight) { Weight = weight; }
    }

    // String Attribute Size
    internal class SizeAttribute : Attribute
    {
        public readonly string Size;
        public SizeAttribute(string size) { Size = size; }
    }

    internal static class EnumPackage
    {
        // Retrieves the Enum Display should you need to print it.
        internal static string GetEnumDisplayName(this Package value)
        {
            return GetMember(value).GetCustomAttribute<DisplayAttribute>().Name;
        }

        // Retrieves the Enum Wright should you need to print it.
        internal static string GetEnumWeight(this Package value)
        {
            // Because this Attribute returns double, we need to use the ToString() method.
            return GetMember(value).GetCustomAttribute<WeightAttribute>().Weight.ToString();
        }

        // Retrieves the Enum Size should you need to print it.
        internal static string GetEnumSize(this Package value)
        {
            return GetMember(value).GetCustomAttribute<SizeAttribute>().Size;
        }

        private static MemberInfo GetMember(Enum value)
        {
            Type type = value.GetType();
            return type.GetMember(value.ToString())[0];
        }

        internal static Package EnumFromDisplayAttribute(string displayValue)
        {
            MemberInfo[] members = GetMembers(typeof(Package));
            if (members.Length > 0)
            {
                for (int i = 0; i < members.Length; i++)
                {
                    if (Enum.TryParse(members[i].Name, out Package e))
                    {
                        // If our Display Attribute matches the parameter displayValue it means it exists.
                        if (members[i].GetCustomAttribute<DisplayAttribute>().Name.Equals(displayValue))
                            return e;
                    }
                }
            }
            return 0;
        }

        internal static Package EnumFromWeightAttribute(double weightValue)
        {
            MemberInfo[] members = GetMembers(typeof(Package));
            if (members.Length > 0)
            {
                for (int i = 0; i < members.Length; i++)
                {
                    if (Enum.TryParse(members[i].Name, out Package e))
                    {
                        // If our Weight Attribute matches the parameter weightValue it means it exists.
                        if (members[i].GetCustomAttribute<WeightAttribute>().Weight.Equals(weightValue))
                            return e;
                    }
                }
            }
            return 0;
        }

        internal static Package EnumFromSizeAttribute(string sizeValue)
        {
            MemberInfo[] members = GetMembers(typeof(Package));
            if (members.Length > 0)
            {
                for (int i = 0; i < members.Length; i++)
                {
                    if (Enum.TryParse(members[i].Name, out Package e))
                    {
                        // If our Weight Attribute matches the parameter sizeValue it means it exists.
                        if (members[i].GetCustomAttribute<SizeAttribute>().Size.Equals(sizeValue))
                            return e;
                    }
                }
            }
            return 0;
        }

        // Retrieves and Enum based on any Attribute should you need to find out
        // if the Attribute passed exits within the Enum constants.
        internal static Package EnumFromAnyAttribute(string enumValue) 
        {
            MemberInfo[] members = GetMembers(typeof(Package));
            if (members.Length > 0)
            {
                for (int i = 0; i < members.Length; i++)
                {
                    if (Enum.TryParse(members[i].Name, out Package e))
                    {
                        // If any of the possible attributes are found, we return the Enum.
                        // We could, as well, have created 3 different methods, one for each attribute.
                        var attributes = members[i].GetCustomAttributes<Attribute>();
                        foreach (var att in attributes)
                        {
                            switch (att)
                            {
                                case DisplayAttribute item:
                                    if (members[i].GetCustomAttribute<DisplayAttribute>().Name.Equals(enumValue))
                                        return e;
                                    break;
                                case WeightAttribute item:
                                    if (members[i].GetCustomAttribute<WeightAttribute>().Weight.ToString().Equals(enumValue))
                                        return e;
                                    break;
                                case SizeAttribute item:
                                    if (members[i].GetCustomAttribute<SizeAttribute>().Size.Equals(enumValue))
                                        return e;
                                    break;
                            }
                        }
                    }
                }
            }
            return 0; // Invalid value
        }

        private static MemberInfo[] GetMembers(Type type)
        {
            // BindingFlags to only bring the enum constants, otherwise it'd bring all members.
            return type.GetMembers(BindingFlags.Static | BindingFlags.Public);
        }
    }
}