package com.livpure.safedrink.subscription.address.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SavedAddressItem.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/SavedAddressItem;", "", "savedAddress", "Lcom/livpure/safedrink/subscription/address/data/model/Address;", "(Lcom/livpure/safedrink/subscription/address/data/model/Address;)V", "getSavedAddress", "()Lcom/livpure/safedrink/subscription/address/data/model/Address;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SavedAddressItem {
    private final Address savedAddress;

    public static /* synthetic */ SavedAddressItem copy$default(SavedAddressItem savedAddressItem, Address address, int i, Object obj) {
        if ((i & 1) != 0) {
            address = savedAddressItem.savedAddress;
        }
        return savedAddressItem.copy(address);
    }

    public final Address component1() {
        return this.savedAddress;
    }

    public final SavedAddressItem copy(Address address) {
        return new SavedAddressItem(address);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SavedAddressItem) && Intrinsics.areEqual(this.savedAddress, ((SavedAddressItem) obj).savedAddress);
    }

    public int hashCode() {
        Address address = this.savedAddress;
        if (address == null) {
            return 0;
        }
        return address.hashCode();
    }

    public String toString() {
        return "SavedAddressItem(savedAddress=" + this.savedAddress + ')';
    }

    public SavedAddressItem(Address address) {
        this.savedAddress = address;
    }

    public final Address getSavedAddress() {
        return this.savedAddress;
    }
}
