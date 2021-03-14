package com.yurikobaggins.dialogexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NumberListDialog extends DialogFragment {
    // 選択された数値をMainActivityに届けるためのリスナー
    private ItemClickListener listener;

    // リスナーの定義
    interface ItemClickListener {
        void onItemClick(String numberText);
    }

    public static NumberListDialog newInstance() {
        return new NumberListDialog();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ItemClickListener) {
            this.listener = (ItemClickListener) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // リストに表示する数字たちの配列
        String[] numberArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_number_list, null, false);
        ListView listView = view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // リスナーでMainActivityに選んだ数字を届ける
                listener.onItemClick(numberArray[position]);
                // ダイアログを非表示にする
                dismiss();
            }
        });

        // アダプターをListViewにセットする
        NumberListAdapter adapter = new NumberListAdapter(requireContext(), numberArray);
        listView.setAdapter(adapter);

        // ダイアログを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(view);
        return builder.create();
    }
}
