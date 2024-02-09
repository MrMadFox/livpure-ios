package com.livpure.safedrink.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.livpure.safedrink.R;
import com.moengage.core.internal.CoreConstants;
import com.newrelic.agent.android.harvest.HarvestTimer;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
/* loaded from: classes3.dex */
public class AppUtils {
    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static void showDefaultAlert(Context context, String msg) {
        new AlertDialog.Builder(context).setTitle("").setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.utils.AppUtils$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showToast(Context mContext, String message) {
        try {
            Toast.makeText(mContext, message, 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager == null || activity.getCurrentFocus() == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer[] convertDecimalToBinary(int decimal_number) {
        ArrayList arrayList = new ArrayList();
        while (decimal_number > 0) {
            arrayList.add(Integer.valueOf(decimal_number % 2));
            decimal_number /= 2;
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
        for (int i = 0; i < arrayList.size(); i++) {
            numArr[i] = (Integer) arrayList.get(i);
        }
        return numArr;
    }

    public static Integer[] convertDecimalToBinaryForTempSensor(int decimal_number) {
        ArrayList arrayList = new ArrayList();
        while (decimal_number > 0) {
            arrayList.add(Integer.valueOf(decimal_number % 2));
            decimal_number /= 2;
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
        for (int i = 0; i < arrayList.size() - 1; i++) {
            numArr[i] = (Integer) arrayList.get(i);
        }
        return numArr;
    }

    public static Integer[] convertDecimalToBinaryForMotionSensor(int decimal_number) {
        ArrayList arrayList = new ArrayList();
        while (decimal_number > 0) {
            arrayList.add(Integer.valueOf(decimal_number % 2));
            decimal_number /= 2;
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
        for (int i = 0; i < arrayList.size() - 2; i++) {
            numArr[i] = (Integer) arrayList.get(i);
        }
        return numArr;
    }

    public static int getOnOffSwitchState(int decimal_number) {
        Integer[] convertDecimalToBinary = convertDecimalToBinary(decimal_number);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < convertDecimalToBinary.length; i2++) {
            stringBuffer.append(convertDecimalToBinary[i2]);
            if (i2 == 6) {
                i = convertDecimalToBinary[i2].intValue();
            }
        }
        return i;
    }

    public static int getMotionState(int decimal_number) {
        Integer[] convertDecimalToBinary = convertDecimalToBinary(decimal_number);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < convertDecimalToBinary.length; i2++) {
            stringBuffer.append(convertDecimalToBinary[i2]);
            if (i2 == 6) {
                i = convertDecimalToBinary[i2].intValue();
            }
        }
        return i;
    }

    public static int getSenstivity(int decimal_number) {
        Integer[] convertDecimalToBinaryForMotionSensor = convertDecimalToBinaryForMotionSensor(decimal_number);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer num : convertDecimalToBinaryForMotionSensor) {
            stringBuffer.append(num);
        }
        return convertBinaryToDecimal(stringBuffer.toString());
    }

    public static int convertBinaryToDecimal(String binary_number) {
        return Integer.parseInt(binary_number, 2);
    }

    public static int getTemperature(int state) {
        Integer[] convertDecimalToBinaryForTempSensor = convertDecimalToBinaryForTempSensor(state);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer num : convertDecimalToBinaryForTempSensor) {
            stringBuffer.append(num);
        }
        return convertBinaryToDecimal(stringBuffer.toString());
    }

    public static String getTimeStampTODate(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long parseLong = Long.parseLong(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(parseLong);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static void hide_keyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static long getDifference(Date startDate, Date endDate) {
        long time = endDate.getTime() - startDate.getTime();
        PrintStream printStream = System.out;
        printStream.println("startDate : " + startDate);
        PrintStream printStream2 = System.out;
        printStream2.println("endDate : " + endDate);
        PrintStream printStream3 = System.out;
        printStream3.println("different : " + time);
        long j = time / 86400000;
        long j2 = time % 86400000;
        long j3 = j2 / CoreConstants.CONFIG_API_SYNC_DELAY;
        long j4 = j2 % CoreConstants.CONFIG_API_SYNC_DELAY;
        System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j4 / HarvestTimer.DEFAULT_HARVEST_PERIOD), Long.valueOf((j4 % HarvestTimer.DEFAULT_HARVEST_PERIOD) / 1000));
        return j;
    }

    public static void showMsgAlert(Context context, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg).setCancelable(false).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        create.show();
        ((TextView) create.findViewById(16908299)).setGravity(17);
        TextView textView = (TextView) create.findViewById(context.getResources().getIdentifier("alertTitle", "id", "android"));
        if (textView != null) {
            textView.setGravity(17);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        create.getButton(-2).setLayoutParams(layoutParams);
    }
}
