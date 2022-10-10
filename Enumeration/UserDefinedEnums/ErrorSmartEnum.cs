using Ardalis.SmartEnum;

namespace Enumeration.UserDefinedEnums
{
    internal class ErrorSmartEnum : SmartEnum<ErrorSmartEnum>
    {
        private ErrorSmartEnum(string name, int value) : base(name, value) { }

        public static readonly ErrorSmartEnum Invalid_ID = new ErrorSmartEnum("Invalid ID.", 1);
        public static readonly ErrorSmartEnum Weak_Password = new ErrorSmartEnum("Password is too weak.", 7);
        public static readonly ErrorSmartEnum Wrong_Captcha = new ErrorSmartEnum("Wrong Captcha.", 13);
        public static readonly ErrorSmartEnum Not_Authorized = new ErrorSmartEnum("Not Authorized.", 21);
        public static readonly ErrorSmartEnum Mandatory_Fields = new ErrorSmartEnum("Fields Marked With * are mandatory.", 25);
    }
}