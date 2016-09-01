package delaem.code.mym1y.db;

import android.provider.BaseColumns;

public class Tables
{
    static public class CashAccounts
    {
        static public final String TABLE_NAME = CashAccounts.class.getCanonicalName().toLowerCase().replace('.', '_') + "_table";
        static public class Columns
        {
            public static final String name = TABLE_NAME + "_" + "name";
            public static final String description = TABLE_NAME + "_" + "description";
            public static final String balance = TABLE_NAME + "_" + "balance";
        }
        static public String createTable()
        {
            return "create table if not exists " + TABLE_NAME + " (" +
                    BaseColumns._ID + " integer primary key autoincrement, " +
                    Columns.description + " text" + "," +
                    Columns.balance + " text" + "," +
                    Columns.name + " text" +
                    ");";
        }
    }
    static public class Transactions
    {
        static public final String TABLE_NAME = Transactions.class.getCanonicalName().toLowerCase().replace('.', '_') + "_table";
        static public class Columns
        {
            public static final String cash_account_from_id = TABLE_NAME + "_" + "cash_account_from_id";
            public static final String summ = TABLE_NAME + "_" + "summ";
            public static final String time = TABLE_NAME + "_" + "time";
        }
        static public String createTable()
        {
            return "create table if not exists " + TABLE_NAME + " (" +
                    BaseColumns._ID + " integer primary key autoincrement, " +
                    //Columns.time_spend + " text" + "," +
                    Columns.cash_account_from_id + " integer" + "," +
                    Columns.time + " integer" + "," +
                    Columns.summ + " integer" + //"," +
                    ");";
        }
    }
}