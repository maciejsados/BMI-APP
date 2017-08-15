// Generated code from Butter Knife. Do not modify!
package maciej.example.com.bmiapp.java;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.bmiapp.R;

public class Main2Activity_ViewBinding implements Unbinder {
  private SecondActivity target;

  @UiThread
  public Main2Activity_ViewBinding(SecondActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Main2Activity_ViewBinding(SecondActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar_2, "field 'toolbar'", Toolbar.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.draw_layout, "field 'drawerLayout'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.navigation_view, "field 'navigationView'", NavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SecondActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.drawerLayout = null;
    target.navigationView = null;
  }
}
