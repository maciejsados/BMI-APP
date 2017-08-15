// Generated code from Butter Knife. Do not modify!
package maciej.example.com.bmiapp.java;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.bmiapp.R;
import maciej.example.com.bmiapp.java.fragment.Fragment3;

public class Fragment3_ViewBinding implements Unbinder {
  private Fragment3 target;

  @UiThread
  public Fragment3_ViewBinding(Fragment3 target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fragment3 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
  }
}
