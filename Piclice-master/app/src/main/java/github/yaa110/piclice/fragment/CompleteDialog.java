package github.yaa110.piclice.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import github.yaa110.piclice.R;

@SuppressWarnings("UnusedDeclaration")
public class CompleteDialog extends DialogFragment {

    private ViewListener listener;
    public String path;

    public CompleteDialog() {}

    public static CompleteDialog newInstance(String path, ViewListener listener) {
        CompleteDialog instance = new CompleteDialog();
        instance.setOnViewListener(listener);
        instance.path = path;
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);

        View view = inflater.inflate(R.layout.dialog_complete, container);

        ((TextView) view.findViewById(R.id.url_txt)).setText(getString(R.string.saved, path));

        view.findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onView(path);
            }
        });

        return view;
    }

    public void setOnViewListener(ViewListener listener) {
        this.listener = listener;
    }

    public interface ViewListener {
        public void onView(String path);
    }

}
