using System;

namespace Enumeration.UserDefinedEnums
{
    public abstract class AbstractEnum
    {
        public enum Compensation { None = 0, Week = 7, Fortnight = 15, Month = 30 }
        public byte Code { get; private set; }
        public string Position { get; private set; }
        public double HourPay { get; private set; }

        protected AbstractEnum(byte code, string position, double hourPay)
        {
            Code = code;
            Position = position;
            HourPay = hourPay;
        }

        // virtual offers a default implementation but allows for method-overridden should you need it.
        public virtual double GetBonus()
        {
            // Here the default impletation is to throw an exception, thus forcing child classes to implement it. 
            throw new NotImplementedException(); 
        }

        // Must be overridden. Doesn't provide any default implementation
        protected internal abstract Compensation GetVacationCompensation();

        /// <summary>
        /// Calculates the salary of the employee.
        /// </summary>
        /// <param name="hours">How many hours the employee has worked in a given period of time.</param>
        /// <returns>The value of the hour (according to the position) times hours</returns>
        public double GetSalary(double hours)
        {
            return HourPay * hours;
        }

        public override string ToString()
        {
            return Position.ToString();
        }
    }
}
