package delaem.code.mym1y.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;

public class SQliteApi
{
    static private final String DB_NAME = "mym1y_alpha";
    static private final int DB_VERSION = 1609051743;
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
            return sdb.query(TABLE_NAME, null, null, null, null, null, null);
        }

        @Override
        public Cursor getOneFromId(int id)
        {
            return sdb.rawQuery("SELECT * "
                    + "FROM " + TABLE_NAME + " "
                    + "WHERE " + BaseColumns._ID + "=" + id, new String[]{});
        }

        @Override
        public long insertOne(CashAccount item)
        {
            return sdb.insertWithOnConflict(TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
        }

        @Override
        public long updateBalance(int id, int balance)
        {
            ContentValues newValues = new ContentValues();
            newValues.put(Columns.balance, balance);
            return sdb.update(TABLE_NAME, newValues, BaseColumns._ID + " = "  + id, null);
        }
    };
    private Tables.Transactions transactions = new Tables.Transactions()
    {
        @Override
        public Cursor getAll()
        {
            return sdb.query(TABLE_NAME, null, null, null, null, null, null);
        }

        @Override
        public Cursor getAllFromCashAccountId(int cash_account_from_id)
        {
            return sdb.rawQuery("SELECT * "
                    + "FROM " + TABLE_NAME + " "
                    + "WHERE " + Columns.cash_account_from_id + "=" + cash_account_from_id, new String[]{});
        }

        @Override
        public long insertNew(Transaction item)
        {
            sdb.insertWithOnConflict(TABLE_NAME, null, ContentDriver.getContentValues(item), SQLiteDatabase.CONFLICT_REPLACE);
            int balance = 0;
            Cursor cursor = getTransactions().getAllFromCashAccountId(item.cash_account_from_id);
            if(cursor.moveToFirst())
            {
                do
                {
                    balance += cursor.getInt(cursor.getColumnIndex(Tables.Transactions.Columns.summ));
                }while(cursor.moveToNext());
            }
            cursor.close();
            return getCashAccounts().updateBalance(item.cash_account_from_id, balance);
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
