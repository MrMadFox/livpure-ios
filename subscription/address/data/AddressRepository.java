package com.livpure.safedrink.subscription.address.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.address.api.AddressAPIService;
import com.livpure.safedrink.subscription.address.data.model.SaveAddressRequest;
import com.livpure.safedrink.subscription.address.data.model.SavedAddressItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AddressRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JN\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/AddressRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/subscription/address/api/AddressAPIService;", "getApiService", "()Lcom/livpure/safedrink/subscription/address/api/AddressAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "saveAddress", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/subscription/address/data/model/SavedAddressItem;", "address", "", "pinCode", "city", "area", "hubCode", "state", "alternatePhoneNumber", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<AddressAPIService>() { // from class: com.livpure.safedrink.subscription.address.data.AddressRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AddressAPIService invoke() {
            return AddressAPIService.Factory.getAddressAPIService();
        }
    });

    private final AddressAPIService getApiService() {
        return (AddressAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<SavedAddressItem>> saveAddress(String address, String pinCode, String city, String area, String hubCode, String state, String str) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(hubCode, "hubCode");
        Intrinsics.checkNotNullParameter(state, "state");
        User user = LSApplication.Companion.getUser();
        AddressAPIService apiService = getApiService();
        Intrinsics.checkNotNull(user);
        String id = user.getId();
        String email = user.getEmail();
        Intrinsics.checkNotNull(email);
        String mobile = user.getMobile();
        Intrinsics.checkNotNull(mobile);
        LiveData<BaseDataHolder<SavedAddressItem>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(apiService.saveAddress(new SaveAddressRequest(id, email, mobile, city, pinCode, area, address, hubCode, state, str))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}
