package ie.setu.rugbygame.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ie.setu.rugbygame.data.DonationModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DonationDAO {
    @Query("SELECT * FROM donationmodel")
    fun getAll(): Flow<List<DonationModel>>

    @Insert
    suspend fun insert(donation: DonationModel)

    @Update
    suspend fun update(donation: DonationModel)

    @Delete
    suspend fun delete(donation: DonationModel)
}