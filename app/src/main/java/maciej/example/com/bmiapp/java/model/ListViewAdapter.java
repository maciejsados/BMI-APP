package maciej.example.com.bmiapp.java.model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import maciej.example.com.bmiapp.R;

/**
 * Created by Maciej on 2017-08-12.
 */

public class ListViewAdapter extends BaseAdapter {

    private final List<String> values;
    private final Context context;
    ViewHolder holder;
    private final LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, List<String> values) {
        this.values = values;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            holder = new ViewHolder();

            view = layoutInflater.inflate(R.layout.list_item, null);


            holder.mTextview = (TextView) view.findViewById(R.id.text_view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

        holder.mTextview.setText(values.get(i));

        return view;

    }

    class ViewHolder {

        TextView mTextview;


    }
}
