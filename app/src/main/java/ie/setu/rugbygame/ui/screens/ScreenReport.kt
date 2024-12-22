package ie.setu.rugbygame.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.rugbygame.R
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.data.fakeDonations
import ie.setu.rugbygame.ui.components.report.DonationCardList
import ie.setu.rugbygame.ui.components.report.ReportText
import ie.setu.rugbygame.ui.components.general.Centre
import ie.setu.rugbygame.ui.theme.RugbyGameTheme

@Composable
fun ScreenReport(modifier: Modifier = Modifier,
                 donations: SnapshotStateList<DonationModel>) {

    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            ReportText()
            if(donations.isEmpty())
                Centre(Modifier.fillMaxSize()) {
                    Text(color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            else
                DonationCardList(
                    donations = donations
                )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    RugbyGameTheme {
        ScreenReport( modifier = Modifier,
            donations = fakeDonations.toMutableStateList()
        )
    }
}