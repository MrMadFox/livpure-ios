package com.livpure.safedrink.subscription.address.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.subscription.address.data.model.SaveAddressRequest;
import com.livpure.safedrink.subscription.address.data.model.SavedAddressItem;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: AddressAPIService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/AddressAPIService;", "", "saveAddress", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/subscription/address/data/model/SavedAddressItem;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/subscription/address/data/model/SaveAddressRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AddressAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/v2/saveAddress")
    Flowable<BaseDataHolder<SavedAddressItem>> saveAddress(@Body SaveAddressRequest saveAddressRequest);

    /* compiled from: AddressAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/address/api/AddressAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAddressAPIService", "Lcom/livpure/safedrink/subscription/address/api/AddressAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final AddressAPIService getAddressAPIService() {
            return (AddressAPIService) new APIService.APIInterfaceFactory(this, AddressAPIService.class).getAPIInterface();
        }
    }
}
