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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.getBodyItems
import com.example.androiddevchallenge.domain.getFavoriteCollection
import com.example.androiddevchallenge.domain.getMindItems
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen() {
    var searchTerm by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        Column(Modifier.align(Alignment.TopCenter)) {
            TextField(
                value = searchTerm,
                onValueChange = { searchTerm = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp, end = 16.dp),
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
            Text(
                text = "FAVORITE COLLECTIONS",
                modifier = Modifier.padding(top = 40.dp),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardRow(items = getFavoriteCollection())
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "ALIGN YOUR BODY",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            ImageListRow(soothItems = getBodyItems())
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "ALIGN YOUR MIND",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            ImageListRow(soothItems = getMindItems())
        }
        BottomNavigation(
            Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding(),
            backgroundColor = MaterialTheme.colors.background
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = "Home page icon"
                    )
                },
                label = {
                    Text(
                        text = "HOME",
                        style = MaterialTheme.typography.caption
                    )
                }
            )
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Home page icon"
                    )
                },
                label = {
                    Text(
                        text = "PROFILE",
                        style = MaterialTheme.typography.caption
                    )
                },
                enabled = false
            )
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(28.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "play button",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
