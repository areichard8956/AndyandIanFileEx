package com.example.andyandianfileex;


import android.app.Dialog;
import android.demo.adapters.ListFileAdapter;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {

private ListView listviewFiles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviewFiles = findViewById(R.id.listViewFiles);


        loadData();
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
        Button buttonCancel = view.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){dialog.dismiss();}
        });
        Button buttonSave = view.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveFile(view);
                dialog.dismiss();
            }
    });
    }


    private void saveFile(View view) {
        try{
            EditText editTextFileNames = view.findViewById(R.id.editTextFileName);
            EditText editTextContent = view.findViewById(R.id.editTextContent);
            File file = new File(getFilesDir()+ File.separator + editTextFileNames.getText().toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(editTextContent.getText().toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            loadData();


        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void loadData(){
File dir = getFilesDir();
        ListFileAdapter listFileAdapter = new ListFileAdapter(getApplicationContext(), dir.listFiles());
        listviewFiles.setAdapter(listFileAdapter);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.file_menu, menu);
        return true;
        }

}
