package com.livpure.safedrink.api;

import com.livpure.safedrink.api.APIService;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
/* compiled from: DummyAPIService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H'¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/api/DummyAPIService;", "", "getDummyResponse", "Lio/reactivex/Observable;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DummyAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @GET("5e12e3273100006600d47430")
    Observable<Object> getDummyResponse();

    /* compiled from: DummyAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/api/DummyAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getDummyAPIInterface", "Lcom/livpure/safedrink/api/DummyAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(" http://www.mocky.io/v2/");
        }

        public final DummyAPIService getDummyAPIInterface() {
            return (DummyAPIService) new APIService.APIInterfaceFactory(this, DummyAPIService.class).getAPIInterface();
        }
    }
}
