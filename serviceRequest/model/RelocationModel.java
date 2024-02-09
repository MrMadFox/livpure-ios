package com.livpure.safedrink.serviceRequest.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.data.RelocationRepository;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeRequest;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeResponse;
import com.livpure.safedrink.serviceRequest.data.model.CityList;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanRequest;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanResponse;
import com.livpure.safedrink.serviceRequest.data.model.UpdateAddressRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: RelocationModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050&0\u0004J\u0006\u0010'\u001a\u00020\u0012J\u0018\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u0014J\b\u0010,\u001a\u00020)H\u0002J\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014J\u0006\u0010\"\u001a\u00020)R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007¨\u0006/"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/RelocationModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "addressLine1", "Landroidx/lifecycle/MutableLiveData;", "", "getAddressLine1", "()Landroidx/lifecycle/MutableLiveData;", "addressLine2", "getAddressLine2", "area", "getArea", "city", "getCity", "cityData", "", "Lcom/livpure/safedrink/serviceRequest/data/model/CityList;", "isFormComplete", "", "listOfAreas", "Landroidx/lifecycle/LiveData;", "newPlan", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanResponse;", "pickupType", "getPickupType", "pinCode", "getPinCode", "relocationRepository", "Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "getRelocationRepository", "()Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "relocationRepository$delegate", "Lkotlin/Lazy;", "selectedState", "updateAddress", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "getUpdateAddress", "getToastObserver", "Lcom/livpure/safedrink/common/arc/Event;", "isFormValidated", "loadAreaSpinner", "", "listOfAreaItems", "populateAreasWhenAvailable", "resetAreaSpinner", "showNewPlan", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RelocationModel extends MediatorViewModel {
    public static final Companion Companion = new Companion(null);
    private static final String PINCODE_BEFORE_AREA_MESSAGE = "Please enter a valid pincode first";
    private final MutableLiveData<String> addressLine1;
    private final MutableLiveData<String> addressLine2;
    private final MutableLiveData<String> area;
    private final MutableLiveData<String> city;
    private final MutableLiveData<List<CityList>> cityData;
    private final MutableLiveData<Boolean> isFormComplete;
    private final LiveData<List<String>> listOfAreas;
    private final MutableLiveData<NewPlanResponse> newPlan;
    private final MutableLiveData<String> pickupType;
    private final MutableLiveData<String> pinCode;
    private final Lazy relocationRepository$delegate = LazyKt.lazy(new Function0<RelocationRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$relocationRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationRepository invoke() {
            return new RelocationRepository();
        }
    });
    private String selectedState;
    private final MutableLiveData<BaseV1Response> updateAddress;

    public RelocationModel() {
        MutableLiveData<List<CityList>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(null);
        this.cityData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(false);
        this.isFormComplete = mutableLiveData2;
        this.newPlan = new MutableLiveData<>();
        this.updateAddress = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData3, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1168pinCode$lambda4$lambda3(RelocationModel.this, (String) obj);
            }
        });
        this.pinCode = mutableLiveData3;
        this.selectedState = "";
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData4, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1164area$lambda6$lambda5(RelocationModel.this, (String) obj);
            }
        });
        this.area = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData5, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1165city$lambda8$lambda7(RelocationModel.this, (String) obj);
            }
        });
        this.city = mutableLiveData5;
        LiveData<List<String>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List m1166listOfAreas$lambda11;
                m1166listOfAreas$lambda11 = RelocationModel.m1166listOfAreas$lambda11(RelocationModel.this, (List) obj);
                return m1166listOfAreas$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(cityData) {\n        …}\n        areasList\n    }");
        this.listOfAreas = map;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData6, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1162addressLine1$lambda14$lambda13(RelocationModel.this, (String) obj);
            }
        });
        this.addressLine1 = mutableLiveData6;
        MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData7, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1163addressLine2$lambda16$lambda15(RelocationModel.this, (String) obj);
            }
        });
        this.addressLine2 = mutableLiveData7;
        MutableLiveData<String> mutableLiveData8 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData8, new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationModel.m1167pickupType$lambda18$lambda17(RelocationModel.this, (String) obj);
            }
        });
        this.pickupType = mutableLiveData8;
    }

    private final RelocationRepository getRelocationRepository() {
        return (RelocationRepository) this.relocationRepository$delegate.getValue();
    }

    public final MutableLiveData<Boolean> isFormComplete() {
        return this.isFormComplete;
    }

    public final MutableLiveData<BaseV1Response> getUpdateAddress() {
        return this.updateAddress;
    }

    public final MutableLiveData<String> getPinCode() {
        return this.pinCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pinCode$lambda-4$lambda-3  reason: not valid java name */
    public static final void m1168pinCode$lambda4$lambda3(final RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str.length() == 6) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                this$0.observeAndTrack(this$0.getRelocationRepository().getCityData(new CityByPincodeRequest(str)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RelocationModel.m1169pinCode$lambda4$lambda3$lambda2(RelocationModel.this, (CityByPincodeResponse) obj);
                    }
                });
                return;
            }
            this$0.getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
            return;
        }
        this$0.resetAreaSpinner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pinCode$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1169pinCode$lambda4$lambda3$lambda2(RelocationModel this$0, CityByPincodeResponse cityByPincodeResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<CityList> pincode = cityByPincodeResponse != null ? cityByPincodeResponse.getPincode() : null;
        if (!(pincode == null || pincode.isEmpty())) {
            this$0.loadAreaSpinner(cityByPincodeResponse != null ? cityByPincodeResponse.getPincode() : null);
            return;
        }
        this$0.getToastMessageLiveData().setValue(new Event<>((cityByPincodeResponse == null || (r3 = cityByPincodeResponse.getMessage()) == null) ? "This pincode is either invalid or not serviceable." : "This pincode is either invalid or not serviceable."));
        this$0.resetAreaSpinner();
    }

    /* compiled from: RelocationModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/RelocationModel$Companion;", "", "()V", "PINCODE_BEFORE_AREA_MESSAGE", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final MutableLiveData<String> getArea() {
        return this.area;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: area$lambda-6$lambda-5  reason: not valid java name */
    public static final void m1164area$lambda6$lambda5(RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, PINCODE_BEFORE_AREA_MESSAGE)) {
            return;
        }
        List<String> value = this$0.listOfAreas.getValue();
        int indexOf = value != null ? value.indexOf(str) : -1;
        if (indexOf != -1) {
            List<CityList> value2 = this$0.cityData.getValue();
            Intrinsics.checkNotNull(value2);
            String state = value2.get(indexOf).getState();
            if (state == null) {
                state = "";
            }
            this$0.selectedState = state;
        }
        this$0.isFormComplete.setValue(Boolean.valueOf(this$0.isFormValidated()));
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: city$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1165city$lambda8$lambda7(RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isFormComplete.setValue(Boolean.valueOf(this$0.isFormValidated()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listOfAreas$lambda-11  reason: not valid java name */
    public static final List m1166listOfAreas$lambda11(RelocationModel this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String area = ((CityList) it.next()).getArea();
                if (area != null) {
                    arrayList.add(area);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(PINCODE_BEFORE_AREA_MESSAGE);
        }
        User user = LSApplication.Companion.getUser();
        if (arrayList.contains((user == null || (r4 = user.getArea()) == null) ? "" : "")) {
            MutableLiveData<String> mutableLiveData = this$0.area;
            User user2 = LSApplication.Companion.getUser();
            String area2 = user2 != null ? user2.getArea() : null;
            Intrinsics.checkNotNull(area2);
            mutableLiveData.setValue(area2);
            User user3 = LSApplication.Companion.getUser();
            String city = user3 != null ? user3.getCity() : null;
            if (!(city == null || StringsKt.isBlank(city))) {
                MutableLiveData<String> mutableLiveData2 = this$0.city;
                User user4 = LSApplication.Companion.getUser();
                Intrinsics.checkNotNull(user4);
                mutableLiveData2.setValue(user4.getCity());
            }
        }
        return arrayList;
    }

    private final void resetAreaSpinner() {
        this.cityData.setValue(null);
        this.area.setValue(null);
        this.city.setValue(null);
        this.isFormComplete.setValue(Boolean.valueOf(isFormValidated()));
    }

    private final void loadAreaSpinner(List<CityList> list) {
        CityList cityList;
        this.cityData.setValue(list);
        MutableLiveData<String> mutableLiveData = this.city;
        List<CityList> value = this.cityData.getValue();
        mutableLiveData.setValue((value == null || (cityList = value.get(0)) == null) ? null : cityList.getCity());
        this.isFormComplete.setValue(Boolean.valueOf(isFormValidated()));
    }

    public final LiveData<List<String>> populateAreasWhenAvailable() {
        return this.listOfAreas;
    }

    public final void updateAddress() {
        String str;
        CityList cityList;
        if (isFormValidated()) {
            if (LSApplication.Companion.isNetworkAvailable()) {
                User user = LSApplication.Companion.getUser();
                String id = user != null ? user.getId() : null;
                User user2 = LSApplication.Companion.getUser();
                String mobile = user2 != null ? user2.getMobile() : null;
                String value = this.area.getValue();
                String value2 = this.city.getValue();
                List<CityList> value3 = this.cityData.getValue();
                boolean z = false;
                String state = (value3 == null || (cityList = value3.get(0)) == null) ? null : cityList.getState();
                String value4 = this.addressLine2.getValue();
                if ((value4 == null || StringsKt.isBlank(value4)) ? true : true) {
                    String value5 = this.addressLine1.getValue();
                    Intrinsics.checkNotNull(value5);
                    str = value5;
                } else {
                    str = this.addressLine1.getValue() + ", " + this.addressLine2.getValue();
                }
                String str2 = str;
                String value6 = this.pinCode.getValue();
                User user3 = LSApplication.Companion.getUser();
                String name = user3 != null ? user3.getName() : null;
                User user4 = LSApplication.Companion.getUser();
                observeAndTrack(getRelocationRepository().updateAddressRelocation(new UpdateAddressRequest(id, mobile, value, value2, state, str2, value6, name, "", user4 != null ? user4.getAlternatePhoneNumber() : null, "", "", this.pickupType.getValue(), "android_app")), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RelocationModel.m1171updateAddress$lambda12(RelocationModel.this, (BaseV1Response) obj);
                    }
                });
                return;
            }
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-12  reason: not valid java name */
    public static final void m1171updateAddress$lambda12(RelocationModel this$0, BaseV1Response baseV1Response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateAddress.setValue(baseV1Response);
    }

    public final MutableLiveData<String> getAddressLine1() {
        return this.addressLine1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addressLine1$lambda-14$lambda-13  reason: not valid java name */
    public static final void m1162addressLine1$lambda14$lambda13(RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isFormComplete.setValue(Boolean.valueOf(this$0.isFormValidated()));
    }

    public final MutableLiveData<String> getAddressLine2() {
        return this.addressLine2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addressLine2$lambda-16$lambda-15  reason: not valid java name */
    public static final void m1163addressLine2$lambda16$lambda15(RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isFormComplete.setValue(Boolean.valueOf(this$0.isFormValidated()));
    }

    public final MutableLiveData<String> getPickupType() {
        return this.pickupType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pickupType$lambda-18$lambda-17  reason: not valid java name */
    public static final void m1167pickupType$lambda18$lambda17(RelocationModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isFormComplete.setValue(Boolean.valueOf(this$0.isFormValidated()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        if ((r3 != null && r3.length() == 6) == false) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isFormValidated() {
        /*
            r5 = this;
            androidx.lifecycle.MutableLiveData<java.lang.String> r0 = r5.addressLine1
            java.lang.Object r0 = r0.getValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            r0 = r0 ^ r1
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.addressLine2
            java.lang.Object r3 = r3.getValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L2a
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L28
            goto L2a
        L28:
            r3 = 0
            goto L2b
        L2a:
            r3 = 1
        L2b:
            if (r3 == 0) goto L2e
            r0 = 0
        L2e:
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.pinCode
            java.lang.Object r3 = r3.getValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L41
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L3f
            goto L41
        L3f:
            r3 = 0
            goto L42
        L41:
            r3 = 1
        L42:
            if (r3 != 0) goto L5a
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.pinCode
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L57
            int r3 = r3.length()
            r4 = 6
            if (r3 != r4) goto L57
            r3 = 1
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 != 0) goto L5b
        L5a:
            r0 = 0
        L5b:
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.city
            java.lang.Object r3 = r3.getValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L6e
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L6c
            goto L6e
        L6c:
            r3 = 0
            goto L6f
        L6e:
            r3 = 1
        L6f:
            if (r3 == 0) goto L72
            r0 = 0
        L72:
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.area
            java.lang.Object r3 = r3.getValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L85
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L83
            goto L85
        L83:
            r3 = 0
            goto L86
        L85:
            r3 = 1
        L86:
            if (r3 == 0) goto L89
            r0 = 0
        L89:
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.pickupType
            java.lang.Object r3 = r3.getValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L9b
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L9a
            goto L9b
        L9a:
            r1 = 0
        L9b:
            if (r1 == 0) goto L9e
            goto L9f
        L9e:
            r2 = r0
        L9f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.serviceRequest.model.RelocationModel.isFormValidated():boolean");
    }

    public final MutableLiveData<Event<String>> getToastObserver() {
        return getToastMessageLiveData();
    }

    public final LiveData<NewPlanResponse> showNewPlan() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            observeAndTrack(getRelocationRepository().showNewPlan(new NewPlanRequest(user != null ? user.getId() : null, this.city.getValue())), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RelocationModel$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RelocationModel.m1170showNewPlan$lambda19(RelocationModel.this, (NewPlanResponse) obj);
                }
            });
        }
        return this.newPlan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNewPlan$lambda-19  reason: not valid java name */
    public static final void m1170showNewPlan$lambda19(RelocationModel this$0, NewPlanResponse newPlanResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = false;
        if (newPlanResponse != null && newPlanResponse.getStatus() == 200) {
            z = true;
        }
        if (z) {
            this$0.newPlan.setValue(newPlanResponse);
        } else {
            this$0.getToastMessageLiveData().setValue(new Event<>((newPlanResponse == null || (r4 = newPlanResponse.getMessage()) == null) ? "Something went wrong. Please try Again." : "Something went wrong. Please try Again."));
        }
    }
}
