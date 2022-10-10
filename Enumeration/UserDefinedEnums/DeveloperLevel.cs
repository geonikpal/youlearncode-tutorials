using System.Reflection;

namespace Enumeration.UserDefinedEnums
{
    public abstract class DeveloperLevel : AbstractEnum
    {
        private static readonly double TraineeBonusRate = 0.01;
        private static readonly double JuniorBonusRate = 0.02;
        private static readonly double MidLevelBonusRate = 0.03;
        private static readonly double SeniorBonusRate = 0.04;
        private static readonly double LeadBonusRate = 0.05;
        private static readonly double Factor = 100;

        private DeveloperLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }


        public static readonly DeveloperLevel Trainee = new TraineeLevel(1, "Trainee", 5.00);
        public static readonly DeveloperLevel Junior = new JuniorLevel(2, "Junior", 10.00);
        public static readonly DeveloperLevel MidLevel = new MidLevelLevel(3, "Mid-Level", 15.00);
        public static readonly DeveloperLevel Senior = new SeniorLevel(4, "Senior", 20.00);
        public static readonly DeveloperLevel Lead = new LeadLevel(4, "Lead", 25.00);

        public static DeveloperLevel[] GetLevels()
        {
            // We will be using reflection to get all public static Fields in Continents.
            FieldInfo[] fields = typeof(DeveloperLevel).GetFields(BindingFlags.Static | BindingFlags.Public);
            DeveloperLevel[] levels = new DeveloperLevel[fields.Length];
            for (int i = 0; i < fields.Length; i++)
            {
                FieldInfo field = fields[i];
                if (field.IsInitOnly) // Checks whether this field can only be set by a Constructor.
                {
                    levels[i] = (DeveloperLevel)field.GetValue(typeof(DeveloperLevel));
                }
            }
            return levels;
        }

        private class TraineeLevel : DeveloperLevel
        {

            protected internal TraineeLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }

            protected internal override Compensation GetVacationCompensation()
            {
                return Compensation.None;
            }

            public override double GetBonus()
            {
                return HourPay * TraineeBonusRate * Factor;
            }
        }

        private class JuniorLevel : DeveloperLevel
        {
            protected internal JuniorLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }
                
            protected internal override Compensation GetVacationCompensation()
            {
                return Compensation.None;
            }

            public override double GetBonus()
            {
                return HourPay * JuniorBonusRate * Factor;
            }
        }

        private class MidLevelLevel : DeveloperLevel
        {
            protected internal MidLevelLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }

            protected internal override Compensation GetVacationCompensation()
            {
                return Compensation.Week;
            }

            public override double GetBonus()
            {
                return HourPay * MidLevelBonusRate * Factor;
            }
        }

        private class SeniorLevel : DeveloperLevel
        {
            protected internal SeniorLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }

            protected internal override Compensation GetVacationCompensation()
            {
                return Compensation.Fortnight;
            }

            public override double GetBonus()
            {
                return HourPay * SeniorBonusRate * Factor;
            }
        }

        private class LeadLevel : DeveloperLevel
        {
            protected internal LeadLevel(byte code, string position, double hourPay) : base(code, position, hourPay) { }

            protected internal override Compensation GetVacationCompensation()
            {
                return Compensation.Month;
            }

            public override double GetBonus()
            {
                return HourPay * LeadBonusRate + Factor;
            }
        }
    }
}