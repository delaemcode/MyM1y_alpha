package delaem.code.mym1y.models;

public abstract class Model<DATA>
{
    protected DATA data;

    public void swapData(DATA d)
    {
        data = d;
    }

    public abstract void readyItem(int i);
    public abstract int getItemCount();
    public abstract void clearData();
}