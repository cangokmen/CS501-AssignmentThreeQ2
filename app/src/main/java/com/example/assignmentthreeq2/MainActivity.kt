package com.example.assignmentthreeq2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmentthreeq2.ui.theme.AssignmentThreeQ2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentThreeQ2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var badgeIsOn by remember { mutableStateOf(true) }

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ProfileAndNotificationBadge(
                            badgeIsOn = badgeIsOn,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )
                        Button(onClick = { badgeIsOn = !badgeIsOn }) {
                            Text(if (badgeIsOn) "hide notification" else "show notification")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileAndNotificationBadge(
    badgeIsOn: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(120.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
        if (badgeIsOn) {
            Badge(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(0.dp)
                    .size(20.dp),
                containerColor = Color.Green
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultMainActivityPreview() {
    AssignmentThreeQ2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            var badgeIsOn by remember { mutableStateOf(true) }

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ProfileAndNotificationBadge(
                    badgeIsOn = badgeIsOn,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Button(onClick = { badgeIsOn = !badgeIsOn }) {
                    Text(if (badgeIsOn) "hide notification" else "show notification")
                }
            }
        }
    }
}
