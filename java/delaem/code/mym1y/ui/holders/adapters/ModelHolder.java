package delaem.code.mym1y.ui.holders.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ModelHolder
        extends RecyclerView.ViewHolder
{
    public ModelHolder(Context context, ViewGroup parent, int layout)
    {
        super(LayoutInflater.from(context).inflate(layout, parent, false));
    }
}