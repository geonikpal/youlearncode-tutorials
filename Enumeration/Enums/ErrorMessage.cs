using System;
using System.ComponentModel;
using System.Reflection;

namespace Enumeration.Enums
{
    [Flags]
    internal enum ErrorMessage
    {
        [Description("This username is already taken! Please choose another one.")]
        TakenUsername = 1,
        [Description("The password is too weak. It must be at least 8 characters long.")]
        WeakPassword = 2,
        [Description("Fields marked with * are mandatory.")]
        MandatoryFields = 4,
        [Description("provide a valid date dd/MM/yyyy")]
        InvalidDate = 8
    }

    internal static class ErrorMessageExtension
    {
        private static MemberInfo[] GetMembers(ErrorMessage value)
        {
            ErrorMessage[] errors = (ErrorMessage[])Enum.GetValues(typeof(ErrorMessage));
            MemberInfo[] memberInfos = new MemberInfo[errors.Length];

            for (int i = 0; i < errors.Length; i++)
            {
                if ((errors[i] & value) != 0)
                {
                    Type type = value.GetType();
                    memberInfos[i] = type.GetMember(errors[i].ToString())[0];
                }
            }
            return memberInfos;
        }

        internal static string[] GetEnumDescriptions(this ErrorMessage value)
        {
            MemberInfo[] members = GetMembers(value);
            string[] errors = new string[members.Length];
            for (int i = 0; i < members.Length && members[i] != null; i++)
            {
                errors[i] = members[i].GetCustomAttribute<DescriptionAttribute>().Description;
            }
            return errors;
        }
    }
}