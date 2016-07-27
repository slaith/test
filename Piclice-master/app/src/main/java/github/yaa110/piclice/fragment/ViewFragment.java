package github.yaa110.piclice.fragment;


import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

import github.yaa110.piclice.R;
import github.yaa110.piclice.adapter.ListAdapter;

public class ViewFragment extends ListFragment {

    String path = null;
    int total = 0;
    File[] folder;

    public ViewFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_view, container, false);

        path = getActivity().getIntent().getStringExtra(MainFragment.EXTRA_PATH);

        if (path == null) getActivity().finish();

        total = getActivity().getIntent().getIntExtra(MainFragment.EXTRA_NUM, 0);

        if (total == 0) getActivity().finish();

        folder = new File[total];

        for (int i = 1; i < total + 1; i++) {
            File file = new File(path, i + ".png");
            if (file.exists()) folder[i - 1] = file;
            else folder[i - 1] = null;
        }

        Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        int reqWidth = size.x;
        int reqHeight = size.y;

        final ListAdapter adapter = new ListAdapter(
                getActivity(),
                folder,
                reqWidth,
                reqHeight
        );

        setListAdapter(adapter);

        getActivity().findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Uri> imageUris = new ArrayList<>();
                for (int j = 0; j < total; j++) {
                    try {
                        imageUris.add(Uri.fromFile(folder[j]));
                    } catch (Exception ignored) {}
                }

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                shareIntent.setType("image/png");
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_all)));
            }
        });

        return fragment;
    }
}
