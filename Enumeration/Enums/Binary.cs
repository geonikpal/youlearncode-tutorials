using System;

namespace Enumeration.Enums
{
    [Flags]
    internal enum Binary : byte
    {
        One = 1,
        Two = 2,
        Four = 4,
        Eight = 8,
        Sixteen = 16,
        ThirtyTwo = 32,
        SixtyFour = 64,
        HundredTwentyEight = 128,
    }
}
