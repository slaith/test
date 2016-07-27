package github.yaa110.piclice.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.File;

import github.yaa110.piclice.R;

public class ListAdapter extends ArrayAdapter<File> {

    public int reqWidth;
    public int reqHeight;

    public ListAdapter(Context context, File[] folder, int reqWidth, int reqHeight) {
        super(context, R.layout.list_item, folder);
        this.reqWidth = reqWidth;
        this.reqHeight = reqHeight;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        if (getItem(position) == null) return convertView;

        final ImageView image = (ImageView) convertView.findViewById(R.id.image);
        final String image_path = getItem(position).getAbsolutePath();

        new Thread() {
            @Override
            public void run() {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(image_path, options);

                int height = options.outHeight;
                int width = options.outWidth;

                int inSampleSize = 1;

                if (height > reqHeight || width > reqWidth) {

                    final int halfHeight = height / 2;
                    final int halfWidth = width / 2;

                    while ((halfHeight / inSampleSize) > reqHeight
                            && (halfWidth / inSampleSize) > reqWidth) {
                        inSampleSize *= 2;
                    }
                }

                options.inSampleSize = inSampleSize;
                options.inJustDecodeBounds = false;

                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageBitmap(BitmapFactory.decodeFile(image_path, options));
                    }
                });

                interrupt();
            }
        }.start();

        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
