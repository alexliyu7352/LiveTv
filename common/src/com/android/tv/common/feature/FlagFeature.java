/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package com.android.tv.common.feature;

import android.content.Context;
import com.google.common.base.Function;

/** Feature from a Flag */
public class FlagFeature<T> implements Feature {

    private final Function<Context, T> mToFlag;
    private final Function<T, Boolean> mToBoolean;

    public static <T> FlagFeature<T> from(
            Function<Context, T> toFlag, Function<T, Boolean> toBoolean) {
        return new FlagFeature<T>(toFlag, toBoolean);
    }

    private FlagFeature(Function<Context, T> toFlag, Function<T, Boolean> toBoolean) {
        mToFlag = toFlag;
        mToBoolean = toBoolean;
    }

    @Override
    public boolean isEnabled(Context context) {
        return mToBoolean.apply(mToFlag.apply(context));
    }

    @Override
    public String toString() {
        return mToBoolean.toString();
    }
}
