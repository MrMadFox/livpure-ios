package com.livpure.safedrink.bolt.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.snackbar.Snackbar;
import com.moengage.core.internal.logger.LogManagerKt;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.RequestBody;
import okio.Buffer;
/* compiled from: GeneralService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/bolt/service/GeneralService;", "", "()V", "forSensitivity", "", "getForSensitivity", "()I", "setForSensitivity", "(I)V", "forTemperature", "getForTemperature", "setForTemperature", "checkPlayService", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GeneralService {
    public static final Companion Companion = new Companion(null);
    private static final int PLAY_SERVICE_RESULATION_REQUEST = 300193;
    private static BroadcastReceiver mWifiScanReceiver;
    private int forSensitivity = 1;
    private int forTemperature;

    public final int getForSensitivity() {
        return this.forSensitivity;
    }

    public final void setForSensitivity(int i) {
        this.forSensitivity = i;
    }

    public final int getForTemperature() {
        return this.forTemperature;
    }

    public final void setForTemperature(int i) {
        this.forTemperature = i;
    }

    private final boolean checkPlayService(Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance()");
        return googleApiAvailability.isGooglePlayServicesAvailable(context) == 0;
    }

    /* compiled from: GeneralService.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006J\u001b\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u001e\u00100\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00101\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u00102\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u00103\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u0010\u00104\u001a\u00020-2\b\u00105\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020-2\b\u00105\u001a\u0004\u0018\u000106J\u000e\u00108\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u001e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020-J\u001a\u0010?\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010@\u001a\u0004\u0018\u00010\u0006J\u001a\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010\u0006J\u001a\u0010E\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010F2\b\u0010D\u001a\u0004\u0018\u00010\u0006J\u001a\u0010G\u001a\u00020)2\b\u0010H\u001a\u0004\u0018\u00010/2\b\u0010I\u001a\u0004\u0018\u00010\u0006J\u000e\u0010J\u001a\u00020)2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/livpure/safedrink/bolt/service/GeneralService$Companion;", "", "()V", "PLAY_SERVICE_RESULATION_REQUEST", "", "deviceName", "", "getDeviceName", "()Ljava/lang/String;", "mWifiScanReceiver", "Landroid/content/BroadcastReceiver;", "WIFIReceiver", "wifiManager", "Landroid/net/wifi/WifiManager;", "hotspotId", "handler", "Lcom/livpure/safedrink/bolt/service/WIFIHandler;", "bodyToString", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/RequestBody;", "capitalize", "str", "convertBinaryToDecimal", "binary_number", "convertDecimalToBinary", "", "decimal_number", "(I)[Ljava/lang/Integer;", "convertDecimalToBinaryForMotionSensor", "convertDecimalToBinaryForTempSensor", "getConnectedWifi", "getLockUnlockSwitchState", "getMotionState", "getOnOffSwitchState", "getPlugState", "getSenstivity", "getTemperature", "state", "getTimeStampTODate", "time", "hideSoftKeyboard", "", "activity", "Landroid/app/Activity;", "isGpsEnabled", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "isHotspotAvailable", "isMobileDataEnabled", "isMobileDataOff", "isOnline", "isValidEmail", "target", "", "isValidEmailAndMobileNo", "isWifiConnected", "scaleDown", "Landroid/graphics/Bitmap;", "realImage", "maxImageSize", "", "filter", "showDefaultAlert", "msg", "showSnackBar", "layout", "Landroid/widget/LinearLayout;", LogManagerKt.LOG_LEVEL_INFO, "showSnackBarForFragment", "Landroid/widget/FrameLayout;", "showToast", "mContext", "message", "unregisterReceiver", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isValidEmail(CharSequence charSequence) {
            if (charSequence == null) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
        }

        public final boolean isValidEmailAndMobileNo(CharSequence charSequence) {
            if (charSequence == null) {
                return false;
            }
            if (StringsKt.contains$default((CharSequence) charSequence.toString(), (CharSequence) "@", false, 2, (Object) null)) {
                return Patterns.EMAIL_ADDRESS.matcher(charSequence.toString()).matches();
            }
            return Patterns.PHONE.matcher(charSequence.toString()).matches();
        }

        public final void showDefaultAlert(Context context, String str) {
            Intrinsics.checkNotNullExpressionValue(new AlertDialog.Builder(context).setTitle("").setMessage(str).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.bolt.service.GeneralService$Companion$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show(), "Builder(context).setTitl…dialog.dismiss() }.show()");
        }

        public final boolean isOnline(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        public final void showToast(Context context, String str) {
            try {
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void hideSoftKeyboard(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                Object systemService = activity.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    View currentFocus = activity.getCurrentFocus();
                    inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final Integer[] convertDecimalToBinary(int i) {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                arrayList.add(Integer.valueOf(i % 2));
                i /= 2;
            }
            int size = arrayList.size();
            if (size < 8) {
                while (8 - size > 0) {
                    arrayList.add(0);
                    size++;
                }
            }
            Collections.reverse(arrayList);
            Integer[] numArr = new Integer[arrayList.size()];
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                numArr[i2] = (Integer) arrayList.get(i2);
            }
            return numArr;
        }

        public final Integer[] convertDecimalToBinaryForTempSensor(int i) {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                arrayList.add(Integer.valueOf(i % 2));
                i /= 2;
            }
            int size = arrayList.size();
            if (size < 8) {
                while (8 - size > 0) {
                    arrayList.add(0);
                    size++;
                }
            }
            Collections.reverse(arrayList);
            Integer[] numArr = new Integer[arrayList.size() - 1];
            int size2 = arrayList.size() - 1;
            for (int i2 = 0; i2 < size2; i2++) {
                numArr[i2] = (Integer) arrayList.get(i2);
            }
            return numArr;
        }

        public final Integer[] convertDecimalToBinaryForMotionSensor(int i) {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                arrayList.add(Integer.valueOf(i % 2));
                i /= 2;
            }
            int size = arrayList.size();
            if (size < 8) {
                while (8 - size > 0) {
                    arrayList.add(0);
                    size++;
                }
            }
            Collections.reverse(arrayList);
            Integer[] numArr = new Integer[arrayList.size() - 2];
            int size2 = arrayList.size() - 2;
            for (int i2 = 0; i2 < size2; i2++) {
                numArr[i2] = (Integer) arrayList.get(i2);
            }
            return numArr;
        }

        public final int getOnOffSwitchState(int i) {
            Integer[] convertDecimalToBinary = convertDecimalToBinary(i);
            StringBuffer stringBuffer = new StringBuffer();
            int length = convertDecimalToBinary.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                stringBuffer.append(convertDecimalToBinary[i3]);
                if (i3 == 6) {
                    Integer num = convertDecimalToBinary[i3];
                    Intrinsics.checkNotNull(num);
                    i2 = num.intValue();
                }
            }
            return i2;
        }

        public final int getLockUnlockSwitchState(int i) {
            Integer[] convertDecimalToBinary = convertDecimalToBinary(i);
            StringBuffer stringBuffer = new StringBuffer();
            int length = convertDecimalToBinary.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                stringBuffer.append(convertDecimalToBinary[i3]);
                if (i3 == 7) {
                    Integer num = convertDecimalToBinary[i3];
                    Intrinsics.checkNotNull(num);
                    i2 = num.intValue();
                }
            }
            return i2;
        }

        public final int getPlugState(int i) {
            Integer[] convertDecimalToBinary = convertDecimalToBinary(i);
            StringBuffer stringBuffer = new StringBuffer();
            int length = convertDecimalToBinary.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                stringBuffer.append(convertDecimalToBinary[i3]);
                if (i3 == 6) {
                    Integer num = convertDecimalToBinary[i3];
                    Intrinsics.checkNotNull(num);
                    i2 = num.intValue();
                }
            }
            return i2;
        }

        public final int getMotionState(int i) {
            Integer[] convertDecimalToBinary = convertDecimalToBinary(i);
            StringBuffer stringBuffer = new StringBuffer();
            int length = convertDecimalToBinary.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                stringBuffer.append(convertDecimalToBinary[i3]);
                if (i3 == 6) {
                    Integer num = convertDecimalToBinary[i3];
                    Intrinsics.checkNotNull(num);
                    i2 = num.intValue();
                }
            }
            return i2;
        }

        public final int getSenstivity(int i) {
            Integer[] convertDecimalToBinaryForMotionSensor = convertDecimalToBinaryForMotionSensor(i);
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer num : convertDecimalToBinaryForMotionSensor) {
                stringBuffer.append(num);
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "buffer.toString()");
            return convertBinaryToDecimal(stringBuffer2);
        }

        public final int convertBinaryToDecimal(String binary_number) {
            Intrinsics.checkNotNullParameter(binary_number, "binary_number");
            return Integer.parseInt(binary_number, CharsKt.checkRadix(2));
        }

        public final int getTemperature(int i) {
            Integer[] convertDecimalToBinaryForTempSensor = convertDecimalToBinaryForTempSensor(i);
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer num : convertDecimalToBinaryForTempSensor) {
                stringBuffer.append(num);
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "buffer.toString()");
            return convertBinaryToDecimal(stringBuffer2);
        }

        public final String getTimeStampTODate(String time) {
            Intrinsics.checkNotNullParameter(time, "time");
            long parseLong = Long.parseLong(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(parseLong);
            String format = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "formatter.format(calendar.time)");
            return format;
        }

        public final void showSnackBar(LinearLayout linearLayout, String str) {
            Intrinsics.checkNotNull(linearLayout);
            Intrinsics.checkNotNull(str);
            Snackbar make = Snackbar.make(linearLayout, str, 0);
            Intrinsics.checkNotNullExpressionValue(make, "make(layout!!, info!!, Snackbar.LENGTH_LONG)");
            make.show();
        }

        public final void showSnackBarForFragment(FrameLayout frameLayout, String str) {
            Intrinsics.checkNotNull(frameLayout);
            Intrinsics.checkNotNull(str);
            Snackbar make = Snackbar.make(frameLayout, str, 0);
            Intrinsics.checkNotNullExpressionValue(make, "make(layout!!, info!!, Snackbar.LENGTH_LONG)");
            make.show();
        }

        public final String bodyToString(RequestBody requestBody) {
            try {
                Buffer buffer = new Buffer();
                if (requestBody != null) {
                    requestBody.writeTo(buffer);
                    return buffer.readUtf8();
                }
                return "";
            } catch (IOException unused) {
                return "did not work";
            }
        }

        public final Bitmap scaleDown(Bitmap realImage, float f, boolean z) {
            Intrinsics.checkNotNullParameter(realImage, "realImage");
            float min = Math.min(f / realImage.getWidth(), f / realImage.getHeight());
            System.out.println((Object) ("image ratio" + min));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(realImage, Math.round(((float) realImage.getWidth()) * min), Math.round(min * ((float) realImage.getHeight())), z);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(realI…          height, filter)");
            return createScaledBitmap;
        }

        public final void isHotspotAvailable(Context context, String hotspotId, WIFIHandler handler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hotspotId, "hotspotId");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            wifiManager.setWifiEnabled(true);
            context.registerReceiver(WIFIReceiver(wifiManager, hotspotId, handler), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            wifiManager.startScan();
        }

        private final BroadcastReceiver WIFIReceiver(final WifiManager wifiManager, final String str, final WIFIHandler wIFIHandler) {
            GeneralService.mWifiScanReceiver = new BroadcastReceiver() { // from class: com.livpure.safedrink.bolt.service.GeneralService$Companion$WIFIReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context c, Intent intent) {
                    Intrinsics.checkNotNullParameter(c, "c");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    GeneralService.Companion.unregisterReceiver(c);
                    if (Intrinsics.areEqual(intent.getAction(), "android.net.wifi.SCAN_RESULTS")) {
                        for (ScanResult scanResult : wifiManager.getScanResults()) {
                            if (scanResult.SSID != null) {
                                String str2 = scanResult.SSID;
                                Intrinsics.checkNotNullExpressionValue(str2, "result.SSID");
                                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                                    wIFIHandler.handleResult(true);
                                    Log.e("ssidsxxxxx", scanResult.SSID);
                                    return;
                                }
                            }
                        }
                        wIFIHandler.handleResult(false);
                    }
                }
            };
            return GeneralService.mWifiScanReceiver;
        }

        public final void unregisterReceiver(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (GeneralService.mWifiScanReceiver != null) {
                    context.unregisterReceiver(GeneralService.mWifiScanReceiver);
                }
            } catch (IllegalArgumentException unused) {
                System.out.println((Object) "");
            }
        }

        public final String getConnectedWifi(WifiManager wifiManager) {
            Intrinsics.checkNotNullParameter(wifiManager, "wifiManager");
            String ssid = wifiManager.getConnectionInfo().getSSID();
            Intrinsics.checkNotNullExpressionValue(ssid, "info.ssid");
            return new Regex("^\"|\"$").replace(ssid, "");
        }

        public final boolean isGpsEnabled(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String provider = Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed");
            Intrinsics.checkNotNullExpressionValue(provider, "provider");
            return StringsKt.contains$default((CharSequence) provider, (CharSequence) "gps", false, 2, (Object) null);
        }

        public final boolean isWifiConnected(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
            Intrinsics.checkNotNull(networkInfo);
            return networkInfo.isConnected();
        }

        public final boolean isMobileDataEnabled(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                Object invoke = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]).invoke(telephonyManager, new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception e) {
                Log.e("msg", "Error getting mobile data state", e);
                return false;
            }
        }

        public final boolean isMobileDataOff(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
            Intrinsics.checkNotNull(networkInfo);
            return networkInfo.isConnected();
        }

        public final String getDeviceName() {
            String manufacturer = Build.MANUFACTURER;
            String model = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(model, "model");
            Intrinsics.checkNotNullExpressionValue(manufacturer, "manufacturer");
            if (StringsKt.startsWith$default(model, manufacturer, false, 2, (Object) null)) {
                return capitalize(model);
            }
            return capitalize(manufacturer) + SafeJsonPrimitive.NULL_CHAR + model;
        }

        private final String capitalize(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (char c : charArray) {
                if (z && Character.isLetter(c)) {
                    sb.append(Character.toUpperCase(c));
                    z = false;
                } else {
                    if (Character.isWhitespace(c)) {
                        z = true;
                    }
                    sb.append(c);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "phrase.toString()");
            return sb2;
        }
    }
}
