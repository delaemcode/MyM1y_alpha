package delaem.code.mym1y.models.edittransaction;

import android.provider.BaseColumns;

import delaem.code.mym1y.db.Tables;
import delaem.code.mym1y.models.CursorModel;

public class ChooseCashAccountsModel
        extends CursorModel
{
    public int getId()
    {
        return data.getInt(data.getColumnIndex(BaseColumns._ID));
    }

    public String getName()
    {
        return data.getString(data.getColumnIndex(Tables.CashAccounts.Columns.name));
    }
}