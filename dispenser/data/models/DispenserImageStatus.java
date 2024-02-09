package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
/* compiled from: DispenserImageStatus.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserImageStatus;", "", "dispense", "", "ic_tds_1", "disinfection", "ic_temp", "(IIII)V", "getDisinfection", "()I", "getDispense", "getIc_tds_1", "getIc_temp", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserImageStatus {
    private final int disinfection;
    private final int dispense;
    private final int ic_tds_1;
    private final int ic_temp;

    public static /* synthetic */ DispenserImageStatus copy$default(DispenserImageStatus dispenserImageStatus, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = dispenserImageStatus.dispense;
        }
        if ((i5 & 2) != 0) {
            i2 = dispenserImageStatus.ic_tds_1;
        }
        if ((i5 & 4) != 0) {
            i3 = dispenserImageStatus.disinfection;
        }
        if ((i5 & 8) != 0) {
            i4 = dispenserImageStatus.ic_temp;
        }
        return dispenserImageStatus.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.dispense;
    }

    public final int component2() {
        return this.ic_tds_1;
    }

    public final int component3() {
        return this.disinfection;
    }

    public final int component4() {
        return this.ic_temp;
    }

    public final DispenserImageStatus copy(int i, int i2, int i3, int i4) {
        return new DispenserImageStatus(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserImageStatus) {
            DispenserImageStatus dispenserImageStatus = (DispenserImageStatus) obj;
            return this.dispense == dispenserImageStatus.dispense && this.ic_tds_1 == dispenserImageStatus.ic_tds_1 && this.disinfection == dispenserImageStatus.disinfection && this.ic_temp == dispenserImageStatus.ic_temp;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.dispense * 31) + this.ic_tds_1) * 31) + this.disinfection) * 31) + this.ic_temp;
    }

    public String toString() {
        return "DispenserImageStatus(dispense=" + this.dispense + ", ic_tds_1=" + this.ic_tds_1 + ", disinfection=" + this.disinfection + ", ic_temp=" + this.ic_temp + ')';
    }

    public DispenserImageStatus(int i, int i2, int i3, int i4) {
        this.dispense = i;
        this.ic_tds_1 = i2;
        this.disinfection = i3;
        this.ic_temp = i4;
    }

    public final int getDispense() {
        return this.dispense;
    }

    public final int getIc_tds_1() {
        return this.ic_tds_1;
    }

    public final int getDisinfection() {
        return this.disinfection;
    }

    public final int getIc_temp() {
        return this.ic_temp;
    }
}
