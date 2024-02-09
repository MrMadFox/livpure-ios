package com.livpure.safedrink.bolt.wifi;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.livpure.safedrink.bolt.api.WifiCommunicator;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Client.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J$\u0010\u0015\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u0017\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J \u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/livpure/safedrink/bolt/wifi/Client;", "", "host", "", "port", "", "ssid", "password", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "communicator", "Lcom/livpure/safedrink/bolt/api/WifiCommunicator;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/livpure/safedrink/bolt/api/WifiCommunicator;)V", "handleConnectCompleted", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "socket", "Lcom/koushikdutta/async/AsyncSocket;", "wifiSSID", "handleResultForCOnnection", "isConnect", "handleResultForPwd", "pwd", "setup", "setupforConnect", "setupforPwd", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Client {
    private final WifiCommunicator communicator;
    private final Context context;
    private final String host;
    private final String password;
    private final int port;
    private final String ssid;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForCOnnection$lambda-12  reason: not valid java name */
    public static final void m527handleResultForCOnnection$lambda12(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
    }

    public Client(String host, int i, String ssid, String password, Context context, WifiCommunicator communicator) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(communicator, "communicator");
        this.host = host;
        this.port = i;
        this.ssid = ssid;
        this.password = password;
        this.context = context;
        this.communicator = communicator;
        setup(ssid, password, "1");
    }

    private final void setup(final String str, String str2, String str3) {
        AsyncServer.getDefault().connectSocket(new InetSocketAddress(this.host, this.port), new ConnectCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda14
            @Override // com.koushikdutta.async.callback.ConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                Client.m534setup$lambda0(Client.this, str, exc, asyncSocket);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setup$lambda-0  reason: not valid java name */
    public static final void m534setup$lambda0(Client this$0, String wifiSSID, Exception ex, AsyncSocket asyncSocket) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(wifiSSID, "$wifiSSID");
        Log.e("connected", "succes");
        if (asyncSocket != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(ex, "ex");
                this$0.handleConnectCompleted(ex, asyncSocket, wifiSSID);
                return;
            } catch (NullPointerException unused) {
                this$0.communicator.respond("Fail");
                return;
            }
        }
        this$0.communicator.respond("Fail");
    }

    private final void setupforPwd(String str, final String str2, String str3) {
        AsyncServer.getDefault().connectSocket(new InetSocketAddress(this.host, this.port), new ConnectCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda2
            @Override // com.koushikdutta.async.callback.ConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                Client.m536setupforPwd$lambda1(Client.this, str2, exc, asyncSocket);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupforPwd$lambda-1  reason: not valid java name */
    public static final void m536setupforPwd$lambda1(Client this$0, String pwd, Exception ex, AsyncSocket socket) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pwd, "$pwd");
        Log.e("connected", "succes");
        try {
            Intrinsics.checkNotNullExpressionValue(ex, "ex");
            Intrinsics.checkNotNullExpressionValue(socket, "socket");
            this$0.handleResultForPwd(ex, socket, pwd);
        } catch (NullPointerException unused) {
            this$0.communicator.respond("Fail");
        }
    }

    private final void setupforConnect(String str, String str2, final String str3) {
        AsyncServer.getDefault().connectSocket(new InetSocketAddress(this.host, this.port), new ConnectCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda1
            @Override // com.koushikdutta.async.callback.ConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                Client.m535setupforConnect$lambda2(Client.this, str3, exc, asyncSocket);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupforConnect$lambda-2  reason: not valid java name */
    public static final void m535setupforConnect$lambda2(Client this$0, String isConnect, Exception ex, AsyncSocket socket) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isConnect, "$isConnect");
        Log.e("connected", "succes");
        try {
            Intrinsics.checkNotNullExpressionValue(ex, "ex");
            Intrinsics.checkNotNullExpressionValue(socket, "socket");
            this$0.handleResultForCOnnection(ex, socket, isConnect);
        } catch (NullPointerException unused) {
            this$0.communicator.respond("Fail");
        }
    }

    private final void handleConnectCompleted(Exception exc, AsyncSocket asyncSocket, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (str.length() <= 9) {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(str.length());
                jSONObject.put("TB", sb.toString());
            } else {
                jSONObject.put("TB", String.valueOf(str.length()));
            }
            jSONObject.put("SSID", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject.toString());
        try {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "`object`.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            Util.writeAll(asyncSocket, bytes, new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda7
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc2) {
                    Client.m522handleConnectCompleted$lambda3(exc2);
                }
            });
        } catch (NullPointerException unused) {
            this.communicator.respond("Fail");
        }
        asyncSocket.setDataCallback(new DataCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda4
            @Override // com.koushikdutta.async.callback.DataCallback
            public final void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                Client.m523handleConnectCompleted$lambda4(Client.this, dataEmitter, byteBufferList);
            }
        });
        asyncSocket.setClosedCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda13
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m524handleConnectCompleted$lambda5(exc2);
            }
        });
        asyncSocket.setEndCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda11
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m525handleConnectCompleted$lambda6(exc2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleConnectCompleted$lambda-3  reason: not valid java name */
    public static final void m522handleConnectCompleted$lambda3(Exception exc) {
        System.out.println((Object) "[Client] Successfully wrote message");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleConnectCompleted$lambda-4  reason: not valid java name */
    public static final void m523handleConnectCompleted$lambda4(Client this$0, DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("[Client] Received Message ");
        byte[] allByteArray = byteBufferList.getAllByteArray();
        Intrinsics.checkNotNullExpressionValue(allByteArray, "bb.allByteArray");
        sb.append(new String(allByteArray, Charsets.UTF_8));
        System.out.println((Object) sb.toString());
        this$0.setupforPwd(this$0.ssid, this$0.password, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleConnectCompleted$lambda-5  reason: not valid java name */
    public static final void m524handleConnectCompleted$lambda5(Exception exc) {
        System.out.println((Object) "[Client] Successfully closed connection");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleConnectCompleted$lambda-6  reason: not valid java name */
    public static final void m525handleConnectCompleted$lambda6(Exception exc) {
        System.out.println((Object) "[Client] Successfully end connection");
    }

    private final void handleResultForPwd(Exception exc, AsyncSocket asyncSocket, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (str.length() <= 9) {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(str.length());
                jSONObject.put("TB", sb.toString());
            } else {
                jSONObject.put("TB", String.valueOf(str.length()));
            }
            jSONObject.put("PASS", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject.toString());
        try {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "`object`.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            Util.writeAll(asyncSocket, bytes, new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda12
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc2) {
                    Client.m531handleResultForPwd$lambda7(exc2);
                }
            });
        } catch (NullPointerException unused) {
            this.communicator.respond("Fail");
        }
        asyncSocket.setDataCallback(new DataCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda3
            @Override // com.koushikdutta.async.callback.DataCallback
            public final void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                Client.m532handleResultForPwd$lambda8(Client.this, dataEmitter, byteBufferList);
            }
        });
        asyncSocket.setClosedCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda6
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m533handleResultForPwd$lambda9(exc2);
            }
        });
        asyncSocket.setEndCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda10
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m530handleResultForPwd$lambda10(exc2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForPwd$lambda-7  reason: not valid java name */
    public static final void m531handleResultForPwd$lambda7(Exception exc) {
        System.out.println((Object) "[Client] Successfully wrote message");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForPwd$lambda-8  reason: not valid java name */
    public static final void m532handleResultForPwd$lambda8(Client this$0, DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("[Client] Received Message ");
        byte[] allByteArray = byteBufferList.getAllByteArray();
        Intrinsics.checkNotNullExpressionValue(allByteArray, "bb.allByteArray");
        sb.append(new String(allByteArray, Charsets.UTF_8));
        System.out.println((Object) sb.toString());
        this$0.setupforConnect(this$0.ssid, this$0.password, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForPwd$lambda-9  reason: not valid java name */
    public static final void m533handleResultForPwd$lambda9(Exception exc) {
        System.out.println((Object) "[Client] Successfully closed connection");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForPwd$lambda-10  reason: not valid java name */
    public static final void m530handleResultForPwd$lambda10(Exception exc) {
        System.out.println((Object) "[Client] Successfully end connection");
    }

    private final void handleResultForCOnnection(Exception exc, AsyncSocket asyncSocket, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TB", "01");
            jSONObject.put("STMD", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject.toString());
        try {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "`object`.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            Util.writeAll(asyncSocket, bytes, new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda9
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc2) {
                    Client.m526handleResultForCOnnection$lambda11(exc2);
                }
            });
        } catch (NullPointerException unused) {
            this.communicator.respond("Fail");
        }
        asyncSocket.setDataCallback(new DataCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda5
            @Override // com.koushikdutta.async.callback.DataCallback
            public final void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                Client.m527handleResultForCOnnection$lambda12(dataEmitter, byteBufferList);
            }
        });
        asyncSocket.setClosedCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda8
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m528handleResultForCOnnection$lambda13(exc2);
            }
        });
        asyncSocket.setEndCallback(new CompletedCallback() { // from class: com.livpure.safedrink.bolt.wifi.Client$$ExternalSyntheticLambda0
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc2) {
                Client.m529handleResultForCOnnection$lambda14(Client.this, exc2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForCOnnection$lambda-11  reason: not valid java name */
    public static final void m526handleResultForCOnnection$lambda11(Exception exc) {
        System.out.println((Object) "[Client] Successfully wrote message");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForCOnnection$lambda-13  reason: not valid java name */
    public static final void m528handleResultForCOnnection$lambda13(Exception exc) {
        System.out.println((Object) "[Client] Successfully closed connection");
        Log.e("msg", "transfered successfully");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResultForCOnnection$lambda-14  reason: not valid java name */
    public static final void m529handleResultForCOnnection$lambda14(Client this$0, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.communicator.respond("success");
        System.out.println((Object) "[Client] Successfully end connection");
    }
}
