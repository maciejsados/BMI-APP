// Generated code from Butter Knife. Do not modify!
package maciej.example.com.bmiapp.java;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import maciej.example.com.bmiapp.R;
import maciej.example.com.bmiapp.java.fragment.BMI;

public class Fragment1_ViewBinding implements Unbinder {
  private BMI target;

  @UiThread
  public Fragment1_ViewBinding(BMI target, View source) {
    this.target = target;

    target.weight_input = Utils.findRequiredViewAsType(source, R.id.weight, "field 'weight_input'", EditText.class);
    target.height_input = Utils.findRequiredViewAsType(source, R.id.height, "field 'height_input'", EditText.class);
    target.bmi_result = Utils.findRequiredViewAsType(source, R.id.BMI_result, "field 'bmi_result'", TextView.class);
    target.bmi_description = Utils.findRequiredViewAsType(source, R.id.BMI_description, "field 'bmi_description'", TextView.class);
    target.weight_range = Utils.findRequiredViewAsType(source, R.id.weight_range, "field 'weight_range'", TextView.class);
    target.target_weight = Utils.findRequiredViewAsType(source, R.id.target_weigh, "field 'target_weight'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BMI target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.weight_input = null;
    target.height_input = null;
    target.bmi_result = null;
    target.bmi_description = null;
    target.weight_range = null;
    target.target_weight = null;
  }
}
