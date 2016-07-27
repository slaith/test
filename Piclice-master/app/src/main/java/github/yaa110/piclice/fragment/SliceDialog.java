package github.yaa110.piclice.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import github.yaa110.piclice.R;

@SuppressWarnings("UnusedDeclaration")
public class SliceDialog extends DialogFragment {

    private SelectListener listener;
    private int scale_it = 100;

    public SliceDialog() {}

    public static SliceDialog newInstance(SelectListener listener) {
        SliceDialog instance = new SliceDialog();
        instance.setOnSelectListener(listener);
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
        getDialog().setCanceledOnTouchOutside(true);

        View view = inflater.inflate(R.layout.dialog_slice, container);

        SeekBar seekBar = (SeekBar) view.findViewById(R.id.resize);
        final TextView resize_txt = (TextView) view.findViewById(R.id.resize_txt);

        view.findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onSelect(2, scale_it);
            }
        });

        view.findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onSelect(3, scale_it);
            }
        });

        final EditText more_number = (EditText) view.findViewById(R.id.more_number);
        final View invalid = view.findViewById(R.id.invalid);

        view.findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().findViewById(R.id.counters).setVisibility(View.GONE);
                getDialog().findViewById(R.id.more).setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int count = Integer.parseInt(more_number.getText().toString());
                    if (count > 0) {
                        dismiss();
                        listener.onSelect(count, scale_it);
                    } else {
                        invalid.setVisibility(View.VISIBLE);
                    }
                } catch (Exception ignored) {
                    invalid.setVisibility(View.VISIBLE);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                resize_txt.setText("Size: " + (i + 10) + "%");
                scale_it = i + 10;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    public void setOnSelectListener(SelectListener listener) {
        this.listener = listener;
    }

    public interface SelectListener {
        public void onSelect(int total, int scale);
    }

}
