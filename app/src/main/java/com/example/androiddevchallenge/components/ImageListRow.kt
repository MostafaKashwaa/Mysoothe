/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.SoothItem
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ImageListRow(
    soothItems: List<SoothItem>
) {
    LazyRow {
        items(soothItems) {
            ImageListRowItem(name = it.name, imageUrl = it.imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ImageListRowItem(
    name: String,
    imageUrl: String
) {
    Column() {
        CoilImage(
            data = imageUrl,
            modifier = Modifier
                .height(88.dp)
                .width(88.dp)
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,

        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }

        Text(
            text = name,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
