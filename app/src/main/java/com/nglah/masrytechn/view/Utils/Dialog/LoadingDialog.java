package com.nglah.masrytechn.view.Utils.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.nglah.masrytechn.R;


class LoadingDialog extends Dialog {
   LoadingDialog(@NonNull Context context) {
       super(context);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.dialog_loading);
       setCancelable(true);
   }

   @Override
   public void show() {
       super.show();
       WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
       Window window = getWindow();
       lp.copyFrom(window.getAttributes());
       lp.width = WindowManager.LayoutParams.MATCH_PARENT;
       lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
       window.setAttributes(lp);
       window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
   }
}
