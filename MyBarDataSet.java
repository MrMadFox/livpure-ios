package com.livpure.safedrink;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;
/* loaded from: classes3.dex */
public class MyBarDataSet extends BarDataSet {
    public MyBarDataSet(List<BarEntry> yVals, String label) {
        super(yVals, label);
    }

    @Override // com.github.mikephil.charting.data.BaseDataSet, com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor(int index) {
        if (index == 6) {
            return this.mColors.get(1).intValue();
        }
        return this.mColors.get(0).intValue();
    }
}
