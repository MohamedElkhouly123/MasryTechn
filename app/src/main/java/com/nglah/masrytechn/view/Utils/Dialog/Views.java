package com.nglah.masrytechn.view.Utils.Dialog;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Views
{
	public static class LoadingView
	{
		private LoadingDialog loading;

		public LoadingView(Context context)
		{
			loading = new LoadingDialog(context);
		}

		public void show()
		{
			if (loading != null && !loading.isShowing())
			{
				loading.show();
			}
		}

		public void dismiss()
		{
			if (loading != null && loading.isShowing())
			{
				loading.dismiss();
			}
		}
	}


	public static class ImageLoader
	{
		public static void load(Context context, ImageView imageView, String imagePath, int placeholder)
		{
			String imagePathFinal = imagePath;
			glideLoader(context, imageView, imagePath,placeholder);
		}


		public static void glideLoader(Context context, ImageView imageView, String uri, int placeholder)
		{
			Picasso.get().load(uri).placeholder( placeholder).into(imageView);
			//Glide.with(context).load(uri).placeholder(placeholder).into(imageView);
		}
	}
}
