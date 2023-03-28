package com.example.instagramprofilepageui.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofilepageui.R
import com.example.instagramprofilepageui.StoryHighlight


@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "imdigitalashish")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        HighlightSection(
            highlight = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.youtube),
                    text = "Youtube"
                ),
                StoryHighlight(

                    image = painterResource(id = R.drawable.qa),
                    text = "Telegram"
                ),
                StoryHighlight(

                    image = painterResource(id = R.drawable.qa),
                    text = "Class 10th"
                ),
                StoryHighlight(

                    image = painterResource(id = R.drawable.qa),
                    text = "India"
                )
            ),
            modifier = Modifier.padding(start = 12.dp, top = 10.dp)
        )
        PostTabView(
            imagesWidthTexts = listOf(
                StoryHighlight(
                    painterResource(id = R.drawable.ic_grid),
                    "posts"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.ic_reels),
                    "Reel"
                ), StoryHighlight(
                    painterResource(id = R.drawable.ic_igtv),
                    "IGTV"
                ),
                StoryHighlight(
                    painterResource(id = R.drawable.profile),
                    "Profile"
                )

            ),
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.kmm),
                ),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier,

    ) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 9.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,

            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

    }

}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.philipp), modifier = Modifier
                    .size(100.dp)
                    .weight(3f)

            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifer = Modifier.weight(7f))
        }

        ProfileDescription(
            displayName = "Ashish Kumar Verma",
            description = "National Winner in web tech",
            url = "https://imdigitalashish.netlify.app",
            followedBy = listOf("vacoder", "username"),
            otherCount = 17
        )

        ButtonsSection()

    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),

        )
}


@Composable
fun StatsSection(modifer: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifer
    ) {
        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "370", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")
    }
}


@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier

) {


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)

    }

}


@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {

    val letterSpacing = 0.5.sp;

    val lineHeight = 20.sp;

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)


    ) {

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")

                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

        }

    }

}


@Composable
fun ButtonsSection() {


    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)

        ) {
            Text(
                text = "Following",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black

            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)


        ) {
            Text(
                text = "Message",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black

            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)

        ) {
            Text(
                text = "Email",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black

            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray,

                ),
            shape = RoundedCornerShape(5.dp)

        ) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        }
    }

}


@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<StoryHighlight>
) {

    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlight[it].image,
                    modifier = Modifier.size(70.dp),
                )
                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}


@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imagesWidthTexts: List<StoryHighlight>,
    onTabSelected: (selectedIndex: Int) -> Unit,
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier

    ) {


        imagesWidthTexts.forEachIndexed { index, item ->


            Tab(
                selected = selectedTabIndex == index,
                onClick = {

                    selectedTabIndex = index
                    onTabSelected(index)

                },
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint =
                    if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }

        }

    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {


    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }

}