package com.example.view.screen.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.component.AppViewNameText
import com.example.component.ClickableIcons
import com.example.domain.entity.CredentialResponseEntity
import com.example.style.secondaryColor
import com.example.view.R
import java.util.Date

@Composable
fun EntryItem(
    modifier: Modifier = Modifier,
    item: CredentialResponseEntity,
    onEditEntry: () -> Unit = {},
    onCopyPassword: () -> Unit = {},
    onDeleteEntry: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = secondaryColor, shape = RoundedCornerShape(8.dp)
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            AppViewNameText(
                text = item.entryName,
                modifier = Modifier
                    .fillMaxWidth(0.5F)
                    .wrapContentHeight()
            )

            ClickableIcons(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                imageVector = R.drawable.ic_copy,
                onClick = {
                    onCopyPassword.invoke()
                }
            )

            ClickableIcons(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                imageVector = R.drawable.ic_edit,
                onClick = {
                    onEditEntry.invoke()
                }
            )

            ClickableIcons(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                imageVector = R.drawable.ic_delete,
                onClick = {
                    onDeleteEntry.invoke()
                }
            )

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewEntryItem(modifier: Modifier = Modifier) {
    EntryItem(
        modifier = modifier,
        item = CredentialResponseEntity(
            entryName = "Sample Entry",
            password = "Sample Password",
            email = "someone@gmail.com",
            mobileNumber = "1234567890",
            createdAt = Date().time,
            updatedAt = Date().time
        )
    )
}