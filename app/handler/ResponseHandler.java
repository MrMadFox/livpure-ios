package com.livpure.safedrink.app.handler;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.iid.GmsRpc;
import com.google.gson.JsonSyntaxException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;
/* compiled from: ResponseHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00012\n\u0010\n\u001a\u00060\u000bj\u0002`\fJ#\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u000e\u001a\u0002H\t¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/app/handler/ResponseHandler;", "", "()V", "getErrorMessage", "", "code", "", "handleException", "Lcom/livpure/safedrink/app/handler/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleSuccess", "data", "(Ljava/lang/Object;)Lcom/livpure/safedrink/app/handler/Resource;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ResponseHandler {
    public static final int API_NOT_FOUND = 404;
    public static final Companion Companion = new Companion(null);
    public static final int INCORRECT_FORMAT = 1000;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NO_CONNECTION = 1002;
    public static final int REQUEST_TIME_OUT = 408;
    public static final int SOCKET_TIME_OUT = 409;
    public static final int UN_AUTHORISED = 401;
    public static final int UN_KNOWN_HOST = 1001;

    private final String getErrorMessage(int i) {
        if (i != 401) {
            if (i != 404) {
                if (i != 500) {
                    if (i == 408 || i == 409) {
                        return "Sorry, Request Time-out";
                    }
                    switch (i) {
                        case 1000:
                            return "Sorry, Invalid response..";
                        case 1001:
                        case 1002:
                            return "Please check your Internet Connection";
                        default:
                            return "Something went wrong, Please try again..";
                    }
                }
                return "Internal Server Error";
            }
            return "Sorry, Unable to find the link..";
        }
        return "Unauthorised User";
    }

    /* compiled from: ResponseHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/app/handler/ResponseHandler$Companion;", "", "()V", "API_NOT_FOUND", "", "INCORRECT_FORMAT", GmsRpc.ERROR_INTERNAL_SERVER_ERROR, "NO_CONNECTION", "REQUEST_TIME_OUT", "SOCKET_TIME_OUT", "UN_AUTHORISED", "UN_KNOWN_HOST", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final <T> Resource<T> handleSuccess(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Resource.Companion.success(data);
    }

    public final <T> Resource<T> handleException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return e instanceof HttpException ? Resource.Companion.error(getErrorMessage(((HttpException) e).code()), null) : e instanceof UnknownHostException ? Resource.Companion.error(getErrorMessage(1001), null) : e instanceof ConnectException ? Resource.Companion.error(getErrorMessage(1002), null) : e instanceof TimeoutException ? Resource.Companion.error(getErrorMessage(REQUEST_TIME_OUT), null) : e instanceof SocketTimeoutException ? Resource.Companion.error(getErrorMessage(409), null) : e instanceof JsonSyntaxException ? Resource.Companion.error(getErrorMessage(1000), null) : e instanceof InternalError ? Resource.Companion.error(getErrorMessage(500), null) : Resource.Companion.error(getErrorMessage(Integer.MAX_VALUE), null);
    }
}
