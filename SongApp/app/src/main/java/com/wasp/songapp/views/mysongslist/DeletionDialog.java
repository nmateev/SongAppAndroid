package com.wasp.songapp.views.mysongslist;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.wasp.songapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeletionDialog extends AlertDialog {

    @BindView(R.id.btn_answer_yes)
    Button mPositiveDialogButton;
    @BindView(R.id.btn_answer_no)
    Button mNegativeDialogButton;


    public DeletionDialog(Context context) {
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View dialogView = inflater.inflate(R.layout.song_deletion_dialog_layout, null);
        setContentView(dialogView);

        ButterKnife.bind(this);
    }
}
