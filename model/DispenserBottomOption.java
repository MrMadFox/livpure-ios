package com.livpure.safedrink.model;

import com.moengage.pushbase.MoEPushConstants;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserBottomOption.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/livpure/safedrink/model/DispenserBottomOption;", "", SettingsJsonConstants.APP_ICON_KEY, "", "title", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/Integer;", "setIcon", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/livpure/safedrink/model/DispenserBottomOption;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserBottomOption {
    private Integer icon;
    private String title;

    public DispenserBottomOption() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ DispenserBottomOption copy$default(DispenserBottomOption dispenserBottomOption, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dispenserBottomOption.icon;
        }
        if ((i & 2) != 0) {
            str = dispenserBottomOption.title;
        }
        return dispenserBottomOption.copy(num, str);
    }

    public final Integer component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final DispenserBottomOption copy(Integer num, String str) {
        return new DispenserBottomOption(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserBottomOption) {
            DispenserBottomOption dispenserBottomOption = (DispenserBottomOption) obj;
            return Intrinsics.areEqual(this.icon, dispenserBottomOption.icon) && Intrinsics.areEqual(this.title, dispenserBottomOption.title);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.icon;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DispenserBottomOption(icon=" + this.icon + ", title=" + this.title + ')';
    }

    public DispenserBottomOption(Integer num, String str) {
        this.icon = num;
        this.title = str;
    }

    public /* synthetic */ DispenserBottomOption(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setIcon(Integer num) {
        this.icon = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
