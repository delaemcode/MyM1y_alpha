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
    static private final int DB_VERSION = 1609011622;
    static private SQliteApi instanse;

    static public SQliteApi getInstanse()
    {
        if (instanse == null)
        {
            instanse = new SQliteApi();
        }
        return instanse;
    }

    private volatile SQLiteDatabase sdb;

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

    //____________________________GET_ALL
    public Cursor getCashAccounts()
    {
        return sdb.query(Tables.CashAccounts.TABLE_NAME, null, null, null, null, null, null);
    }
    public Cursor getTransactions()
    {
        return sdb.query(Tables.Transactions.TABLE_NAME, null, null, null, null, null, null);
    }

    //____________________________INSERT
    public long insertCashAccount(CashAccount item)
    {
        return sdb.insertWithOnConflict(Tables.CashAccounts.TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
    }
    public long insertTransaction(Transaction item)
    {
        return sdb.insertWithOnConflict(Tables.Transactions.TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
    }

    private void clearTables(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.CashAccounts.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Transactions.TABLE_NAME);
    }
    public void createTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.CashAccounts.createTable());
        db.execSQL(Tables.Transactions.createTable());
    }
}
