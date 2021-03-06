/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.tv.testing;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/** Static utilities for testing using databases. */
public final class DbTestingUtils {

    public static List<List<String>> toList(Cursor cursor) {
        ArrayList<List<String>> result = new ArrayList<>();
        int colCount = cursor.getColumnCount();
        while (cursor.moveToNext()) {
            List<String> row = new ArrayList<>(colCount);
            for (int i = 0; i < colCount; i++) {
                row.add(cursor.isNull(i) ? "null" : cursor.getString(i));
            }
            result.add(row);
        }
        return result;
    }

    private DbTestingUtils() {}
}
