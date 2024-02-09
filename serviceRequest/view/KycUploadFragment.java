package com.livpure.safedrink.serviceRequest.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.BuildConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.databinding.FragmentKYCUploadBinding;
import com.livpure.safedrink.serviceRequest.model.KycUploadModel;
import com.livpure.safedrink.utils.RealPathUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
/* compiled from: KycUploadFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0005H\u0014J\u000e\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0015J\u0014\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010 H\u0002J\b\u0010)\u001a\u00020*H\u0014J\u001a\u0010+\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010,\u001a\u00020-H\u0002J\"\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001cH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\b\u0010:\u001a\u00020\u001cH\u0002J\b\u0010;\u001a\u00020\u001cH\u0002J\u0016\u0010<\u001a\u00020\u001c2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150>H\u0002J\b\u0010?\u001a\u00020\u001cH\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u0015H\u0002J\u0006\u0010B\u001a\u00020\u001cJ\b\u0010C\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006D"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/KycUploadFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentKYCUploadBinding;", "()V", "REQUEST_IMAGE_CAPTURE", "", "REQUEST_PERMISSION", "REQUEST_PICK_IMAGE", "backPhoto", "", "frontPhoto", "imageBack", "Ljava/io/File;", "imageFront", "kycUploadModel", "Lcom/livpure/safedrink/serviceRequest/model/KycUploadModel;", "getKycUploadModel", "()Lcom/livpure/safedrink/serviceRequest/model/KycUploadModel;", "kycUploadModel$delegate", "Lkotlin/Lazy;", "mCurrentPhotoPath", "", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "getRequestPermissionLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "bindVariablesToView", "", "dataBinding", "getFileName", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getImageUri", "inImage", "Landroid/graphics/Bitmap;", "getLayoutId", "getPhotoFileUri", "fileName", "getRealPathFromURI", "contentUri", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "grantUriPermission", "activity", "Landroid/app/Activity;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openCamera", "openGallery", "openSettingManagePageForPermission", "openSettingPageForPermission", "populateProofSpinner", "addressProofList", "", "requestStoragePermission", "selectImage", "str", "showFileAccessDialog", "uploadBtnEnable", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KycUploadFragment extends DataBindingFragment<FragmentKYCUploadBinding> {
    private boolean backPhoto;
    private boolean frontPhoto;
    private File imageBack;
    private File imageFront;
    private final ActivityResultLauncher<String> requestPermissionLauncher;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int REQUEST_PERMISSION = 100;
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int REQUEST_PICK_IMAGE = 2;
    private String mCurrentPhotoPath = "";
    private final Lazy kycUploadModel$delegate = LazyKt.lazy(new Function0<KycUploadModel>() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$kycUploadModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KycUploadModel invoke() {
            return (KycUploadModel) new ViewModelProvider(KycUploadFragment.this).get(KycUploadModel.class);
        }
    });

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public int getLayoutId() {
        return R.layout.fragment_k_y_c__upload;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public KycUploadFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                KycUploadFragment.m1188requestPermissionLauncher$lambda5(KycUploadFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.requestPermissionLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    private final KycUploadModel getKycUploadModel() {
        return (KycUploadModel) this.kycUploadModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentKYCUploadBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getKycUploadModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ArrayList arrayList = new ArrayList();
        String string = getString(R.string.driving_license);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.driving_license)");
        arrayList.add(string);
        String string2 = getString(R.string.passport);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.passport)");
        arrayList.add(string2);
        String string3 = getString(R.string.voter_id_card);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.voter_id_card)");
        arrayList.add(string3);
        String string4 = getString(R.string.electricity_bill);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.electricity_bill)");
        arrayList.add(string4);
        String string5 = getString(R.string.water_bill);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.water_bill)");
        arrayList.add(string5);
        String string6 = getString(R.string.gas_connection_bill);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.gas_connection_bill)");
        arrayList.add(string6);
        String string7 = getString(R.string.rent_agreement);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.rent_agreement)");
        arrayList.add(string7);
        populateProofSpinner(arrayList);
        ((LinearLayout) _$_findCachedViewById(R.id.uploadFrontPhoto)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KycUploadFragment.m1183onViewCreated$lambda0(KycUploadFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.uploadBackPhoto)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KycUploadFragment.m1184onViewCreated$lambda1(KycUploadFragment.this, view2);
            }
        });
        ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KycUploadFragment.m1185onViewCreated$lambda3(KycUploadFragment.this, view2);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$onViewCreated$4
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1183onViewCreated$lambda0(KycUploadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.frontPhoto = true;
        Editable text = ((AutoCompleteTextView) this$0._$_findCachedViewById(R.id.addressProofCompleteTextView)).getText();
        Intrinsics.checkNotNullExpressionValue(text, "addressProofCompleteTextView.text");
        if (text.length() > 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (ContextCompat.checkSelfPermission(this$0.requireActivity(), "android.permission.READ_MEDIA_IMAGES") != 0) {
                    this$0.requestPermissionLauncher.launch("android.permission.READ_MEDIA_IMAGES");
                    return;
                } else {
                    this$0.selectImage("front");
                    return;
                }
            }
            this$0.requestStoragePermission();
            this$0.selectImage("front");
            return;
        }
        Toast.makeText(this$0.getMContext(), this$0.getString(R.string.select_address_proof), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1184onViewCreated$lambda1(KycUploadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.backPhoto = true;
        Editable text = ((AutoCompleteTextView) this$0._$_findCachedViewById(R.id.addressProofCompleteTextView)).getText();
        Intrinsics.checkNotNullExpressionValue(text, "addressProofCompleteTextView.text");
        if (text.length() > 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (ContextCompat.checkSelfPermission(this$0.requireActivity(), "android.permission.READ_MEDIA_IMAGES") != 0) {
                    this$0.requestPermissionLauncher.launch("android.permission.READ_MEDIA_IMAGES");
                    return;
                } else {
                    this$0.selectImage("back");
                    return;
                }
            }
            this$0.requestStoragePermission();
            this$0.selectImage("back");
            return;
        }
        Toast.makeText(this$0.getMContext(), this$0.getString(R.string.select_address_proof), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m1185onViewCreated$lambda3(final KycUploadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getKycUploadModel().uploadDoc(((AutoCompleteTextView) this$0._$_findCachedViewById(R.id.addressProofCompleteTextView)).getText().toString(), ((CheckBox) this$0._$_findCachedViewById(R.id.checkInstall)).isChecked(), this$0.imageFront, this$0.imageBack).observe(this$0.requireActivity(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                KycUploadFragment.m1186onViewCreated$lambda3$lambda2(KycUploadFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1186onViewCreated$lambda3$lambda2(KycUploadFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KycUploadFragment kycUploadFragment = this$0;
        NavDestination currentDestination = FragmentKt.findNavController(kycUploadFragment).getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == R.id.kycUpload) {
            Toast.makeText(this$0.getMContext(), str, 0).show();
            NavDirections actionUploadKycToTrackRelocation = KycUploadFragmentDirections.actionUploadKycToTrackRelocation();
            Intrinsics.checkNotNullExpressionValue(actionUploadKycToTrackRelocation, "actionUploadKycToTrackRelocation()");
            FragmentKt.findNavController(kycUploadFragment).navigate(actionUploadKycToTrackRelocation);
        }
    }

    public final ActivityResultLauncher<String> getRequestPermissionLauncher() {
        return this.requestPermissionLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestPermissionLauncher$lambda-5  reason: not valid java name */
    public static final void m1188requestPermissionLauncher$lambda5(final KycUploadFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.selectImage("");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0.getContext());
        builder.setCancelable(true);
        builder.setTitle("Storage Permission Needed");
        builder.setMessage("This app needs the Storage permission, please accept to use Storage functionality");
        builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KycUploadFragment.m1189requestPermissionLauncher$lambda5$lambda4(KycUploadFragment.this, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestPermissionLauncher$lambda-5$lambda-4  reason: not valid java name */
    public static final void m1189requestPermissionLauncher$lambda5$lambda4(KycUploadFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openSettingPageForPermission();
    }

    private final void openSettingPageForPermission() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        startActivity(intent);
    }

    private final void selectImage(final String str) {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getMContext());
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KycUploadFragment.m1190selectImage$lambda6(charSequenceArr, str, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectImage$lambda-6  reason: not valid java name */
    public static final void m1190selectImage$lambda6(CharSequence[] items, String str, KycUploadFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(str, "$str");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(items[i], "Take Photo")) {
            if (Intrinsics.areEqual(str, "back")) {
                this$0.backPhoto = true;
                this$0.frontPhoto = false;
            }
            if (Intrinsics.areEqual(str, "front")) {
                this$0.frontPhoto = true;
                this$0.backPhoto = false;
            }
            this$0.openCamera();
        } else if (Intrinsics.areEqual(items[i], "Choose from Library")) {
            this$0.openGallery();
        } else if (Intrinsics.areEqual(items[i], "Cancel")) {
            dialogInterface.dismiss();
            if (this$0.frontPhoto) {
                this$0.frontPhoto = false;
            }
            if (this$0.backPhoto) {
                this$0.backPhoto = false;
            }
        }
    }

    private final void openGallery() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/png | image/jpeg | image/jpg | application/pdf");
        intent.addFlags(1);
        intent.setAction("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/png", "image/jpeg", "image/jpg", "application/pdf"});
        ComponentName resolveActivity = intent.resolveActivity(requireActivity().getPackageManager());
        if (resolveActivity != null) {
            Intrinsics.checkNotNullExpressionValue(resolveActivity, "resolveActivity(requireActivity().packageManager)");
            startActivityForResult(intent, this.REQUEST_PICK_IMAGE);
        }
    }

    private final void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.frontPhoto) {
            this.imageFront = getPhotoFileUri("photo1.jpg");
            File file = this.imageFront;
            Intrinsics.checkNotNull(file);
            Uri uriForFile = FileProvider.getUriForFile(requireActivity(), BuildConfig.APPLICATION_ID, file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(requireAct…safedrink\", imageFront!!)");
            intent.putExtra("output", uriForFile);
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivityForResult(intent, this.REQUEST_IMAGE_CAPTURE);
            }
        }
        if (this.backPhoto) {
            this.imageBack = getPhotoFileUri("photo2.jpg");
            File file2 = this.imageBack;
            Intrinsics.checkNotNull(file2);
            Uri uriForFile2 = FileProvider.getUriForFile(requireActivity(), BuildConfig.APPLICATION_ID, file2);
            Intrinsics.checkNotNullExpressionValue(uriForFile2, "getUriForFile(requireAct….safedrink\", imageBack!!)");
            intent.putExtra("output", uriForFile2);
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivityForResult(intent, this.REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    public final File getPhotoFileUri(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "LivpureApp");
        if (!file.exists() && !file.mkdirs()) {
            Log.d("LivpureApp", "failed to create directory");
        }
        return new File(file.getPath() + File.separator + fileName);
    }

    private final void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(getMContext(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(getMContext(), new String[]{"android.permission.CAMERA"}, this.REQUEST_PERMISSION);
        }
        if (ContextCompat.checkSelfPermission(getMContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(getMContext(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_PERMISSION);
        }
        if (ContextCompat.checkSelfPermission(getMContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(getMContext(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.REQUEST_PERMISSION);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == this.REQUEST_IMAGE_CAPTURE) {
                if (this.frontPhoto) {
                    Object obj = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.get("data");
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
                    Bitmap bitmap = (Bitmap) obj;
                    Uri imageUri = getImageUri(bitmap);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                    this.imageFront = new File(RealPathUtil.getRealPath(getMContext(), imageUri));
                    ((LinearLayout) _$_findCachedViewById(R.id.uploadFrontPhoto)).setBackgroundResource(R.drawable.border_service_request);
                    this.frontPhoto = false;
                    TextView textView = (TextView) _$_findCachedViewById(R.id.frontName);
                    File file = this.imageFront;
                    textView.setText(file != null ? file.getPath() : null);
                    ((ImageView) _$_findCachedViewById(R.id.imageViewFront)).setImageDrawable(getMContext().getDrawable(R.drawable.ic_check_green_24dp));
                }
                if (this.backPhoto) {
                    Object obj2 = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.get("data");
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.graphics.Bitmap");
                    Bitmap bitmap2 = (Bitmap) obj2;
                    Uri imageUri2 = getImageUri(bitmap2);
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                    this.imageBack = new File(RealPathUtil.getRealPath(getMContext(), imageUri2));
                    ((LinearLayout) _$_findCachedViewById(R.id.uploadBackPhoto)).setBackgroundResource(R.drawable.border_service_request);
                    this.backPhoto = false;
                    TextView textView2 = (TextView) _$_findCachedViewById(R.id.backName);
                    File file2 = this.imageBack;
                    textView2.setText(file2 != null ? file2.getPath() : null);
                    ((ImageView) _$_findCachedViewById(R.id.imageViewBack)).setImageDrawable(getMContext().getDrawable(R.drawable.ic_check_green_24dp));
                }
            } else if (i == this.REQUEST_PICK_IMAGE) {
                if (this.frontPhoto) {
                    Uri data = intent != null ? intent.getData() : null;
                    if (RealPathUtil.getRealPath(requireActivity(), data) == null) {
                        showFileAccessDialog();
                    } else {
                        if (data != null) {
                            FragmentActivity requireActivity = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                            grantUriPermission(data, requireActivity);
                            FragmentActivity activity = getActivity();
                            if (activity != null && (contentResolver2 = activity.getContentResolver()) != null) {
                                contentResolver2.takePersistableUriPermission(data, 1);
                            }
                        }
                        this.imageFront = new File(RealPathUtil.getRealPath(requireActivity(), data));
                        ((LinearLayout) _$_findCachedViewById(R.id.uploadFrontPhoto)).setBackgroundResource(R.drawable.border_service_request);
                        this.frontPhoto = false;
                        ((TextView) _$_findCachedViewById(R.id.frontName)).setText(getFileName(data));
                        ((ImageView) _$_findCachedViewById(R.id.imageViewFront)).setImageDrawable(getMContext().getDrawable(R.drawable.ic_check_green_24dp));
                    }
                }
                if (this.backPhoto) {
                    Uri data2 = intent != null ? intent.getData() : null;
                    if (RealPathUtil.getRealPath(requireActivity(), data2) == null) {
                        showFileAccessDialog();
                    } else {
                        if (data2 != null) {
                            FragmentActivity requireActivity2 = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                            grantUriPermission(data2, requireActivity2);
                            FragmentActivity activity2 = getActivity();
                            if (activity2 != null && (contentResolver = activity2.getContentResolver()) != null) {
                                contentResolver.takePersistableUriPermission(data2, 1);
                            }
                        }
                        this.imageBack = new File(RealPathUtil.getRealPath(requireActivity(), data2));
                        ((LinearLayout) _$_findCachedViewById(R.id.uploadBackPhoto)).setBackgroundResource(R.drawable.border_service_request);
                        this.backPhoto = false;
                        ((TextView) _$_findCachedViewById(R.id.backName)).setText(getFileName(data2));
                        ((ImageView) _$_findCachedViewById(R.id.imageViewBack)).setImageDrawable(getMContext().getDrawable(R.drawable.ic_check_green_24dp));
                    }
                }
            }
            uploadBtnEnable();
        }
    }

    private final void grantUriPermission(Uri uri, Activity activity) {
        try {
            activity.grantUriPermission(activity.getPackageName(), uri, 65);
        } catch (IllegalArgumentException unused) {
            activity.grantUriPermission(activity.getPackageName(), uri, 1);
        } catch (SecurityException e) {
            Toast.makeText(requireActivity(), "Please try again", 0).show();
            Log.e("securityExceptionBankSt", e.toString());
        }
    }

    private final Uri getImageUri(Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        return Uri.parse(MediaStore.Images.Media.insertImage(getMContext().getContentResolver(), bitmap, "Title", (String) null));
    }

    private final String getRealPathFromURI(Uri uri) {
        Integer valueOf;
        Cursor cursor = null;
        String str = null;
        try {
            ContentResolver contentResolver = getMContext().getContentResolver();
            Intrinsics.checkNotNull(uri);
            Cursor query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    valueOf = Integer.valueOf(query.getColumnIndexOrThrow("_data"));
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                valueOf = null;
            }
            if (query != null) {
                query.moveToFirst();
            }
            if (query != null) {
                Intrinsics.checkNotNull(valueOf);
                str = query.getString(valueOf.intValue());
            }
            if (query != null) {
                query.close();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void populateProofSpinner(List<String> list) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.addressProofCompleteTextView);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, list));
        autoCompleteTextView.setShowSoftInputOnFocus(false);
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                KycUploadFragment.m1187populateProofSpinner$lambda11$lambda10$lambda9(KycUploadFragment.this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populateProofSpinner$lambda-11$lambda-10$lambda-9  reason: not valid java name */
    public static final void m1187populateProofSpinner$lambda11$lambda10$lambda9(KycUploadFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.isAdded()) {
            UiUtilKt.hideKeyboard(this$0.requireActivity());
        }
        this$0.uploadBtnEnable();
    }

    private final void uploadBtnEnable() {
        Editable text = ((AutoCompleteTextView) _$_findCachedViewById(R.id.addressProofCompleteTextView)).getText();
        Intrinsics.checkNotNullExpressionValue(text, "addressProofCompleteTextView.text");
        if ((text.length() > 0) && this.imageBack != null && this.imageFront != null) {
            ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setBackgroundResource(R.color.color4);
            ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setTextColor(getResources().getColor(R.color.colorWhite));
            ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setEnabled(true);
            return;
        }
        ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setBackgroundResource(R.color.color9);
        ((Button) _$_findCachedViewById(R.id.btnUploadDocument)).setEnabled(false);
    }

    public final String getFileName(Uri uri) {
        Cursor query = uri != null ? requireActivity().getContentResolver().query(uri, null, null, null, null) : null;
        Intrinsics.checkNotNull(query);
        int columnIndex = query.getColumnIndex("_display_name");
        query.moveToFirst();
        String name = query.getString(columnIndex);
        query.close();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return name;
    }

    public final void showFileAccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Livpure Smart need all file access permission");
        builder.setTitle("All File Access Required!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KycUploadFragment.m1191showFileAccessDialog$lambda13(KycUploadFragment.this, dialogInterface, i);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.KycUploadFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KycUploadFragment.m1192showFileAccessDialog$lambda14(KycUploadFragment.this, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFileAccessDialog$lambda-13  reason: not valid java name */
    public static final void m1191showFileAccessDialog$lambda13(KycUploadFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface != null) {
            dialogInterface.cancel();
        }
        this$0.openSettingManagePageForPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showFileAccessDialog$lambda-14  reason: not valid java name */
    public static final void m1192showFileAccessDialog$lambda14(KycUploadFragment this$0, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.cancel();
        this$0.frontPhoto = false;
        this$0.backPhoto = false;
    }

    private final void openSettingManagePageForPermission() {
        Intent intent = new Intent();
        intent.setAction("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        startActivity(intent);
    }
}
