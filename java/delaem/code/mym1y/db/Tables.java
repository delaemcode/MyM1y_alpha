package delaem.code.mym1y.db;

import android.database.Cursor;
import android.provider.BaseColumns;

import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;

public class Tables
{
    public interface CashAccounts
    {
        String TABLE_NAME = CashAccounts.class.getCanonicalName().toLowerCase().replace('.', '_') + "_table";
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + " (" +
                BaseColumns._ID + " integer primary key autoincrement, " +
                Columns.description + " text" + "," +
                Columns.balance + " text" + "," +
                Columns.type + " integer" + "," +
                Columns.ico + " integer" + "," +
                Columns.name + " text" +
                ");";
        class Columns
        {
            public static final String name = TABLE_NAME + "_" + "name";
            public static final String description = TABLE_NAME + "_" + "description";
            public static final String balance = TABLE_NAME + "_" + "balance";
            public static final String type = TABLE_NAME + "_" + "type";
            public static final String ico = TABLE_NAME + "_" + "ico";
        }

        Cursor getAll();
        Cursor getOneFromId(int id);
        long insertOne(CashAccount item);
        long updateBalance(int id, int balance);
    }
    public interface Transactions
    {
        String TABLE_NAME = Transactions.class.getCanonicalName().toLowerCase().replace('.', '_') + "_table";
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + " (" +
                BaseColumns._ID + " integer primary key autoincrement, " +
                Columns.cash_account_from_id + " integer" + "," +
                Columns.time + " integer" + "," +
                Columns.comment + " text" + "," +
                Columns.summ + " integer" + //"," +
                ");";
        class Columns
        {
            public static final String cash_account_from_id = TABLE_NAME + "_" + "cash_account_from_id";
            public static final String summ = TABLE_NAME + "_" + "summ";
            public static final String time = TABLE_NAME + "_" + "time";
            public static final String comment = TABLE_NAME + "_" + "comment";
        }

        Cursor getAll();
        Cursor getAllFromCashAccountId(int cash_account_from_id);
        long insertNew(Transaction item);
    }
}