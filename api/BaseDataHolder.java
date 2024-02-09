package com.livpure.safedrink.api;

import androidx.exifinterface.media.ExifInterface;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BaseDataHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/api/BaseDataHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/api/BaseDTO;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Object;)Lcom/livpure/safedrink/api/BaseDataHolder;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseDataHolder<T> extends BaseDTO {
    private final T data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseDataHolder copy$default(BaseDataHolder baseDataHolder, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = baseDataHolder.data;
        }
        return baseDataHolder.copy(obj);
    }

    public final T component1() {
        return this.data;
    }

    public final BaseDataHolder<T> copy(T t) {
        return new BaseDataHolder<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BaseDataHolder) && Intrinsics.areEqual(this.data, ((BaseDataHolder) obj).data);
    }

    public int hashCode() {
        T t = this.data;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "BaseDataHolder(data=" + this.data + ')';
    }

    public BaseDataHolder(T t) {
        super(null, null, false, 0, null, null, 63, null);
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }
}
