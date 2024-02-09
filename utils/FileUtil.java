package com.livpure.safedrink.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.livpure.safedrink.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes3.dex */
public class FileUtil {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;

    public static File from(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        String fileName = getFileName(context, uri);
        String[] splitFileName = splitFileName(fileName);
        File rename = rename(File.createTempFile(splitFileName[0], splitFileName[1]), fileName);
        rename.deleteOnExit();
        try {
            fileOutputStream = new FileOutputStream(rename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        if (openInputStream != null) {
            copy(openInputStream, fileOutputStream);
            openInputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return rename;
    }

    private static String[] splitFileName(String fileName) {
        String str;
        int lastIndexOf = fileName.lastIndexOf(InstructionFileId.DOT);
        if (lastIndexOf != -1) {
            String substring = fileName.substring(0, lastIndexOf);
            str = fileName.substring(lastIndexOf);
            fileName = substring;
        } else {
            str = "";
        }
        return new String[]{fileName, str};
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r8 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getFileName(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L42
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)
            if (r8 == 0) goto L3d
            boolean r0 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r0 == 0) goto L3d
            java.lang.String r0 = "_display_name"
            int r0 = r8.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r0 = r8.getString(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1 = r0
            goto L3d
        L2e:
            r9 = move-exception
            goto L37
        L30:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L42
            goto L3f
        L37:
            if (r8 == 0) goto L3c
            r8.close()
        L3c:
            throw r9
        L3d:
            if (r8 == 0) goto L42
        L3f:
            r8.close()
        L42:
            if (r1 != 0) goto L57
            java.lang.String r1 = r9.getPath()
            java.lang.String r8 = java.io.File.separator
            int r8 = r1.lastIndexOf(r8)
            r9 = -1
            if (r8 == r9) goto L57
            int r8 = r8 + 1
            java.lang.String r1 = r1.substring(r8)
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.utils.FileUtil.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static File getFile(String filePath) {
        if (filePath == null || filePath.isEmpty() || filePath.equalsIgnoreCase("null")) {
            return null;
        }
        PrintStream printStream = System.out;
        printStream.println("Sending file: " + filePath);
        try {
            return new File(filePath);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    private static File rename(File file, String newName) {
        File file2 = new File(file.getParent(), newName);
        if (!file2.equals(file)) {
            if (file2.exists() && file2.delete()) {
                Log.d("FileUtil", "Delete old " + newName + " file");
            }
            if (file.renameTo(file2)) {
                Log.d("FileUtil", "Rename file to " + newName);
            }
        }
        return file2;
    }

    private static long copy(InputStream input, OutputStream output) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = input.read(bArr);
            if (-1 == read) {
                return j;
            }
            output.write(bArr, 0, read);
            j += read;
        }
    }

    public static File getDestinationFile(Context mContext, File compressedFile, String imageName) {
        File externalStoragePublicDirectory;
        if (Build.VERSION.SDK_INT >= 29) {
            externalStoragePublicDirectory = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES + File.separator + mContext.getString(R.string.app_name));
        } else {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + mContext.getString(R.string.app_name));
        }
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdir();
        }
        File file = new File(externalStoragePublicDirectory, imageName + ".jpg");
        if (compressedFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(compressedFile);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static File getPDFDestinationFile(Context mContext, File compressedFile, String imageName) {
        File externalStoragePublicDirectory;
        if (Build.VERSION.SDK_INT >= 29) {
            externalStoragePublicDirectory = mContext.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + File.separator + mContext.getString(R.string.app_name));
        } else {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS + File.separator + mContext.getString(R.string.app_name));
        }
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdir();
        }
        File file = new File(externalStoragePublicDirectory, imageName + ".pdf");
        if (compressedFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(compressedFile);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static void deleteExternalStoragePrivatePicture(Context mContext, String imageName) {
        File externalStoragePublicDirectory;
        if (Build.VERSION.SDK_INT >= 29) {
            externalStoragePublicDirectory = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES + File.separator + mContext.getString(R.string.app_name));
        } else {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + mContext.getString(R.string.app_name));
        }
        if (externalStoragePublicDirectory == null || !externalStoragePublicDirectory.isDirectory()) {
            return;
        }
        for (String str : externalStoragePublicDirectory.list()) {
            new File(externalStoragePublicDirectory, str).delete();
        }
    }

    private static String getDate(long milliSeconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("_yyyy_MM_dd_hh_mm_ss", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return simpleDateFormat.format(calendar.getTime());
    }
}
