package ie.setu.rugbygame.ui.components.donate

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import timber.log.Timber
import ie.setu.rugbygame.R
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.data.fakeDonations
import ie.setu.rugbygame.ui.theme.RugbyGameTheme

@Composable
fun DonateButton(
    modifier: Modifier = Modifier,
    donation: DonationModel,
    donations: SnapshotStateList<DonationModel>,
    onTotalDonatedChange: (Int) -> Unit
) {
    var totalDonated = donations.sumOf { it.paymentAmount }
    val context = LocalContext.current
    val message = stringResource(R.string.limitExceeded,donation.paymentAmount)

    Row {
        Button(
            onClick = {
                if(totalDonated + donation.paymentAmount <= 10000) {
                    totalDonated+=donation.paymentAmount
                    onTotalDonatedChange(totalDonated)
                    donations.add(donation)
                    Timber.i("Donation info : $donation")
                    Timber.i("Donation List info : ${donations.toList()}")
                }
                else
                    Toast.makeText(context,message,
                        Toast.LENGTH_SHORT).show()
            },
            elevation = ButtonDefaults.buttonElevation(20.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Donate")
            Spacer(modifier.width(width = 4.dp))
            Text(
                text = stringResource(R.string.donateButton),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Spacer(modifier.weight(1f))
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                ) {
                    append(stringResource(R.string.total) + " €")
                }


                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary)
                ) {
                    append(totalDonated.toString())
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun DonateButtonPreview() {
    RugbyGameTheme {
        DonateButton(
            Modifier,
            DonationModel(),
            donations = fakeDonations.toMutableStateList()
        ) {}
    }
}