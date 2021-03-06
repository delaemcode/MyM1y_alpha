package delaem.code.mym1y.models;

import android.database.Cursor;

public abstract class CursorModel
        extends Model<Cursor>
{
    @Override
    public void readyItem(int i)
    {
        data.moveToPosition(i);
    }

    @Override
    public int getItemCount()
    {
        if(data == null)
        {
            return 0;
        }
        return data.getCount();
    }

    @Override
    public void swapData(Cursor d)
    {
        clearData();
        super.swapData(d);
    }

    @Override
    public void clearData()
    {
        if(data != null)
        {
            data.close();
        }
    }
}