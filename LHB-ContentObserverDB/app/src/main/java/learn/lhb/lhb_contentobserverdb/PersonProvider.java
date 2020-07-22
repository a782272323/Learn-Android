package learn.lhb.lhb_contentobserverdb;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {
    private static UriMatcher mUriMatcher = new UriMatcher(-1);
    private static final int SUCCESS = 1;
    private PersonDBOpenHelper helper;

    static {
        mUriMatcher.addURI("learn.lhb.lhb_contentobserverdb","info",SUCCESS);
    }


    public PersonProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int code = mUriMatcher.match(uri);
        if (code == SUCCESS) {
            SQLiteDatabase db = helper.getWritableDatabase();
            int count = db.delete("info", selection, selectionArgs);
            if (count > 0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            db.close();
            return count;

        } else {
            throw new IllegalArgumentException("路径不正确，无法删除数据");
        }

//        // Implement this to handle requests to delete one or more rows.
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
//        // TODO: Implement this to handle requests for the MIME type of the data
//        // at the given URI.
//        throw new UnsupportedOperationException("Not yet implemented");

        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int code = mUriMatcher.match(uri);
        if (code == SUCCESS) {
            SQLiteDatabase db = helper.getReadableDatabase();
            long rowId = db.insert("info", null, values);
            if (rowId > 0) {
                Uri insertedUri = ContentUris.withAppendedId(uri, rowId);
                getContext().getContentResolver().notifyChange(insertedUri,null);
                return insertedUri;
            }
            db.close();
            return uri;
        } else {
            throw new IllegalArgumentException("路径不正确，无法添加数据");
        }


//        // TODO: Implement this to handle requests to insert a new row.
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int code = mUriMatcher.match(uri);
        if (code == SUCCESS) {
            SQLiteDatabase db = helper.getReadableDatabase();
            return db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
        } else {
            throw new IllegalArgumentException("路径不正确，无法查询数据!");
        }
//        // TODO: Implement this to handle query requests from clients.
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        int code = mUriMatcher.match(uri);
        if (code == SUCCESS) {
            SQLiteDatabase db = helper.getWritableDatabase();
            int count = db.update("info", values, selection, selectionArgs);
            if (count > 0) {
                getContext().getContentResolver().notifyChange(uri,null);
            }
            db.close();
            return count;
        } else {
            throw new IllegalArgumentException("路径不正确，无法更新数据");

        }


//        // TODO: Implement this to handle requests to update one or more rows.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
