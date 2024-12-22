package ie.setu.rugbygame.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ie.setu.rugbygame.data.DonationModel
import ie.setu.rugbygame.ui.screens.about.AboutScreen
import ie.setu.rugbygame.ui.screens.donate.DonateScreen
import ie.setu.rugbygame.ui.screens.reports.ReportScreen

@Composable
fun NavHostProvider(
    modifier: Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
    donations: SnapshotStateList<DonationModel>
) {
    NavHost(
        navController = navController,
        startDestination = Report.route,
        modifier = Modifier.padding(paddingValues = paddingValues)) {

        composable(route = Donate.route) {
            //call our 'Donate' Screen Here
            DonateScreen(modifier = modifier)
        }
        composable(route = Report.route) {
            //call our 'Report' Screen Here
            ReportScreen(modifier = modifier,
                onClickDonationDetails = {
                        donationId : Int ->
                    navController.navigateToDonationDetails(donationId)
                },
            )
        }
        composable(route = About.route) {
            //call our 'About' Screen Here
            AboutScreen(modifier = modifier)
        }
    }
}

private fun NavHostController.navigateToDonationDetails(donationId: Int) {
    this.navigate("details/$donationId")
}
