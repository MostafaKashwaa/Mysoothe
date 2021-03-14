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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.domain.SoothCollection
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CardRow(
    items: List<SoothCollection>,
    rows: Int = 2
) {
    val chunkedList = items.chunked(rows)
    LazyRow() {
        items(chunkedList) {
            Column {
                for (item in it) {
                    CardRowItem(imageUrl = item.imageUrl, text = item.text)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun CardRowItem(
    imageUrl: String,
    text: String,
    circleCrop: Boolean = false
) {
    Card(
        Modifier.size(192.dp, 56.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Row(Modifier.fillMaxSize()) {
            CoilImage(
                data = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp),
                contentScale = ContentScale.Crop,
                requestBuilder = {
                    if (circleCrop) transformations(CircleCropTransformation())
                    else transformations(coil.transform.RoundedCornersTransformation(topLeft = 8f, bottomLeft = 8f))
                }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 8.dp)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h3
            )
        }
    }
}
