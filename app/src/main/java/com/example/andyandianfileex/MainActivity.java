package com.example.andyandianfileex;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

>>>>>>> 351789be8a625a02c146df860aa59da0aaad246d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
<<<<<<< HEAD

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

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



=======
>>>>>>> 351789be8a625a02c146df860aa59da0aaad246d
}
