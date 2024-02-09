package com.livpure.safedrink.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.livpure.safedrink.app.LSApplication;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionStateMonitor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/api/ConnectionStateMonitor;", "Landroid/net/ConnectivityManager$NetworkCallback;", "()V", "networkRequest", "Landroid/net/NetworkRequest;", "getNetworkRequest", "()Landroid/net/NetworkRequest;", "networkRequest$delegate", "Lkotlin/Lazy;", "enable", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onLost", AndroidContextPlugin.NETWORK_KEY, "Landroid/net/Network;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionStateMonitor extends ConnectivityManager.NetworkCallback {
    private final Lazy networkRequest$delegate = LazyKt.lazy(new Function0<NetworkRequest>() { // from class: com.livpure.safedrink.api.ConnectionStateMonitor$networkRequest$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NetworkRequest invoke() {
            return new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
        }
    });

    private final NetworkRequest getNetworkRequest() {
        Object value = this.networkRequest$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-networkRequest>(...)");
        return (NetworkRequest) value;
    }

    public final void enable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).registerNetworkCallback(getNetworkRequest(), this);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        LSApplication.Companion.setNetworkAvailable(false);
        super.onLost(network);
    }
}
