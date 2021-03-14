package com.yurikobaggins.dialogexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NumberListDialog.ItemClickListener {
    private Button dialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogButton = findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 数字のリストダイアログを表示する
                showNumberListDialog();
            }
        });
    }

    /** リストなダイアログを表示するメソッド */
    private void showNumberListDialog() {
        NumberListDialog dialog = NumberListDialog.newInstance();
        dialog.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onItemClick(String numberText) {
        // リストでタップして選ばれた数字をボタンに表示する
        dialogButton.setText(numberText);
    }
}