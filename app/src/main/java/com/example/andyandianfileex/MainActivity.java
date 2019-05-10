package com.example.andyandianfileex;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

private ListView listviewFiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviewFiles = findViewById(R.id.listViewFiles);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.file_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);




    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.createFile){
        openCreateFileDialog();

        }

        return super.onOptionsItemSelected(item);
    }

    private void openCreateFileDialog(){View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.create_file_dialog_layout, null);
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle(getText(R.string.create_file));
    builder.setView(view);
    builder.setCancelable(false);
       final Dialog dialog = builder.show();
        // Button buttonCancel = view.findViewById(R.id.butto)

    }


}
