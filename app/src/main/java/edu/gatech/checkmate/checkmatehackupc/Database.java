package edu.gatech.checkmate.checkmatehackupc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

import static java.lang.Long.valueOf;

/**
 * Created by Courtney on 7/21/16.
 */
public class Database extends SQLiteOpenHelper{
        //Please use these names for the variables, don't hardcode them in case we need to change something

    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_CHECKIN = "nextCheckIn";
    private static final String COLUMN_ISDISABLED = "isDisabled";

    /**
     * constructor for the database
     * @param context The context we're using
     */
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //This creates all of the columns in our table followed by their data
        // type with a boolean represented as an integer that is either 1 or 0
        String query = "CREATE TABLE " + TABLE_USERS + " ("
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_CHECKIN + " TEXT, "
                + COLUMN_ISDISABLED + " INTEGER"
                + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Should never really call this, it deletes the whole table and makes a new one
        db.execSQL("DROP_TABLE_IF_EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    /**
     * Add a new row to the database (used when registering a user)
     * @param check The user info to be added to the table
     * @return boolean value of whether or not the new user has been added
     */
    public boolean addUser(Check check) throws Exception {
        //Gets a user object and puts all the data in its respective column
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + check.getUsername() + "';", null);
        c.moveToFirst();
        if (c.isBeforeFirst()) {
            values.put(COLUMN_USERNAME, check.getUsername());
            values.put(COLUMN_CHECKIN, check.getNextCheckIn().toString());
            values.put(COLUMN_ISDISABLED, 0);
            //inserts the new line to the table
            db.insert(TABLE_USERS, null, values);
        } else {
            return false;
        }
        c.close();
        db.close();
        return true;
    }

    /**
     * Checks to see if the database contains the user
     * @param username the user we are looking for
     * @return boolean whether or not
     */
    public boolean containsUser(String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "';", null);
        c.moveToFirst();
        if(c.isBeforeFirst()){
            return false;
        }
        c.close();
        return true;

    }


    public boolean isGood(Check check) throws Exception {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + check.getUsername() + "';", null);
        c.moveToFirst();
        String isDisabled = c.getString(c.getColumnIndex(COLUMN_ISDISABLED));
        if (new Date().getTime() <= check.getNextCheckIn().getTime()) return true;
        else return false;
    }

    public void updateNextCheckIn(Check check) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + check.getUsername() + "';", null);
        c.moveToFirst();
        long current;
        long newVal;
        String val;
        if(!c.isBeforeFirst()){
            current = valueOf(c.getString(c.getColumnIndex(COLUMN_CHECKIN)));
            newVal = current + check.getDelay();
            ContentValues values = new ContentValues();
            values.put(COLUMN_CHECKIN, newVal + "");
            db.update(TABLE_USERS, values, COLUMN_USERNAME + "= '" + check.getUsername() + "';", null);
            db.close();
        }
    }

}
