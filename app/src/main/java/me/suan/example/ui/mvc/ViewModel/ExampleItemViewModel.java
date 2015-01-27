package me.suan.example.ui.mvc.ViewModel;

import android.content.Context;
import android.view.ViewGroup;

import me.suan.common.io.http.image.Photo;
import me.suan.common.ui.mvc.Model.BaseModel;
import me.suan.common.ui.mvc.ViewModel.BaseViewModel;
import me.suan.example.R;
import me.suan.example.ui.mvc.Model.ExampleItemModel;
import me.suan.example.ui.mvc.View.ExampleItemView;

/**
 * Created by suanmiao on 15/1/26.
 */
public class ExampleItemViewModel extends BaseViewModel {
  public ExampleItemViewModel(ViewGroup container, Context context,
      UIChangeListener uiChangeListener) {
    super(new ExampleItemView(context, container), context, uiChangeListener);
  }

  @Override
  public void bind(int index, BaseModel baseModel, int scrollState, float scrollSpeed) {
    ExampleItemView itemView = (ExampleItemView) getView();
    ExampleItemModel model = (ExampleItemModel) baseModel;
    itemView.text.setText(model.text);
    if (Math.random() > 0.5) {
      Photo.loadScrollItemImg(itemView.img, model.img, R.drawable.ic_launcher, scrollState,
              scrollSpeed);
    } else {
      Photo.loadScrollItemBlurImg(itemView.img, model.img, R.drawable.ic_launcher, scrollState,
          scrollSpeed);
    }
  }

  @Override
  public void idleReload() {
    ExampleItemView itemView = (ExampleItemView) getView();
    Photo.reloadImg(itemView.img);
  }
}