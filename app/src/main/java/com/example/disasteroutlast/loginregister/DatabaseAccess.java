package com.example.disasteroutlast.loginregister;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    // for object creation outside the box is avoided
    private DatabaseAccess(Context context)
    {
        this.openHelper=new DatabaseOpenHelper(context);

    }
    //to return the single instance of database
    public static DatabaseAccess getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new DatabaseAccess(context);
        }
        return instance;
    }
    //to open the database
    public void open()
    {
        this.db= openHelper.getWritableDatabase();
    }

    public void close()
    {
        if (db!=null)
        {
            this.db.close();
        }
    }
    //now method for query
    public String getinfo(String disaster,String coloumn)
    {

        c = db.rawQuery("select "+coloumn+" from disasterPreparation where name='"+disaster+"'", new String[]{});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext())
        {
            String name = c.getString(0);
            buffer.append("\n"+ name + "  " );

        }
        return buffer.toString();
    }
    //now method for query
    public ArrayList getLat(String str)
    {
        ArrayList<Double> arrayList = new ArrayList<>();
        Cursor c1 = db.rawQuery("SELECT lat FROM shelter where city='"+str+"'",new String[]{});

        while (c1.moveToNext())
        {
            double name = c1.getDouble(0);
            arrayList.add(name);

        }
        return arrayList;
    }

    public ArrayList getLong(String str)
    {
        ArrayList<Double> arrayList = new ArrayList<>();
        Cursor c2 = db.rawQuery("SELECT long FROM shelter where city='"+str+"'",new String[]{});

        while (c2.moveToNext())
        {
            double name = c2.getDouble(0);
            arrayList.add(name);

        }
        return arrayList;
    }

    public ArrayList getPlaceName(String str)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor c3 = db.rawQuery("SELECT name FROM shelter where city='"+str+"'",new String[]{});

        while (c3.moveToNext())
        {
            String name = c3.getString(0);
            arrayList.add(name);

        }
        return arrayList;
    }

    public ArrayList getAddress(String str)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor c4 = db.rawQuery("SELECT address FROM shelter where city='"+str+"'",new String[]{});

        while (c4.moveToNext())
        {
            String name = c4.getString(0);
            arrayList.add(name);

        }
        return arrayList;
    }


}
