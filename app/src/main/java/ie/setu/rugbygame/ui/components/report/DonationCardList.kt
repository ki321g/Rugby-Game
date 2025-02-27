package ie.setu.rugbygame.ui.components.report

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import java.text.DateFormat
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.data.fakeDonations
import ie.setu.rugbygame.ui.theme.RugbyGameTheme

@Composable
internal fun DonationCardList(
    donations: SnapshotStateList<DonationModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = donations,
            key = { donation -> donation.id }
        ) { donation ->
            DonationCard(
                paymentType = donation.paymentType,
                paymentAmount = donation.paymentAmount,
                message = donation.message,
                dateCreated = DateFormat.getDateTimeInstance().format(donation.dateDonated),
            )
        }
    }
}

@Preview(showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)

@Composable
fun DonationCardListPreview() {
    RugbyGameTheme {
        DonationCardList(fakeDonations.toMutableStateList())
    }
}