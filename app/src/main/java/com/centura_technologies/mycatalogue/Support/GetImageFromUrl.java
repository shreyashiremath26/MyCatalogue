package com.centura_technologies.mycatalogue.Support;

import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;


import com.centura_technologies.mycatalogue.Support.Apis.Urls;
import com.centura_technologies.mycatalogue.Support.DBHelper.DbHelper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Centura on 12-05-2016.
 */
public class GetImageFromUrl extends AsyncTask<ImageCache, Void, ImageCache> {
    public static StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    // String fileURL,fName;
    //Context context;

    @Override protected ImageCache doInBackground(ImageCache... data) {
        StrictMode.setThreadPolicy(policy);
        data[0].fileURL= Urls.parentIP+data[0].fileURL;
        data[0].strean = downloadImage(data[0]);
        return data[0];
    }
    // Sets the Bitmap returned by doInBackground
    @Override
    protected void onPostExecute(ImageCache result) {
        //final code here
        // imageProfile.setImageBitmap(result);
    } // Creates Bitmap from InputStream and returns it
    private InputStream downloadImage(ImageCache result) {
        try {
            result.strean = getHttpConnection(result.fileURL);
            File folderDir = Environment.getExternalStoragePublicDirectory("/MyCatalogueLocalData")  ;
            File file = new File(folderDir, result.fName);
            if (file.exists()) {
                file.delete();
            }
            if ((folderDir.mkdirs() || folderDir.isDirectory())) {
                try {
                    BufferedInputStream bufferedInputStream = null;
                    bufferedInputStream = new BufferedInputStream(result.strean,
                            1024 * 5);
                    FileOutputStream fileOutputStream = new FileOutputStream(
                            folderDir + "/" + result.fName);
                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    while ((len1 = result.strean.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len1);
                    }
                    DbHelper db=new DbHelper(result.context);
                    db.saveImage(result.fileURL,"/MyCatalogueLocalData/"+result.fName);
                    bufferedInputStream.close();
                    fileOutputStream.close();
                    result.strean.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        return result.strean;
    } // Makes HttpURLConnection and returns InputStream
    private InputStream getHttpConnection(String urlString)
            throws IOException {
        InputStream stream = null;
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            { stream = httpConnection.getInputStream();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return stream;
    }
}