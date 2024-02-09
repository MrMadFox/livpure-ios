package com.livpure.safedrink.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import androidx.loader.content.CursorLoader;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class RealPathUtil {
    public static String getRealPath(Context context, Uri fileUri) {
        if (Build.VERSION.SDK_INT < 11) {
            return getRealPathFromURI_BelowAPI11(context, fileUri);
        }
        if (Build.VERSION.SDK_INT < 19) {
            return getRealPathFromURI_API11to18(context, fileUri);
        }
        return getRealPathFromURI_API19(context, fileUri);
    }

    public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        Cursor loadInBackground = new CursorLoader(context, contentUri, new String[]{"_data"}, null, null, null).loadInBackground();
        if (loadInBackground != null) {
            int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow("_data");
            loadInBackground.moveToFirst();
            String string = loadInBackground.getString(columnIndexOrThrow);
            loadInBackground.close();
            return string;
        }
        return null;
    }

    public static String getRealPathFromURI_BelowAPI11(Context context, Uri contentUri) {
        Cursor query = context.getContentResolver().query(contentUri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            String string = query.getString(columnIndexOrThrow);
            query.close();
            return string;
        }
        return "";
    }

    public static String getRealPathFromURI_API19(final Context context, final Uri uri) {
        Uri contentUri;
        String dataColumn;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String filePath = getFilePath(context, uri);
                if (filePath != null) {
                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + filePath;
                }
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId != null && documentId.startsWith("raw:")) {
                    return documentId.substring(4);
                }
                String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                for (int i = 0; i < 3; i++) {
                    Uri withAppendedId = ContentUris.withAppendedId(Uri.parse(strArr[i]), Long.valueOf(documentId).longValue());
                    try {
                        Log.e("DownloadsProvider", withAppendedId.getPath());
                        dataColumn = getDataColumn(context, withAppendedId, null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (dataColumn != null) {
                        return dataColumn;
                    }
                }
                File generateFileName = generateFileName(getFileName(context, uri), getDocumentCacheDir(context));
                if (generateFileName != null) {
                    String absolutePath = generateFileName.getAbsolutePath();
                    saveFileFromUri(context, uri, absolutePath);
                    return absolutePath;
                }
                return null;
            } else if (isMediaDocument(uri)) {
                Log.e("Media", "media");
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    contentUri = MediaStore.Files.getContentUri("external");
                }
                return getDataColumn(context, contentUri, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            Log.e("MediaStore", "MediaStore");
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getFilePath(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getFileName(Context context, Uri uri) {
        context.getContentResolver().getType(uri);
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("_display_name");
            query.moveToFirst();
            String string = query.getString(columnIndex);
            query.close();
            return string;
        }
        return null;
    }

    public static File getDocumentCacheDir(Context context) {
        File file = new File(context.getCacheDir(), "document");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File generateFileName(String name, File directory) {
        String str;
        if (name == null) {
            return null;
        }
        File file = new File(directory, name);
        if (file.exists()) {
            int lastIndexOf = name.lastIndexOf(46);
            int i = 0;
            if (lastIndexOf > 0) {
                String substring = name.substring(0, lastIndexOf);
                str = name.substring(lastIndexOf);
                name = substring;
            } else {
                str = "";
            }
            while (file.exists()) {
                i++;
                file = new File(directory, name + '(' + i + ')' + str);
            }
        }
        try {
            if (file.createNewFile()) {
                return file;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005f A[Catch: IOException -> 0x005b, TRY_LEAVE, TryCatch #7 {IOException -> 0x005b, blocks: (B:40:0x0057, B:44:0x005f), top: B:51:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void saveFileFromUri(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r2 = 0
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r3.read(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
        L1b:
            r4.write(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            int r0 = r3.read(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r1 = -1
            if (r0 != r1) goto L1b
            if (r3 == 0) goto L2a
            r3.close()     // Catch: java.io.IOException -> L48
        L2a:
            r4.close()     // Catch: java.io.IOException -> L48
            goto L53
        L2e:
            r5 = move-exception
            goto L34
        L30:
            r5 = move-exception
            goto L38
        L32:
            r5 = move-exception
            r4 = r0
        L34:
            r0 = r3
            goto L55
        L36:
            r5 = move-exception
            r4 = r0
        L38:
            r0 = r3
            goto L3f
        L3a:
            r5 = move-exception
            r4 = r0
            goto L55
        L3d:
            r5 = move-exception
            r4 = r0
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.io.IOException -> L48
            goto L4a
        L48:
            r3 = move-exception
            goto L50
        L4a:
            if (r4 == 0) goto L53
            r4.close()     // Catch: java.io.IOException -> L48
            goto L53
        L50:
            r3.printStackTrace()
        L53:
            return
        L54:
            r5 = move-exception
        L55:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.io.IOException -> L5b
            goto L5d
        L5b:
            r3 = move-exception
            goto L63
        L5d:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L5b
            goto L66
        L63:
            r3.printStackTrace()
        L66:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.utils.RealPathUtil.saveFileFromUri(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r9 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r9 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r9 == 0) goto L2b
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L4c
            if (r10 == 0) goto L2b
            int r10 = r9.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L4c
            java.lang.String r8 = r9.getString(r10)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L4c
            if (r9 == 0) goto L28
            r9.close()
        L28:
            return r8
        L29:
            r10 = move-exception
            goto L35
        L2b:
            if (r9 == 0) goto L4b
        L2d:
            r9.close()
            goto L4b
        L31:
            r8 = move-exception
            goto L4e
        L33:
            r10 = move-exception
            r9 = r7
        L35:
            java.lang.String r11 = "Exception"
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L4c
            android.util.Log.e(r11, r10)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = "Please choose file from file manager"
            r11 = 0
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r10, r11)     // Catch: java.lang.Throwable -> L4c
            r8.show()     // Catch: java.lang.Throwable -> L4c
            if (r9 == 0) goto L4b
            goto L2d
        L4b:
            return r7
        L4c:
            r8 = move-exception
            r7 = r9
        L4e:
            if (r7 == 0) goto L53
            r7.close()
        L53:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.utils.RealPathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
