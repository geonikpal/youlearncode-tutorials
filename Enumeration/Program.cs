using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Reflection;
using System.Threading;
using Enumeration.Enums;
using Enumeration.Methods;

namespace Enumeration
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Thread.CurrentThread.CurrentUICulture = new CultureInfo("en-us");
            LoopThroughEnum.PrintEnums();
            //LoopThroughEnum.PrintEnumNames();
            //LoopThroughEnum.PrintEnumValues();
            //LoopThroughEnum.PrintEnumUsingForLoop();
            //ParseEnumMethods.StringToEnum("Monday"); // Try different weekdays
            //ParseEnumMethods.StringToEnum("6"); // Try different numbers            
            //ParseEnumMethods.StringToEnum("Star Wars Day"); // =^_^=
            //ParseEnumMethods.StringToEnumIgnoreCase("SUNDAY");
            //ParseEnumMethods.StringToEnumIgnoreCase("wednesday");
            //ParseEnumMethods.StringToEnumIgnoreCase("FRiDay");
            //ParseEnumMethods.StringToObject("Thursday");
            //ParseEnumMethods.StringToObject("3");
            //ParseEnum.StringToObject("Weekend"); // UNCOMMENT to get an ArgumentException.
            //ParseEnum.StringToObject("-128"); // UNCOMMENT to get an OverflowException
            //ParseEnumMethods.StringToObjectIgnoreCase("WEDNESDAY");
            //ParseEnumMethods.StringToObjectIgnoreCase("sunday");
            //ParseEnumMethods.StringToObjectIgnoreCase("SaTuRDay");
            //OtherEnumMethods.GetUnderlyingType();
            //OtherEnumMethods.GetName(6); // A byte value, you may try different numbers
            //OtherEnumMethods.GetName(8); // null, there is no enum of value 8 whose underlying type is byte.
            //OtherEnumMethods.ToObject(1); // A byte value, you may try different numbers
            //OtherEnumMethods.IsDefinied("Thursday");
            //OtherEnumMethods.IsDefinied((byte)7); // If not cast, would result in exception
            //OtherEnumMethods.Format(DaysOfWeek.Sunday);
            //InstanceMethods.CompareTo(DaysOfWeek.Monday, DaysOfWeek.Saturday); //Returns -1
            //InstanceMethods.CompareTo(DaysOfWeek.Sunday, DaysOfWeek.Sunday);   //Returns  0
            //InstanceMethods.CompareTo(DaysOfWeek.Saturday, DaysOfWeek.Friday); //Returns +1
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "G");
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "D");
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "X");
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "F");
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "");   // Same as "G"
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, null); // Same as "G"
            //InstanceMethods.ToString(DaysOfWeek.Wednesday, "A");  // Throw FormatException
            //LoopThroughEnum.PrintEnumFlags();
            //InstanceMethods.HasFlag();
            //InstanceMethods.GetTypeCode();
            //EnhancedEnumMethods.Print();
            //EnhancedEnumMethods.EnhancedEnum();
            //EnhancedEnumMethods.MoreEnhancedEnum();
            //LoopThroughEnum.PrintWeekdays();
            //LoopThroughEnum.ContainWeekdays(new Weekday[] { Weekday.BusinessDays, Weekday.Weekend }); // All true
            //LoopThroughEnum.ContainWeekdays(new Weekday[] { 0, (Weekday)128 }); // All false
            //LoopThroughEnum.ContainWeekdays(new Weekday[] { Weekday.Monday }); // true for Monday & BusinessDay
            //LoopThroughEnum.ContainWeekdays(new Weekday[] { Weekday.Sunday }); // true for Sunday & Weekend
            //LoopThroughEnum.EqualsWeekday(Weekday.Monday);
            //LoopThroughEnum.EqualsWeekday(Weekday.Weekend);
            //LoopThroughEnum.EqualsWeekday(Weekday.BusinessDays);
            //LoopThroughEnum.PrintDeveloperLevels();
            //SmartEnumMethods.PrintSmartEnum();
            //SmartEnumMethods.TryFromValue(13);
            //SmartEnumMethods.TryFromValue(15);
            //SmartEnumMethods.TryFromName("Invalid ID.");
            //SmartEnumMethods.TryFromName("Invalid Password.");
            //SmartEnumMethods.FromValue(13);
            //SmartEnumMethods.FromValue(15); // UNCOMMENT to Throw ThrowValueNotFoundException
            //SmartEnumMethods.FromName("Invalid ID.");
            //SmartEnumMethods.FromName("Invalid Password."); // UNCOMMENT to Throw ThrowNameNotFoundException
            //LoopThroughEnum.PrintPackages();
            //DataAnnotationMethods.EnumFromDisplayAttribute("Small Package");
            //DataAnnotationMethods.EnumFromDisplayAttribute("Extra Large Package");
            //DataAnnotationMethods.EnumFromDisplayAttribute("Tiny Package");
            //Console.WriteLine();
            //DataAnnotationMethods.EnumFromWeightAttribute(20);
            //DataAnnotationMethods.EnumFromWeightAttribute(35);
            //DataAnnotationMethods.EnumFromWeightAttribute(5);
            //Console.WriteLine();
            //DataAnnotationMethods.EnumFromSizeAttribute("25x25x40");
            //DataAnnotationMethods.EnumFromSizeAttribute("30x30x50");
            //DataAnnotationMethods.EnumFromSizeAttribute("10x10x15");
            //LoopThroughEnum.PrintErrorMessages(ErrorMessage.TakenUsername | ErrorMessage.WeakPassword);
            // Instead of adding all four, which would take up a lot of space, we are using binary.
            // When cast to ErrorMessage, it will contain all mesasges
            //LoopThroughEnum.PrintErrorMessages((ErrorMessage)0b000_1111);

            Console.ReadKey(true); // Waits for the user to press any key, true not to show the key.
        }
    }
}