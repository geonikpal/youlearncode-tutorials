using System;

namespace Enumeration.Enums
{
    [Flags]
    internal enum Weekday
    {
        Monday = 1,    //0000-0001
        Tuesday = 2,   //0000-0010
        Wednesday = 4, //0000-0100
        Thursday = 8,  //0000-1000
        Friday = 16,   //0001-0000
        Saturday = 32, //0010-0000
        Sunday = 64,   //0100-0000
        // Value will be 96 (64 + 32)
        Weekend = Saturday | Sunday, //0110-0000
        // Value will be 31 (16 + 8 + 4 + 2 + 1)
        BusinessDays = Monday | Tuesday | Wednesday | Thursday | Friday, //0001-1111
    }
    internal static class WeekdayExtension
    {
        internal static bool IsWeekend(this Weekday e, Weekday day)
        {
            return Weekday.Weekend.HasFlag(day);
        }

        internal static bool IsBusinessDay(this Weekday e, Weekday day)
        {
            return Weekday.BusinessDays.HasFlag(day);
        }

        internal static bool Contains(this Weekday[] weekdays, Weekday day)
        {
            foreach (Weekday d in weekdays)
            {
                if ((day & d) != 0)
                    return true;
            }
            return false;
        }

        public static bool IsEqualsTo(this Weekday day, Weekday otherDay)
        {
            return (day ^ otherDay) == 0;
        }
    }
}