package com.livpure.safedrink.subscription.kyc.viewmodel;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.kyc.data.ConfigRepository;
import com.livpure.safedrink.subscription.kyc.data.KYCRepository;
import com.livpure.safedrink.subscription.kyc.data.model.DropDownResponse;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UploadKYCViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J.\u0010*\u001a*\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00040+J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u0004J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u001c\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00060\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00060\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00060\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/viewmodel/UploadKYCViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "addressProofs", "Landroidx/lifecycle/LiveData;", "", "", "configRepository", "Lcom/livpure/safedrink/subscription/kyc/data/ConfigRepository;", "getConfigRepository", "()Lcom/livpure/safedrink/subscription/kyc/data/ConfigRepository;", "configRepository$delegate", "Lkotlin/Lazy;", "dropDownResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/kyc/data/model/DropDownResponse;", "idProofs", "kycRepository", "Lcom/livpure/safedrink/subscription/kyc/data/KYCRepository;", "getKycRepository", "()Lcom/livpure/safedrink/subscription/kyc/data/KYCRepository;", "kycRepository$delegate", "salutationList", "getSalutationList", "()Ljava/util/List;", "selectedAddressProof", "kotlin.jvm.PlatformType", "getSelectedAddressProof", "()Landroidx/lifecycle/LiveData;", "selectedAddressProofPosition", "", "getSelectedAddressProofPosition", "()Landroidx/lifecycle/MutableLiveData;", "selectedIdProof", "getSelectedIdProof", "selectedIdProofPosition", "getSelectedIdProofPosition", "selectedSalutation", "selectedSalutationPosition", "getSelectedSalutationPosition", "state", "Lcom/livpure/safedrink/subscription/kyc/viewmodel/UploadKYCViewModel$States;", "fetchSpinnerData", "Lkotlin/Pair;", "getCurrentState", "onUploadAddressProofClicked", "", "onUploadIDProofClicked", "updateKYCInformation", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "fileNames", "States", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadKYCViewModel extends MediatorViewModel {
    private final LiveData<List<String>> addressProofs;
    private final Lazy configRepository$delegate;
    private final MutableLiveData<DropDownResponse> dropDownResponse;
    private final LiveData<List<String>> idProofs;
    private final Lazy kycRepository$delegate;
    private final List<String> salutationList = CollectionsKt.listOf((Object[]) new String[]{"Mr.", "Ms."});
    private final LiveData<String> selectedAddressProof;
    private final MutableLiveData<Integer> selectedAddressProofPosition;
    private final LiveData<String> selectedIdProof;
    private final MutableLiveData<Integer> selectedIdProofPosition;
    private final LiveData<String> selectedSalutation;
    private final MutableLiveData<Integer> selectedSalutationPosition;
    private final MutableLiveData<States> state;

    /* compiled from: UploadKYCViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/viewmodel/UploadKYCViewModel$States;", "", "(Ljava/lang/String;I)V", "SELECT_ADDRESS_PROOF", "SELECT_ID_PROOF", "HOME", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum States {
        SELECT_ADDRESS_PROOF,
        SELECT_ID_PROOF,
        HOME
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedAddressProof$lambda-11$lambda-10  reason: not valid java name */
    public static final void m1308selectedAddressProof$lambda11$lambda10(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedAddressProofPosition$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1310selectedAddressProofPosition$lambda3$lambda2(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedIdProof$lambda-14$lambda-13  reason: not valid java name */
    public static final void m1312selectedIdProof$lambda14$lambda13(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedIdProofPosition$lambda-5$lambda-4  reason: not valid java name */
    public static final void m1313selectedIdProofPosition$lambda5$lambda4(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedSalutation$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1315selectedSalutation$lambda8$lambda7(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedSalutationPosition$lambda-1$lambda-0  reason: not valid java name */
    public static final void m1316selectedSalutationPosition$lambda1$lambda0(Integer num) {
    }

    public UploadKYCViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        observeAndTrack(mutableLiveData, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1316selectedSalutationPosition$lambda1$lambda0((Integer) obj);
            }
        });
        this.selectedSalutationPosition = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData2, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1310selectedAddressProofPosition$lambda3$lambda2((Integer) obj);
            }
        });
        this.selectedAddressProofPosition = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData3, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1313selectedIdProofPosition$lambda5$lambda4((Integer) obj);
            }
        });
        this.selectedIdProofPosition = mutableLiveData3;
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1314selectedSalutation$lambda6;
                m1314selectedSalutation$lambda6 = UploadKYCViewModel.m1314selectedSalutation$lambda6(UploadKYCViewModel.this, (Integer) obj);
                return m1314selectedSalutation$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        observeAndTrack(map, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1315selectedSalutation$lambda8$lambda7((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map<Int, String>(selecte…        }\n        )\n    }");
        this.selectedSalutation = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData2, new Function() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1309selectedAddressProof$lambda9;
                m1309selectedAddressProof$lambda9 = UploadKYCViewModel.m1309selectedAddressProof$lambda9(UploadKYCViewModel.this, (Integer) obj);
                return m1309selectedAddressProof$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        observeAndTrack(map2, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1308selectedAddressProof$lambda11$lambda10((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map<Int, String>(selecte…        }\n        )\n    }");
        this.selectedAddressProof = map2;
        LiveData<String> map3 = Transformations.map(mutableLiveData3, new Function() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1311selectedIdProof$lambda12;
                m1311selectedIdProof$lambda12 = UploadKYCViewModel.m1311selectedIdProof$lambda12(UploadKYCViewModel.this, (Integer) obj);
                return m1311selectedIdProof$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "");
        observeAndTrack(map3, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKYCViewModel.m1312selectedIdProof$lambda14$lambda13((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map<Int, String>(selecte…        }\n        )\n    }");
        this.selectedIdProof = map3;
        this.configRepository$delegate = LazyKt.lazy(new Function0<ConfigRepository>() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$configRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigRepository invoke() {
                return new ConfigRepository();
            }
        });
        this.kycRepository$delegate = LazyKt.lazy(new Function0<KYCRepository>() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$kycRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KYCRepository invoke() {
                return new KYCRepository();
            }
        });
        MutableLiveData<DropDownResponse> mutableLiveData4 = new MutableLiveData<>();
        this.dropDownResponse = mutableLiveData4;
        LiveData<List<String>> map4 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List m1305addressProofs$lambda17;
                m1305addressProofs$lambda17 = UploadKYCViewModel.m1305addressProofs$lambda17((DropDownResponse) obj);
                return m1305addressProofs$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dropDownResponse) {\n…     null\n        }\n    }");
        this.addressProofs = map4;
        LiveData<List<String>> map5 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List m1307idProofs$lambda20;
                m1307idProofs$lambda20 = UploadKYCViewModel.m1307idProofs$lambda20((DropDownResponse) obj);
                return m1307idProofs$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dropDownResponse) {\n…     null\n        }\n    }");
        this.idProofs = map5;
        this.state = new MutableLiveData<>();
    }

    public final List<String> getSalutationList() {
        return this.salutationList;
    }

    public final MutableLiveData<Integer> getSelectedSalutationPosition() {
        return this.selectedSalutationPosition;
    }

    public final MutableLiveData<Integer> getSelectedAddressProofPosition() {
        return this.selectedAddressProofPosition;
    }

    public final MutableLiveData<Integer> getSelectedIdProofPosition() {
        return this.selectedIdProofPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedSalutation$lambda-6  reason: not valid java name */
    public static final String m1314selectedSalutation$lambda6(UploadKYCViewModel this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<String> list = this$0.salutationList;
        if (!(list == null || list.isEmpty())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.intValue() < this$0.salutationList.size()) {
                return this$0.salutationList.get(it.intValue());
            }
        }
        return "";
    }

    public final LiveData<String> getSelectedAddressProof() {
        return this.selectedAddressProof;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedAddressProof$lambda-9  reason: not valid java name */
    public static final String m1309selectedAddressProof$lambda9(UploadKYCViewModel this$0, Integer it) {
        List<String> value;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        int intValue = it.intValue();
        List<String> value2 = this$0.addressProofs.getValue();
        return (intValue >= (value2 != null ? value2.size() : 0) || (value = this$0.addressProofs.getValue()) == null || (str = value.get(it.intValue())) == null) ? "" : str;
    }

    public final LiveData<String> getSelectedIdProof() {
        return this.selectedIdProof;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedIdProof$lambda-12  reason: not valid java name */
    public static final String m1311selectedIdProof$lambda12(UploadKYCViewModel this$0, Integer it) {
        List<String> value;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        int intValue = it.intValue();
        List<String> value2 = this$0.idProofs.getValue();
        return (intValue >= (value2 != null ? value2.size() : 0) || (value = this$0.idProofs.getValue()) == null || (str = value.get(it.intValue())) == null) ? "" : str;
    }

    private final ConfigRepository getConfigRepository() {
        return (ConfigRepository) this.configRepository$delegate.getValue();
    }

    private final KYCRepository getKycRepository() {
        return (KYCRepository) this.kycRepository$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addressProofs$lambda-17  reason: not valid java name */
    public static final List m1305addressProofs$lambda17(DropDownResponse dropDownResponse) {
        List<JsonElement> dropDownLists = dropDownResponse.getDropDownLists();
        if (!(dropDownLists == null || dropDownLists.isEmpty()) && dropDownResponse.getDropDownLists().get(2).isJsonObject()) {
            ArrayList arrayList = new ArrayList();
            JsonArray<JsonElement> asJsonArray = dropDownResponse.getDropDownLists().get(2).getAsJsonObject().get("addressProof").getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray, "it.dropDownLists[2].asJs…ddressProof\").asJsonArray");
            for (JsonElement jsonElement : asJsonArray) {
                String proof = jsonElement.getAsString();
                if (!StringsKt.equals(proof, "select", true)) {
                    Intrinsics.checkNotNullExpressionValue(proof, "proof");
                    arrayList.add(proof);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: idProofs$lambda-20  reason: not valid java name */
    public static final List m1307idProofs$lambda20(DropDownResponse dropDownResponse) {
        List<JsonElement> dropDownLists = dropDownResponse.getDropDownLists();
        if (!(dropDownLists == null || dropDownLists.isEmpty()) && dropDownResponse.getDropDownLists().get(3).isJsonObject()) {
            ArrayList arrayList = new ArrayList();
            JsonArray<JsonElement> asJsonArray = dropDownResponse.getDropDownLists().get(3).getAsJsonObject().get("idProof").getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray, "it.dropDownLists[3].asJs…et(\"idProof\").asJsonArray");
            for (JsonElement jsonElement : asJsonArray) {
                String proof = jsonElement.getAsString();
                if (!StringsKt.equals(proof, "select", true)) {
                    Intrinsics.checkNotNullExpressionValue(proof, "proof");
                    arrayList.add(proof);
                }
            }
            return arrayList;
        }
        return null;
    }

    public final LiveData<States> getCurrentState() {
        return this.state;
    }

    public final void onUploadAddressProofClicked() {
        this.state.setValue(States.SELECT_ADDRESS_PROOF);
    }

    public final void onUploadIDProofClicked() {
        this.state.setValue(States.SELECT_ID_PROOF);
    }

    public final Pair<LiveData<List<String>>, LiveData<List<String>>> fetchSpinnerData() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getConfigRepository().getDropDownListsForProofs(), new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda9
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UploadKYCViewModel.m1306fetchSpinnerData$lambda21(UploadKYCViewModel.this, (DropDownResponse) obj);
                    }
                });
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Sorry! We faced an issue while providing the required options. Please try again"));
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return new Pair<>(this.addressProofs, this.idProofs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchSpinnerData$lambda-21  reason: not valid java name */
    public static final void m1306fetchSpinnerData$lambda21(final UploadKYCViewModel this$0, DropDownResponse dropDownResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dropDownResponse, new Function1<DropDownResponse, Unit>() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$fetchSpinnerData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DropDownResponse dropDownResponse2) {
                invoke2(dropDownResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DropDownResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = UploadKYCViewModel.this.dropDownResponse;
                mutableLiveData.setValue(successfulResponse);
                List<JsonElement> dropDownLists = successfulResponse.getDropDownLists();
                if (dropDownLists == null || dropDownLists.isEmpty()) {
                    toastMessageLiveData = UploadKYCViewModel.this.getToastMessageLiveData();
                    toastMessageLiveData.setValue(new Event("Sorry! We faced an issue while providing the required options. Please try again"));
                }
            }
        }, new Function1<DropDownResponse, Unit>() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$fetchSpinnerData$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DropDownResponse dropDownResponse2) {
                invoke2(dropDownResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DropDownResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = UploadKYCViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Sorry! We faced an issue while providing the required options. Please try again"));
            }
        });
    }

    public final void updateKYCInformation(final Context context, List<String> fileNames) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileNames, "fileNames");
        if (LSApplication.Companion.isNetworkAvailable()) {
            KYCRepository kycRepository = getKycRepository();
            String value = this.selectedIdProof.getValue();
            Intrinsics.checkNotNull(value);
            String value2 = this.selectedAddressProof.getValue();
            Intrinsics.checkNotNull(value2);
            String value3 = this.selectedSalutation.getValue();
            Intrinsics.checkNotNull(value3);
            observeAndTrack(kycRepository.updateKYCInformation(fileNames, value, value2, value3), new Observer() { // from class: com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel$$ExternalSyntheticLambda8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UploadKYCViewModel.m1317updateKYCInformation$lambda23(context, this, (BaseDataHolder) obj);
                }
            });
            return;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateKYCInformation$lambda-23  reason: not valid java name */
    public static final void m1317updateKYCInformation$lambda23(Context context, UploadKYCViewModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseDataHolder.getStatus()) {
            SegmentLogger.Companion.with(context).sendUploadedKYCEvent(this$0.selectedIdProof.getValue(), this$0.selectedAddressProof.getValue());
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                user.setKycCompleted(true);
            } else {
                user = null;
            }
            UserRepository.Companion.getInstance(context).setUser(user);
            this$0.state.setValue(States.HOME);
            return;
        }
        this$0.getToastMessageLiveData().setValue(new Event<>("KYC upload failed."));
    }
}
