package com.example.ejemplocompose.model
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "user")
data class User (
    @ColumnInfo (name = "name") val name: String,
    @ColumnInfo (name = "LasName") val lastName: String,
    @ColumnInfo (name = "city") val city: String,
    @ColumnInfo (name = "thumbnail") val thumbail: String,
    @PrimaryKey (autoGenerate = true) var id: Int = 0
)

@Dao
interface  UserDao{
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert (user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAll(): LiveData<List<User>>

    @Delete
    fun delete(user: User)
}

