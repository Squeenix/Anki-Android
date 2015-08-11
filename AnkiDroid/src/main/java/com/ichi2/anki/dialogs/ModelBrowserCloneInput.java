package com.ichi2.anki.dialogs;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ichi2.anki.R;
import com.ichi2.themes.Themes;

public class ModelBrowserCloneInput extends DialogFragment {

    public final static int FIELD_OPTIONS = 0;
    public final static int FIELD_RENAME = 1;
    public final static int FIELD_DELETE = 2;


    private static MaterialDialog.ListCallback mContextMenuListener;

    public static ModelBrowserCloneInput newInstance(String label, MaterialDialog.ListCallback contextMenuListener){
        ModelBrowserCloneInput n = new ModelBrowserCloneInput();
        mContextMenuListener = contextMenuListener;
        Bundle b = new Bundle();
        b.putString("label", label);
        mContextMenuListener = contextMenuListener;
        n.setArguments(b);
        return n;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_applications_black_36dp);
        icon.setAlpha(Themes.ALPHA_ICON_ENABLED_DARK);

        String[] entries = new String[3];
        entries[FIELD_DELETE] = getResources().getString(R.string.model_editor_delete);
        entries[FIELD_OPTIONS] = getResources().getString(R.string.model_editor_options);
        entries[FIELD_RENAME] = getResources().getString(R.string.model_editor_rename);

        return new MaterialDialog.Builder(getActivity())
                .title(getArguments().getString("label"))
                .icon(icon)
                .items(entries)
                .itemsCallback(mContextMenuListener)
                .build();
    }
}