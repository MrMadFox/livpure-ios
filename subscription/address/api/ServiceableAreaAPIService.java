package com.livpure.safedrink.subscription.address.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaRequest;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
/* compiled from: ServiceableAreaAPIService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ4\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\tH'¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/ServiceableAreaAPIService;", "", "getMappedAreas", "Lio/reactivex/Flowable;", "", "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaRequest;", "url", "", "entryPoint", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServiceableAreaAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST
    Flowable<List<ServiceableAreaItem>> getMappedAreas(@Body ServiceableAreaRequest serviceableAreaRequest, @Url String str, @Query("entryPoint") String str2);

    /* compiled from: ServiceableAreaAPIService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Flowable getMappedAreas$default(ServiceableAreaAPIService serviceableAreaAPIService, ServiceableAreaRequest serviceableAreaRequest, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "https://customer.livcrm.com/index.php/";
                }
                if ((i & 4) != 0) {
                    str2 = "Drona";
                }
                return serviceableAreaAPIService.getMappedAreas(serviceableAreaRequest, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMappedAreas");
        }
    }

    /* compiled from: ServiceableAreaAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/ServiceableAreaAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAreaAPIService", "Lcom/livpure/safedrink/subscription/address/api/ServiceableAreaAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final ServiceableAreaAPIService getAreaAPIService() {
            return (ServiceableAreaAPIService) new APIService.APIInterfaceFactory(this, ServiceableAreaAPIService.class).getAPIInterface();
        }
    }
}
