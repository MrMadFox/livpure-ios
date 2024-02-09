package com.livpure.safedrink.common;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FileUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"getFileChooserIntentForImageAndPdf", "Landroid/content/Intent;", "getFile", "Ljava/io/File;", "Landroid/net/Uri;", "ctx", "Landroid/content/Context;", "storagePath", "", "getFileName", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileUtilKt {
    public static final String getFileName(Uri uri, AppCompatActivity activity) {
        String str;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str2 = null;
        if (StringsKt.equals$default(uri.getScheme(), "content", false, 2, null)) {
            Cursor query = activity.getContentResolver().query(uri, null, null, null, null);
            try {
                Cursor cursor = query;
                str = (cursor == null || !cursor.moveToFirst()) ? null : cursor.getString(cursor.getColumnIndex("_display_name"));
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(query, th);
                    throw th2;
                }
            }
        } else {
            str = null;
        }
        if (str == null) {
            String path = uri.getPath();
            Integer valueOf = path != null ? Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) path, '/', 0, false, 6, (Object) null)) : null;
            if (valueOf == null || valueOf.intValue() == -1) {
                return path;
            }
            if (path != null) {
                str2 = path.substring(valueOf.intValue() + 1);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
            }
            return str2;
        }
        return str;
    }

    public static final File getFile(Uri uri, Context ctx, String storagePath) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(storagePath, "storagePath");
        File file = new File(storagePath);
        try {
            InputStream openInputStream = ctx.getContentResolver().openInputStream(uri);
            Intrinsics.checkNotNull(openInputStream);
            byte[] bArr = new byte[openInputStream.available()];
            openInputStream.read(bArr);
            new FileOutputStream(file).write(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static final Intent getFileChooserIntentForImageAndPdf() {
        Intent putExtra = new Intent("android.intent.action.GET_CONTENT").setType("image/*|application/pdf").putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "application/pdf"});
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_GET…RA_MIME_TYPES, mimeTypes)");
        return putExtra;
    }
}
