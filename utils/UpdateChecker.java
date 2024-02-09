package com.livpure.safedrink.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.livpure.safedrink.R;
import org.jsoup.Jsoup;
/* loaded from: classes3.dex */
public class UpdateChecker {
    Activity act;

    public void getVersionCode(Activity act) {
        this.act = act;
        new GetVersionCode(act).execute(new Void[0]);
    }

    /* loaded from: classes3.dex */
    private class GetVersionCode extends AsyncTask<Void, String, String> {
        Activity act;

        public GetVersionCode(Activity act) {
            this.act = act;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) {
            try {
                return Jsoup.connect("https://play.google.com/store/apps/details?id=" + this.act.getPackageName() + "&hl=it").timeout(30000).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://www.google.com").get().select(".hAyfc .htlgb").get(7).ownText();
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String onlineVersion) {
            super.onPostExecute((GetVersionCode) onlineVersion);
            if (onlineVersion == null || onlineVersion.isEmpty()) {
                return;
            }
            try {
                String str = this.act.getPackageManager().getPackageInfo(this.act.getPackageName(), 0).versionName;
                Log.d("update", "Current version " + str + "playstore version " + onlineVersion);
                if (str.equalsIgnoreCase(onlineVersion)) {
                    return;
                }
                Log.d("update", "LaunchDailog");
                UpdateChecker.this.showDialog();
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(this.act);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.app_update_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        ((ImageView) dialog.findViewById(R.id.cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.utils.UpdateChecker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.ok_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.utils.UpdateChecker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activity = UpdateChecker.this.act;
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + UpdateChecker.this.act.getPackageName())));
            }
        });
    }
}
