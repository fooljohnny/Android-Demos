/*
 * Copyright (C) 2016.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.bobomee.android.mortar_flow_samples.flow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bobomee.android.mortar_flow_samples.R;
import flow.Flow;

public class BasicSampleActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.basic_activity_frame);
  }

  @Override protected void attachBaseContext(Context baseContext) {
    baseContext = Flow.configure(baseContext, this) //
        .dispatcher(new BasicDispatcher(this)) //
        .defaultKey(new WelcomeScreen()) //
        .keyParceler(new BasicKeyParceler()) //
        .install();
    super.attachBaseContext(baseContext);
  }

  @Override public void onBackPressed() {
    if (!Flow.get(this).goBack()) {
      super.onBackPressed();
    }
  }
}
