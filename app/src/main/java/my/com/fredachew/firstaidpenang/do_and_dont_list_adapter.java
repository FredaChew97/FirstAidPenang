package my.com.fredachew.firstaidpenang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KhooZhiYan on 11/07/2017.
 */

public class do_and_dont_list_adapter extends ArrayAdapter<String> {

    String[] name ;
    int[] images;
    Context mContext;

    public do_and_dont_list_adapter(Context context, int[] images, String[] title) {
        super(context, R.layout.do_and_dont_list_item);
        this.images = images;
        this.name =title;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.do_and_dont_list_item, parent, false);
            mViewHolder.ivImage = (ImageView) convertView.findViewById(R.id.itemImage);
            mViewHolder.tvName = (TextView) convertView.findViewById(R.id.Itemname);

            mViewHolder.ivImage.setImageResource(images[position]);
            mViewHolder.tvName.setText(name[position]);


            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView ivImage;
        TextView tvName;
    }
}
