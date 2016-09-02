package delaem.code.mym1y.db;

import android.content.ContentValues;
import android.provider.BaseColumns;

import delaem.code.mym1y.core.CashAccount;
import delaem.code.mym1y.core.Transaction;

public class ContentDriver
{
    static public ContentValues getContentValues(CashAccount item)
    {
        ContentValues content = new ContentValues();
        if(item.id > 0)
        {
            content.put(BaseColumns._ID, item.id);
        }
        content.put(Tables.CashAccounts.Columns.name, item.name);
        content.put(Tables.CashAccounts.Columns.description, item.description);
        content.put(Tables.CashAccounts.Columns.balance, item.balance + "");
        return content;
    }
    static public ContentValues getContentValues(Transaction item)
    {
        ContentValues content = new ContentValues();
        if(item.id > 0)
        {
            content.put(BaseColumns._ID, item.id);
        }
        content.put(Tables.Transactions.Columns.cash_account_from_id, item.cash_account_from_id);
        content.put(Tables.Transactions.Columns.time, item.time);
        content.put(Tables.Transactions.Columns.summ, item.summ);
        content.put(Tables.Transactions.Columns.comment, item.comment);
        return content;
    }
}