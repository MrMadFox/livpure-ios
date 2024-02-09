package com.livpure.safedrink.airpurifier.data.models;

import com.github.mikephil.charting.data.Entry;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierGraph.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003JT\u0010\u0019\u001aP\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d0\u001aJP\u0010\u001f\u001aL\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d0\u001aJT\u0010 \u001aP\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001d0\u001aJ\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u001cHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;", "", "dayily", "", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphDaily;", "weekly", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphWeekly;", "monthly", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphMonthly;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDayily", "()Ljava/util/List;", "setDayily", "(Ljava/util/List;)V", "getMonthly", "setMonthly", "getWeekly", "setWeekly", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "getDailyGraphData", "Lkotlin/Triple;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lcom/github/mikephil/charting/data/Entry;", "getMonthlyGraphData", "getWeeklyGraphData", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierGraph {
    @SerializedName("day")
    private List<AirPurifierGraphDaily> dayily;
    @SerializedName("month")
    private List<AirPurifierGraphMonthly> monthly;
    @SerializedName("week")
    private List<AirPurifierGraphWeekly> weekly;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AirPurifierGraph copy$default(AirPurifierGraph airPurifierGraph, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = airPurifierGraph.dayily;
        }
        if ((i & 2) != 0) {
            list2 = airPurifierGraph.weekly;
        }
        if ((i & 4) != 0) {
            list3 = airPurifierGraph.monthly;
        }
        return airPurifierGraph.copy(list, list2, list3);
    }

    public final List<AirPurifierGraphDaily> component1() {
        return this.dayily;
    }

    public final List<AirPurifierGraphWeekly> component2() {
        return this.weekly;
    }

    public final List<AirPurifierGraphMonthly> component3() {
        return this.monthly;
    }

    public final AirPurifierGraph copy(List<AirPurifierGraphDaily> dayily, List<AirPurifierGraphWeekly> weekly, List<AirPurifierGraphMonthly> monthly) {
        Intrinsics.checkNotNullParameter(dayily, "dayily");
        Intrinsics.checkNotNullParameter(weekly, "weekly");
        Intrinsics.checkNotNullParameter(monthly, "monthly");
        return new AirPurifierGraph(dayily, weekly, monthly);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierGraph) {
            AirPurifierGraph airPurifierGraph = (AirPurifierGraph) obj;
            return Intrinsics.areEqual(this.dayily, airPurifierGraph.dayily) && Intrinsics.areEqual(this.weekly, airPurifierGraph.weekly) && Intrinsics.areEqual(this.monthly, airPurifierGraph.monthly);
        }
        return false;
    }

    public int hashCode() {
        return (((this.dayily.hashCode() * 31) + this.weekly.hashCode()) * 31) + this.monthly.hashCode();
    }

    public String toString() {
        return "AirPurifierGraph(dayily=" + this.dayily + ", weekly=" + this.weekly + ", monthly=" + this.monthly + ')';
    }

    public AirPurifierGraph(List<AirPurifierGraphDaily> dayily, List<AirPurifierGraphWeekly> weekly, List<AirPurifierGraphMonthly> monthly) {
        Intrinsics.checkNotNullParameter(dayily, "dayily");
        Intrinsics.checkNotNullParameter(weekly, "weekly");
        Intrinsics.checkNotNullParameter(monthly, "monthly");
        this.dayily = dayily;
        this.weekly = weekly;
        this.monthly = monthly;
    }

    public final List<AirPurifierGraphDaily> getDayily() {
        return this.dayily;
    }

    public final void setDayily(List<AirPurifierGraphDaily> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dayily = list;
    }

    public final List<AirPurifierGraphWeekly> getWeekly() {
        return this.weekly;
    }

    public final void setWeekly(List<AirPurifierGraphWeekly> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.weekly = list;
    }

    public final List<AirPurifierGraphMonthly> getMonthly() {
        return this.monthly;
    }

    public final void setMonthly(List<AirPurifierGraphMonthly> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.monthly = list;
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getDailyGraphData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (AirPurifierGraphDaily airPurifierGraphDaily : this.dayily) {
            if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphDaily.getHour()), "")) {
                arrayList.add(String.valueOf(airPurifierGraphDaily.getHour()));
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphDaily.getIndoor().getPm2_5()), "")) {
                    Integer pm2_5 = airPurifierGraphDaily.getIndoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_5);
                    arrayList2.add(new Entry(pm2_5.intValue(), i));
                }
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphDaily.getOutdoor().getPm2_5()), "")) {
                    Integer pm2_52 = airPurifierGraphDaily.getOutdoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_52);
                    arrayList3.add(new Entry(pm2_52.intValue(), i));
                }
                i++;
            }
        }
        return new Triple<>(arrayList, arrayList2, arrayList3);
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getWeeklyGraphData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (AirPurifierGraphWeekly airPurifierGraphWeekly : this.weekly) {
            if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphWeekly.getDate()), "")) {
                String date = airPurifierGraphWeekly.getDate();
                Intrinsics.checkNotNull(date);
                String substring = date.substring(5, 7);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String str = new DateFormatSymbols().getMonths()[Integer.parseInt(substring) - 1];
                Intrinsics.checkNotNullExpressionValue(str, "DateFormatSymbols().months[monthNumber - 1]");
                String substring2 = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String date2 = airPurifierGraphWeekly.getDate();
                Intrinsics.checkNotNull(date2);
                String substring3 = date2.substring(8, 10);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(substring2 + " - " + substring3);
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphWeekly.getIndoor().getPm2_5()), "")) {
                    Integer pm2_5 = airPurifierGraphWeekly.getIndoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_5);
                    arrayList2.add(new Entry(pm2_5.intValue(), i));
                }
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphWeekly.getOutdoor().getPm2_5()), "")) {
                    Integer pm2_52 = airPurifierGraphWeekly.getOutdoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_52);
                    arrayList3.add(new Entry(pm2_52.intValue(), i));
                }
                i++;
            }
        }
        return new Triple<>(arrayList, arrayList2, arrayList3);
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getMonthlyGraphData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (AirPurifierGraphMonthly airPurifierGraphMonthly : this.monthly) {
            if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphMonthly.getDate()), "")) {
                String date = airPurifierGraphMonthly.getDate();
                Intrinsics.checkNotNull(date);
                String substring = date.substring(5, 7);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String str = new DateFormatSymbols().getMonths()[Integer.parseInt(substring) - 1];
                Intrinsics.checkNotNullExpressionValue(str, "DateFormatSymbols().months[monthNumber - 1]");
                String substring2 = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String date2 = airPurifierGraphMonthly.getDate();
                Intrinsics.checkNotNull(date2);
                String substring3 = date2.substring(8, 10);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(substring2 + " - " + substring3);
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphMonthly.getIndoor().getPm2_5()), "")) {
                    Integer pm2_5 = airPurifierGraphMonthly.getIndoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_5);
                    arrayList2.add(new Entry(pm2_5.intValue(), i));
                }
                if (!Intrinsics.areEqual(String.valueOf(airPurifierGraphMonthly.getOutdoor().getPm2_5()), "")) {
                    Integer pm2_52 = airPurifierGraphMonthly.getOutdoor().getPm2_5();
                    Intrinsics.checkNotNull(pm2_52);
                    arrayList3.add(new Entry(pm2_52.intValue(), i));
                }
                i++;
            }
        }
        return new Triple<>(arrayList, arrayList2, arrayList3);
    }
}
