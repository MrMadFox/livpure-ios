package com.livpure.safedrink.subscription.plan.data.model.plan;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContentItem.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/ContentItem;", "Landroid/os/Parcelable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getA", "()Ljava/lang/String;", "getB", "getC", "getD", "getE", "getF", "getG", "component1", "component2", "component3", "component4", "component5", "component6", "component7", MoEPushConstants.ACTION_COPY, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentItem implements Parcelable {
    public static final Parcelable.Creator<ContentItem> CREATOR = new Creator();
    @SerializedName("a")
    private final String A;
    @SerializedName("b")
    private final String B;
    @SerializedName("c")
    private final String C;
    @SerializedName("d")
    private final String D;
    @SerializedName("e")
    private final String E;
    @SerializedName("f")
    private final String F;
    @SerializedName("g")
    private final String G;

    /* compiled from: ContentItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ContentItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContentItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContentItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContentItem[] newArray(int i) {
            return new ContentItem[i];
        }
    }

    public ContentItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ContentItem copy$default(ContentItem contentItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentItem.A;
        }
        if ((i & 2) != 0) {
            str2 = contentItem.B;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = contentItem.C;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = contentItem.D;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = contentItem.E;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = contentItem.F;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = contentItem.G;
        }
        return contentItem.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.A;
    }

    public final String component2() {
        return this.B;
    }

    public final String component3() {
        return this.C;
    }

    public final String component4() {
        return this.D;
    }

    public final String component5() {
        return this.E;
    }

    public final String component6() {
        return this.F;
    }

    public final String component7() {
        return this.G;
    }

    public final ContentItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new ContentItem(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentItem) {
            ContentItem contentItem = (ContentItem) obj;
            return Intrinsics.areEqual(this.A, contentItem.A) && Intrinsics.areEqual(this.B, contentItem.B) && Intrinsics.areEqual(this.C, contentItem.C) && Intrinsics.areEqual(this.D, contentItem.D) && Intrinsics.areEqual(this.E, contentItem.E) && Intrinsics.areEqual(this.F, contentItem.F) && Intrinsics.areEqual(this.G, contentItem.G);
        }
        return false;
    }

    public int hashCode() {
        String str = this.A;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.B;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.C;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.D;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.E;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.F;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.G;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ContentItem(A=" + this.A + ", B=" + this.B + ", C=" + this.C + ", D=" + this.D + ", E=" + this.E + ", F=" + this.F + ", G=" + this.G + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.A);
        out.writeString(this.B);
        out.writeString(this.C);
        out.writeString(this.D);
        out.writeString(this.E);
        out.writeString(this.F);
        out.writeString(this.G);
    }

    public ContentItem(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.A = str;
        this.B = str2;
        this.C = str3;
        this.D = str4;
        this.E = str5;
        this.F = str6;
        this.G = str7;
    }

    public /* synthetic */ ContentItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getA() {
        return this.A;
    }

    public final String getB() {
        return this.B;
    }

    public final String getC() {
        return this.C;
    }

    public final String getD() {
        return this.D;
    }

    public final String getE() {
        return this.E;
    }

    public final String getF() {
        return this.F;
    }

    public final String getG() {
        return this.G;
    }
}
