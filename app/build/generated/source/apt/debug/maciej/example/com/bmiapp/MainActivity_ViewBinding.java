// Generated code from Butter Knife. Do not modify!
package maciej.example.com.bmiapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import maciej.example.com.bmiapp.java.MainActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawerLayout'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigationView'", NavigationView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.drawerLayout = null;
    target.navigationView = null;
    target.toolbar = null;
  }
}
