package com.livpure.safedrink.api;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.GsonBuilder;
import com.livpure.safedrink.LSHConfig;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: RelocationService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/api/RelocationService;", "", "baseUrl", "", "(Ljava/lang/String;)V", "<set-?>", "Lretrofit2/Retrofit$Builder;", "retrofitBuilder", "getRetrofitBuilder", "()Lretrofit2/Retrofit$Builder;", "APIInterfaceFactory", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class RelocationService {
    private static final String ACCEPT_KEY = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final Companion Companion = new Companion(null);
    private final String baseUrl;
    private Retrofit.Builder retrofitBuilder;

    public RelocationService() {
        this(null, 1, null);
    }

    public RelocationService(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Interceptor.Companion companion = Interceptor.Companion;
        builder.addInterceptor(new Interceptor() { // from class: com.livpure.safedrink.api.RelocationService$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkParameterIsNotNull(chain, "chain");
                Request.Builder addHeader = chain.request().newBuilder().addHeader("Accept", "application/json").addHeader("Content-Type", "application/json");
                if (LSApplication.Companion.getUser() != null) {
                    User user = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user);
                    addHeader.addHeader("Authorization", user.getToken());
                }
                return chain.proceed(addHeader.build());
            }
        }).readTimeout(15L, TimeUnit.SECONDS).connectTimeout(15L, TimeUnit.SECONDS);
        Retrofit.Builder baseUrl2 = new Retrofit.Builder().client(builder.build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).baseUrl(baseUrl);
        Intrinsics.checkNotNullExpressionValue(baseUrl2, "Builder()\n            .c…        .baseUrl(baseUrl)");
        this.retrofitBuilder = baseUrl2;
    }

    public /* synthetic */ RelocationService(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LSHConfig.BASE_RELOCATION_URL : str);
    }

    /* compiled from: RelocationService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/api/RelocationService$Companion;", "", "()V", "ACCEPT_KEY", "", "APPLICATION_JSON", "AUTHORIZATION", "CONTENT_TYPE", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Retrofit.Builder getRetrofitBuilder() {
        return this.retrofitBuilder;
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    private static final void m302_init_$lambda1(String str) {
        if (str == null) {
            str = "";
        }
        Log.d("curl", str);
    }

    /* compiled from: RelocationService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/api/RelocationService$APIInterfaceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Ljava/lang/Class;", "(Lcom/livpure/safedrink/api/RelocationService;Ljava/lang/Class;)V", "callAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "(Lcom/livpure/safedrink/api/RelocationService;Ljava/lang/Class;Lretrofit2/CallAdapter$Factory;)V", "getAPIInterface", "()Ljava/lang/Object;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class APIInterfaceFactory<T> {
        private final CallAdapter.Factory callAdapterFactory;
        final /* synthetic */ RelocationService this$0;
        private final Class<T> type;

        public APIInterfaceFactory(RelocationService relocationService, Class<T> type, CallAdapter.Factory callAdapterFactory) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
            this.this$0 = relocationService;
            this.type = type;
            this.callAdapterFactory = callAdapterFactory;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public APIInterfaceFactory(com.livpure.safedrink.api.RelocationService r3, java.lang.Class<T> r4) {
            /*
                r2 = this;
                java.lang.String r0 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory r0 = retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create()
                java.lang.String r1 = "create()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                retrofit2.CallAdapter$Factory r0 = (retrofit2.CallAdapter.Factory) r0
                r2.<init>(r3, r4, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.api.RelocationService.APIInterfaceFactory.<init>(com.livpure.safedrink.api.RelocationService, java.lang.Class):void");
        }

        public final T getAPIInterface() {
            return (T) this.this$0.getRetrofitBuilder().addCallAdapterFactory(this.callAdapterFactory).build().create(this.type);
        }
    }
}
