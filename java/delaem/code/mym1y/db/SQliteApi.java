package delaem.code.mym1y.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;

public class SQliteApi
{
    static private final String DB_NAME = "mym1y_alpha";
    static private final int DB_VERSION = 1609021620;
    static private SQliteApi instanse;

    static public SQliteApi getInstanse()
    {
        if (instanse == null)
        {
            instanse = new SQliteApi();
        }
        return instanse;
    }

    private SQLiteDatabase sdb;
    private Tables.CashAccounts cashAccounts = new Tables.CashAccounts()
    {
        @Override
        public Cursor getAll()
        {
            return sdb.query(Tables.CashAccounts.TABLE_NAME, null, null, null, null, null, null);
        }

        @Override
        public long insertOne(CashAccount item)
        {
            return sdb.insertWithOnConflict(Tables.CashAccounts.TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
        }
    };
    private Tables.Transactions transactions = new Tables.Transactions()
    {
        @Override
        public Cursor getAll()
        {
            return sdb.query(Tables.Transactions.TABLE_NAME, null, null, null, null, null, null);
        }

        @Override
        public long insertOne(Transaction item)
        {
            return sdb.insertWithOnConflict(Tables.Transactions.TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
        }
    };

    private SQliteApi()
    {

    }

    public void createDB(Context context)
    {
        sdb = new SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)
        {
            @Override
            public void onCreate(SQLiteDatabase db)
            {
                createTables(db);
            }
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
            {
                clearTables(db);
                onCreate(db);
            }
        }.getWritableDatabase();
    }

    public void startTransaction()
    {
        sdb.beginTransaction();
    }

    public void endTransaction()
    {
        sdb.setTransactionSuccessful();
        sdb.endTransaction();
    }

    public Tables.CashAccounts getCashAccounts()
    {
        return cashAccounts;
    }
    public Tables.Transactions getTransactions()
    {
        return transactions;
    }

    private void clearTables(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.CashAccounts.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Transactions.TABLE_NAME);
    }
    public void createTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.CashAccounts.CREATE_TABLE);
        db.execSQL(Tables.Transactions.CREATE_TABLE);
    }
}
