package com.detroitlabs.kyleofori.hellomoon;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by kyleofori on 1/13/15.
 */
public class VideoProvider extends ContentProvider {

    private static final String VIDEO_MIME_TYPE = "video/mp4";
    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getType(Uri uri) {
        return VIDEO_MIME_TYPE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        File f = new File(uri.getPath());

        if(f.exists()) {
            return (ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY));
        }

        throw new FileNotFoundException(uri.getPath());
    }
}
