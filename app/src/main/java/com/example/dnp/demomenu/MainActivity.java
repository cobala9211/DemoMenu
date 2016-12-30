package com.example.dnp.demomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TAG11";
    private Button btnContextMenu;
    private Button btnPopUpMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context menu
        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        btnContextMenu.setOnClickListener(this);
        registerForContextMenu(btnContextMenu);

        // popup menu
        btnPopUpMenu = (Button) findViewById(R.id.btnPopupMenu);
        btnPopUpMenu.setOnClickListener(this);
    }

    //create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    //action select option menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_item1:
                Log.d(TAG, "onOptionsItemSelected: item 1 select");
                break;
            case R.id.mnu_item2:
                Log.d(TAG, "onOptionsItemSelected: item 2 select");
                break;
            case R.id.mnu_item3:
                Log.d(TAG, "onOptionsItemSelected: item 3 select");
                break;
            default:
                throw new IllegalStateException("not found id item menu");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnContextMenu:
//                registerForContextMenu(btnContextMenu);
                break;
            case R.id.btnPopupMenu:
                final PopupMenu menu = new PopupMenu(this, btnPopUpMenu);
                menu.getMenuInflater().inflate(R.menu.pop_up_menu, menu.getMenu());
                menu.setOnMenuItemClickListener(onClickPopUpMenu);
                menu.show();
                break;
            default:
                throw new IllegalStateException("not found id view");
        }
    }

    // action click item menu pop up
    PopupMenu.OnMenuItemClickListener onClickPopUpMenu = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mnu_popup1:
                    Log.d(TAG, "onMenuItemClick: pop up 1");
                    break;
                case R.id.mnu_popup2:
                    Log.d(TAG, "onMenuItemClick: pop up 2");
                    break;
                case R.id.mnu_popup3:
                    Log.d(TAG, "onMenuItemClick: pop up 3");
                    break;
                default:
                    throw new IllegalStateException("not found id pop up menu");
            }
            return true;
        }
    };

    //create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    //action context menu select
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_context1:
                Log.d(TAG, "onContextItemSelected: context 1");
                break;
            case R.id.mnu_context2:
                Log.d(TAG, "onContextItemSelected: context 2");
                break;
            case R.id.mnu_context3:
                Log.d(TAG, "onContextItemSelected: context 3");
                break;
            default:
                throw new IllegalStateException("not found id context menu");
        }
        return super.onContextItemSelected(item);
    }
}
