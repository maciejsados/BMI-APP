// Generated code from Butter Knife. Do not modify!
package maciej.example.com.bmiapp.java.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.bmiapp.R;

public class Historia_ViewBinding implements Unbinder {
  private Historia target;

  @UiThread
  public Historia_ViewBinding(Historia target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_item, "field 'listView'", SwipeMenuListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Historia target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
