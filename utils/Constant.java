package com.livpure.safedrink.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Constant.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/livpure/safedrink/utils/Constant;", "", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Constant {
    public static final String AADHAR_BACK = "aadharBackImage";
    public static final String AADHAR_FRONT = "aadharFrontImage";
    public static final String ADDRESS_BACK_IMAGE = "addressBackImage";
    public static final String ADDRESS_FRONT_IMAGE = "addressFrontImage";
    public static final String ADDRESS_PROOF_BACK = "addressProofBack";
    public static final String ADDRESS_PROOF_FRONT = "addressProofFront";
    public static final String AFTER_FIX_CONTAINER_IMAGE = "afterFixContainerImage";
    public static final String AGREEMENT_PAGE_1 = "agreementPage1";
    public static final String AGREEMENT_PAGE_2 = "agreementPage2";
    public static final String AGREEMENT_PAGE_3 = "agreementPage3";
    public static final String AGREEMENT_PAGE_4 = "agreementPage4";
    public static final float ALPHA_DISABLED = 0.38f;
    public static final String AVAILABLE = "Available";
    public static final int BAR_CODE_SCANNER = 1001;
    public static final int BLUETOOTH_REQUEST_CODE = 1001;
    public static final int CALL_PERMISSION = 105;
    public static final int CAMERA_PERMISSION = 101;
    public static final int CAMERA_PICTURE = 201;
    public static final String CHEQUE_IMAGE = "chequeImage";
    public static final int CONTACT_PERMISSION = 104;
    public static final String COUNT = "COUNT";
    public static final String COUNTRY = "in";
    public static final Companion Companion = new Companion(null);
    public static final String DAILY = "Daily";
    public static final long DELAY_TIME = 2000;
    public static final String DRIVING_LICENCE_BACK = "dlBackImage";
    public static final String DRIVING_LICENCE_FRONT = "dlFrontImage";
    public static final String ELECTRICITY_BILL = "electricityBillImage";
    public static final int ERROR_CODE = 1000;
    public static final String FAILED_STATUS = "failed";
    public static final String FAILURE_STATUS = "faliure";
    public static final String FAQ = "FAQ";
    public static final String FILE_KEY = "file";
    public static final int FOLDER_DOCUMENT = 203;
    public static final String FRAGMENT_REQUEST_CODE = "fragment:requestCode";
    public static final int FROM_ACCOUNTANT_KYC = 312;
    public static final int FROM_ACCOUNTANT_TOP_UP = 308;
    public static final int FROM_DROP = 311;
    public static final int FROM_KYC_MANAGER_APPROVE = 313;
    public static final int FROM_LAB_MANAGER_KYC_LIST = 312;
    public static final int FROM_LOGIN = 300;
    public static final int FROM_LOGIN_FORGOT = 304;
    public static final int FROM_MAINTENANCE_VEHICLE = 317;
    public static final int FROM_NEW_TICKET = 306;
    public static final int FROM_NOTIFICATION = 302;
    public static final int FROM_OTP = 301;
    public static final int FROM_PICKUP = 310;
    public static final int FROM_REGISTRATION = 303;
    public static final int FROM_REPLACE_BATTERY = 305;
    public static final int FROM_REPLACE_BATTERY_SCAN = 310;
    public static final int FROM_REPLACE_FAULT_BATTERY_SCAN = 314;
    public static final int FROM_REPLACE_NEW_BATTERY_SCAN = 315;
    public static final int FROM_SECURITY_DRIVER = 307;
    public static final int FROM_SERVICE_VEHICLE = 316;
    public static final int FROM_SWAP_BATTERY_SCAN = 311;
    public static final int FROM_TECH_BATTERY_ALLOCATION = 309;
    public static final int GALLERY_PICTURE = 202;
    public static final int GOOGLE_SIGN_IN = 7;
    public static final String IDENTITY_BACK_IMAGE = "identityBackImage";
    public static final String IDENTITY_FRONT_IMAGE = "identityFrontImage";
    public static final String IDENTITY_PROOF_BACK = "idProofBack";
    public static final String IDENTITY_PROOF_FRONT = "idProofFront";
    public static final String IMAGE_URI = "image_uri";
    private static boolean IsPaymentFailed = false;
    public static final String KEY_LOCATION = "location";
    public static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates";
    public static final String KYC_VIEW_STATUS = "KYC_VIEW_STATUS";
    public static final String LATITUDE = "LATITUDE";
    public static final int LOAD_LIMIT = 15;
    public static final long LOCATION_INTERVAL = 10000;
    public static final int LOCATION_PERMISSION = 102;
    public static final String LOCATION_PICK_STATUS = "LOCATION_PICK_STATUS";
    public static final int LOCATION_SETTING_PERMISSION = 103;
    public static final String LONGITUDE = "LONGITUDE";
    public static final String MAIL_DOCUMENT = "mailDocument";
    public static final String MANDATORY_UPDATE = "Mandatory Update";
    public static final String MONTHLY = "Monthly";
    public static final String NO_BALANCE = "noBalance";
    public static final int NO_NETWORK_ERROR_CODE = 1001;
    public static final String NO_UPDATE = "No Update";
    public static final String PAN_CARD_FRONT = "panCardFrontImage";
    public static final String PASSBOOK_IMAGE = "passBookImage";
    public static final int PHONE_HINT_REQUEST = 400;
    public static final String POSITION = "POSITION";
    public static final String PROFILE_FRONT = "profileImage";
    public static final int RADIUS_RANGE = 5000;
    public static final int REQUEST_CHECK_SETTINGS = 1;
    public static final int RESULT_REQUEST_CODE = 1000;
    public static final String SCANNER_TITLE = "SCANNER_TITLE";
    public static final String SCANNER_TYPE = "SCANNER_TYPE";
    public static final String SCAN_BATTERY_TITLE = "Scan Battery QR Code";
    public static final String SCAN_DRIVER_TITLE = "Scan Driver QR Code";
    public static final String SCAN_FAULT_BATTERY_TITLE = "Scan Fault Battery QR Code";
    public static final String SCAN_NEW_BATTERY_TITLE = "Scan New Battery QR Code";
    public static final long SCAN_PERIOD = 10000;
    public static final String SCAN_RESULT = "SCAN_RESULT";
    public static final String SELFIE = "FILE_SELFIE";
    public static final String SING_UP_LINK = "Sign Up";
    public static final String SUCCESS_STATUS = "success";
    public static final String TERMS_AND_CONDITIONS = "Terms And Conditions";
    public static final String TERMS_OF_USE = "Terms of Use";
    public static final String TIME_OUT = "TIME_OUT";
    public static final String WEEKLY = "Weekly";

    @JvmStatic
    public static final String getStringResource(Context context, int i) {
        return Companion.getStringResource(context, i);
    }

    /* compiled from: Constant.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010r\u001a\u00020\u00042\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/livpure/safedrink/utils/Constant$Companion;", "", "()V", "AADHAR_BACK", "", "AADHAR_FRONT", "ADDRESS_BACK_IMAGE", "ADDRESS_FRONT_IMAGE", "ADDRESS_PROOF_BACK", "ADDRESS_PROOF_FRONT", "AFTER_FIX_CONTAINER_IMAGE", "AGREEMENT_PAGE_1", "AGREEMENT_PAGE_2", "AGREEMENT_PAGE_3", "AGREEMENT_PAGE_4", "ALPHA_DISABLED", "", "AVAILABLE", "BAR_CODE_SCANNER", "", "BLUETOOTH_REQUEST_CODE", "CALL_PERMISSION", "CAMERA_PERMISSION", "CAMERA_PICTURE", "CHEQUE_IMAGE", "CONTACT_PERMISSION", Constant.COUNT, "COUNTRY", "DAILY", "DELAY_TIME", "", "DRIVING_LICENCE_BACK", "DRIVING_LICENCE_FRONT", "ELECTRICITY_BILL", "ERROR_CODE", "FAILED_STATUS", "FAILURE_STATUS", Constant.FAQ, "FILE_KEY", "FOLDER_DOCUMENT", "FRAGMENT_REQUEST_CODE", "FROM_ACCOUNTANT_KYC", "FROM_ACCOUNTANT_TOP_UP", "FROM_DROP", "FROM_KYC_MANAGER_APPROVE", "FROM_LAB_MANAGER_KYC_LIST", "FROM_LOGIN", "FROM_LOGIN_FORGOT", "FROM_MAINTENANCE_VEHICLE", "FROM_NEW_TICKET", "FROM_NOTIFICATION", "FROM_OTP", "FROM_PICKUP", "FROM_REGISTRATION", "FROM_REPLACE_BATTERY", "FROM_REPLACE_BATTERY_SCAN", "FROM_REPLACE_FAULT_BATTERY_SCAN", "FROM_REPLACE_NEW_BATTERY_SCAN", "FROM_SECURITY_DRIVER", "FROM_SERVICE_VEHICLE", "FROM_SWAP_BATTERY_SCAN", "FROM_TECH_BATTERY_ALLOCATION", "GALLERY_PICTURE", "GOOGLE_SIGN_IN", "IDENTITY_BACK_IMAGE", "IDENTITY_FRONT_IMAGE", "IDENTITY_PROOF_BACK", "IDENTITY_PROOF_FRONT", "IMAGE_URI", "IsPaymentFailed", "", "getIsPaymentFailed", "()Z", "setIsPaymentFailed", "(Z)V", "KEY_LOCATION", "KEY_REQUESTING_LOCATION_UPDATES", Constant.KYC_VIEW_STATUS, Constant.LATITUDE, "LOAD_LIMIT", "LOCATION_INTERVAL", "LOCATION_PERMISSION", Constant.LOCATION_PICK_STATUS, "LOCATION_SETTING_PERMISSION", Constant.LONGITUDE, "MAIL_DOCUMENT", "MANDATORY_UPDATE", "MONTHLY", "NO_BALANCE", "NO_NETWORK_ERROR_CODE", "NO_UPDATE", "PAN_CARD_FRONT", "PASSBOOK_IMAGE", "PHONE_HINT_REQUEST", Constant.POSITION, "PROFILE_FRONT", "RADIUS_RANGE", "REQUEST_CHECK_SETTINGS", "RESULT_REQUEST_CODE", Constant.SCANNER_TITLE, Constant.SCANNER_TYPE, "SCAN_BATTERY_TITLE", "SCAN_DRIVER_TITLE", "SCAN_FAULT_BATTERY_TITLE", "SCAN_NEW_BATTERY_TITLE", "SCAN_PERIOD", Constant.SCAN_RESULT, "SELFIE", "SING_UP_LINK", "SUCCESS_STATUS", "TERMS_AND_CONDITIONS", "TERMS_OF_USE", Constant.TIME_OUT, "WEEKLY", "getStringResource", "mContext", "Landroid/content/Context;", "stringResource", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getIsPaymentFailed() {
            return Constant.IsPaymentFailed;
        }

        public final void setIsPaymentFailed(boolean z) {
            Constant.IsPaymentFailed = z;
        }

        @JvmStatic
        public final String getStringResource(Context mContext, int i) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            String string = mContext.getResources().getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getString(stringResource)");
            return string;
        }
    }
}
