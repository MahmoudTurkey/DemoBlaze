package Utils;

public class TestData {
    public static String UserName;
    public static String Password;
    public static String Name;
    public static String Country;
    public static String City;
    public static String CreditCard;
    public static String Month;
    public static String Year;

    // Optional: Clear method for reuse between scenarios
    public static void clear() {
        Name = null;
        Country = null;
        City = null;
        CreditCard = null;
        Month = null;
        Year = null;
    }
}
