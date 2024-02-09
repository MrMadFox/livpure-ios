package com.livpure.safedrink.bolt.view;

import com.livpure.safedrink.bolt.model.SettingModel;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.AppConstants;
import com.newrelic.agent.android.payload.PayloadController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.bolt.view.SettingsFragment$displayData$2", f = "SettingsFragment.kt", i = {}, l = {664, 671}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SettingsFragment$displayData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsFragment$displayData$2(SettingsFragment settingsFragment, Continuation<? super SettingsFragment$displayData$2> continuation) {
        super(2, continuation);
        this.this$0 = settingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$displayData$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$displayData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SettingModel settingModel;
        String publishToDevice;
        AnimProgressBar animProgressBar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.this$0.disConnectBLE();
                this.this$0.updateWifiSettings();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        settingModel = this.this$0.getSettingModel();
        String str = "";
        if (!Intrinsics.areEqual(settingModel.getProductType(), "air-purifier") ? (publishToDevice = this.this$0.publishToDevice(AppConstants.CONFIG_RESET_COMMAND)) != null : (publishToDevice = this.this$0.publishToDevice(AppConstants.CONFIG_RESET_COMMAND_AIR)) != null) {
            str = publishToDevice;
        }
        if (!Intrinsics.areEqual(str, "succes")) {
            animProgressBar = this.this$0.animProgressBar;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.dismiss();
            return Unit.INSTANCE;
        }
        this.label = 2;
        if (DelayKt.delay(PayloadController.PAYLOAD_COLLECTOR_TIMEOUT, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.disConnectBLE();
        this.this$0.updateWifiSettings();
        return Unit.INSTANCE;
    }
}
