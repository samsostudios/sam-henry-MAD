package com.example.sam.grocerylist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class GroceryListActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        realm = Realm.getDefaultInstance();


        RealmResults<Grocery> groceries = realm.where(Grocery.class).findAll();

        final GroceryAdapter adapter = new GroceryAdapter(this, groceries);

        ListView listView = (ListView) findViewById(R.id.grocery_list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                LinearLayout layout = new LinearLayout(GroceryListActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                final Grocery grocery = (Grocery) adapterView.getAdapter().getItem(i);

                final EditText groceryEditText = new EditText(GroceryListActivity.this);
                groceryEditText.setText(grocery.getItem());
                layout.addView(groceryEditText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(GroceryListActivity.this);
                dialog.setTitle("Edit");
                dialog.setView(layout);
                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final String updatedItems = groceryEditText.getText().toString();
                        if(!updatedItems.isEmpty()) {
                            changeItem(grocery.getID(), updatedItems);
                        }
                    }
                });
                dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteItem(grocery.getID());
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout layout = new LinearLayout(GroceryListActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText groceryEditText = new EditText(GroceryListActivity.this);
                groceryEditText.setHint("Book name");
                layout.addView(groceryEditText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(GroceryListActivity.this);
                dialog.setTitle("Add Item");
                dialog.setView(layout);
                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final String newGroceryName = groceryEditText.getText().toString();

                        if(!newGroceryName.isEmpty()) {

                            realm.executeTransactionAsync(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    Grocery newGrocery = realm.createObject(Grocery.class, UUID.randomUUID().toString());
                                    newGrocery.setItem(newGroceryName);
                                }
                            });
                        }
                    }
                });
                dialog.setNegativeButton("Cancel", null);
                dialog.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }

    public void changeItemBought(final String itemID){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Grocery grocery = realm.where(Grocery.class).equalTo("id", itemID).findFirst();
                grocery.setBought(!grocery.isBought());
            }
        });
    }

    private void changeItem(final String itemID, final String itemName){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Grocery grocery =  realm.where(Grocery.class).equalTo("id", itemID).findFirst();
                grocery.setItem(itemName);
            }
        });
    }

    private void deleteItem(final String itemID){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Grocery.class).equalTo("id", itemID).findFirst().deleteFromRealm();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grocery_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
